package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.Box;

public class BrowsingInventory extends JFrame {

    private JPanel contentPane;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel filterPanel;
    private JPanel filterTopPanel;
    private JPanel filterBottomPanel;
    protected JPanel buttonPanel;
    
    protected JScrollPane scrollPane;
    protected JTable table;
    
    private JLabel pic;
    private JLabel category;
    private JLabel year;
    private JLabel type;
    private JLabel price;
    private JLabel lbl_price_label;
    private JLabel lblMakeLabel;
    private JLabel lbl_year_label;
    private JLabel lblModelLabel;
    
    private JTextField yearFrom;
    private JTextField priceFrom;
    private JTextField yearTo;
    private JTextField priceTo;
    
    private JComboBox jcb_category;
    private JComboBox jcb_maker;
    private JComboBox jcb_type;
    private JComboBox jcb_model;
    
    protected JButton searchButton;
    
    
    private String dealerID;
    private Inventory inventory;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BrowsingInventory frame = new BrowsingInventory("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public BrowsingInventory(String dealerID) {
        

    }
    
    private Inventory getInventory(String dealerID) {
        

        
        return inventory;
    }
    
    private void create() {
        


    }
    
    private void setFeatures() {
        

    }
    
    
    
    private JComboBox addMakerInfoToComboBox() {
        // TODO Auto-generated method stub

        return jcb;
    }

    private JComboBox addModelInfoToComboBox() {
        // TODO Auto-generated method stub

        return jcb;
    }

    private JComboBox addCategoryInfoToComboBox() {
        // TODO Auto-generated method stub

        return jcb_category;
    }

    
    private JComboBox addTypeInfoToComboBox() {

        
        return jcb_category;
    }
    
    private JTable addInfoToTable(Collection<Vehicle> vehicles) {


        
        return tab;
        
    }

    private void addListener() {
        

        
    }
    
    private class OnlyNumberAllowedKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }
    
    private class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            
            
        }

        private Collection<Vehicle> filterPrice(Collection<Vehicle> vehicle, String low, String high) {
            // TODO Auto-generated method stub

        }

        private Collection<Vehicle> filterYear(Collection<Vehicle> vehicle, String low, String high) {
            // TODO Auto-generated method stub

        }

        private Collection<Vehicle> filterMaker(Collection<Vehicle> vehicle, String maker) {
            // TODO Auto-generated method stub

            return temp;
        }

        private Collection<Vehicle> filterModel(Collection<Vehicle> vehicle, String model) {
            // TODO Auto-generated method stub

            
            return temp;
        }

        private Collection<Vehicle> filterType(Collection<Vehicle> vehicle, String type) {
            // TODO Auto-generated method stub

            
            return temp;
        }

        private Collection<Vehicle> filterCategory(Collection<Vehicle> vehicle, String category) {
            // TODO Auto-generated method stub
            
}
            
            return temp;
        }
        
    }
    
    

}
