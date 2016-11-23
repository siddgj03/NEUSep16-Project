package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Vehicle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ResultPanel extends JPanel {

	private JPanel carResultCombo;

	// private JPanel details;

	private JLabel id;
	private JLabel webId;
	private JLabel category;
	private JLabel year;
	private JLabel make;
	private JLabel model;
	private JLabel trim;
	private JLabel type;
	private JLabel price;

	private ButtonGroup selects;
	private JRadioButton select;

	public ResultPanel(Collection<Vehicle> vehicles) {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for (Vehicle object : vehicles) {

			selects.add(getRadioButton(showResultCar(object)));
			add(showResultCar(object));

		}

	}

	public JPanel showResultCar(Vehicle vehicle) {
		carResultCombo = new JPanel();
		GroupLayout layout = new GroupLayout(carResultCombo);
		carResultCombo.setLayout(layout);

		select = new JRadioButton("Select");
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

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(type).addComponent(make).addComponent(model));
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(id).addComponent(webId).addComponent(category)
				.addComponent(year).addComponent(trim));
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(price).addComponent(select));
		hGroup.addGap(10);
		layout.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(id));
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(type).addComponent(webId));
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(make).addComponent(category).addComponent(price));
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(model).addComponent(year));
		vGroup.addGap(10);
		vGroup.addGroup(layout.createParallelGroup().addComponent(trim).addComponent(price));
		vGroup.addGap(10);
		layout.setVerticalGroup(vGroup);

		return carResultCombo;
	}

	private JRadioButton getRadioButton(JPanel jpanel) {

		JRadioButton radioButton = null;
		int count = jpanel.getComponentCount();

		for (int i = 0; i < count; i++) {
			Component comp = jpanel.getComponent(i);
			if (comp instanceof JRadioButton) {
				radioButton = (JRadioButton) comp;
			}
		}

		return radioButton;

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
