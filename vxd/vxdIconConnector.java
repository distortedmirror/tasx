package vxd;

import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.*;

import vxd.vxd;
import vxd.vxdDragIcon;
public class vxdIconConnector implements ActionListener {
    public static final int CONNECTION = 1;
    public static final int AGGREGATION = 2;
    public static final int ARROWSIZE = 7;

    public vxdDragIcon icona;
    public vxdDragIcon iconb;
    public int type;
    public boolean visible;
    public Element element;

    public vxdIconConnector(vxdDragIcon a, vxdDragIcon b, int type) {
        icona = a;
        iconb = b;
        this.type = type;
        visible = true;
        element = null;
    }

    public vxdIconConnector(vxdDragIcon a, vxdDragIcon b, int type, Element e) {
        this(a, b, type);
        element = e;
    }

    public void setVisible(boolean v) {
        visible = v;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setElement(Element e) {
        element = e;
    }


    public void actionPerformed(ActionEvent e) {
        vxd.controller.DEBUG_STACK_TRACE(e);
        if (e.getActionCommand().equals("OPEN")) {
            try {
                java.lang.Runtime.getRuntime().exec(element.getAttributeNode("ShellCommand").getNodeValue());
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(vxd.frame, "Error: " + exc.getMessage());
                exc.printStackTrace();
            }
        } else if (e.getActionCommand().equals("EXTERNALURL")) {
            try {
                java.lang.Runtime.getRuntime().exec(vxd.config.getDocumentElement()
                        .getAttribute("browserpath") + " " + element.getAttributeNode("ExternalLinkURL").getNodeValue());
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(vxd.frame, "Error: " + exc.getMessage());
                exc.printStackTrace();
            }
        } else if (e.getActionCommand().equals("DELETE")) {
            element.getParentNode().removeChild(element);
            vxd.controller.iconConnectionView.connectors.remove(this);
            vxd.controller.selectedNode = new TreePath(vxd.controller.project.programXML.getDocumentElement());
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    vxd.controller.iconConnectionView.validateIconsAndConnectors();
                }
            });
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    vxd.controller.refreshXMLViews();
                }
            });
        } else {
            if (element.getAttribute(e.getActionCommand()).equals("TRUE"))
                element.getAttributeNode(e.getActionCommand()).
                        setValue("FALSE");
            else
                element.getAttributeNode(e.getActionCommand()).
                        setValue("TRUE");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    vxd.controller.refreshXMLViews();
                }
            });
        }
    }
}
