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
	return comp;
    }    
}
