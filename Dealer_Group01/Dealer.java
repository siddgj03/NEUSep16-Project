package NEUSep16_Project;

/**
@author Yalin
**/

public class Dealer {


	 private String dealerName;
	 private String dealerID;
	 private String URL;
	 private Inventory inventory;
	
	 public Dealer(){
	 }
	 
	 public Dealer(String dealerID, String dealerName,String URL){
		 this.dealerName = dealerName;
		 this.dealerID = dealerID;
		 this.URL = URL;
	 }
	 
	 
	 public String getDealerName() {
		return dealerName;
	}
	 
	 public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	 
	 public String getDealerID() {
		return dealerID;
	}
	 
	 public void setDealerID(String dealerID) {
		this.dealerID = dealerID;
	}
	 
	 public String getURL() {
	 	return URL;
	}
	 
	 public void setURL(String URL) {
		this.URL = URL;
	}
	 	
	 
	 @Override
	 public int hashCode(){
		 return dealerName.hashCode() * dealerID.hashCode() * URL.hashCode();
	 }
	 
	 @Override
	 public boolean equals(Object obj){
		 if(!(obj instanceof Dealer))
		    return false;
		 Dealer d1 = (Dealer)obj;
		    return this.dealerName.equals(d1.dealerName) && this.dealerID.equals(d1.dealerID) && this.URL.equals(d1.URL);
	 }
}


