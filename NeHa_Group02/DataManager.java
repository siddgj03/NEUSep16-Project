package finalProject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DataManager {
    
    DealerPool dealerPool;
    InventoryPool inventoryPool;
   
    
    

    public DataManager(String dealerfilePath, String inventoryFilefoldPath) {
        FileManager fm = new FileManager();
        File dealersData = new File(dealerfilePath);
        dealerPool = fm.readDealerData(dealersData);
        
        File inventorys = new File(inventoryFilefoldPath);
        File[] inventoryFiles = inventorys.listFiles();
        inventoryPool = fm.readInventoryData(inventoryFiles);
        
    }
    
    public DealerPool getDealerPool(){
        
        return dealerPool;
    }
    
    public InventoryPool getInventoryPool() {
        return inventoryPool;
    }
    


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
//        DataManager dm = new DataManager();
//        
//        Inventory inv = dm.getInventoryData("gmps-ernievon");
//        for (Vehicle v: inv.getAllVehicles()) {
//            System.out.println(v);
//        }

    }

}
