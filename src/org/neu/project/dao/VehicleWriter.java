package org.neu.project.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.Vehicle;

import com.sun.jmx.snmp.defaults.DefaultPaths;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

/* Writing into a File and Deleting */
public class VehicleWriter {
	
	private Inventory inventory;
	private String defaultPath = System.getProperty("user.dir") + "/data/";

	public void setInventory(Inventory inventory){
		this.inventory = inventory;
	}
	
	public void writeIntoFile(String fileName) throws Exception
    {
      File file = new File(defaultPath + fileName);
      FileWriter writer = new FileWriter(file);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
      
      StringBuilder sb = new StringBuilder();
      
  	  sb.append("id~webId~category~year~make~model~trim~type~price\n"); // title
  	  for(Vehicle vehicle : inventory.getVehicles()){
      	  sb.append(vehicle.toString() + "\n");
      }
  	
      bufferedWriter.write(sb.toString());
      bufferedWriter.flush();
      bufferedWriter.close();
    }
    
}


//public class VehicleWriter {
//	
//	private Inventory inventory;
//	private String defaultPath = System.getProperty("user.dir") + "/data/";
//	
//	public VehicleWriter(){
//		
//	}
//	
//	public void setInventory(Inventory inventory){
//		this.inventory = inventory;
//	}
//	
//	public void writeIntoFile(String fileName) throws Exception
//    {
//        File file = new File(defaultPath + fileName);
//        FileWriter writer = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        
//        StringBuilder sb = new StringBuilder();
//        
//    	sb.append("id~webId~category~year~make~model~trim~type~price\n"); // title
//    	for(Vehicle vehicle : inventory.getVehicles()){
//        	sb.append(vehicle.toString() + "\n");
//        }
//    	
//        bufferedWriter.write(sb.toString());
//        bufferedWriter.flush();
//        bufferedWriter.close();
//    }
//}