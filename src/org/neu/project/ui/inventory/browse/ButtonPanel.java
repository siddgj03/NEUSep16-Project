package org.neu.project.ui.inventory.browse;

import org.neu.project.ui.inventory.browse.components.BrowseButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
	BrowseButton btnView;
	BrowseButton btnEdit;
	BrowseButton btnDelete;
	BrowseButton btnAdd;

	public ButtonPanel(JFrame currentFrame) {
		// Arrange in vertical order, with spacing of 10
		super(new GridLayout(4,1,0,5));

		BrowseActionListener commonListener = new BrowseActionListener();
		commonListener.setFrame(currentFrame);

		btnView = new BrowseButton("View Vehicle", BrowseInventory.COMMAND_VIEW, commonListener);
		btnEdit = new BrowseButton("Edit Vehicle", BrowseInventory.COMMAND_EDIT, commonListener);
		btnDelete = new BrowseButton("Delete Vehicle", BrowseInventory.COMMAND_DELETE, commonListener);
		btnAdd = new BrowseButton("Add New Vehicle", BrowseInventory.COMMAND_ADD, commonListener);

		add(btnView);
		add(btnEdit);
		add(btnDelete);
		add(btnAdd);
	}

	private void addListener() {
		// Look for what's checked in the results panel

	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		comp.setMaximumSize( comp.getPreferredSize() ); // Limits size from expanding
		return comp;
	}
}

class BrowseActionListener implements ActionListener {
	private JFrame frame;

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case BrowseInventory.COMMAND_ADD:
				frame.dispose();
		}
	}
}