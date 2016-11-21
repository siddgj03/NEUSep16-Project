package org.neu.project.ui.inventory.browse;




import javax.swing.*;

import org.neu.project.dto.Vehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ResultPanel extends JPanel {

	private JPanel carResultCombo;
	
	private JLabel details;

	private JLabel id;
	private JLabel webId;
	private JLabel category;
	private JLabel year;
	private JLabel make;
	private JLabel model;
	private JLabel trim;
	private JLabel type;
	private JLabel price;

	private JCheckBox select;

	public static void main(String[] args) {

		ResultPanel gui = new ResultPanel();

	}

	public ResultPanel() {

		super(new FlowLayout());
		add(new JScrollPane());

		Vehicle[] vehicles = this.getResultVehicles();
		for (Vehicle object : vehicles) {
			add(showResultCar(object));
		}

	}

	private Vehicle[] getResultVehicles() {
		Vehicle a = new Vehicle();
		Vehicle b = new Vehicle();
		Vehicle c = new Vehicle();
		Vehicle d = new Vehicle();
		Vehicle e = new Vehicle();
		Vehicle f = new Vehicle();
		Vehicle g = new Vehicle();
		a.setTrim("1");
		b.setTrim("2");
		c.setTrim("3");
		d.setTrim("4");
		e.setTrim("5");
		f.setTrim("6");
		g.setTrim("7");
		Vehicle[] vehicles = { a, b, c, d, e, f, g };
		return vehicles;
	}

	public Component showResultCar(Vehicle vehicle) {

		carResultCombo = new JPanel();
		carResultCombo.setLayout(null);
		details = new JLabel();
		details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
		select = new JCheckBox("Select");
		ClickMeListener cml = new ClickMeListener();
		select.addActionListener(cml);

		id = new JLabel("ID   " + vehicle.getId());
		webId = new JLabel("webId   " + vehicle.getWebId());
		category = new JLabel("Category   " + vehicle.getCategory());
		year = new JLabel("Year   " + vehicle.getYear());
		make = new JLabel("Make   " + vehicle.getMake());
		model = new JLabel("Model   " + vehicle.getModel());
		trim = new JLabel("Trim   " + vehicle.getTrim());
		type = new JLabel("Type   " + vehicle.getType());
		price = new JLabel("Price   " + vehicle.getPrice());

		details.add(id);
		details.add(webId);
		details.add(category);
		details.add(year);
		details.add(make);
		details.add(model);
		details.add(trim);

		carResultCombo.add(type);
		carResultCombo.add(price);
		//carResultCombo.add(picture);
		carResultCombo.add(details);
		carResultCombo.add(select);

		type.setBounds(5, 5, 100, 35);
		price.setBounds(400, 5, 100, 35);
		//picture.setBounds(5, 150, 150, 150);
		details.setBounds(250, 150, 300, 200);
		select.setBounds(500, 250, 250, 50);

		return carResultCombo;

	}

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

