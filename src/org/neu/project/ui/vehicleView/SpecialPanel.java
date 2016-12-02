package org.neu.project.ui.vehicleView;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.neu.project.dto.Special;
import org.neu.project.dto.Vehicle;

import org.neu.project.ui.vehicleView.common.DetailViewBasePanel;

public class SpecialPanel extends DetailViewBasePanel {

	

	public SpecialPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		add();
	}

	 protected void add() {
		
	}

	
}
