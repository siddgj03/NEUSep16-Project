package manageInventory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class TextWriter {
	 
	private static TextWriter instance = new TextWriter();
	
	private TextWriter(){}
	
	public static TextWriter getInstance(){
		return instance;
	}
	
	public void writeVehiclesIntoFile(Collection<Vehicle> vehicles, String pathName) throws Exception
    {
        File file = new File(pathName);
        FileWriter writer = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        
        // Write title
        bufferedWriter.write("id~webId~category~year~make~model~trim~type~price\n");
        bufferedWriter.flush();
        
        for(Vehicle vehicle : vehicles){
        	StringBuilder sb = new StringBuilder();
            sb.append(vehicle.getId());
            sb.append("~");
            sb.append(vehicle.getWebId());
            sb.append("~");
            sb.append(vehicle.getCategory());
            sb.append("~");
            sb.append(vehicle.getYear());
            sb.append("~");
            sb.append(vehicle.getMake());
            sb.append("~");
            sb.append(vehicle.getModel());
            sb.append("~");
            sb.append(vehicle.getTrim());
            sb.append("~");
            sb.append(vehicle.getType());
            sb.append("~");
            sb.append(vehicle.getPrice());
            sb.append("\n");
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
        }
        
        bufferedWriter.close();
        writer.close();
    }
	
	public void writeDealersIntoFile(Collection<Dealer> dealers, String pathName) throws Exception
    {
        File file = new File(pathName);
        FileWriter writer = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        
        // Write title
        bufferedWriter.write("id|name|url\n");
        bufferedWriter.flush();
        
        for(Dealer dealer : dealers){
        	StringBuilder sb = new StringBuilder();
            sb.append(dealer.getId());
            sb.append("|");
            sb.append(dealer.getName());
            sb.append("|");
            sb.append(dealer.getUrl());
            sb.append("\n");
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
        }
        
        bufferedWriter.close();
        writer.close();
    }
}
