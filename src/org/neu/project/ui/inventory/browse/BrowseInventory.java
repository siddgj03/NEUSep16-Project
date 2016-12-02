package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.service.InventoryManagerImp;
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
	private Collection<Vehicle> inventory;

	// Mutating variables
	private String selectedVehicleId;

	// Components
	private Container container;
	private JScrollPane resultsContainer;

	/**
	 * Frame constructor with DealerID to determine inventory list
	 * @param dealerId - ID of the Dealer
	 * @param isDealer - TRUE if Dealer, FALSE if Customer
	 */
	BrowseInventory(String dealerId, boolean isDealer) {
		super(scrWidth, scrHeight);

		this.dealerId = dealerId;
		this.isDealer = isDealer;

		setTitle("Inventory List - Dealer ID " + dealerId);
	}

	/**
	 * Loads list of Vehicles to browse through
	 */
	void loadVehicles() {
		InventoryManagerImp invManager = new InventoryManagerImp();
		Inventory inv = invManager.getInventory(dealerId);
		inventory = inv.getVehicles();
	}

	Collection<Vehicle> getInventory() {
		return inventory;
	}

	/**
	 * Refreshes the ResultPanel with whatever is in inventory
	 */
	private void refreshResults() {
		container.remove(resultsContainer);
		addResultsPanel();
		container.validate();
		container.repaint();
	}

	/**
	 * Removes vehicle from the ui's collection, then refreshes Results UI
	 * @param v - Vehicle to remove
	 */
	void removeVehicle(Vehicle v) {
		// Create temporary Inventory, delete then use as current inventory
		Inventory temp = new Inventory();
		for (Vehicle vehicle: inventory) {
			temp.addVehicle(vehicle);
		}
		temp.removeVehicle(v.getId());
		this.inventory = temp.getVehicles();
		refreshResults();
	}

	/**
	 * Sets the inventory. Automatically refreshes the UI
	 * @param inventory - The collection of Vehicle
	 */
	void setInventory(Collection<Vehicle> inventory) {
		if (!this.inventory.equals(inventory)) {
			this.inventory = inventory;
			refreshResults();
		}
	}

	@Override
	protected void add() {
		container = this.getContentPane();
		container.setLayout(new FlowLayout());

		/* Declare and Add Panels here */

		// SearchPanel/Filter panel
		JPanel filterPanel = new JPanel();
		filterPanel.add(new SortPanel(this));
		try {
			SearchPanel searchPane = new SearchPanel(this);
			filterPanel.add(searchPane);
			filterPanel.setPreferredSize(new Dimension(300,600));
		} catch (IOException e) {
			System.out.println(e);
		}
		container.add(filterPanel);

		// Results panel
		addResultsPanel();

		// Arrange Horizontal screen layout
		ButtonPanel buttonPanel = new ButtonPanel(this);
		container.add(buttonPanel);
	}

	/**
	 * Set scrolling panel with fixed dimensions
	 * Always add to the middle container space (index 1)
	 */
	private void addResultsPanel() {
		ResultPanel results = new ResultPanel(this);
		resultsContainer = new JScrollPane(results);
		resultsContainer.setPreferredSize(new Dimension(600,600));
		container.add(resultsContainer, 1);
	}

	@Override
	protected void create() {
		loadVehicles();
	}

	@Override
	protected void addListener() {

	}

	public String getDealerId() {
		return dealerId;
	}

	String getSelectedVehicleId() {
		return selectedVehicleId;
	}

	void setSelectedVehicleId(String selectedVehicleId) {
		this.selectedVehicleId = selectedVehicleId;
	}

//	public static void main(String args[]) {
//		BrowseInventory bi = new BrowseInventory("gmps-priority", true);
//		bi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		bi.display();
//	}
}