package org.neu.project.service;

import org.neu.project.dto.Inventory;


/**
 * please refer to InventorySearchControl and InventorySortControl
 *
 */

public interface InventoryManager {
    
	public InventorySearchControl getInventorySearchControl(String dealerId);

	public Inventory getInventory(String dealerId);

	public InventorySearchControl getInventorySearchControlForMakeSelection(String make, String dealerId);

	public Inventory sort(String sortCriterion, Inventory inventory);

}
