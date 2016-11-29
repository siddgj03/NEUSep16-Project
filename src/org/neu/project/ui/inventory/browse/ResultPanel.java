package org.neu.project.ui.inventory.browse;

import org.neu.project.dto.Vehicle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ResultPanel extends JPanel {
	
	private JLabel image;
//	private ImageIcon img;


	private JPanel carResultCombo;

	private JLabel id;
//	private JLabel webId;
	private JLabel category;
	private JLabel year;
	private JLabel make;
	private JLabel model;
	private JLabel trim;
	private JLabel type;
	private JLabel price;
	private JLabel special;

	public ResultPanel(Collection<Vehicle> vehicles) {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		ButtonGroup selects = new ButtonGroup();

		for (Vehicle object : vehicles) {

			JPanel panel = showResultVehicle(object);
			selects.add(getRadioButton(panel));
			add(panel);

		}

	}

	public JPanel showResultVehicle(Vehicle vehicle) {
		
//	    image = new JLabel();
//		img = new ImageIcon(vehicle.getImage());
//		image.setIcon(img);

		carResultCombo = new JPanel();
		GroupLayout layout = new GroupLayout(carResultCombo);
		carResultCombo.setLayout(layout);
		carResultCombo.setBorder(BorderFactory.createTitledBorder("details "));

		JRadioButton select = new JRadioButton("Select ");
		ClickMeListener cml = new ClickMeListener(vehicle.getId());
		select.addActionListener(cml);

		id = new JLabel("ID:   " + vehicle.getId());
		// webId = new JLabel("webId: " + vehicle.getWebId());
		category = new JLabel("Category:   " + vehicle.getCategory());
		year = new JLabel("Year:   " + vehicle.getYear());
		make = new JLabel("Make:   " + vehicle.getMake());
		model = new JLabel("Model:   " + vehicle.getModel());
		trim = new JLabel("Trim:   " + vehicle.getTrim());
		type = new JLabel("Type:   " + vehicle.getType());
		price = new JLabel("Price:   " + vehicle.getPrice());
		special = new JLabel("Special:   ");

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(category).addComponent(make));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(id).addComponent(type).addComponent(year)
				.addComponent(model).addComponent(trim));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(price).addComponent(special).addComponent(select));
		hGroup.addGap(20);
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(category).addComponent(id));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(type).addComponent(price));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(year).addComponent(special));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(make).addComponent(model));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(trim).addComponent(select));
		vGroup.addGap(20);
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
	private String vehicleId;

	public ClickMeListener(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		BrowseInventory.setSelectedVehicleId(vehicleId);
		System.out.println("Car selected: " + vehicleId);

	}

}
