package org.neu.project.service;

import org.neu.project.dto.Vehicle;
import java.util.*;

public class InventorySearchControl {
	public static final String FILTER_BY_MAKE = "make";
	public static final String FILTER_BY_MODEL = "model";
	public static final String FILTER_BY_TYPE = "type";
	public static final String FILTER_BY_YEAR = "year";
	public static final String FILTER_BY_PRICE = "price";
	public static final String FILTER_BY_CATEGORY = "category";
	
	public Collection<Vehicle> filter(Collection<Vehicle> vehicles, String key, String filterValue) {
		Collection<Vehicle> result = new ArrayList<>();
		
		for (Vehicle v: vehicles) {
			boolean isMatch = false;

			// Determine how to filter
			switch (key) {
				case FILTER_BY_MAKE:
					if(v.getMake().equals(filterValue)) {
						isMatch = true;
					}
					break;
				case FILTER_BY_MODEL:
					if(v.getModel().equals(filterValue)) {
						isMatch = true;
					}
					break;
				case FILTER_BY_TYPE:
					if(v.getType().equals(filterValue)) {
						isMatch = true;
					}
					break;
				case FILTER_BY_YEAR:
					if(v.getYear() == Integer.parseInt(filterValue)) {
						isMatch = true;
					}
					break;
				case FILTER_BY_PRICE:
					if(v.getPrice() <= Integer.parseInt(filterValue)) {
						isMatch = true;
					}
					break;
				case FILTER_BY_CATEGORY:
					if(v.getCategory().equals(filterValue)) {
						isMatch = true;
					}
					break;
			}
			// Add to the result if it matches
			if (isMatch) {
				result.add(v);
			}
		}
		return result;
	}

	public Collection<Vehicle> filter(Collection<Vehicle> vehicles, String key, String[] filterValue) {
		Collection<Vehicle> result = new ArrayList<>();
		
		for (Vehicle v: vehicles) {
			boolean isMatch = false;

			switch (key) {
				
				case FILTER_BY_CATEGORY:
					for(int i=0;i<filterValue.length;i++){
						if(v.getCategory().equals(filterValue[i]))
							isMatch = true;					
					}
					break;
			}
			if (isMatch) {
				result.add(v);
			}
		}
		return result;
	}
	
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
