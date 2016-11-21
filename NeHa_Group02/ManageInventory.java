package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ManageInventory extends BaseFrame {

    private String dealerID;

    /**
     * Create the frame.
     */
    public ManageInventory(String dealerID) {
        super();
        this.dealerID = dealerID;

    }

    @Override
    public void create() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addListener() {
        // TODO Auto-generated method stub
        
    }
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageInventory frame = new ManageInventory("gmps-chaparral");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
