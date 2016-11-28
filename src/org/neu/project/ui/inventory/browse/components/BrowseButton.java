package org.neu.project.ui.inventory.browse.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BrowseButton extends JButton {

	public BrowseButton(String text, String actionCommand, ActionListener listener) {
		super(text);
		setActionCommand(actionCommand);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addActionListener(listener);
	}

}