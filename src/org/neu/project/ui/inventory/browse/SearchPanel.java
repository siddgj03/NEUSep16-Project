package org.neu.project.ui.inventory.browse;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.neu.project.dao.InventoryDAO;
import org.neu.project.dto.Vehicle;
import org.neu.project.service.InventorySearchControl;

@SuppressWarnings("serial")
class SearchPanel extends JPanel {


	private JCheckBox New;
	private JCheckBox Used;
	private JCheckBox Certified;
	private JComboBox<String> makes;
	private JComboBox<String> models;
	private JComboBox<String> maxPrice;
	private JComboBox<String> types;
	private JComboBox<String> years;
	private JButton search;
	String selectmakes;
	String selectmodels;
	String selecttypes;
	String selectyears;
	String selectmaxprice;
	boolean selectnew;
	boolean selectused;
	boolean selectcertified;
	BrowseInventory frame;

	public SearchPanel(BrowseInventory frame) throws IOException {

		super(new GridLayout(0,1,0,6));

		this.frame = frame;

		New = new JCheckBox("New");
		New.setActionCommand(InventorySearchControl.FILTER_BY_CATEGORY);
		Used = new JCheckBox("Used");
		Used.setActionCommand(InventorySearchControl.FILTER_BY_CATEGORY);
		Certified = new JCheckBox("Certified");
		Certified.setActionCommand(InventorySearchControl.FILTER_BY_CATEGORY);
		
		makes = new JComboBox<String>();
		makes.setActionCommand(InventorySearchControl.FILTER_BY_MAKE);
		models = new JComboBox<String>();
		models.setActionCommand(InventorySearchControl.FILTER_BY_MODEL);
		maxPrice = new JComboBox<String>();
		maxPrice.setActionCommand(InventorySearchControl.FILTER_BY_PRICE);
		types = new JComboBox<String>();
		types.setActionCommand(InventorySearchControl.FILTER_BY_TYPE);
		years = new JComboBox<String>();
		years.setActionCommand(InventorySearchControl.FILTER_BY_YEAR);
		
		search = new JButton("SEARCH INVENTORY");


		add(New);
		add(Used);
		add(Certified);
		add(makes);
		add(models);
		add(types);
		add(years);
		add(maxPrice);
		add(search);


		new AddSearchInformation(makes, models, types, maxPrice, years);

		addListener();
		
	}
	

	public void addListener() {

		makes.addActionListener(new MatchMakesAndModels());
		models.addActionListener(new MatchModelsAndTypes());
		models.addActionListener(new MatchModelsAndYears());

		search.addActionListener(new ClickMeSearch(frame));
	}


	class MatchMakesAndModels implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			selectmakes = (String) makes.getSelectedItem();
			if (selectmakes != null && !selectmakes.equals("All Makes")) {
				ConditionMatching cm = new ConditionMatching();
				try {
					cm.matchMakesAndModels(models, selectmakes);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	class MatchModelsAndTypes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			selectmodels = (String) models.getSelectedItem();
			if (selectmakes != null && !selectmodels.equals("All Models")) {
				ConditionMatching cm = new ConditionMatching();
				try {
					cm.matchModelsAndTypes(types, selectmodels);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	
	class MatchModelsAndYears implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			selectmodels = (String) models.getSelectedItem();
			if (selectmakes != null && !selectmodels.equals("All Models")) {
				ConditionMatching cm = new ConditionMatching();
				try {
					cm.matchModelsAndYears(years, selectmodels);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}


	class ClickMeSearch implements ActionListener {

		private BrowseInventory frame;

		public ClickMeSearch(BrowseInventory frame)
		{

			this.frame = frame;
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			// First refresh the inventory
			// ToDo: No Year selection?
			selectnew = New.isSelected();
			selectused = Used.isSelected();
			selectcertified = Certified.isSelected();
			selectmakes = (String) makes.getSelectedItem();
			selectmodels = (String) models.getSelectedItem();
			selecttypes = (String) types.getSelectedItem();
			selectyears = (String) years.getSelectedItem();
			selectmaxprice = (String)maxPrice.getSelectedItem();

			ArrayList<SearchCommand> searchCommands = new ArrayList<>();
			ArrayList<String> filterCategory = new ArrayList<>();
			// Add Category filters
			if (selectnew) {
				filterCategory.add("new");
			}
			if (selectused) {
				filterCategory.add("used");
			}
			if (selectcertified) {
				filterCategory.add("certified");
			}
			// Add Other search filters
			if (!selectmakes.equals("All Makes")) {
				searchCommands.add(new SearchCommand(makes.getActionCommand(), makes.getSelectedItem().toString()));
			}
			if (!selectmodels.equals("All Models")) {
				searchCommands.add(new SearchCommand(models.getActionCommand(), models.getSelectedItem().toString()));
			}
			if (!selecttypes.equals("All Types")) {
				searchCommands.add(new SearchCommand(types.getActionCommand(), types.getSelectedItem().toString()));
			}
			if (!selectyears.equals("All Years")) {
				searchCommands.add(new SearchCommand(years.getActionCommand(), years.getSelectedItem().toString()));
			}
			if (!selectmaxprice.equals("No Max Price")) {
				searchCommands.add(new SearchCommand(maxPrice.getActionCommand(), maxPrice.getSelectedItem().toString()));
			}
			// Filter the vehicles
			frame.loadVehicles();
			Collection<Vehicle> result = frame.getInventory();
			InventorySearchControl isc = new InventorySearchControl();
			for (SearchCommand cmd: searchCommands) {
				result = isc.filter(result, cmd.getSearchKey(), cmd.getSearchValue());
			}
			// If not empty, filter by category
			if (filterCategory.size() > 0) {
				result = isc.filter(result, InventorySearchControl.FILTER_BY_CATEGORY
						, filterCategory.toArray(new String[0]));
			}
			frame.setInventory(result);
		}

	}

class SearchCommand {
	public String getSearchKey() {
		return searchKey;
	}

	public String getSearchValue() {
		return searchValue;
	}

	private String searchKey;
	private String searchValue;

	public SearchCommand(String searchKey, String searchValue) {
		this.searchKey = searchKey;
		this.searchValue = searchValue;
	}
}

class ConditionMatching {

	InventoryDAO idao = new InventoryDAO();
	Collection<Vehicle>allv = new ArrayList<Vehicle>();
	
	HashMap<String, HashSet<String>> vehicleMakesAndModels = new HashMap<String, HashSet<String>>();
	HashMap<String, HashSet<String>> vehicleModelsAndTypes = new HashMap<String, HashSet<String>>();
	HashMap<String, HashSet<Integer>> vehicleModelsAndYears = new HashMap<String, HashSet<Integer>>();

	HashSet<String> setMakes = new HashSet<String>();
	HashSet<String> setModels = new HashSet<String>();
	HashSet<String> setTypes = new HashSet<String>();
	HashSet<Integer> setYears = new HashSet<Integer>();
	

	public void getAllSet(HashSet<String>setMakes, HashSet<String>setModels, HashSet<String>setTypes, HashSet<Integer>setYears) {
		
		allv = idao.getAllVehicles();
		for (Vehicle v : allv) {
			setMakes.add(v.getMake());
		}
		for (Vehicle v : allv) {
			setModels.add(v.getModel());
		}
		for (Vehicle v : allv) {
			setTypes.add(v.getType());
		}
		for (Vehicle v : allv) {
			setYears.add(v.getYear());
		}
	}
	
	public void matchMakesAndModels(JComboBox<String> models, String certainMake) throws IOException {
        
		getAllSet(setMakes, setModels, setTypes, setYears);
		inputMakesAndModels(vehicleMakesAndModels);
		
		for (String s : setModels) {
			models.removeItem(s);
		}
		for (String s : vehicleMakesAndModels.get(certainMake)) {
			models.addItem(s);
		}
	}

	public void matchModelsAndTypes(JComboBox<String> types, String certainModel) throws IOException {

		getAllSet(setMakes, setModels, setTypes, setYears);
		inputModelsAndTypes(vehicleModelsAndTypes);

		for (String s : setTypes) {
			types.removeItem(s);
		}
		for (String s : vehicleModelsAndTypes.get(certainModel)) {
			types.addItem(s);
		}

	}
	
	public void matchModelsAndYears(JComboBox<String> years, String certainModel) throws IOException {

		getAllSet(setMakes, setModels, setTypes, setYears);
		inputModelsAndYears(vehicleModelsAndYears);

		for (int i : setYears) {
			years.removeItem(String.valueOf(i));
		}
		for (Integer i : vehicleModelsAndYears.get(certainModel)) {
			years.addItem(String.valueOf(i));
		}

	}

	private void inputMakesAndModels(HashMap<String, HashSet<String>> vehicleMakesAndModels) throws IOException {

		allv = idao.getAllVehicles();
		
		for (Vehicle v : allv) {
			if (!vehicleMakesAndModels.containsKey(v.getMake())) {
				vehicleMakesAndModels.put(v.getMake(), new HashSet<String>());
			}
			
			vehicleMakesAndModels.get(v.getMake()).add(v.getModel());

		}

	}

	private void inputModelsAndTypes(HashMap<String, HashSet<String>> vehicleModelsAndTypes) throws IOException {

		allv = idao.getAllVehicles();
		
		for (Vehicle v : allv) {
			if (!vehicleModelsAndTypes.containsKey(v.getModel())) {
				vehicleModelsAndTypes.put(v.getModel(), new HashSet<String>());
			}
			
			vehicleModelsAndTypes.get(v.getModel()).add(v.getType());

		}
	}
	
	private void inputModelsAndYears(HashMap<String, HashSet<Integer>> vehicleModelsAndYears) throws IOException {

		allv = idao.getAllVehicles();

		for (Vehicle v : allv) {
			if (!vehicleModelsAndYears.containsKey(v.getModel())) {
				vehicleModelsAndYears.put(v.getModel(), new HashSet<Integer>());
			}

			vehicleModelsAndYears.get(v.getModel()).add(v.getYear());

		}
	}


}


class AddSearchInformation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddSearchInformation(JComboBox makes, JComboBox models, JComboBox types, JComboBox maxPrice, JComboBox years)
			throws IOException {

		HashSet<String> setMakes = new HashSet<String>();
		HashSet<String> setModels = new HashSet<String>();
		HashSet<String> setTypes = new HashSet<String>();
		TreeSet<Integer> setYears = new TreeSet<Integer>();
		
		getAllAttributes(setMakes, setModels, setTypes, setYears);


//		HashSet<String> setDealers = new HashSet<String>();
//		getAllDealers(setDealers);
//
//		InventoryManagerImp imp = new InventoryManagerImp();
//		Inventory DealerInventory = new Inventory();
//
//		for (String dealerID : setDealers) {    																		
//
//			DealerInventory = imp.getInventory(dealerID);
//
//			for (String make : DealerInventory.getAllMaker()) {
//				setMakes.add(make);
//			}
//			for (String model : DealerInventory.getAllModel()) {
//				setModels.add(model);
//			}
//			for (String type : DealerInventory.getAllType()) {
//				setTypes.add(type);
//			}
//			for (int year : DealerInventory.getAllYear()) {
//				setYears.add(year);
//			}
//		}

		makes.addItem("All Makes");
		for (String s : setMakes) {
			if (!s.isEmpty() && !s.endsWith("make"))
				makes.addItem(s);
		}

		models.addItem("All Models");
		for (String s : setModels) {
			if (!s.isEmpty() && !s.endsWith("model"))
				models.addItem(s);
		}

		types.addItem("All Types");
		for (String s : setTypes) {
			if (!s.isEmpty() && !s.endsWith("type"))
				types.addItem(s);
		}
		years.addItem("All Years");
		for (int i : setYears) {
			String year = String.valueOf(i);
			years.addItem(year);
		}

		maxPrice.addItem("No Max Price");
		String[] prices = { "10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000",
				"200000", "500000", "1000000" };
		for (String s : prices)
			maxPrice.addItem(s);

	}
	
	public void getAllAttributes(HashSet<String>setMakes, HashSet<String>setModels, HashSet<String>setTypes, TreeSet<Integer>setYears) {
		
		InventoryDAO idao = new InventoryDAO();
		Collection<Vehicle>allv = new ArrayList<Vehicle>();
		allv = idao.getAllVehicles();
		
		for (Vehicle v : allv) {
			setMakes.add(v.getMake());
		}
		for (Vehicle v : allv) {
			setModels.add(v.getModel());
		}
		for (Vehicle v : allv) {
			setTypes.add(v.getType());
		}
		for (Vehicle v : allv) {
			setYears.add(v.getYear());
		}
	}

//	private static void getAllDealers(HashSet<String> setDealers) throws IOException {
//
//		// File filefolder = new File(System.getProperty("user.dir") +
//		// "/data/car-dealers");
//		// String file = findFile(filefolder);
//
//		File file = new File(System.getProperty("user.dir") + "/data/car-dealers");
//		@SuppressWarnings("resource")
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//
//		String line;
//		while ((line = reader.readLine()) != null) {
//			String[] str = line.split("\\|");
//			setDealers.add(str[0]);
//			setDealers.remove("id");
//
//		}
//	}

}

