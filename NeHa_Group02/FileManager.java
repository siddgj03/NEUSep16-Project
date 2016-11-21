package finalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class FileManager {
    
    public DealerPool readDealerData(File file) {
        

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DealerPool pool = new DealerPool();
            String data = br.readLine();
            data = br.readLine();
            
            while (data != null) {
                String[] info = data.split("\\|");
                pool.addDealer(info[0], info[1], info[2]); // add dealer's id/name/url
                data = br.readLine();

            }
            
            br.close();
            return pool;
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("file not exists!");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
        
    }
    
    public InventoryPool readInventoryData(File[] inventoryFiles) {
        // TODO Auto-generated method stub
        
        InventoryPool inventoryPool = new InventoryPool();
        
        for (File file: inventoryFiles) {
            if(file.isHidden()) continue;
            
            Inventory inv = this.readInventoryFile(file);
            String dealerID = this.getDealerId(file);
            inventoryPool.addInventory(dealerID, inv);
        }
        
        return inventoryPool;
        
    }
    
    
    
    private Inventory readInventoryFile(File file) {
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data = br.readLine();
            data = br.readLine();
            
            Inventory inventory = new Inventory();
            
            while (data != null) {
                String[] info = data.split("~");
                Vehicle vec = new Vehicle(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
                inventory.addVehicle(vec);
                data = br.readLine();
            }
            
            br.close();
            return inventory;
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String getDealerId(File file) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data = br.readLine();
            data = br.readLine();
//            System.out.println(data);
            String[] seq = data.split("~");
            
            br.close();
            return seq[1];
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    
    public void writeDealerInfo(File file, Dealer dealr) {
        
    }
    
    public void writeInventoryInfo(File file, Vehicle car) {
        
    }


    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        FileManager fman = new FileManager();
        
//        File file = new File("/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/src/project/data/dealerInfo.txt");
//        DealerPool pool = fman.readDealerData(file);
        
//        File file = new File("/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/src/project/data/inventoryInfo/gmps-aj-dohmann.txt");
//        Inventory inventory = fman.readInventoryData(file);
//        
//        for (Vehicle v: inventory.getAllVehicles()) {
//            System.out.println(v);
//        }

        
//        for (String name: pool.getDealersName()) System.out.println(name);

    }

}
