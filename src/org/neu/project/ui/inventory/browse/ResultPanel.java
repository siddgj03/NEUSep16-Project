package org.neu.project.ui.inventory.browse;


import javax.swing.*;
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

		List<Vehicle> vehicles = this.getResultVehicles();
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
		a.setVin("1");
		b.setVin("2");
		c.setVin("3");
		d.setVin("4");
		e.setVin("5");
		f.setVin("6");
		g.setVin("7");
		List<Vehicle> vehicles = { a, b, c, d, e, f, g };
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

		id = new JLabel("ID   " + vehicle.id);
		webId = new JLabel("webId   " + vehicle.webId);
		category = new JLabel("Category   " + vehicle.category);
		year = new JLabel("Year   " + vehicle.year);
		make = new JLabel("Make   " + vehicle.make);
		model = new JLabel("Model   " + vehicle.model);
		trim = new JLabel("Trim   " + vehicle.trim);
		type = new JLabel("Type   " + vehicle.type);
		price = new JLabel("Price   " + vehicle.price);

		details.add(id);
		details.add(webId);
		details.add(category);
		details.add(year);
		details.add(make);
		details.add(model);
		details.add(trim);

		carResultCombo.add(type);
		carResultCombo.add(price);
		carResultCombo.add(picture);
		carResultCombo.add(details);
		carResultCombo.add(select);

		type.setBounds(5, 5, 100, 35);
		price.setBounds(400, 5, 100, 35);
		picture.setBounds(5, 150, 150, 150);
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
