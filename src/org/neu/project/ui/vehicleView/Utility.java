package org.neu.project.ui.vehicleView;

import java.util.HashMap;
import java.util.List;

import org.neu.project.dto.Special;
import org.neu.project.dto.Vehicle;
/**
 * @author Rachel
 * */
public class Utility {
	static HashMap<String, Special> specialList;
	static List<Special> specialListArray;
	static List<Vehicle> vehicleList;
    
	public static HashMap<String, Special> getSpecialListMap() {
		return specialList;
	}

	public static void setSpecialListMap(HashMap<String, Special> sList) {
		specialList = sList;
	}

	public static void setSpecialListArray(List<Special> sList) {
		specialListArray = sList;
	}

	public static List<Special> getSpecialListArray() {
		return specialListArray;
	}
	 public static List<Vehicle> getVehicleList(){
		 return vehicleList;
	 }
	 public static void setVehicleList(List<Vehicle> vList){
		 vehicleList = vList;
	 }
}
