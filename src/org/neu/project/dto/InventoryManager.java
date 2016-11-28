package src.org.neu.project.dto;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.InventoryResults;
import org.neu.project.dto.InventorySearchControl;


public interface InventoryManager {
    
    HashMap<String, Inventory> pool;

    public InventoryManager() {
        // TODO Auto-generated constructor stub
        pool = new HashMap<String, Inventory>();
    }
    
    public void addInventory(String dealerID, Inventory inventory) {
        if (!pool.containsKey(dealerID)) pool.put(dealerID, inventory);
    }
    
    
    
    public Inventory getInventoryByDealerID(String dealerId) {
        
        if (pool.containsKey(dealerId)) return pool.get(dealerId);
        return null;
        
    }

}
