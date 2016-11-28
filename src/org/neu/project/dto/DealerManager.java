package src.org.neu.project.dto;


public class DealerManager {
    
    private HashMap<String, Dealer> pool;
    
    

    public DealerManager() {
        pool = new HashMap<String, Dealer>();
    }
    
    public void addDealer(Dealer dealer) {
        if (!pool.containsKey(dealer.getName())) {
            pool.put(dealer.getName(), dealer);
        }
    }
    
    public void addDealer(String id, String name, String url) {
        if (!pool.containsKey(name)) pool.put(name, new Dealer(id, name, url));
    }
    
    public Set<String> getDealersName() {
        return pool.keySet();
    }
    
    public String getDealerIDbyName(String name) {
        if (pool.containsKey(name)) {
            Dealer dealer = pool.get(name);
            return dealer.getId();
        }
        return null;
    }

}
