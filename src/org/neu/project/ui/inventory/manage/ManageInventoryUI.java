package org.neu.project.ui.inventory.manage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.dto.Vehicle.VehicleInfo;
import org.neu.project.service.InventoryManagerImp;
import org.neu.project.ui.common.BaseFrame;

import com.sun.org.apache.bcel.internal.generic.NEW;



public class ManageInventoryUI extends BaseFrame{
	
	protected JButton saveButton;
	protected JButton cancelButton;
	protected JButton clearButton;
	
	protected JLabel dealerIdLabel;
	protected JLabel vehicleIdInfo;
	protected JComboBox carYearInfo;
	protected JComboBox categoryInfo;
	protected JTextField carModelInfo;
	protected JTextField carMakeInfo;
	protected JTextField trimInfo;
	protected JTextField typeInfo;
    protected JTextField carPriceInfo;
	
	// Static values
	private static final int scrWidth = 700;
	private static final int scrHeight = 300;
	
	// Dealer
	private String dealerId;
	
	// Vehicle
	private Vehicle currentVehicle;
	
	// InventoryManagerImp
	private InventoryManagerImp imp = new InventoryManagerImp();
	
	private boolean bAddVehicle;
	
	public ManageInventoryUI(){
		super(scrWidth, scrHeight);
	}
	/**
	 * Open ManageInventoryUI
	 * @param vehicle : Pass a current selected vehicle, if adding a new vehicle, please pass a new Vehicle(dealerId).
	 * @param bAddVehicle : If add a new vehicle : true, else : false.
	 */
	public ManageInventoryUI(Vehicle vehicle, boolean bAddVehicle) {
		super(scrWidth, scrHeight);
		display();
		currentVehicle = vehicle;
		this.dealerId = currentVehicle.getWebId();
		setupContent();
		this.bAddVehicle = bAddVehicle;
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setupContent(){
		dealerIdLabel.setText(dealerId);
		vehicleIdInfo.setText(currentVehicle.getId());
		carMakeInfo.setText(currentVehicle.getMake() == null ? "" : currentVehicle.getMake());
		trimInfo.setText(currentVehicle.getTrim() == null ? "" : currentVehicle.getTrim());
		carModelInfo.setText(currentVehicle.getModel() == null ? "" : currentVehicle.getModel());
		typeInfo.setText(currentVehicle.getType() == null ? "" : currentVehicle.getType());
		carPriceInfo.setText(String.valueOf(currentVehicle.getPrice()));
		categoryInfo.setSelectedItem(currentVehicle.getCategory());
		carYearInfo.setSelectedItem(currentVehicle.getYear());
	}
	
	@Override
	protected void create() {
		this.setTitle("Manage Inventory");
	}

	@Override
	protected void add() {
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		
		ComponetInitialize(new JLabel("Dealer ID : "), 0, 0, 1, 1, false);
		dealerIdLabel = new JLabel();
		ComponetInitialize(dealerIdLabel, 1, 0, 3, 1, true);
		
		ComponetInitialize(new JLabel("Vehicle ID : "), 0, 1, 1, 1, false);
	    vehicleIdInfo = new JLabel();
	    ComponetInitialize(vehicleIdInfo, 1, 1, 3, 1, true);
	    
	    ComponetInitialize(new JLabel("Type : "), 0, 2, 1, 1, false);
	    typeInfo = new JTextField();
	    ComponetInitialize(typeInfo, 1, 2, 1, 1, true);
	    
	    ComponetInitialize(new JLabel("Make : "), 2, 2, 1, 1, false);
	    carMakeInfo = new JTextField();
	    ComponetInitialize(carMakeInfo, 3, 2, 1, 0, true);
	    
	    ComponetInitialize(new JLabel("Category : "), 0, 3, 1, 1, false);
	    categoryInfo = new JComboBox();
	    categoryInfo.addItem("new");
	    categoryInfo.addItem("used");
	    categoryInfo.addItem("certified");
	    ComponetInitialize(categoryInfo, 1, 3, 1, 0, true);
	    
	    ComponetInitialize(new JLabel("Year : "), 2, 3, 1, 1, false);
	    carYearInfo = new JComboBox();
	    for(int i = 1970; i <= 2016; i++){
	    	carYearInfo.addItem(i);
	    }
	    ComponetInitialize(carYearInfo, 3, 3, 1, 0, true);

	    ComponetInitialize(new JLabel("Model : "), 0, 4, 1, 1, false);
	    carModelInfo = new JTextField();
	    ComponetInitialize(carModelInfo, 1, 4, 1, 0, true);

	    ComponetInitialize(new JLabel("Trim : "), 2, 4, 1, 1, false);
	    trimInfo = new JTextField();
	    ComponetInitialize(trimInfo, 3, 4, 1, 0, true);

	    ComponetInitialize(new JLabel("Price : "), 0, 5, 1, 1, false);
	    carPriceInfo = new JTextField();
	    ComponetInitialize(carPriceInfo, 1, 5, 1, 0, true);
	    
	    saveButton = new JButton("Save"); 
	    ComponetInitialize(saveButton, 0, 6, 1, 1, false);
	    clearButton = new JButton("Clear");
	    ComponetInitialize(clearButton, 1, 6, 1, 1, false);
	    cancelButton = new JButton("Cancel");
	    ComponetInitialize(cancelButton, 3, 6, 1, 1, false);
	}

	@Override
	protected void addListener() {
		saveButton.addActionListener(new saveEventListener());
		clearButton.addActionListener(new clearEventListener());
		cancelButton.addActionListener(new cancelEventListener());
		carPriceInfo.addKeyListener(new keyTypeListener());
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
	
	class saveEventListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(carMakeInfo.getText().equals("") || trimInfo.getText().equals("") || typeInfo.getText().equals("")
					|| carPriceInfo.getText().equals("") || carModelInfo.getText().equals("")){
				JOptionPane.showMessageDialog(rootPane, "Some slots are empty.");
				return;
			}
			
			try{
				Double.parseDouble(carPriceInfo.getText());
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(rootPane, "Value of Price is Invalid.");
				return;
			}
				
			if(bAddVehicle){
				setupVehicleAttributes();
				imp.addVehicleToInventory(currentVehicle.getWebId(), currentVehicle);
				System.out.println(currentVehicle.getId() + " is Added !");
			}
			else{
				setupVehicleAttributes();
				imp.updateInventory(currentVehicle.getWebId(), currentVehicle);
				System.out.println(currentVehicle.getId() + " is Updated !");
			}
			
			dispose();
		}
	}
	
	private void setupVehicleAttributes(){
		currentVehicle.setCategory(categoryInfo.getSelectedItem().toString());
		currentVehicle.setMake(carMakeInfo.getText());
		currentVehicle.setModel(carModelInfo.getText());
		currentVehicle.setTrim(trimInfo.getText());
		currentVehicle.setType(typeInfo.getText());
		currentVehicle.setPrice(carPriceInfo.getText());
		currentVehicle.setYear(carYearInfo.getSelectedItem().toString());
	}
	
	class clearEventListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			carMakeInfo.setText("");
			trimInfo.setText("");
			carPriceInfo.setText("0.0");
			carModelInfo.setText("");
			typeInfo.setText("");
			categoryInfo.setSelectedIndex(0);
			carYearInfo.setSelectedIndex(0);
		}
	}
	
	class cancelEventListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();	
		}
	}
	
	class keyTypeListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			char vchar = e.getKeyChar();
			if(!Character.isDigit(vchar)){
				if(vchar != '.' && vchar != KeyEvent.VK_DELETE && vchar != KeyEvent.VK_BACK_SPACE)
					e.consume();
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}
	
    public static void main(String[] args) {
    	InventoryManagerImp browseImp = new InventoryManagerImp();
    	Inventory inventory = browseImp.getInventory("gmps-bertogden-cch");
    	Vehicle vehicle = (Vehicle)inventory.getVehicles().toArray()[0];
    	Vehicle vehicle2 = new Vehicle("gmps-bertogden-cch");
    	new ManageInventoryUI(vehicle, false);
    	
    }

}

