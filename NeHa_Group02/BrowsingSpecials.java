package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BrowsingSpecials extends BaseFrame {

    private String dealerID;


    /**
     * Create the frame.
     */
    public BrowsingSpecials(String dealerID) {
       
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
                    BrowsingSpecials frame = new BrowsingSpecials("gmps-chaparral");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
