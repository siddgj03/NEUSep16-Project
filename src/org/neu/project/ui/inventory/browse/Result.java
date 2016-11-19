package org.neu.project.ui.inventory.browse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Result extends JPanel {

	private JFrame result;
	private JLabel details;

	private JLabel type;
	private JLabel price;
	private JLabel picture;
	private JLabel vin;
	private JLabel make;
	private JLabel mileage;
	private JLabel model;
	private JLabel year;
	private JLabel doors;
	private JLabel bodyType;
	private JLabel color;

	protected JCheckBox select;

	public Result() {

		super(null);
		details = new JLabel();
		details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
		select = new JCheckBox("Select");
		ClickMeListener cml = new ClickMeListener();
		select.addActionListener(cml);

		type = new JLabel("type");
		price = new JLabel("Sale Price");
		picture = new JLabel("picture");
		make = new JLabel("make");
		vin = new JLabel("vin");
		mileage = new JLabel("mileage");
		model = new JLabel("model");
		year = new JLabel("year");
		doors = new JLabel("doors");
		bodyType = new JLabel("bodyType");
		color = new JLabel("color");

		details.add(make);
		details.add(vin);
		details.add(mileage);
		details.add(model);
		details.add(year);
		details.add(doors);
		details.add(bodyType);
		details.add(color);

		type.setBounds(5, 5, 50, 35);
		price.setBounds(400, 5, 100, 35);
		picture.setBounds(5, 150, 150, 150);
		details.setBounds(250, 150, 300, 200);
		select.setBounds(500, 250, 250, 50);

		add(type);
		add(price);
		add(picture);
		add(details);
		add(select);
	}

	public static void main(String[] args) {
		Result gui = new Result();
		gui.show();
	}

	public void show() {

		result = new JFrame();
		Container conRE = result.getContentPane();
		result.setLayout(null);
		details = new JLabel();
		details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
		select = new JCheckBox("Select");
		ClickMeListener cml = new ClickMeListener();
		select.addActionListener(cml);

		type = new JLabel("type");
		price = new JLabel("Sale Price");
		picture = new JLabel("picture");
		make = new JLabel("make");
		vin = new JLabel("vin");
		mileage = new JLabel("mileage");
		model = new JLabel("model");
		year = new JLabel("year");
		doors = new JLabel("doors");
		bodyType = new JLabel("bodyType");
		color = new JLabel("color");

		details.add(make);
		details.add(vin);
		details.add(mileage);
		details.add(model);
		details.add(year);
		details.add(doors);
		details.add(bodyType);
		details.add(color);

		conRE.add(type);
		conRE.add(price);
		conRE.add(picture);
		conRE.add(details);
		conRE.add(select);

		type.setBounds(5, 5, 50, 35);
		price.setBounds(400, 5, 100, 35);
		picture.setBounds(5, 150, 150, 150);
		details.setBounds(250, 150, 300, 200);
		select.setBounds(500, 250, 250, 50);

		result.setSize(600, 400);
		result.setVisible(true);

	}

	class ClickMeListener implements ActionListener {
		int cnt = 0;
		private JFrame frame;

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cnt % 2 == 0) {
				System.out.println("Car selected");
			}
			cnt++;

		}
	}

}