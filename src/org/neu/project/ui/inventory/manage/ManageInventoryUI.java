package org.neu.project.ui.inventory.manage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.neu.project.ui.common.BaseFrame;


public class ManageInventoryUI extends BaseFrame{
	
	protected JButton saveButton;
	protected JButton cancelButton;
	protected JButton clearButton;
	
	protected JLabel dealerIdLabel;
	protected JTextField vehicleIdInfo;
	protected JComboBox carYearInfo;
	protected JComboBox carMakeInfo;
	protected JComboBox carModelInfo;
	protected JTextField categoryInfo;
	protected JTextField trimInfo;
    protected JTextField carPriceInfo;
	
	// Static values
	private static final int scrWidth = 600;
	private static final int scrHeight = 250;
	
	// Dealer
	private String dealerId;
	
	public ManageInventoryUI(String dealerId) {
		super(scrWidth, scrHeight);
		this.dealerId = dealerId;
		dealerIdLabel.setText(dealerId);
	}

	@Override
	protected void create() {
		this.setTitle("Manage Inventory");
	}

	@Override
	protected void add() {
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		//container.setBounds(10, 10, 500, 300);
		
		ComponetInitialize(new JLabel("Dealer ID : "), 0, 0, 1, 1, false);
		dealerIdLabel = new JLabel();
		ComponetInitialize(dealerIdLabel, 1, 0, 1, 1, false);
		
		// use UUID to assign a id to vehicle
		ComponetInitialize(new JLabel("Vehicle ID : "), 0, 1, 1, 1, false);
	    vehicleIdInfo = new JTextField();
	    ComponetInitialize(vehicleIdInfo, 1, 1, 3, 400, true);
	    
	    ComponetInitialize(new JLabel("Make : "), 0, 2, 1, 1, false);
	    carMakeInfo = new JComboBox();
	    ComponetInitialize(carMakeInfo, 1, 2, 1, 0, true);
	    
	    ComponetInitialize(new JLabel("Category : "), 2, 2, 1, 1, false);
	    categoryInfo = new JTextField();
	    ComponetInitialize(categoryInfo, 3, 2, 1, 0, true);
	    
	    ComponetInitialize(new JLabel("Year : "), 0, 3, 1, 1, false);
	    carYearInfo = new JComboBox();
	    ComponetInitialize(carYearInfo, 1, 3, 1, 0, true);

	    ComponetInitialize(new JLabel("Model : "), 2, 3, 1, 1, false);
	    carModelInfo = new JComboBox();
	    ComponetInitialize(carModelInfo, 3, 3, 1, 0, true);

	    ComponetInitialize(new JLabel("Trim : "), 0, 4, 1, 1, false);
	    trimInfo = new JTextField();
	    ComponetInitialize(trimInfo, 1, 4, 1, 0, true);

	    ComponetInitialize(new JLabel("Price : "), 2, 4, 1, 1, false);
	    carPriceInfo = new JTextField();
	    ComponetInitialize(carPriceInfo, 3, 4, 1, 0, true);
	    
	    saveButton = new JButton("Save"); 
	    ComponetInitialize(saveButton, 0, 5, 1, 1, false);
	    clearButton = new JButton("Clear");
	    ComponetInitialize(clearButton, 1, 5, 1, 1, false);
	    cancelButton = new JButton("Cancel");
	    ComponetInitialize(cancelButton, 2, 5, 1, 1, false);
	}

	@Override
	protected void addListener() {
		
		
	}
	
	protected void ComponetInitialize(JComponent component, int x, int y, int width, int ipadx, boolean fill) {
		Container container = this.getContentPane();
		GridBagConstraints gridBagConstrains = new GridBagConstraints();
	    gridBagConstrains.gridx = x;
	    gridBagConstrains.gridy = y;
	    gridBagConstrains.insets = new Insets(5, 1, 3, 1);
	    if (width > 1) {
	      gridBagConstrains.gridwidth = width;
	    }
	    if (ipadx > 0) {
	      gridBagConstrains.ipadx = ipadx;
	    }
	    if (fill) {
	      gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
	    }
	    container.add(component, gridBagConstrains);
    }

//    public static void main(String[] args) {
//    	new ManageInventoryUI("gmps-aj-dohmann");
//    }

}

