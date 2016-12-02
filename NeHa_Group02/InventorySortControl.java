package finalProject;
import java.util.*;
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
				case InventorySortControl.SORT_BY_MAKE:
				   y1 = new MutableVariable(v1.getMake());
				   y2 = new MutableVariable(v2.getMake());
				case InventorySortControl.SORT_BY_MODEL:
				   y1 = new MutableVariable(v1.getModel());
				   y2 = new MutableVariable(v2.getModel());
				case InventorySortControl.SORT_BY_TYPE:
				   y1 = new MutableVariable(v1.getType());
				   y2 = new MutableVariable(v2.getType());
				case InventorySortControl.SORT_BY_CATEGORY:
				   y1 = new MutableVariable(v1.getCategory());
				   y2 = new MutableVariable(v2.getCategory());
				case InventorySortControl.SORT_BY_CARID:
				   y1 = new MutableVariable(v1.getId());
				   y2 = new MutableVariable(v2.getId());
				case InventorySortControl.SORT_BY_TRIM:
				   y1 = new MutableVariable(v1.getTrim());
				   y2 = new MutableVariable(v2.getTrim());
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
	
	/*
	 * 
	public List<Vehicle> sortByMake (Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByMake = new ArrayList(vehicle);
	  if (isDesc) {
		Collections.sort(vehiclesByMake, new Comparator<Vehicle>() {
		  @Override
		  public int compare(Vehicle v1, Vehicle v2) {
			return v2.getMake().compareTo(v1.getMake());
		  }
		});
	  } else {
		Collections.sort(vehiclesByMake, new Comparator<Vehicle>() {
		  @Override
		  public int compare(Vehicle v1, Vehicle v2) {
			return v1.getMake().compareTo(v2.getMake());
		  }
	    });  
	  }
	  return vehiclesByMake;
    }
		     

	public List<Vehicle> sortByType(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByType = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByType, new Comparator<Vehicle>(){
			@Override
			public int compare(Vehicle v1, Vehicle v2){
			  return v2.getType().compareTo(v1.getType());
			}
		  });		  
	  }else{
		  Collections.sort(vehiclesByType, new Comparator<Vehicle>(){
			@Override
			public int compare(Vehicle v1, Vehicle v2){
				return v1.getType().compareTo(v2.getType());
			}
		  });
	  }
	  return vehiclesByType;
    }
		 
		    
	public List<Vehicle> sortByCategory(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByCategory = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByCategory, new Comparator<Vehicle>(){
			  @Override
			  public int compare(Vehicle v1, Vehicle v2){
				  return v2.getCategory().compareTo(v1.getCategory());
			  }
		  });
	  }else{
		  Collections.sort(vehiclesByCategory, new Comparator<Vehicle>(){
			  @Override
			  public int compare(Vehicle v1, Vehicle v2){
				  return v1.getCategory().compareTo(v2.getCategory());
			  }
		  });
	  }
		        return vehiclesByCategory;
		     }
		     
		     
	public List<Vehicle> sortByCarId(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByCarId = new ArrayList(vehicle); 
	  if(isDesc){
		  Collections.sort(vehiclesByCarId, new Comparator<Vehicle>(){
		  @Override
		  public int compare(Vehicle v1, Vehicle v2){
			  return v2.getId().compareTo(v1.getId());
		    }
	    });
	  }else{
		  Collections.sort(vehiclesByCarId, new Comparator<Vehicle>(){
			  @Override
			  public int compare(Vehicle v1, Vehicle v2){
				  return v1.getId().compareTo(v2.getId());
			    }
		    });		  
	  }
		        return vehiclesByCarId;
		     }
		     
		     
	public List<Vehicle> sortByYear(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByYear = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByYear, new Comparator<Vehicle>(){
			  public int compare(Vehicle v1, Vehicle v2){
				  return v2.getYear().compareTo(v1.getYear());
			  }
		  });
	  }else{
		  Collections.sort(vehiclesByYear, new Comparator<Vehicle>(){
			  public int compare(Vehicle v1, Vehicle v2){
				  return v1.getYear().compareTo(v2.getYear());
			  }
		  });
	  }
		         return vehiclesByYear;
		     }
		     
		     
	public List<Vehicle> sortByModel(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByModel = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByModel, new Comparator<Vehicle>(){
		  @Override
		  public int compare(Vehicle v1,Vehicle v2){
			  return v2.getModel().compareTo(v1.getModel());
		  }			  
		  });
	  }else{
		  Collections.sort(vehiclesByModel, new Comparator<Vehicle>(){
		  @Override
		  public int compare(Vehicle v1,Vehicle v2){
			  return v1.getModel().compareTo(v2.getModel());
		  }			  
		  });
	  }	  
		       return vehiclesByModel;
		   }
	     
		    
	public List<Vehicle> sortByTrim(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByTrim = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByTrim, new Comparator<Vehicle>(){
			@Override
			public int compare(Vehicle v1, Vehicle v2){
				return v2.getTrim().compareTo(v1.getTrim());
			}
		  });
	  }else{
		  Collections.sort(vehiclesByTrim, new Comparator<Vehicle>(){
			@Override
			public int compare(Vehicle v1, Vehicle v2){
				return v1.getTrim().compareTo(v2.getTrim());
			}
			});
	  }
		        return vehiclesByTrim;
		   }
		     
		     
	public List<Vehicle> sortByPrice(Collection<Vehicle> vehicle, boolean isDesc) {
	  List vehiclesByPrice = new ArrayList(vehicle);
	  if(isDesc){
		  Collections.sort(vehiclesByPrice, new Comparator<Vehicle>(){
			  public int compare(Vehicle v1, Vehicle v2){
				  return v2.getPrice().compareTo(v1.getPrice());
			  }
		  });
	  }else{
		  Collections.sort(vehiclesByPrice, new Comparator<Vehicle>(){
			  public int compare(Vehicle v1, Vehicle v2){
				  return v1.getPrice().compareTo(v2.getPrice());
			  }
		  });
	  }
		         return vehiclesByPrice;
		     }		 
*
*/
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}