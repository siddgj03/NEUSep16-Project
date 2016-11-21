package finalProject;

import java.util.HashMap;

public class InventoryPool {
    
    HashMap<String, Inventory> pool;

    public InventoryPool() {
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

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
