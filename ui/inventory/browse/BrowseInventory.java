package ui.inventory.browse;

import ui.BaseFrame;

import javax.swing.*;
import java.awt.*;

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

		// Main controls layout
		FlowLayout layoutControls = new FlowLayout();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(layoutControls);
		con.setLayout(layoutMaster);

		// Declare and Add Panels here
		SortUI sort = new SortUI();
		mainPanel.add(sort);
		mainPanel.add(new TestPanel());

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

	public TestPanel() {
		// Arrange in vertical order, with spacing of 10
		super(new GridLayout(0, 1, 0, 10));

		JComboBox box = new JComboBox();
		JComboBox box2 = new JComboBox();
		box.addItem("First box");
		box2.addItem("Second box");

		add(new JLabel("I am inside a panel."));
		add(box);
		add(box2);
	}

	@Override
	public Component add(Component comp) {
		super.add(comp);
		comp.setMaximumSize( comp.getPreferredSize() ); // Limits size from expanding
		return comp;
	}
}
