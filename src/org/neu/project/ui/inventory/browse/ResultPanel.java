package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Vehicle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ResultPanel extends JPanel {

	private JPanel carResultCombo;

	private JPanel details;

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

	public ResultPanel(Collection<Vehicle> vehicles) {

		super(new FlowLayout());
		add(new JScrollPane());

		for (Vehicle object : vehicles) {
			add(showResultCar(object));
		}

	}

	public Component showResultCar(Vehicle vehicle) {

		carResultCombo = new JPanel();
		carResultCombo.setLayout(new BorderLayout());
		details = new JPanel();
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

		carResultCombo.add(type, BorderLayout.NORTH);
		carResultCombo.add(price, BorderLayout.SOUTH);
		carResultCombo.add(details);
		carResultCombo.add(select, BorderLayout.EAST);

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
