package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.ui.common.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
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
		inv.addVehicle(new Vehicle("a", "123", "SUV", "2014", "Honda", "CR-V", "some trim", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Honda", "Civic", "2-Door", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("a", "123", "SUV", "2014", "Honda", "CR-V", "some trim", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Honda", "Civic", "2-Door", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("a", "123", "SUV", "2014", "Honda", "CR-V", "some trim", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Honda", "Civic", "2-Door", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("a", "123", "SUV", "2014", "Honda", "CR-V", "some trim", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Honda", "Civic", "2-Door", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("a", "123", "SUV", "2014", "Honda", "CR-V", "some trim", "6 Cylinder", "20000"));
		inv.addVehicle(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Honda", "Civic", "2-Door", "6 Cylinder", "20000"));
		this.inventory = inv.getAllVehicles();
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

	public static void main(String args[]) {
		new BrowseInventory("gmps-goldstein", false);
	}
}

/**
 * Example for reference.
 * Renders a scrollable Table.
 */
class ListPanel extends JPanel {
	private JPanel mainList;
	public JTable table;

	public ListPanel() {

		mainList = new JPanel();
		mainList.setLayout(new BorderLayout());

		Object[][] data = getVehicleData();
		String[] labels = {"VIN", "Make", "Model", "Year", "Type", "Color", "Mileage"};
		table = new JTable(data, labels);

		JScrollPane tableContainer = new JScrollPane(table);
		tableContainer.setPreferredSize(new Dimension(500, 150));

		mainList.add(tableContainer, BorderLayout.CENTER);
		add(tableContainer);
	}

	private static Object[][] getVehicleData() {
		Object[][] data = {
				{"VIN-NO1", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO2", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO3", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO4", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO5", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO6", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO7", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO8", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO9", "Honda", "Civic", "2012", "Sedan", "White", "5000"}
		};
		return data;
	}
}