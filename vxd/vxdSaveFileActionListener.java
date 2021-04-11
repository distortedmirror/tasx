package vxd;

import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.xml.parsers.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.*;
import java.io.*;
import java.text.*;

import org.apache.crimson.tree.*;
import org.apache.crimson.jaxp.*;
import org.apache.crimson.parser.*;
import org.apache.crimson.util.*;

import vxd.*;

public class vxdSaveFileActionListener implements ActionListener, Runnable {
    protected String passwdString;
    public vxdSaveFileActionListener() {
    }
    public void actionPerformed(ActionEvent e) {
	if (vxd.passwdtextField.getText() == null
	    || vxd.passwdtextField.getText().length() == 0) {
	    JOptionPane.showMessageDialog(vxd.frame,
					  "The Password Cannot Be Blank");
	} else {
	    this.passwdString = vxd.passwdtextField.getText();
	    vxd.topDialog.setVisible(false);
	    vxd.topDialog.dispose();
	    vxd.topDialog = null;
	    SwingUtilities.invokeLater(this);
	}
    }
    public void run() {
	Component component=vxd.controller.iconConnectionView;
	BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
	Graphics g = image.getGraphics();
	component.paint(g);
	try {
	    String filename=vxd.SAVEFILEDIR + vxd.controller.project.name +"/"+
		vxd.controller.project.name+".png";
	    ImageIO.write(image, "png", new File(filename));
	} catch (IOException ex) {
	    ;
	}
	PrintWriter out;
	ByteArrayOutputStream outcrypt;
	File f;
	File d;
	FileInputStream rdr;
	byte[] filedata = new byte[0];
	try {
	    d = new File(vxd.SAVEFILEDIR + vxd.controller.project.name
			 + "/");
	    d.mkdir();
	    f = new File(vxd.SAVEFILEDIR + vxd.controller.project.name
			 + "/" + vxd.controller.project.name + ".xml.unencrypted");
	    if (f.exists()) {
		f.delete();
		f = new File(vxd.SAVEFILEDIR + vxd.controller.project.name
			     + "/" + vxd.controller.project.name + ".xml.unencrypted");
	    }
	    try {
		out = new PrintWriter(new FileWriter(f));
		XmlDocument xdoc = (XmlDocument) vxd.controller.project.programXML;
		StringWriter stwr = new StringWriter();
		xdoc.write(stwr);
		out.print(stwr.toString());
		out.flush();
		out.close();
	    } catch (Exception oi) {
		oi.printStackTrace();
	    }
	    try{
		File fl = new File(vxd.SAVEFILEDIR + vxd.controller.project.name
			 + "/" + vxd.controller.project.name + ".xml.unencrypted");
		rdr = new FileInputStream(fl);
		DataInputStream dta = new DataInputStream(rdr);
		filedata = new byte[(int) fl.length()];
		dta.readFully(filedata);
		String readxml = new String(filedata);
		rdr.close();
		dta.close();
		fl.delete();
	    } catch (Exception oix) {
		oix.printStackTrace();
	    }
	    int iter = 0;
	    int accum = 0;
	    for (int di = 0; di < filedata.length; ++di) {
		accum += (int) passwdString.charAt(iter++ % passwdString.length());
		filedata[di] += accum;
		filedata[di] ^= (int) passwdString.charAt(iter % passwdString.length());
		++iter;
	    }
	    FileOutputStream fcrypt = new FileOutputStream(vxd.SAVEFILEDIR + vxd.controller.project.name
							   + "/" + vxd.controller.project.name + ".xml.encrypted", false);
	    try {
		outcrypt = new ByteArrayOutputStream();
		outcrypt.write(filedata, 0, (int) filedata.length);
		outcrypt.writeTo(fcrypt);
		outcrypt.flush();
		outcrypt.close();
		fcrypt.flush();
		fcrypt.close();
	    }catch (Exception fcrypte){
		fcrypte.printStackTrace();
	    }
	    File logfiledir = new File(vxd.SAVEFILEDIR + vxd.controller.project.name + "/Archive");
	    logfiledir.mkdir(); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	    String timestamp = dateFormat.format(new Date());
	    File logfile = new File(vxd.SAVEFILEDIR + vxd.controller.project.name + "/Archive/" + "/" + vxd.controller.project.name + " " + timestamp + ".xml");
	    File mainfile = new File(vxd.SAVEFILEDIR + vxd.controller.project.name
					      + "/" + vxd.controller.project.name + ".xml");
	    File encryptfile= (new File(vxd.SAVEFILEDIR + vxd.controller.project.name
					+ "/" + vxd.controller.project.name + ".xml.encrypted"));
	    File decryptedfile = (new File(vxd.SAVEFILEDIR + vxd.controller.project.name
					   + "/" + vxd.controller.project.name + ".xml.decrypted"));
	    try {
		if(mainfile.exists()){
		    mainfile.renameTo(logfile);
		}
		encryptfile.setWritable(true);
		encryptfile.renameTo(new File(vxd.SAVEFILEDIR + vxd.controller.project.name
					      + "/" + vxd.controller.project.name + ".xml"));
		decryptedfile.delete();
	    } catch (Exception saveence) {
		saveence.printStackTrace();
	    } finally {
		encryptfile.setWritable(true);
	    }
	    JOptionPane.showMessageDialog(vxd.frame, vxd.SAVEFILEDIR
					  + vxd.controller.project.name + "/"
					  + vxd.controller.project.name + ".xml Saved");
	} catch (Exception ex) {
	    JOptionPane.showMessageDialog(vxd.frame, "Saving "
					  + vxd.SAVEFILEDIR + vxd.controller.project.name + "/"
					  + vxd.controller.project.name + ".xml Failed");
	    ex.printStackTrace();
	} finally {
	}
    }

}
