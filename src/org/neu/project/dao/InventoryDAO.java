package src.org.neu.project.dao;

import src.org.neu.project.dto.InventoryManager;

public class InventoryDAO {
    

    InventoryManager pool;
    
    public InventoryDAP(String inventoryFileFolerPath) {
        // read files from path inventoryFileFolerPath
        // call readInventoryData here to initialize variable pool
        
    }
    
    
    
    private void readInventoryData(File[] inventoryFiles) {
        // TODO Auto-generated method stub
        // use inventoryFiles here
        // in this function, you should call function readInventoryFile(File file) to get inventory
        // and getDealerID(File file) to get dealerID, and then map them in inventoryManager
        // store the inventoryManger object to variable pool;
        
    }
    
    public InventoryManager getInventoryManager() {
        return pool;
    }
    
    
    private Inventory readInventoryFile(File file) {
        

        
        return null;
    }
    
    private String getDealerId(File file) {
        
        return null
    }
}
