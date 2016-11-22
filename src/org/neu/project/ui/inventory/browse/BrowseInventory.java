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
	// Dealer
	private String dealerId;
	// Use InventoryPool -> Get inventory by Dealer ID
	public Collection<Vehicle> inventory;
	// Components
	private ButtonPanel buttonPanel;

	public BrowseInventory(String dealerId) {
		super(scrWidth, scrHeight);
		this.dealerId = dealerId;
	}

	private void refresh() {
//		Inventory inv = new Inventory();
//		Vehicle test = new Vehicle("a", "123", "SUV", "2014", "CRV", "Honda", "some trim", "6 Cylinder", "20000");
//		inv.addVehicle(test);
//		this.inventory = inv.getAllVehicles();
		ArrayList<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle("a", "gmps-goldstein", "SUV", "2014", "CRV", "Honda", "4-Door", "6 Cylinder", "25000"));
		list.add(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Civic", "Honda", "2-Door", "6 Cylinder", "20000"));
		list.add(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Civic", "Honda", "2-Door", "6 Cylinder", "20000"));
		list.add(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Civic", "Honda", "2-Door", "6 Cylinder", "20000"));
		list.add(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Civic", "Honda", "2-Door", "6 Cylinder", "20000"));
		list.add(new Vehicle("b", "gmps-goldstein", "Sedan", "2016", "Civic", "Honda", "2-Door", "6 Cylinder", "20000"));
		System.out.println(list.toString());
		this.inventory = list;
	}

	@Override
	protected void create() {
		this.setTitle("Inventory List");
		refresh();
	}

	@Override
	protected void add() {
		Container container = this.getContentPane();
		// First layout to separate header, controls and footer
//		GridLayout layoutMaster = new GridLayout(1,3,0,10);
		container.setLayout(new FlowLayout());

		/* Declare and Add Panels here */

		// Search/Filter panel
		JPanel filterPanel = new JPanel();
//		SearchPanel searchPane = new SearchPanel();
//		filterPanel.add(searchPane);
		filterPanel.add(new SortUI());
		filterPanel.setPreferredSize(new Dimension(300,720));

		// Results panel
		JPanel resultsMaster = new JPanel();
		resultsMaster.setLayout(new GridLayout(0, 1, 0, 5));
		ResultPanel results = new ResultPanel(inventory);
		resultsMaster.add(results);
		JScrollPane resultsCont = new JScrollPane(results);
		resultsCont.setPreferredSize(new Dimension(600,400));

		// Arrange Horizontal screen layout
		container.add(filterPanel);
		container.add(resultsCont);
		buttonPanel = new ButtonPanel();
		container.add(buttonPanel);
	}

	@Override
	protected void addListener() {

	}

	public static void main(String args[]) {
		new BrowseInventory("TestID1");
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