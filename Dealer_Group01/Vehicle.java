package NEUSep16_Project;


/**
 * @author Serena
 * 
 */
public class Vehicle {
	//make final
		private String vin;
		private int id;
		private String webId;
		private Category category; //new,used,certified
		private int year;
		private String make; //Chevrolet,Toyota
		private String model;//Colorado,Highlander
		private String trim;//Extended Cab Long Box 4-Wheel Drive LT
		private String type;//Truck,CAR,SUV
		private float price;
		private int mileage;//
		private String color;//
		
			
		
		public Vehicle(int id, String webId, Category category, int year, String make,
	            String model, String trim, String type, float price) {
	        this.id = id;
	        this.webId = webId;
	        this.category = category;
	        this.year = year;
	        this.make = make;
	        this.model = model;
	        this.trim = trim;
	        this.type = type;
	        this.price = price;
	    }

		private enum Category {
			NEW,
			USED, 
			CERTIFIED;
		}


		public String getVIN(){
			return this.vin;
		}
		
		public void setVIN(String vin){
			this.vin = vin;
		}
		
		public int getID(){
			return this.id;
		}
		public void setID(int id){
			this.id = id;
		}
		
		public String getWebID(){
			return this.webId;
		}
		public void setWebID(String webID){
			this.webId = webID;
		}
		
		public Category getCategory(){
			return this.category;
		}
		public void setCategory(Category cate){
			this.category = cate;
		}
		
		public int getYear(){
			return this.year;
		}
		public void setYear(int year){
			this.year = year;
		}
		
		
		public String getMake(){
			return this.make;
		}
		public void setMake(String make){
			this.make = make;
		}
		
		public String getModel(){
			return this.model;
		}
		public void setModel(String model){
			this.model = model;
		}
		
		
		public String getTrim(){
			return this.trim;
		}
		public void setTrim(String trim){
			this.trim = trim;
		}
		
		
		public String getType(){
			return this.type;
		}
		public void setType(String type){
			this.type = type;
		}
		
		public float getPrice(){
			return this.price;
		}
		public void setPrice(float price){
			this.price = price;
		}
		
		public int getMileage(){
			return this.mileage ;
		}
		public void setMileage(int mil){
			this.mileage = mil;
		}
		
		public String getColor(){
			return this.color;
		}
		public void setColor(String color){
			this.color = color;
		}
}//close the class