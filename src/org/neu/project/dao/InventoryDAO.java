package org.neu.project.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.InventoryResults;
import org.neu.project.dto.Vehicle;

public class InventoryDAO {
    
	private InventoryResults inventoryResults;
	private VehicleReader reader;
	//private VehicleWriter writer;
    
	public InventoryDAO(){
		inventoryResults = new InventoryResults();
		reader = new VehicleReader();
		reader.readAllVehicleFiles();
		setUpInventoryResult();
	}
	
	public void createInventory(String dealerId){
		
	}
	
	public void deleteInventory(String dealerId){
		
	}
	
	public void updateInventory(String dealerId){
		
	}
	
	public ArrayList<Inventory> getInventoriesFromReader(){
		return reader.getAllInventories();
	}
	
	public void setUpInventoryResult(){
		ArrayList<Inventory> inventories = getInventoriesFromReader();
		
		for(Inventory i : inventories){
			inventoryResults.addInventoryByDealerId(i.getDealerId(), i);
		}
	}
	
	public Inventory getInventory(String dealerId){
		return inventoryResults.getInventoryByDealerId(dealerId);
	}
	
	public Collection<Vehicle> getAllVehicles(){
		return inventoryResults.getAllVehicles(); 
	}
    
//	public void writeFile(InventoryResults inventoryResults){
//		
//	}
	
}
