package org.neu.project.ui.inventory.browse;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

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
	private JButton search;
	String selectmakes;
	String selectmodels;
	String selecttypes;
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
		//Font bigFont = new Font("", Font.BOLD, 18);
		//New.setFont(bigFont);
		//Used.setFont(bigFont);
		//Certified.setFont(bigFont);
		makes = new JComboBox<String>();
		makes.setActionCommand(InventorySearchControl.FILTER_BY_MAKE);
		models = new JComboBox<String>();
		models.setActionCommand(InventorySearchControl.FILTER_BY_MODEL);
		maxPrice = new JComboBox<String>();
		maxPrice.setActionCommand(InventorySearchControl.FILTER_BY_PRICE);
		types = new JComboBox<String>();
		types.setActionCommand(InventorySearchControl.FILTER_BY_TYPE);
		search = new JButton("SEARCH INVENTORY");


		add(New);
		add(Used);
		add(Certified);
		add(makes);
		add(models);
		add(types);
		add(maxPrice);
		add(search);


		AddSearchInformation asi = new AddSearchInformation(makes, models, types, maxPrice);

		addListener();
	}

	public void addListener() {

		makes.addActionListener(new MatchMakesAndModelsListener());
		models.addActionListener(new MatchModelsAndTypesListener());

		search.addActionListener(new ClickMeSearch(frame));
	}


	class MatchMakesAndModelsListener implements ActionListener {

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

	class MatchModelsAndTypesListener implements ActionListener {

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
			selectmaxprice = (String)maxPrice.getSelectedItem();

			ArrayList<SearchCommand> searchCommands = new ArrayList<>();
			if (selectnew) {
				searchCommands.add(new SearchCommand(New.getActionCommand(), "new"));
			}
			if (selectused) {
				searchCommands.add(new SearchCommand(Used.getActionCommand(), "used"));
			}
			if (selectcertified) {
				searchCommands.add(new SearchCommand(Certified.getActionCommand(), "certified"));
			}
			if (!selectmakes.equals("All Makes")) {
				searchCommands.add(new SearchCommand(makes.getActionCommand(), makes.getSelectedItem().toString()));
			}
			if (!selectmodels.equals("All Models")) {
				searchCommands.add(new SearchCommand(models.getActionCommand(), models.getSelectedItem().toString()));
			}
			if (!selecttypes.equals("All Types")) {
				searchCommands.add(new SearchCommand(types.getActionCommand(), types.getSelectedItem().toString()));
			}
			if (!selectmaxprice.equals("No Max Price")) {
				searchCommands.add(new SearchCommand(maxPrice.getActionCommand(), maxPrice.getSelectedItem().toString()));
			}

			frame.loadVehicles();
			Collection<Vehicle> result = frame.getInventory();
			InventorySearchControl isc = new InventorySearchControl();
			for (SearchCommand cmd: searchCommands) {
				result = isc.filter(result, cmd.getSearchKey(), cmd.getSearchValue());
			}
			frame.setInventory(result);
		}

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

	HashMap<String, HashSet<String>> vehicleMakes = new HashMap<String, HashSet<String>>();
	HashMap<String, HashSet<String>> vehicleModels = new HashMap<String, HashSet<String>>();

	HashSet<String> setMakes = new HashSet<String>();
	HashSet<String> setModels = new HashSet<String>();
	HashSet<String> setTypes = new HashSet<String>();

	public void matchMakesAndModels(JComboBox<String> models, String certainMake) throws IOException {

		readFile(setMakes, setModels, setTypes);
		inputMakesAndModels(vehicleMakes);

		for (String s : setModels) {
			models.removeItem(s);
		}
		for (String s : vehicleMakes.get(certainMake)) {
			models.addItem(s);
		}
	}

	public void matchModelsAndTypes(JComboBox<String> types, String certainModel) throws IOException {

		readFile(setMakes, setModels, setTypes);
		inputModelsAndTypes(vehicleModels);

		for (String s : setTypes) {
			types.removeItem(s);
		}
		for (String s : vehicleModels.get(certainModel)) {
			types.addItem(s);
		}

	}

	private void inputMakesAndModels(HashMap<String, HashSet<String>> vehicleMakes2) throws IOException {

		File filefolder = new File("data/");
		String file = findFile(filefolder);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = reader.readLine()) != null) {
			String[] str = line.split("~");
			if (!vehicleMakes2.containsKey(str[4])) {
				vehicleMakes2.put(str[4], new HashSet<String>());
				vehicleMakes2.get(str[4]).add(str[5]);
			} else {
				vehicleMakes2.get(str[4]).add(str[5]);
			}

		}
	}

	private void inputModelsAndTypes(HashMap<String, HashSet<String>> vehicleModels2) throws IOException {

		File filefolder = new File("data/");
		String file = findFile(filefolder);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = reader.readLine()) != null) {
			String[] str = line.split("~");
			if (!vehicleModels2.containsKey(str[5])) {
				vehicleModels2.put(str[5], new HashSet<String>());
				vehicleModels2.get(str[5]).add(str[7]);
			} else {
				vehicleModels2.get(str[5]).add(str[7]);
			}

		}
	}

	private void readFile(HashSet<String> setMakes, HashSet<String> setModels, HashSet<String> setTypes)
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

	private String findFile(File filefolder) {
		// TODO Auto-generated method stub
		String filepath = null;
		for (File file : filefolder.listFiles()) {
			filepath = file.getAbsolutePath();
		}
		return filepath;
	}

}


class AddSearchInformation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddSearchInformation(JComboBox makes, JComboBox models, JComboBox types, JComboBox maxPrice)
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
			if (!s.isEmpty() && !s.endsWith("model"))
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