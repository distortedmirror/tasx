package vxd;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class VXDTreeCellRenderer extends DefaultTreeCellRenderer {
    public VXDTreeCellRenderer() {
	super();
    }
    public Component getTreeCellRendererComponent(JTree tree, Object value,
						  boolean sel, boolean expanded, boolean leaf, int row,
						  boolean hasFocus) {
	Component comp=super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
	try{
	    DefaultTreeCellRenderer rcomp=(DefaultTreeCellRenderer)this;
	    rcomp.setText(((Element)value).getAttribute("Name"));
	    Element element = (Element) value;
	    ActionListener selectedIcon=null;
	    boolean iconSet=false;
	    try {
		if (element != null) {
		    selectedIcon=(ActionListener)vxd.controller.iconConnectionView.getDragIconByID(element.getAttribute("ID"));
		    if (selectedIcon == null) {
			selectedIcon=(ActionListener)vxd.controller.iconConnectionView.getIconConnectorByID(element.getAttribute("ID"));
		    }
		    if(selectedIcon!=null){
			if(selectedIcon instanceof vxdIconConnector){
			    ImageIcon icon=((vxdIconConnector)selectedIcon).iconb.icon;
			    if(icon!=null){
				rcomp.setIcon(icon);
				iconSet=true;
			    }
			}else if(selectedIcon instanceof vxdDragIcon){
			    ImageIcon icon=((vxdDragIcon)selectedIcon).icon;
			    if(icon!=null){
				rcomp.setIcon(icon);
				iconSet=true;
			    }
			}
		    }
		}
	    }catch(Exception iiex){;}
	    if(!iconSet){
		rcomp.setIcon(vxd.controller.GetIconButton(((Element)value).getTagName()).icon);
	    }
	}catch(Exception rex){}
	if(sel)
	    vxd.controller.statusText.setText(value.toString());
	return this;
    }    
}
