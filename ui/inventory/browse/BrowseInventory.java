package ui.inventory.browse;

import ui.BaseFrame;

import javax.swing.*;
import java.awt.*;

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

	}

	@Override
	protected void add() {
		Container con = this.getContentPane();
		// ToDo: GridLayout might not do it.. Controls are taking up the whole height
		GridLayout layout = new GridLayout(0,3);
		con.setLayout(layout);

		TestPanel p = new TestPanel();
		con.add(p);
		con.add(title);
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
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JComboBox box = new JComboBox();
		JComboBox box2 = new JComboBox();
		box.addItem("First box");
		box2.addItem("Second box");

		add(new JLabel("I am inside a panel."));
		add(box);
		add(box2);
	}
}
