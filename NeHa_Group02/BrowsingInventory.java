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
        
        this.dealerID = dealerID;
        inventory = getInventory(dealerID);

        create();
        setFeatures();
        addListener();
        
        Dimension screenDimen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocation((int)(screenDimen.getWidth() - this.getWidth()) / 2, (int)(screenDimen.getHeight() - this.getHeight()) / 2);
        this.setVisible(true);
    }
    
    private Inventory getInventory(String dealerID) {
        
        String dealerFile = "/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/car-dealers.txt";
        String inventoryFileFoldPath = "/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/inventorys/";
        
        DataManager dm = new DataManager(dealerFile, inventoryFileFoldPath);
        InventoryPool pool = dm.getInventoryPool();
        Inventory inventory = pool.getInventoryByDealerID(dealerID);
        
        return inventory;
    }
    
    private void create() {
        
        topPanel = new JPanel();
        midPanel = new JPanel();
        
        table = addInfoToTable(inventory.getAllVehicles());
        scrollPane = new JScrollPane(table);
        
        contentPane = new JPanel();
        contentPane.add(topPanel);
        contentPane.add(midPanel);
        contentPane.add(Box.createVerticalStrut(10)); 
        contentPane.add(scrollPane);
        
        ImageIcon image = new ImageIcon("/Users/xiaoyue/NEU_2016FALL__InformationSystem/INFO5100_JAVA/Assigments/finalProject/data/birds.gif");
        image.setImage(image.getImage().getScaledInstance(391,180,Image.SCALE_DEFAULT));
        pic = new JLabel(image);
        topPanel.add(pic);
        
        
        filterPanel = new JPanel();
        filterTopPanel = new JPanel();
        filterBottomPanel = new JPanel();
        filterPanel.add(filterTopPanel);
        filterPanel.add(filterBottomPanel);
        
        buttonPanel = new JPanel();
        
        midPanel.add(filterPanel);
        midPanel.add(buttonPanel);
        midPanel.add(Box.createHorizontalGlue());
        
        category = new JLabel("Category :");
        lblMakeLabel = new JLabel("Maker :");
        year = new JLabel("Year :");
        yearFrom = new JTextField();
        lbl_year_label = new JLabel(" - ");
        yearTo = new JTextField();
        type = new JLabel("Type       :");
        lblModelLabel = new JLabel("Model :");
        price = new JLabel("Price :");
        priceFrom = new JTextField();
        lbl_price_label = new JLabel(" - ");
        priceTo = new JTextField();
        
        jcb_category = addCategoryInfoToComboBox();
        jcb_maker = addMakerInfoToComboBox();
        jcb_type = addTypeInfoToComboBox();
        jcb_model = addModelInfoToComboBox();
        
        filterTopPanel.add(category);
        filterTopPanel.add(jcb_category);      
        filterTopPanel.add(Box.createHorizontalStrut(3));
        filterTopPanel.add(lblMakeLabel);
        filterTopPanel.add(jcb_maker);
        filterTopPanel.add(Box.createHorizontalStrut(3));
        filterTopPanel.add(year);        
        filterTopPanel.add(yearFrom);
        filterTopPanel.add(lbl_year_label);
        filterTopPanel.add(yearTo);

        filterBottomPanel.add(type);
        filterBottomPanel.add(jcb_type);
        filterBottomPanel.add(Box.createHorizontalStrut(3));
        filterBottomPanel.add(lblModelLabel);
        filterBottomPanel.add(jcb_model);
        filterBottomPanel.add(Box.createHorizontalStrut(3));
        filterBottomPanel.add(price);
        filterBottomPanel.add(priceFrom);
        filterBottomPanel.add(lbl_price_label);
        filterBottomPanel.add(priceTo);
     
        searchButton = new JButton("Search");
        buttonPanel.add(searchButton);

    }
    
    private void setFeatures() {
        
        setContentPane(contentPane);
        setBounds(100, 100, 762, 395);
        
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBackground(Color.white);
        
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
        topPanel.setBackground(Color.WHITE);
        
        midPanel.setBorder(new LineBorder(new Color(204, 204, 204), 2, true));
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
        midPanel.setBackground(Color.GRAY);
        
        
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.setBackground(Color.GRAY);
        

        filterTopPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 2));
        filterTopPanel.setBackground(Color.GRAY);
        
        filterBottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 2));
        filterBottomPanel.setBackground(Color.GRAY);
        
        yearFrom.setHorizontalAlignment(SwingConstants.LEFT);
        yearFrom.setColumns(10);
        yearTo.setColumns(10);
        
        priceFrom.setHorizontalAlignment(SwingConstants.LEFT);
        priceFrom.setColumns(10);
        priceTo.setColumns(10);
        
        buttonPanel.setBackground(Color.GRAY);
        searchButton.setPreferredSize(new Dimension(120, 40));


        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 900));

        
        jcb_category.setPreferredSize(new Dimension(200, 30));
        jcb_type.setPreferredSize(new Dimension(200, 30));
        jcb_model.setPreferredSize(new Dimension(200, 30));
        jcb_maker.setPreferredSize(new Dimension(200, 30));
    }
    
    
    
    private JComboBox addMakerInfoToComboBox() {
        // TODO Auto-generated method stub
        JComboBox jcb = new JComboBox();
        jcb.addItem("all");
        for (String maker: inventory.getAllMaker()) {
            if (maker.equals("")) continue;
            jcb.addItem(maker);
        }
        return jcb;
    }

    private JComboBox addModelInfoToComboBox() {
        // TODO Auto-generated method stub
        JComboBox jcb = new JComboBox();
        jcb.addItem("all");
        for (String model: inventory.getAllModel()) {
            if (model.equals("")) continue;
            jcb.addItem(model);
        }
        
        return jcb;
    }

    private JComboBox addCategoryInfoToComboBox() {
        // TODO Auto-generated method stub
        HashSet<String> categorys = inventory.getAllCategory();
        JComboBox jcb_category = new JComboBox();
        jcb_category.addItem("all");
        for (String cate: categorys) {
            if (cate.equals("")) continue;
            jcb_category.addItem(cate);
        }
        
        return jcb_category;
    }

    
    private JComboBox addTypeInfoToComboBox() {
        HashSet<String> types = inventory.getAllType();
        JComboBox jcb_category = new JComboBox();
        jcb_category.addItem("all");
        for (String type: types) {
            if (type.equals("")) continue;
            jcb_category.addItem(type);
        }
        
        return jcb_category;
    }
    
    private JTable addInfoToTable(Collection<Vehicle> vehicles) {

        String[] columnName = inventory.getTitles();
        String[][] data = new String[vehicles.size()][];
        
        int idx = 0;
        for (Vehicle ve: vehicles) {
            data[idx++] = ve.getVehicleInfo();
        }
        
        JTable tab = new JTable(new DefaultTableModel(data, columnName)) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        tab.setAutoCreateRowSorter(true);
        
        return tab;
        
    }

    private void addListener() {
        
        SearchButtonListener sbl = new SearchButtonListener();
        searchButton.addActionListener(sbl);
        
        OnlyNumberAllowedKeyListener onlyNumberkl = new OnlyNumberAllowedKeyListener();
        
        yearFrom.addKeyListener(onlyNumberkl);
        yearTo.addKeyListener(onlyNumberkl);
        priceFrom.addKeyListener(onlyNumberkl);
        priceTo.addKeyListener(onlyNumberkl);
        
    }
    
    private class OnlyNumberAllowedKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            int keyChar = e.getKeyChar();
            
            if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
                
            }
            else e.consume();
            
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
            
            Collection<Vehicle> vehicle = inventory.getAllVehicles();
            if (!jcb_category.getSelectedItem().equals("all")) {
                vehicle = filterCategory(vehicle, jcb_category.getSelectedItem().toString());
            }
            
            if (!jcb_type.getSelectedItem().equals("all")) {
                vehicle = filterType(vehicle, jcb_type.getSelectedItem().toString());
            }
            
            if (!jcb_model.getSelectedItem().equals("all")) {
                vehicle = filterModel(vehicle, jcb_model.getSelectedItem().toString());
            }
            
            if (!jcb_maker.getSelectedItem().equals("all")) {
                vehicle = filterMaker(vehicle, jcb_maker.getSelectedItem().toString());
            }
            
            vehicle = filterYear(vehicle, yearFrom.getText(), yearTo.getText());
            vehicle = filterPrice(vehicle, priceFrom.getText(), priceTo.getText());
            
            table = addInfoToTable(vehicle);
            scrollPane.setViewportView(table);
            
            
        }

        private Collection<Vehicle> filterPrice(Collection<Vehicle> vehicle, String low, String high) {
            // TODO Auto-generated method stub
            if (low.equals("") && high.equals("")) return vehicle;
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (low.equals("")) {
                    int price = Integer.parseInt(high);
                    if (ve.getPrice() <= price) temp.add(ve);
                }
                else if (high.equals("")) {
                    int price = Integer.parseInt(low);
                    if (ve.getPrice() >= price) temp.add(ve);
                }
                else {
                    int lowP = Integer.parseInt(low);
                    int highP = Integer.parseInt(high);
                    if (ve.getPrice() >= lowP && ve.getPrice() <= highP) temp.add(ve);
                }
            }
            
            return temp;
        }

        private Collection<Vehicle> filterYear(Collection<Vehicle> vehicle, String low, String high) {
            // TODO Auto-generated method stub
            
            if (low.equals("") && high.equals("")) return vehicle;
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (low.equals("")) {
                    int year = Integer.parseInt(high);
                    if (ve.getYear() <= year) temp.add(ve);
                }
                else if (high.equals("")) {
                    int year = Integer.parseInt(low);
                    if (ve.getYear() >= year) temp.add(ve);
                }
                else {
                    int lowY = Integer.parseInt(low);
                    int highY = Integer.parseInt(high);
                    if (ve.getYear() >= lowY && ve.getYear() <= highY) temp.add(ve);
                }
            }
            
            return temp;
        }

        private Collection<Vehicle> filterMaker(Collection<Vehicle> vehicle, String maker) {
            // TODO Auto-generated method stub
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (ve.getMake().equals(maker)) temp.add(ve);
            }
            
            return temp;
        }

        private Collection<Vehicle> filterModel(Collection<Vehicle> vehicle, String model) {
            // TODO Auto-generated method stub
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (ve.getModel().equals(model)) temp.add(ve);
            }
            
            return temp;
        }

        private Collection<Vehicle> filterType(Collection<Vehicle> vehicle, String type) {
            // TODO Auto-generated method stub
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (ve.getType().equals(type)) temp.add(ve);
            }
            
            return temp;
        }

        private Collection<Vehicle> filterCategory(Collection<Vehicle> vehicle, String category) {
            // TODO Auto-generated method stub
            
            Collection<Vehicle> temp = new ArrayList<Vehicle>();
            
            for (Vehicle ve: vehicle) {
                if (ve.getCategory().equals(category)) temp.add(ve);
            }
            
            return temp;
        }
        
    }
    
    

}
