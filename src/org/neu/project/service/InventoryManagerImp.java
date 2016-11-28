package org.neu.project.service;

import java.util.Collection;

import org.neu.project.dao.InventoryDAO;
import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;


public class InventoryManagerImp implements InventoryManager{
	
	private InventoryDAO inventoryDao;
	
	public InventoryManagerImp() {
		inventoryDao = new InventoryDAO();
	}
	
	public Collection<Vehicle> getAllVehicles(){
		return inventoryDao.getAllVehicles();
	}
	
	@Override
	public InventorySearchControl getInventorySearchControl(String dealerId) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * Get Inventory for a specific dealer
	 * */
	@Override
	public Inventory getInventory(String dealerId) {
		return inventoryDao.getInventoryByDealerId(dealerId);
	}

	@Override
	public InventorySearchControl getInventorySearchControlForMakeSelection(String make, String dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory sort(String sortCriterion, Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}

//  Example :
//	public static void main(String[] args){
//		InventoryManagerImp im = new InventoryManagerImp(); // instantiate InventoryManagerImp in somewhere.
//		Inventory i = im.getInventory("gmps-bertogden-cch");
//		Collection<Vehicle> vehicles = i.getVehicles(); // return vehicles belonging to gmps-bertogden-cch
//		System.out.println(vehicles.size());
//	
//		Collection<Vehicle> allVehicles = im.getAllVehicles(); // return "All" vehicles in the system.
//		System.out.println(allVehicles.size());
//	}

}
