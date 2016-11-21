package finalProject;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame {
    public BaseFrame() {
        create();
        add();
        addListener();
        
        Dimension screenDimen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocation((int)(screenDimen.getWidth() - this.getWidth()) / 2, (int)(screenDimen.getHeight() - this.getHeight()) / 2);
        this.setVisible(true);

    }

    public abstract void create();

    public abstract void add();

    public abstract void addListener();
    
    protected Inventory getInventory(String dealerID) {
        
        String dealerFile = "/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/car-dealers.txt";
        String inventoryFileFoldPath = "/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/inventorys/";
        
        DataManager dm = new DataManager(dealerFile, inventoryFileFoldPath);
        InventoryPool pool = dm.getInventoryPool();
        Inventory inventory = pool.getInventoryByDealerID(dealerID);
        
        return inventory;
    }

}
