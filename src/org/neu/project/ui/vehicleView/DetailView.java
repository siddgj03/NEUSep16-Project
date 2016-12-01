package org.neu.project.ui.vehicleView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;

import org.neu.project.dto.Rating;
import org.neu.project.dto.Special;
import org.neu.project.dto.Vehicle;
import org.neu.project.ui.vehicleView.common.DetailViewBaseFrame;

/**
 * @author Rachel
 */
public class DetailView extends DetailViewBaseFrame {
	public static final int scrWidth = 1020;
	public static final int scrHeight = 720;
	Vehicle selectedVehicle = null;
	// using hashMap to store specials instead of ArrayList because finding a
	// element in a hashMap is constant time

	public DetailView(Vehicle selectedVehicle) {
		super(scrWidth, scrHeight);
		this.selectedVehicle = selectedVehicle;
		add();
		setup();
	}

	@Override
	protected void add() {
		this.add(new TabPanel(selectedVehicle));
	}

	public static void main(String arg[]) {
//		HashMap<String, Special> specialListMap = new HashMap<String, Special>();
//		Special s1 = new Special();
//		Special s2 = new Special();
//		s1.setSpecialTitle("16-40AX:14 Bonus Cash Program");
//		s1.setDiscountValue(500.00);
//		s1.setSpecialEndDate(new Date());
//		s1.setCarYear(2016);
//		s1.setDescription("16-40AX:14 Bonus Cash Program");
//		s1.setDisclosure("Not available with special finance or lease offers. Take delivery by 11-30-2016.");
//
//		s2.setSpecialTitle("16-40AX:14 Percent Program");
//		s2.setDiscountPercentage(10.00);
//		s2.setCarModel("ATS");
//		s2.setCarMake("Cadillac");
//		s2.setDescription("16-40AX:14 Percent Program");
//		s2.setDisclosure("Not available with special finance or lease offers. Take delivery by 11-30-2016.");
//		s2.setSpecialEndDate(new Date());
//		List<Special> specialList = new ArrayList<>();
//		specialList.add(s1);
//		specialList.add(s2);
//		Utility.setSpecialListArray(specialList);
//		specialListMap.put(s1.getSpecialTitle(), s1);
//		specialListMap.put(s2.getSpecialTitle(), s2);
//		Utility.setSpecialListMap(specialListMap);

		makeVehicleList();
		Vehicle vehicle = new Vehicle();
		vehicle.setTitle("NEW 2016 BUICK ENCORE FWD");
		vehicle.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle.setPrice("24990");
//		vehicle.setSale(19992);
//		vehicle.setSave(4998);
//		vehicle.setExpires("11/30/2016");
		vehicle.setCategory("new");
		vehicle.setMake("Cadillac");
		vehicle.setModel("ATS");
		vehicle.setYear("2016");
		vehicle.setColor("white");
		vehicle.setBodyType("Compact");
		vehicle.setTrim("3.6L V6 RWD Luxury");
		setVehicleRating(vehicle);
		new DetailView(vehicle);
	}

	private static void setVehicleRating(Vehicle vehicle) {
		Rating rating = new Rating();
		rating.setAverRate(4.5f);
		rating.setVoteCount(99);
		vehicle.setRating(rating);
	}

	private static void makeVehicleList() {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setTitle("vehicle 1 NEW 2016 BUICK ENCORE FWD");
		vehicle1.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle1.setPrice(24990);
//		vehicle1.setSale(19992);
//		vehicle1.setSave(4998);
//		vehicle1.setExpires("11/30/2016");
		vehicle1.setCategory("new");
		vehicle1.setMake("Cadillac");
		vehicle1.setModel("ATS");
		vehicle1.setYear("2016");
		vehicle1.setColor("white");
		vehicle1.setBodyType("Compact");
		vehicle1.setTrim("3.6L V6 RWD Luxury");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setTitle("vehicle 2 NEW 2016 BUICK ENCORE FWD");
		vehicle2.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle2.setPrice("25000");
//		vehicle2.setSale(19992);
//		vehicle2.setSave(4998);
//		vehicle2.setExpires("11/30/2016");
		vehicle2.setCategory("new");
		vehicle2.setMake("Cadillac");
		vehicle2.setModel("ATS");
		vehicle2.setYear("2016");
		vehicle2.setColor("black");
		vehicle2.setBodyType("Compact");
		vehicle2.setTrim("3.6L V6 RWD Luxury");

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setTitle("vehicle 3 NEW 2016 BUICK ENCORE FWD");
		vehicle3.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle3.setPrice("24000");
//		vehicle3.setSale(19992);
//		vehicle3.setSave(4998);
//		vehicle3.setExpires("11/30/2016");
		vehicle3.setCategory("new");
		vehicle3.setMake("Cadillac");
		vehicle3.setModel("ATS");
		vehicle3.setYear("2016");
		vehicle3.setColor("red");
		vehicle3.setBodyType("Compact");
		vehicle3.setTrim("3.6L V6 RWD Luxury");

		Vehicle vehicle4 = new Vehicle();
		vehicle4.setTitle("vehicle 4 NEW 2016 BUICK ENCORE FWD");
		vehicle4.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle4.setPrice("24000");
//		vehicle4.setSale(19992);
//		vehicle4.setSave(4998);
//		vehicle4.setExpires("11/30/2016");
		vehicle4.setCategory("new");
		vehicle4.setMake("Cadillac");
		vehicle4.setModel("ATS");
		vehicle4.setYear("2016");
		vehicle4.setColor("red");
		vehicle4.setBodyType("Compact");
		vehicle4.setTrim("3.6L V6 RWD Luxury");

		Vehicle vehicle5 = new Vehicle();
		vehicle5.setTitle("vehicle 5 NEW 2016 BUICK ENCORE FWD");
		vehicle5.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle5.setPrice("24000");
//		vehicle5.setSale(19992);
//		vehicle5.setSave(4998);
//		vehicle5.setExpires("11/30/2016");
		vehicle5.setCategory("new");
		vehicle5.setMake("Cadillac");
		vehicle5.setModel("ATS");
		vehicle5.setYear("2016");
		vehicle5.setColor("red");
		vehicle5.setBodyType("Compact");
		vehicle5.setTrim("3.6L V6 RWD Luxury");

		Vehicle vehicle6 = new Vehicle();
		vehicle6.setTitle("vehicle 6 NEW 2016 BUICK ENCORE FWD");
		vehicle6.setImagePath("src/data/image/vehicle/pathList.txt");
		vehicle6.setPrice("24000);
//		vehicle6.setSale(19992);
//		vehicle6.setSave(4998);
//		vehicle6.setExpires("11/30/2016");
		vehicle6.setCategory("new");
		vehicle6.setMake("Cadillac");
		vehicle6.setModel("ATS");
		vehicle6.setYear("2016");
		vehicle6.setColor("red");
		vehicle6.setBodyType("Compact");
		vehicle6.setTrim("3.6L V6 RWD Luxury");

		List<Vehicle> vList = new ArrayList<>();
		vList.add(vehicle1);
		vList.add(vehicle2);
		vList.add(vehicle3);
		vList.add(vehicle4);
		vList.add(vehicle5);
		vList.add(vehicle6);
		Utility.setVehicleList(vList);

	}

}
