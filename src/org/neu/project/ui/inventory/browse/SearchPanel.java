package org.neu.project.ui.inventory.browse;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

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
	}

	class OperationListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange()==ItemEvent.SELECTED) {
				String selectmake = (String) makes.getSelectedItem();
				String selectmodel = (String) models.getSelectedItem();
				String selectmaxpreice = (String) maxPrice.getSelectedItem();
				String selecttypes = (String) types.getSelectedItem();
			}
		}

		

	}

	class clickMeSearch implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

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

		File filefolder = new File(
				"C:/Users/yzwddsgysz/Downloads/NEUSep16-Project-master/NEUSep16-Project-master/data");
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





