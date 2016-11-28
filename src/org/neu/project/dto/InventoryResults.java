package org.neu.project.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class InventoryResults {
	// key : dealerId, value : Inventory of specific dealer
	private HashMap<String, Inventory> dealerInventory;
	
	public InventoryResults(){
		dealerInventory = new HashMap<String, Inventory>();
	}
	
	public void addInventoryByDealerId(String dealerId, Inventory inventory){
		dealerInventory.put(dealerId, inventory);
	}
	
	public Inventory getInventoryByDealerId(String dealerId){
		return dealerInventory.get(dealerId);
	}
	
	public Collection<Vehicle> getVehiclesByDealerId(String dealerId){
		return dealerInventory.get(dealerId).getVehicles();
	}
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
}
