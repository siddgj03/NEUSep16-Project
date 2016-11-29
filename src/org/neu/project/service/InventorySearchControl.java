package src.org.neu.project.service;

import java.util.*;

public class InventorySearchControl {
	public List<vehicle> filterMake(List<vehicle> vehicles, String make) {
	    
		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getMake().equals(make))
	    		result.add(v);
	    }
	    
	    return result;
	}
	
    public List<vehicle> filterType(List<vehicle> vehicles, String type) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getType().equals(type))
	    		result.add(v);
	    }
	    
	    return result;
    }

    public List<vehicle> filterCategory(List<vehicle> vehicles, String category) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getCategory().equals(category))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<vehicle> filterCarId(List<vehicle> vehicles, String carId) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getId().equals(carId))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<vehicle> filterYear(List<vehicle> vehicles, int year) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getYear()==year)
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<vehicle> filterModel(List<vehicle> vehicles, String model) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getModel().equals(model))
	    		result.add(v);
	    }
	    
	    return result;
    }
    
    public List<vehicle> filterTrim(List<vehicle> vehicles, String trim) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getTrim().equals(trim))
	    		result.add(v);
	    }
	    
	    return result;
    }
	
    public List<vehicle> filterPrice(List<vehicle> vehicles, int price) {

		List<vehicle> result = new ArrayList<vehicle>();
	    for(vehicle v : vehicles){
	    	if(v.getPrice()<=price)
	    		result.add(v);
	    }
	    
	    return result;
    }
}

