package ui.vehicleView;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpecialPanel extends BasePanel {
	private static final String SPECIAL_APPLIED = "Special Applied";
	private static final String DESCRIPTION = "Description:";
	private static final String CATERIA = "Cateria:";
	private static final String DISCLOSURE = "Disclosure:";
	private static final String EXPIRES = "Expires:";

	public SpecialPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		add();
	}

	private void add() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel selectionPanel = (JPanel) getSelectionPanel();
		add(selectionPanel);
		add(getSpecialDetailPanel(selectionPanel));

	}

	private Component getSpecialDetailPanel(JPanel selectionPanel) {
		// String
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		JComboBox selectionComb = (JComboBox) selectionPanel.getComponent(1);
		
		Special special = Utility.getSpecialList().get(selectionComb.getSelectedItem());
		JLabel description = new JLabel(DESCRIPTION);
		JLabel desContent = new JLabel(special.getDescription());
		JLabel cateria = new JLabel(CATERIA);
		// TODO
		JLabel cateriaContent = new JLabel(special.getCriteria().get("make"));
		JLabel disclosure = new JLabel(DISCLOSURE);
		JLabel disclosureContent = new JLabel(special.getDisclosure());
		JLabel expires = new JLabel(EXPIRES);
		JLabel expiresDate = new JLabel(special.getExpires());

		panel.add(description);
		panel.add(desContent);
		panel.add(cateria);
		panel.add(cateriaContent);
		panel.add(disclosure);
		panel.add(disclosureContent);
		panel.add(expires);
		panel.add(expiresDate);
		return panel;
	}

	private Component getSelectionPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		JLabel specialApplied = new JLabel(SPECIAL_APPLIED);
		JComboBox specialSelection = new JComboBox();
		specialSelection.addItem("special1");
		specialSelection.addItem("special2");
		specialSelection.addItem("special3");
		// TODO: change to ComboBoxModel
		panel.add(specialApplied);
		panel.add(specialSelection);
		return panel;
	}

}
