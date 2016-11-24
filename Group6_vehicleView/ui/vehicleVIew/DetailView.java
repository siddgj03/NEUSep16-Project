package ui.vehicleView;

import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;

import ui.BaseFrame;

public class DetailView extends BaseFrame {
	public static final int scrWidth = 1020;
	public static final int scrHeight = 720;
	Vehicle selectedVehicle = null;
	//using hashMap to store specials instead of ArrayList because finding a element in a hashMap is constant time
	
	public DetailView(Vehicle selectedVehicle) {
		super(scrWidth, scrHeight);
		this.selectedVehicle = selectedVehicle;
		add();
		setup();
	}

	@Override
	protected void create() {
		
		
	}
	@Override
	protected void add() {
		this.add(new TabPanel(selectedVehicle));
	}

	@Override
	protected void addListener() {
		
		
	}
	public static void main(String arg[]){
		HashMap<String,Special> specialList = new HashMap<String,Special>();
		Special s1 = new Special();
		Special s2 = new Special();
		s1.setName("special1");
		HashMap<String,String> criteria1 = new HashMap<String,String>();
		criteria1.put("make", "Cadillac");
		s1.setCriteria(criteria1);x
		HashMap<String,Integer> type1 = new HashMap<String,Integer>();
		type1.put("cash", 500);
		s1.setType(type1);
		s1.setDescription("16-40AX:14 Bonus Cash Program");
		s1.setDisclosure("Not available with special finance or lease offers. Take delivery by 11-30-2016.");
		s1.setExpires("11/30/2016");
		s2.setName("special2");
		HashMap<String,String> criteria2 = new HashMap<String,String>();
		criteria2.put("year", "2016");
		s2.setCriteria(criteria2);
		HashMap<String,Integer> type2 = new HashMap<String,Integer>();
		type2.put("cash", 400);
		s2.setDescription("16-40AX:14 Bonus Cash Program");
		s2.setDisclosure("Not available with special finance or lease offers. Take delivery by 11-30-2016.");
		s2.setExpires("11/30/2016");
		specialList.put(s1.getName(),s1);
		specialList.put(s2.getName(),s2);
		Utility.setSpecialList(specialList);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setTitle("NEW 2016 BUICK ENCORE FWD");
		vehicle.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle.setMsrp(24990);
		vehicle.setSale(19992);
		vehicle.setSave(4998);
		vehicle.setExpires("11/30/2016");
		vehicle.setCategory("new");
		vehicle.setMake("Cadillac");
		vehicle.setModel("ATS");
		vehicle.setYear(2016);
		vehicle.setColor("white");
		vehicle.setBodyType("Compact");
		vehicle.setTrim("3.6L V6 RWD Luxury");
		new DetailView(vehicle);
	}

}
