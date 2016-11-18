package manageInventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Dealer {
	
	private String id, name, url;
	// HashMap for vehicles. Key : VIN, Value : Vehicle object
	private HashMap<Long, Vehicle> vehicles = new HashMap<Long, Vehicle>();
	 
	public Dealer(String id, String name, String url){
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void addVehicle(Vehicle vehicle){
		vehicles.put(vehicle.getId(), vehicle);
	}
	
	public void addVehicleAndSave(Vehicle vehicle){
		addVehicle(vehicle);
		save();
	}
	
	public void deleteVehicle(long vin){
		vehicles.remove(vin);
		save();
	}
	
	public void updateVehicle(Vehicle vehicle){
		vehicles.replace(vehicle.getId(), vehicle);
		save();
	}
	
	public void save(){
		try {
			TextWriter.getInstance().writeVehiclesIntoFile(vehicles.values(), TextReader.defaultDirectory + id);
		} catch (Exception e) {
			System.out.println("Something error when writing vehicles into file !");
		}
	}
	
	public Collection<Vehicle> getVehicles(){
		return vehicles.values();
	}
	
}
