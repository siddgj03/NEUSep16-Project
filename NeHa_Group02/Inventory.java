package finalProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Inventory {
    
    HashMap<String, Vehicle> pool;
    private String[] titles;
    
    public Inventory() {
        pool = new HashMap<String, Vehicle>();
        titles = new String[] {"ID", "DealerID", "Category", "Year", "Make", "Model", "Trim", "Type", "Price"};
        
    }
    
    public String[] getTitles() {
        return titles;
    }
    
    public void addVehicle(Vehicle vec) {
        if (!pool.containsKey(vec.getId())) {
            pool.put(vec.getId(), vec);
        }
    }
    
    public Collection<Vehicle> getAllVehicles() {
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


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
