package ui.vehicleView;

import java.util.HashMap;

public class Utility {
	public static HashMap<String, Special> specialList;

	public static HashMap<String, Special> getSpecialList() {
		return specialList;
	}
	public static void setSpecialList(HashMap<String,Special> sList){
		specialList = sList;
	}
}
