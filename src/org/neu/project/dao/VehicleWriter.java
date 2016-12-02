package org.neu.project.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.neu.project.dto.Vehicle;


/* Writing into a File and Deleting */
/** Created by Rashmitha **/

public class VehicleWriter {
	public void writeIntoFile(String fileName, Collection<Vehicle> vehicles, boolean append) throws Exception
    {
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file, append);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        
        if(!append)
        	bufferedWriter.write("id~webId~category~year~make~model~trim~type~price\n"); // Title
        
        for (Vehicle vehicle : vehicles)
        {
            bufferedWriter.write(vehicle.toString() + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void delete(Collection<Vehicle> vehicles, String fileName) throws Exception
    {
        writeIntoFile(fileName, vehicles, false);
    }

    public void add(Vehicle vehicle, String fileName) throws Exception
    {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(vehicle);
        writeIntoFile(fileName, vehicles, true);
    }

    public void update(Collection<Vehicle> vehicles, String fileName) throws Exception
    {
        writeIntoFile(fileName, vehicles, false);
    }
}
