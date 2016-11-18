package ui.inventory.browse;

import ui.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author ken prayogo
 * Main BrowseInventory UI rendering class
 */
public class BrowseInventory extends BaseFrame {
	// Static values
	private static final int scrWidth = 1020;
	private static final int scrHeight = 720;
	// Components
	private JLabel title;
	private ListPanel list;
	private TestPanel buttonPane;

	public BrowseInventory() {
		super(scrWidth, scrHeight);
	}

	@Override
	protected void create() {
		title = new JLabel("Inventory");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.NORTH);
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

	}

	@Override
	protected void add() {
		Container con = this.getContentPane();
		// First layout to separate header, controls and footer
		GridLayout layoutMaster = new GridLayout(3,1,0,10);
		con.setLayout(layoutMaster);

		// Main controls layout
		FlowLayout layoutControls = new FlowLayout();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(layoutControls);

		// Declare and Add Panels here
		SortUI sort = new SortUI();
		mainPanel.add(sort);

		list = new ListPanel();
		mainPanel.add(list);

		buttonPane = new TestPanel();
		mainPanel.add(buttonPane);

		// Arrange vertical screen layout
		con.add(title);
		con.add(mainPanel);

		JLabel footerNote = new JLabel("Footer goes here");
		footerNote.setHorizontalAlignment(JLabel.CENTER);
		footerNote.setVerticalAlignment(JLabel.CENTER);
		con.add(footerNote);
	}

	@Override
	protected void addListener() {
		ViewListener ol = new ViewListener();
		buttonPane.btnView.addActionListener(ol);
	}

	class ViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String vin = list.table.getValueAt(list.table.getSelectedRow(), 0).toString();
			System.out.println("Got VIN: " + vin);
		}
	}

	public static void main(String args[]) {
		JFrame f = new BrowseInventory();
	}
}

/**
 * Example custom JPanel to group controls into one
 * Uses the BoxLayout, which places controls vertically
 * (Still some issues with the combo box width)
 */
class TestPanel extends JPanel {
	JButton btnView;

	public TestPanel() {
		// Arrange in vertical order, with spacing of 10
		super(new GridLayout(0, 1, 0, 10));

		btnView = new JButton("View Vehicle");

		add(btnView);
	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		comp.setMaximumSize( comp.getPreferredSize() ); // Limits size from expanding
		return comp;
	}
}

class ListPanel extends JPanel {
	private JPanel mainList;
	public JTable table;

	public ListPanel() {

		mainList = new JPanel();
		mainList.setLayout(new BorderLayout());

		Object[][] data = getVehicleData();
		String[] labels = {"VIN", "Make", "Model", "Year", "Type", "Color", "Mileage"};
		table = new JTable(data, labels);

		JScrollPane tableContainer = new JScrollPane(table);
		tableContainer.setPreferredSize(new Dimension(500, 150));

		mainList.add(tableContainer, BorderLayout.CENTER);
		add(tableContainer);
	}

	private static Object[][] getVehicleData() {
		Object[][] data = {
				{"VIN-NO1", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO2", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO3", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO4", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO5", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO6", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO7", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO8", "Honda", "Civic", "2012", "Sedan", "White", "5000"},
				{"VIN-NO9", "Honda", "Civic", "2012", "Sedan", "White", "5000"}
		};
		return data;
	}
}