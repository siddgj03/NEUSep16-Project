package org.neu.project.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.neu.project.dao.PropertyReader;
import org.neu.project.ui.inventory.browse.*;
import org.neu.project.ui.special.ViewSpecialsUI;


public class DealerSelectedUI extends JFrame {

	private String curDealerName;
	private String curDealerID;
	private JButton inventory, specials;
	private JLabel welcome;
	private JLabel labelofDealerName;
	private JLabel pic;
	private PropertyReader rp = new PropertyReader();

	public DealerSelectedUI(String dealerName, String dealerID) {
		curDealerName = dealerName;
		curDealerID = dealerID;
		this.setSize(rp.getDimension("DealerSelectedUI.Screen.Size"));
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenDimension.getWidth() - this.getWidth()) / 2, (int)(screenDimension.getHeight() - this.getHeight()) / 2);

		create();
		add();
		addListener();

		this.setVisible(true);
	}

	private void create() {


		welcome = new JLabel("WELCOME:");
		labelofDealerName = new JLabel(curDealerName);
		labelofDealerName.setFont(rp.getFont("DealerSelectedUI.dealerNameLabel.Font"));

		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+rp.getString("selectedDealerUIImage"));
		image.setImage(image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		pic = new JLabel(image);
		pic.setPreferredSize(rp.getDimension("DealerSelectedUI.Image.Size"));


		inventory = new JButton("Inventory");
		inventory.setPreferredSize(rp.getDimension("DealerSelectedUI.Buttons.Size"));
		inventory.setFont(rp.getFont("DealerSelectedUI.Buttons.Font"));

		specials = new JButton("Specials");
		specials.setPreferredSize(rp.getDimension("DealerSelectedUI.Buttons.Size"));
		specials.setFont(rp.getFont("DealerSelectedUI.Buttons.Font"));
	}

	private void add() {
		Container con = this.getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.X_AXIS));

		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
		left.add(pic);
		left.setBackground(rp.getColor("White.Color"));



		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		right.add(Box.createHorizontalStrut(5));
		JPanel welPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		welPanel.add(welcome);
		right.add(welPanel);
		JPanel dealPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		dealPanel.add(labelofDealerName);
		right.add(dealPanel);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(inventory);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(specials);
		right.add(buttonPanel);

		welPanel.setBackground(rp.getColor("White.Color"));
		dealPanel.setBackground(rp.getColor("White.Color"));
		buttonPanel.setBackground(rp.getColor("White.Color"));
		right.setBackground(rp.getColor("White.Color"));

		con.add(left);
		con.add(right);
	}


	private void addListener() {

		InventoryListener il = new InventoryListener();
		inventory.addActionListener(il);

		SpecialsListener sl = new SpecialsListener();
		specials.addActionListener(sl);

	}


	private class InventoryListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			BrowseInventory browseDealerInventory = new BrowseInventoryDealer(curDealerID);
			browseDealerInventory.display();
		}

	}

	private class SpecialsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new ViewSpecialsUI(curDealerID);

		}

	}

}
