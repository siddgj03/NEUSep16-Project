package org.neu.project.dao;

import java.io.File;
import java.util.ArrayList;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;
import org.neu.project.dto.Vehicle.VehicleInfo;

public class VehicleReader extends ReadFile{
	
	private String defaultPath;
	private ArrayList<Inventory> inventories;
	private Inventory current;
	
	public VehicleReader() {
		super();
		defaultPath = System.getProperty("user.dir") + "/data/";
		inventories = new ArrayList<Inventory>();
	}
	/*
	 * Invoke this function to start reading all files of vehicles
	 * */
	public void readAllVehicleFiles(){
		File file = new File(defaultPath);
		String[] fileNames = file.list();
		
		for(String s: fileNames){
			if(!s.contains("dealer")){
				//System.out.println(defaultPath + s);
				current = addNewInventory(s);
				readFileHelper(defaultPath + s);
			}
		}
	}
	
	public Inventory addNewInventory(String dealerId){
		Inventory inventory = new Inventory();
		inventory.setDealerId(dealerId);
		inventories.add(inventory);
		return inventory;
	}
	
	public ArrayList<Inventory> getAllInventories(){
		return inventories;
	}
	@Override
	public void readFileLine(String line) {
		String[] attributes = line.split("~");
		 
		String id = attributes[VehicleInfo.Id.ordinal()];
		String webId = attributes[VehicleInfo.WebId.ordinal()];
		String category = attributes[VehicleInfo.Category.ordinal()];
		String year = attributes[VehicleInfo.Year.ordinal()];
		String make = attributes[VehicleInfo.Make.ordinal()];
		String model = attributes[VehicleInfo.Model.ordinal()];
		String trim = attributes[VehicleInfo.Trim.ordinal()];
		String type = attributes[VehicleInfo.Type.ordinal()];
		String price = attributes[VehicleInfo.Price.ordinal()];
		
		Vehicle vehicle = new Vehicle(id, webId, category, year, make, model, trim, type, price);
		current.addVehicle(vehicle);
	}

}
