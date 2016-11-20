import java.util.ArrayList;

public class carTypeList {
	
	public static ArrayList getCarTypeList(){
		ArrayList carTypeList=new ArrayList();
		
		carTypeList.add("All"); carTypeList.add("Convertible"); carTypeList.add("Coupe"); carTypeList.add("Crossover"); 
		carTypeList.add("Diesel"); carTypeList.add("Hatchback"); carTypeList.add("Hybrid/Electric"); carTypeList.add("Luxury"); 
		carTypeList.add("Minivan"); carTypeList.add("Sedan"); carTypeList.add("SUV"); carTypeList.add("Truck"); 
		carTypeList.add("Wagon");
		
		return carTypeList;
	}
}
