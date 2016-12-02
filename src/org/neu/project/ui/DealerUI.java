package org.neu.project.ui;

import org.neu.project.dao.PropertyReader;
import org.neu.project.service.DealerManager;
import org.neu.project.service.DealerManagerImpl;
import org.neu.project.ui.inventory.browse.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;


@SuppressWarnings("serial")
public class DealerUI extends JFrame{

	private JButton customer, dealer; //Button names

	@SuppressWarnings("rawtypes")
	private JComboBox dealerList; // ComboBox name
	private JLabel label; // ComboBox Label

	DealerManager dealerMap = new DealerManagerImpl();
	private PropertyReader rp = new PropertyReader();

	public DealerUI() {
		create();
		add();
		addListener();

		Dimension screenDimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setLocation((int)(screenDimen.getWidth() - this.getWidth()) / 2, (int)(screenDimen.getHeight() - this.getHeight()) / 2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void create() {
		label = new JLabel(rp.getString("DealerUI.selectDealerLabel"));
		label.setFont(rp.getFont("DealerUI.comboBoxMessage.Font"));
		label.setSize(rp.getDimension("DealerUI.ComboBoxLabel.Size"));

		customer = new JButton(rp.getString("DealerUI.customerLabel"));
		customer.setEnabled(false);
		customer.setFont(rp.getFont("DealerUI.Buttons.Font"));
		customer.setPreferredSize(rp.getDimension("DealerUI.Buttons.Size"));

		dealer = new JButton(rp.getString("DealerUI.dealerLabel"));
		dealer.setEnabled(false);
		dealer.setFont(rp.getFont("DealerUI.Buttons.Font"));
		dealer.setPreferredSize(rp.getDimension("DealerUI.Buttons.Size"));

		dealerList = new JComboBox();
		dealerList.setPreferredSize(rp.getDimension("DealerUI.ComboBox.Size"));
		dealerList.setFont(rp.getFont("DealerUI.comboBoxList.Font"));

		//Adding dealernames to the comboBox for display
		addDataToComboBoxList(dealerList,dealerMap);
	}

	/*Function to read dealer names and display in comboBox */
	@SuppressWarnings("unchecked")
	private void addDataToComboBoxList(JComboBox list, DealerManager dealerManager) {
		Set<String> dealerNames = dealerManager.getDealersName();
		list.addItem(null);

		for (String name: dealerNames) {
			list.addItem(name);
		}
	}

	private void add() {
		Container con = this.getContentPane();
		JPanel base = new JPanel();
		con.add(base);
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));

		JPanel topPanel = new JPanel();
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+rp.getString("dealerUIImage"));
		JLabel pic = new JLabel(image);
		topPanel.add(pic);
		topPanel.setBackground(rp.getColor("White.Color"));
		topPanel.setPreferredSize(rp.getDimension("DealerUI.TopPanel.Size"));
		base.add(topPanel);

		JPanel midPanel = new JPanel();
		midPanel.add(label);
		midPanel.add(dealerList);
		midPanel.setBackground(rp.getColor("White.Color"));
		midPanel.setPreferredSize(rp.getDimension("DealerUI.MidPanel.Size"));
		base.add(midPanel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(customer);
		bottomPanel.add(Box.createHorizontalStrut(20));
		bottomPanel.add(dealer);
		bottomPanel.setBackground(rp.getColor("Gray.Color"));
		base.add(bottomPanel);

		con.setBackground(rp.getColor("White.Color"));
	}

	private void addListener() {
		/*Listener for ComboBox */
		ComboBoxListener cbl = new ComboBoxListener();
		dealerList.addItemListener(cbl);

		/*Listener for Customer and Dealer Buttons */
		ButtonListener buttonClicked = new ButtonListener();
		dealer.addActionListener(buttonClicked);
		customer.addActionListener(buttonClicked);
	}

	/*ComboBox action for selecting a dealer */
	class ComboBoxListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (dealerList.getSelectedItem() == null) {
				customer.setEnabled(false);
				dealer.setEnabled(false);
			}
			else {
				customer.setEnabled(true);
				dealer.setEnabled(true);
			}
		}
	}

	/*Dealer and Customer Buttons action implementation */
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			Object source = click.getSource();
			String dealerid = dealerMap.getDealerIDbyName(dealerList.getSelectedItem().toString());

			if (source == dealer ){
				String dealerName = dealerList.getSelectedItem().toString();
				new DealerSelectedUI(dealerName, dealerid);      
			}
			if (source == customer){
				BrowseInventory browseCustomerInventory = new BrowseInventoryCustomer(dealerid);
				browseCustomerInventory.display();
			}
		}
	}

	public static void main(String[] args) {
		DealerUI entry = new DealerUI();
	}
}

