package manageInventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by liyang on 2016/11/14.
 */
public class TextReader {
    public static final String defaultDirectory = "/Users/Jim_Pai/NEUSep16-Project/data/";
	 
	public void readfile(String filepath) throws FileNotFoundException, IOException {

        File files = new File(filepath);
        String[] list = files.list();
        
        // Read dealers at first
        File file = new File(filepath + "car-dealers");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        
        String line = null;
        
        while ((line = reader.readLine()) != null) {
            if (line == null) break;

        	String[] attributes = line.split("\\|");
        	InventoryManager.getInstance().addDealer(attributes);
        }
        
        // Read files of vehicles
        for (String str : list) {
        	
            file = new File(filepath + str);
            reader = new BufferedReader(new FileReader(file));
            reader.readLine(); // skip the first line of title
            line = null;
            
            while ((line = reader.readLine()) != null) {
                if (line == null) break;

                if(str.equals("car-dealers")){
                	break;
                }
                else{
                	String[] attributes = line.split("~");
                	InventoryManager.getInstance().addVehicleByDealer(attributes);
                }
            }
            
        }
        
        reader.close();
        
    }
}
