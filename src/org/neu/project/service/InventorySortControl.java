package org.neu.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.neu.project.dto.Vehicle;

public class InventorySortControl {	
	public static final String SORT_BY_PRICE = "price";
	public static final String SORT_BY_MAKE = "make";
	public static final String SORT_BY_YEAR = "year";
	public static final String SORT_BY_MODEL = "model";
	public static final String SORT_BY_TRIM = "trim";
	public static final String SORT_BY_CATEGORY = "category";
	public static final String SORT_BY_CARID = "carID";
	public static final String SORT_BY_TYPE = "type";

	public static final boolean ORDER_DESC = true;
	public static final boolean ORDER_ASC = false;

	public List<Vehicle> sort(Collection<Vehicle> vehicle,String key, boolean isDesc){
		List<Vehicle> result = new ArrayList<Vehicle>(vehicle);

		Collections.sort(result, new Comparator<Vehicle>(){
			@Override
			public int compare(Vehicle v1, Vehicle v2){
				MutableVariable y1;
				MutableVariable y2;
				switch (key){
				case InventorySortControl.SORT_BY_YEAR:
					y1 = new MutableVariable(v1.getYear());
					y2 = new MutableVariable(v2.getYear());
					break;
				case InventorySortControl.SORT_BY_MAKE:
					y1 = new MutableVariable(v1.getMake());
					y2 = new MutableVariable(v2.getMake());
					break;
				case InventorySortControl.SORT_BY_MODEL:
					y1 = new MutableVariable(v1.getModel());
					y2 = new MutableVariable(v2.getModel());
					break;
				case InventorySortControl.SORT_BY_TYPE:
					y1 = new MutableVariable(v1.getType());
					y2 = new MutableVariable(v2.getType());
					break;
				case InventorySortControl.SORT_BY_CATEGORY:
					y1 = new MutableVariable(v1.getCategory());
					y2 = new MutableVariable(v2.getCategory());
					break;
				case InventorySortControl.SORT_BY_CARID:
					y1 = new MutableVariable(v1.getId());
					y2 = new MutableVariable(v2.getId());
					break;
				case InventorySortControl.SORT_BY_TRIM:
					y1 = new MutableVariable(v1.getTrim());
					y2 = new MutableVariable(v2.getTrim());
					break;
				case InventorySortControl.SORT_BY_PRICE:
					y1 = new MutableVariable(v1.getPrice());
					y2 = new MutableVariable(v2.getPrice());
					break;
				default:
					return 0;
				}
				if(isDesc){
					return y2.compareTo(y1);
				}else{
					return y1.compareTo(y2);
				}
			}
		});
		return result;
	}
}





