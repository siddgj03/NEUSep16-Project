package manageInventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class InventoryManager {
	/*
	 * Singleton design of this class
	 * Call static method InventoryManager.getInstance() to get the unique instance
	 * */
	private static InventoryManager instance = new InventoryManager();
	// HashMap for vehicles. Key : Id, Value : Dealer object
	private HashMap<String, Dealer> dealers = new HashMap<String, Dealer>();
	private long maxVin = Long.MIN_VALUE;
	 
	private InventoryManager(){
		
	}
	/*
	 * Refresh Max Vin whenever adding a new vehicle
	 * */
	private void refreshMaxVin(long vin){
		maxVin = vin > maxVin ? vin : maxVin;
	}
	
	public boolean containsDealer(String dealerID){
		return dealers.containsKey(dealerID);
	}
	
	public void addDealer(String[] attributes) {
		String id = attributes[0];
		String name = attributes[1];
		String url = attributes[2];
		Dealer newDealer = new Dealer(id, name, url);
		dealers.put(id, newDealer);
	}
	
	public void addDealerAndSave(String[] attributes) {
		addDealer(attributes);
		saveDealers();
	}
	
	public void updateDealer(Dealer dealer){
		dealers.replace(dealer.getId(), dealer);
		saveDealers();
	}
	
	public void saveDealers(){
		try {
			TextWriter.getInstance().writeDealersIntoFile(dealers.values(), TextReader.defaultDirectory + "car-dealers");
		} catch (Exception e) {
			System.out.println("Something error when writing dealers into file !");
		}
		
	}
	
	public Collection<Dealer> getDealers(){
		return dealers.values();
	}
	
	public Dealer getDealerById(String dealerId){
		return dealers.get(dealerId);
	}
	
	public void addVehicleByDealer(String[] attributes){
		Vehicle vehicle = new Vehicle();
		vehicle.setId(Long.parseLong(attributes[0]));
		vehicle.setWebId(attributes[1]);
		vehicle.setCategory(attributes[2]);
		vehicle.setYear(Integer.parseInt(attributes[3]));
		vehicle.setMake(attributes[4]);
		vehicle.setModel(attributes[5]);
		vehicle.setTrim(attributes[6]);
		vehicle.setType(attributes[7]);
		vehicle.setPrice(Double.parseDouble(attributes[8]));
		getDealerById(attributes[1]).addVehicle(vehicle);
		refreshMaxVin(Long.parseLong(attributes[0]));
	}
	/*
	 * You can get unique Vehicle ID by this function
	 * */
	public long getUniqueVin(){
		return maxVin + 1;
	}
	
	public Collection<Vehicle> getVehiclesByDealerId(String dealerID){
		Dealer target = dealers.get(dealerID);
		return target.getVehicles();
	}
	
	public void saveVehiclesByDealerId(String dealerID){
		getDealerById(dealerID).save();
	}
	
	public static InventoryManager getInstance(){
		return instance;
	}
}
