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
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class DealerUI extends JFrame{

	private JButton customer, dealer;
	private JComboBox dealerList;
	private JLabel label;

	DealerManager dealerMap = new DealerManagerImpl();
	PropertyReader rp = new PropertyReader();


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
		// TODO Auto-generated method stub
		label = new JLabel(rp.getString("DealerUI.selectDealerLabel"));
		label.setFont(rp.getFont("DealerUI.comboBoxMessage.Font"));
		label.setSize(200, 50);

		customer = new JButton(rp.getString("DealerUI.customerLabel"));
		customer.setEnabled(false);
		customer.setFont(rp.getFont("DealerUI.Buttons.Font"));
		customer.setPreferredSize(rp.getDimension("DealerUI.Buttons.Size"));

		dealer = new JButton(rp.getString("DealerUI.dealerLabel"));
		dealer.setEnabled(false);
		dealer.setFont(rp.getFont("DealerUI.Buttons.Font"));
		dealer.setPreferredSize(rp.getDimension("DealerUI.Buttons.Size"));

		dealerList = new JComboBox();
		dealerList.setPreferredSize(new Dimension(250, 40));


		Set<String> dealerNames = dealerMap.getDealersName();
		System.out.println(dealerNames);

		addDataToComboBoxList(dealerList,dealerMap);

	}



	private void addDataToComboBoxList(JComboBox list, DealerManager dealerManager) {
		Set<String> dealerNames = dealerManager.getDealersName();
		list.addItem(null);

		for (String name: dealerNames) {
			list.addItem(name);
		}

	}

	private void add() {
		// TODO Auto-generated method stub
		Container con = this.getContentPane();
		JPanel base = new JPanel();
		con.add(base);
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));

		JPanel topPanel = new JPanel();
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+rp.getString("dealerUIImage"));
		JLabel pic = new JLabel(image);
		topPanel.add(pic);
		topPanel.setBackground(rp.getColor("DealerUI.White.Color"));
		topPanel.setPreferredSize(new Dimension(200, 250));
		base.add(topPanel);

		JPanel midPanel = new JPanel();
		midPanel.add(label);
		midPanel.add(dealerList);
		midPanel.setBackground(rp.getColor("DealerUI.White.Color"));
		midPanel.setPreferredSize(new Dimension(200, 20));
		base.add(midPanel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(customer);
		bottomPanel.add(Box.createHorizontalStrut(20));
		bottomPanel.add(dealer);
		bottomPanel.setBackground(rp.getColor("DealerUI.Gray.Color"));
		base.add(bottomPanel);

		con.setBackground(rp.getColor("DealerUI.White.Color"));

	}


	
	private void addListener() {
		// TODO Auto-generated method stub
		ComboBoxListener cbl = new ComboBoxListener();
		dealerList.addItemListener(cbl);

		CustomerListener cl = new CustomerListener();
		customer.addActionListener(cl);

		DealerListener dl = new DealerListener();
		dealer.addActionListener(dl);

	}


	/*ComboBox for selecting a dealer */
	class ComboBoxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
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

	/*Button to browse customer inventory */
	class CustomerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String dealerid = dealerMap.getDealerIDbyName(dealerList.getSelectedItem().toString());
			new BrowseInventoryCustomer(dealerid);

		}   
	}

	
	/*Button to open selected dealer UI frame*/
	class DealerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String dealerName = dealerList.getSelectedItem().toString();
			String dealerid = dealerMap.getDealerIDbyName(dealerList.getSelectedItem().toString());
			new DealerSelectedUI(dealerName, dealerid);      
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DealerUI entry = new DealerUI();

	}

}

