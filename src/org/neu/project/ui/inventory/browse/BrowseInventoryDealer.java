package org.neu.project.ui.inventory.browse;

/**
 * Extension of BrowseInventory class to display for Dealers
 */
public class BrowseInventoryDealer extends BrowseInventory {

	public BrowseInventoryDealer(String dealerId) {
		super(dealerId, true);
	}

}