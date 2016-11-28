package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.ui.common.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;

/**
 * @author ken prayogo
 * Main BrowseInventory UI rendering class
 */
public class BrowseInventory extends BaseFrame {
	// Static values
	private static final int scrWidth = 1200;
	private static final int scrHeight = 720;

	static final String COMMAND_VIEW = "view";
	static final String COMMAND_EDIT = "edit";
	static final String COMMAND_DELETE = "delete";
	static final String COMMAND_ADD = "add";

	// Dealer
	private String dealerId;

	// User/Employee
	boolean isDealer;

	// Use InventoryPool -> Get inventory by Dealer ID
	public Collection<Vehicle> inventory;

	// Mutating variables
	private static String selectedVehicleId;

	// Components

	/**
	 * Frame constructor with DealerID to determine inventory list
	 * @param dealerId - ID of the Dealer
	 * @param isDealer - TRUE if Dealer, FALSE if Customer
	 */
	public BrowseInventory(String dealerId, boolean isDealer) {
		super(scrWidth, scrHeight);
		this.dealerId = dealerId;
		this.isDealer = isDealer;
	}

	/**
	 * Loads list of Vehicles to browse through
	 */
	private void loadVehicles() {
		Inventory inv = new Inventory();
		inv.setDealerId(dealerId);
//		InventoryResults ir = new InventoryResults();
//		Inventory inv = ir.getInventoryByDealerId(dealerId);

		// Temporary placeholder Vehicles
		inv.addVehicle(new Vehicle("a", "gmps-goldstein", "new", "2014", "Honda", "CR-V", "3.6L 2Dr", "SUV", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "new", "2016", "Honda", "Civic", "2-Door", "CAR", "20000"));
		inv.addVehicle(new Vehicle("c", "gmps-goldstein", "new", "2014", "Honda", "CR-V", "3.6L 2Dr", "SUV", "20000"));
		inv.addVehicle(new Vehicle("d", "gmps-goldstein", "new", "2016", "Honda", "Civic", "2-Door", "CAR", "20000"));
		inv.addVehicle(new Vehicle("e", "gmps-goldstein", "new", "2014", "Honda", "CR-V", "3.6L 2Dr", "SUV", "20000"));
		inv.addVehicle(new Vehicle("f", "gmps-goldstein", "new", "2016", "Honda", "Civic", "2-Door", "CAR", "20000"));
		inv.addVehicle(new Vehicle("g", "gmps-goldstein", "new", "2014", "Honda", "CR-V", "3.6L 2Dr", "SUV", "20000"));
		inv.addVehicle(new Vehicle("h", "gmps-goldstein", "new", "2016", "Honda", "Civic", "2-Door", "CAR", "20000"));
		inv.addVehicle(new Vehicle("i", "gmps-goldstein", "new", "2014", "Honda", "CR-V", "3.6L 2Dr", "SUV", "20000"));
		inv.addVehicle(new Vehicle("j", "gmps-goldstein", "new", "2016", "Honda", "Civic", "2-Door", "CAR", "20000"));
		this.inventory = inv.getVehicles();
		System.out.println(inv.getAllModel().toString());
	}

	@Override
	protected void create() {
		this.setTitle("Inventory List");
		loadVehicles();
	}

	@Override
	protected void add() {
		Container container = this.getContentPane();
		// First layout to separate header, controls and footer
//		GridLayout layoutMaster = new GridLayout(1,3,0,10);
		container.setLayout(new FlowLayout());

		/* Declare and Add Panels here */

		// SearchPanel/Filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.add(new SortUI());
		try {
			SearchPanel searchPane = new SearchPanel();
			filterPanel.add(searchPane);
			filterPanel.setPreferredSize(new Dimension(300,600));
		} catch (IOException e) {
			System.out.println(e);
		}

		// Results panel
		ResultPanel results = new ResultPanel(inventory);
		// ToDo: Scroll not working with BorderLayout for now
		JScrollPane resultsContainer = new JScrollPane(results);
		resultsContainer.setPreferredSize(new Dimension(600,600));

		// Arrange Horizontal screen layout
		container.add(filterPanel);
		container.add(resultsContainer);
		// ToDo: Pass in reference to Vehicle data to determine selection
		ButtonPanel buttonPanel = new ButtonPanel(this, isDealer);
		container.add(buttonPanel);
	}

	@Override
	protected void addListener() {

	}

	static String getSelectedVehicleId() {
		return selectedVehicleId;
	}

	static void setSelectedVehicleId(String selectedVehicleId) {
		BrowseInventory.selectedVehicleId = selectedVehicleId;
	}

	public static void main(String args[]) {
		new BrowseInventory("gmps-goldstein", false);
	}
}