package org.neu.project.dto;

import java.util.ArrayList;
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
	
	public boolean containsDealer(String dealerId){
		if(dealerInventory.containsKey(dealerId)){
			return true;
		}
		return false;
	}
	
}
