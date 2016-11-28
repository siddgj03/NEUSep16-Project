package org.neu.project.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;

public class InventoryDAO {
    
	// key : dealerId, value : Inventory of specific dealer
	private HashMap<String, Inventory> dealerInventory;
	private VehicleReader reader;
	//private VehicleWriter writer;
    
	public InventoryDAO(){
		dealerInventory = new HashMap<String, Inventory>();
		reader = new VehicleReader();
		reader.readAllVehicleFiles();
		setUpInventory();
	}
	
	public void addInventory(String dealerId, Inventory inventory){
		dealerInventory.put(dealerId, inventory);
	}
	
	public void deleteInventory(String dealerId){
		
	}
	
	public void updateInventory(String dealerId){
		
	}
	
	public ArrayList<Inventory> getInventoriesFromReader(){
		return reader.getAllInventories();
	}
	
	public void setUpInventory(){
		ArrayList<Inventory> inventories = getInventoriesFromReader();
		
		for(Inventory i : inventories){
			addInventory(i.getDealerId(), i);
		}
	}
	
	public Inventory getInventoryByDealerId(String dealerId){
		return dealerInventory.get(dealerId);
	}
	
//	public Collection<Vehicle> getVehiclesByDealerId(String dealerId){
//		return dealerInventory.get(dealerId).getVehicles();
//	}
	
	/**
	 * Invoke this function to get "All" Inventories in the system
	 */
	public Collection<Inventory> getAllInventories(){
		return dealerInventory.values();
	}
	
	/**
	 * Invoke this function to get "All" Vehicles in the system
	 */
	public Collection<Vehicle> getAllVehicles(){
		Collection<Inventory> cInventories = getAllInventories();
		Collection<Vehicle> cVehicles = new ArrayList<Vehicle>();
		
		for(Inventory i : cInventories){
			//System.out.println(i.getDealerId() + "\t" + i.getAllVehicles().size());
			cVehicles.addAll(i.getVehicles());
		}
		
		return cVehicles;
	}
    
//	public void writeFile(InventoryResults inventoryResults){
//		
//	}
	
}
