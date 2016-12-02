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
	private VehicleWriter writer;
	private String defaultPath = System.getProperty("user.dir") + "/data/";
    
	public InventoryDAO(){
		dealerInventory = new HashMap<String, Inventory>();
		reader = new VehicleReader();
		reader.readAllVehicleFiles();
		setUpInventory();
		writer = new VehicleWriter();
	}
	
	public void addInventory(String dealerId, Inventory inventory){
		dealerInventory.put(dealerId, inventory);
	}
	
	public void addVehicleToInventory(String dealerId, Vehicle vehicle){ 
		getInventoryByDealerId(dealerId).addVehicle(vehicle);
		try{
			writer.add(vehicle, defaultPath + dealerId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//writeToFile(dealerId);
	}
	
	public void removeVehicleFromInventory(String dealerId, String vehicleId){
		getInventoryByDealerId(dealerId).removeVehicle(vehicleId);
		try{
			Collection<Vehicle> vehicles = getInventoryByDealerId(dealerId).getVehicles();
			writer.delete(vehicles, defaultPath + dealerId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//writeToFile(dealerId);
	}
	
	public void updateInventoryInfo(String dealerId, Vehicle vehicle){
		getInventoryByDealerId(dealerId).updateVehicle(vehicle);
		try{
			Collection<Vehicle> vehicles = getInventoryByDealerId(dealerId).getVehicles();
			writer.update(vehicles, defaultPath + dealerId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//writeToFile(dealerId);
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
			cVehicles.addAll(i.getVehicles());
		}
		
		return cVehicles;
	}
    
//	public void writeToFile(String dealerId){
//		System.out.println("Save ======= " + dealerId);
//		Inventory inventory = getInventoryByDealerId(dealerId);
//		writer.setInventory(inventory);
//		try{
//			writer.writeIntoFile(dealerId);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
