package org.neu.project.ui.inventory.browse;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.neu.project.dto.Vehicle;

@SuppressWarnings("serial")
class SearchPanel extends JPanel {

	private JCheckBox New;
	private JCheckBox Used;
	private JCheckBox Certified;
	private JComboBox<String> makes;
	private JComboBox<String> models;
	private JComboBox<String> maxPrice;
	private JComboBox<String> types;
	private JButton search; 
	String selectmakes;
	String selectmodels;
	String selecttypes;
	int selectmaxprice;
	boolean selectnew;
	boolean selectused;
	boolean selectcertified;

	public SearchPanel() throws IOException {

		super(new GridLayout(0,1,0,6));

		New = new JCheckBox("New");
		Used = new JCheckBox("Used");
		Certified = new JCheckBox("Certified");
		//Font bigFont = new Font("", Font.BOLD, 18);
		//New.setFont(bigFont);
		//Used.setFont(bigFont);
		//Certified.setFont(bigFont);
		makes = new JComboBox<String>();
		models = new JComboBox<String>();
		maxPrice = new JComboBox<String>();
		types = new JComboBox<String>();
		search = new JButton("SEARCH INVENTORY");


		add(New);
		add(Used);
		add(Certified);
		add(makes);
		add(models);
		add(types);
		add(maxPrice);
		add(search);

		
		addSearchInformation asi = new addSearchInformation(makes, models, types, maxPrice);
		
		
		addListener();
	}
	public void addListener() {
		
		
		ClickMeSearch cms = new ClickMeSearch();
		search.addActionListener(cms);
	}


	class ClickMeSearch implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//InventorySearchControl.filterMake(vehicles, ol.selectmakes, ol.selectmodels, ol.selecttypes, ol.selectmaxprice, ol.selectnew, ol.selectused, ol.selectcertified);
            selectnew = New.isSelected();
            selectused = Used.isSelected();
			selectcertified = Certified.isSelected();
			selectmakes = (String) makes.getSelectedItem();
			selectmodels = (String) models.getSelectedItem();
			selecttypes = (String) types.getSelectedItem();
			selectmaxprice = maxPrice.getSelectedIndex();
			
			if (selectnew==true) System.out.println("i want new");
			if (selectused==true) System.out.println("i want used");
			if (selectcertified==true) System.out.println("i want certified");
			if (selectmakes!=null) System.out.println(selectmakes);
			if (selectmodels!=null) System.out.println(selectmodels);
			if (selecttypes!=null) System.out.println(selecttypes);
			if (selectmaxprice!=0) System.out.println(selectmaxprice*10000);
		}

	}

}

class InventorySearchControl {

	List<Vehicle> result = new ArrayList<Vehicle>();

	public List<Vehicle> filterMake(List<Vehicle> vehicles, String make, String model, String type, int price, boolean categorynew, boolean categoryused, boolean categorycertified) {

		for (Vehicle v : vehicles) {
			result.clear();
			if (v.getMake() == make && v.getModel() == model && v.getType() == type && v.getPrice() <= price) {
				if (categorynew == true && v.getCategory()=="new") {
					result.add(v);
				} else if (categoryused == true && v.getCategory()=="used") {
					result.add(v);
				} else if (categorycertified == true && v.getCategory()=="certified") {
					result.add(v);
				}  
			} 
			
		}

		return result;
	}

}

class addSearchInformation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public addSearchInformation(JComboBox makes, JComboBox models, JComboBox types, JComboBox maxPrice)
			throws IOException {
		HashSet<String> setMakes = new HashSet<String>();
		HashSet<String> setModels = new HashSet<String>();
		HashSet<String> setTypes = new HashSet<String>();

		makes.addItem("All Makes");
		readFile(setMakes, setModels, setTypes);
		for (String s : setMakes) {
			if (!s.isEmpty() && !s.endsWith("make"))
				makes.addItem(s);
		}

		models.addItem("All Models");
		for (String s : setModels) {
			if (!s.isEmpty() && !s.endsWith("models"))
				models.addItem(s);
		}

		types.addItem("All Types");
		for (String s : setTypes) {
			if (!s.isEmpty() && !s.endsWith("type"))
				types.addItem(s);
		}

		maxPrice.addItem("No Max Price");
		String[] prices = { "10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000" };
		for (String s : prices)
			maxPrice.addItem(s);
	}

	private static void readFile(HashSet<String> setMakes, HashSet<String> setModels, HashSet<String> setTypes)
			throws IOException {

		File filefolder = new File("data/");
		String file = findFile(filefolder);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] str = line.split("~");
			setMakes.add(str[4]);
			setModels.add(str[5]);
			setTypes.add(str[7]);
		}
	}

	private static String findFile(File filefolder) {
		// TODO Auto-generated method stub
		String filepath = null;
		for (File file : filefolder.listFiles()) {
			filepath = file.getAbsolutePath();
		}
		return filepath;
	}

}






