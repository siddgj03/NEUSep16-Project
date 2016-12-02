package org.neu.project.dto;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.neu.project.dto.Vehicle.VehicleInfo;


public class Inventory {
    
    private HashMap<String, Vehicle> pool;
    private String[] titles;
    private String dealerId;
    
    public Inventory() {
        pool = new HashMap<String, Vehicle>();
    }
    
    public String getDealerId(){
    	return dealerId;
    }
    
    public void setDealerId(String dealerId){
    	this.dealerId = dealerId;
    }
    
    public void setTitles(String[] titles) {
        this.titles = titles;
    }
    
    public String[] getTitles() {
        return titles;
    }
    
    public void addVehicle(Vehicle vec) {
        if (!pool.containsKey(vec.getId())) {
            pool.put(vec.getId(), vec);
        }
    }
    
    public Vehicle getVehicleById(String vehicleId){
    	return pool.get(vehicleId);
    }
    
    public Collection<Vehicle> getVehicles() {
        return pool.values();
    }
    
    public HashSet<String> getAllType() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) {
            ls.add(ve.getType());
        }
        
        return ls;   
    }
    
    public HashSet<String> getAllCategory() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) {
            ls.add(ve.getCategory());
        }
        
        return ls; 
    }
    
    public HashSet<String> getAllModel() {
        
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) ls.add(ve.getModel());
        
        return ls;
    }
    
    public HashSet<String> getAllMaker() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) ls.add(ve.getMake());
        
        return ls;
    }
    
    public void removeVehicle(String vehicleID) {
        if (pool.containsKey(vehicleID)) {
            pool.remove(vehicleID);
        }
    }
    
//    public void modifyCategory(String vehicleID, String category) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setCategory(category);
//        }
//    }
//    
//    public void modifyYear(String vehicleID, String year) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setYear(year);
//        }
//    }
//    
//    public void modifyMaker(String vehicleID, String make) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setMake(make);
//        }
//    }
//    
//    public void modifyModel(String vehicleID, String model) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setModel(model);
//        }
//    }
//    
//    public void modfiyTrime(String vehicleID, String trim) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setTrim(trim);
//        }
//    }
//    
//    public void modfiyType(String vehicleID, String type) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setType(type);
//        }
//    }
//    
//    public void modifyPrice(String vehicleID, String price) {
//        if (pool.containsKey(vehicleID)) {
//            Vehicle ve = pool.get(vehicleID);
//            ve.setPrice(price);
//        }
//    }
    
    public void modifyAttribute(String vehicleID, VehicleInfo attribute, String value){
    	if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            
            switch (attribute) {
			case Category:
				ve.setCategory(value);
				break;
			case Year:
				ve.setYear(value);
				break;
			case Make:
				ve.setMake(value);
				break;
			case Trim:
				ve.setTrim(value);
				break;
			case Model:
				ve.setModel(value);
				break;
			case Price:
				ve.setPrice(value);
				break;
			default:
				break;
			}
        }
    }

}
