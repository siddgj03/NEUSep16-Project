package org.neu.project.dao;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.InventoryResults;
import org.neu.project.dto.Vehicle;

public class InventoryDAO {
    
	private InventoryResults result;
    //use filemanager()
    
	public InventoryDAO(){
		result = new InventoryResults();
	}
	
	public void createNewInventory(String dealerId){
		Inventory newInventory = new Inventory();
		result.addInventoryByDealerId(dealerId, newInventory);
	}
	
	public void getVehicleFromFile(Vehicle vehicle){
		Inventory inventory = result.getInventoryByDealerId(vehicle.getWebId());
		inventory.addVehicle(vehicle);
	}
	
    public Inventory getInventory(String dealerId) {
        return result.getInventoryByDealerId(dealerId);
    }
    
}
