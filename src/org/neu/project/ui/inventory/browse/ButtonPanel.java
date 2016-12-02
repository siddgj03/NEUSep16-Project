package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.service.InventoryManagerImp;
import org.neu.project.ui.inventory.browse.components.BrowseButton;
import org.neu.project.ui.inventory.manage.ManageInventoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JPanel container for Buttons in the BrowseInventory class
 * @author - Ken
 */
public class ButtonPanel extends JPanel {

	public ButtonPanel(BrowseInventory currentFrame) {
		// Arrange in vertical order, with spacing of 10
		super(new GridLayout(4,1,0,5));

		BrowseActionListener commonListener = new BrowseActionListener();
		commonListener.setFrame(currentFrame);

		BrowseButton btnView = new BrowseButton("View Vehicle", BrowseInventory.COMMAND_VIEW, commonListener);
		add(btnView);

		// Only add Dealer-allowed controls
		if (currentFrame.isDealer) {
			BrowseButton btnEdit = new BrowseButton("Edit Vehicle", BrowseInventory.COMMAND_EDIT, commonListener);
			BrowseButton btnDelete = new BrowseButton("Delete Vehicle", BrowseInventory.COMMAND_DELETE, commonListener);
			BrowseButton btnAdd = new BrowseButton("Add New Vehicle", BrowseInventory.COMMAND_ADD, commonListener);

			add(btnEdit);
			add(btnDelete);
			add(btnAdd);
		}
	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		comp.setMaximumSize( comp.getPreferredSize() ); // Limits size from expanding
		return comp;
	}
}

/**
 * Browse button listeners. Takes different actions depending on selection.
 */
class BrowseActionListener implements ActionListener {
	private BrowseInventory frame;

	public void setFrame(BrowseInventory frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Warn user if no vehicle is selected (unless command is Add)
		if (!e.getActionCommand().equals(BrowseInventory.COMMAND_ADD) && frame.getSelectedVehicleId() == null) {
			JOptionPane.showMessageDialog(frame, "Please select a Vehicle.");
			return;
		}

		// Create Vehicle instance of selected vehicle
		InventoryManagerImp imp = new InventoryManagerImp();
		Inventory iv = imp.getInventory(frame.getDealerId());
		Vehicle selectedVehicle = iv.getVehicleById(frame.getSelectedVehicleId());

		switch(e.getActionCommand()) {
			case BrowseInventory.COMMAND_VIEW:
				System.out.println("Viewing Vehicle ID: " + selectedVehicle.getId());
				break;
			case BrowseInventory.COMMAND_EDIT:
				new ManageInventoryUI(selectedVehicle, false);
				break;
			case BrowseInventory.COMMAND_ADD:
				new ManageInventoryUI(new Vehicle(), true);
				break;
			case BrowseInventory.COMMAND_DELETE:
				int dialogResult = JOptionPane.showConfirmDialog(
						frame,
						"Are you sure you want to delete vehicle ID: " + frame.getSelectedVehicleId() + "?",
						"Confirm Deletion",
						JOptionPane.YES_NO_OPTION
				);
				if (dialogResult == JOptionPane.YES_OPTION) {
					// Delete from UI, then delete from Source
					frame.removeVehicle(selectedVehicle);
					imp.deleteVehicle(frame.getDealerId(), frame.getSelectedVehicleId());
					frame.setSelectedVehicleId(null);
				}
				break;
		}
	}
}