package src.org.neu.project.service;

import java.util.*;


public class InventorySearchControl {
	public List<Vehicle> filterMake(List<Vehicle> vehicles, String make) {
	    
		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getMake().equals(make))
	    		result.add(v);
	    }
	    
	    return result;
	}
	
    public List<Vehicle> filterType(List<Vehicle> vehicles, String type) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getType().equals(type))
	    		result.add(v);
	    }
	    
	    return result;
    }

    public List<Vehicle> filterCategory(List<Vehicle> vehicles, String category) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getCategory().equals(category))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<Vehicle> filterCarId(List<Vehicle> vehicles, String carId) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getId().equals(carId))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<Vehicle> filterYear(List<Vehicle> vehicles, int year) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getYear()==year)
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<Vehicle> filterModel(List<Vehicle> vehicles, String model) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getModel().equals(model))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<Vehicle> filterTrim(List<Vehicle> vehicles, String trim) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getTrim().equals(trim))
	    		result.add(v);
	    }
	    
	    return result;
    }
	
    public List<Vehicle> filterPrice(List<Vehicle> vehicles, int price) {

		List<Vehicle> result = new ArrayList<Vehicle>();
	    for(Vehicle v : vehicles){
	    	if(v.getPrice()<=price)
	    		result.add(v);
	    }
	    
	    return result;
    }
}
