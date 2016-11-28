package org.neu.project.dao;

import java.io.File;

import org.neu.project.dto.Vehicle;
import org.neu.project.dto.Vehicle.VehicleInfo;

public class VehicleReader extends ReadFile{
	
	private InventoryDAO inventoryDAO;
	private String defaultPath;
	
	public VehicleReader() {
		super();
		inventoryDAO = new InventoryDAO();
		defaultPath = System.getProperty("user.dir") + "/data/";
	}
	/*
	 * Invoke this function to start reading all files of vehicles
	 * */
	public void readAllVehicleFiles(){
		File file = new File(defaultPath);
		String[] fileNames = file.list();
		
		for(String s: fileNames){
			if(!s.contains("dealer")){
				inventoryDAO.createNewInventory(s);
				ReadFileHelper(defaultPath + s);
				//System.out.println(defaultPath + s);
			}
		}
	}
	
	@Override
	public void ReadFileLine(String line) {
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
		inventoryDAO.getVehicleFromFile(vehicle);
	}
	
//	public static void main(String[] args){
//		VehicleReader vr = new VehicleReader();
//		vr.readAllVehicleFiles();
//		System.out.println(vr.inventoryDAO.getInventory("gmps-jimmy").getAllVehicles().size());
//	}

}
