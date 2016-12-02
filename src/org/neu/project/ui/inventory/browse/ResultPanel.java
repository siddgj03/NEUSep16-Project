package org.neu.project.ui.inventory.browse;

import org.neu.project.dao.ImageAccess;
import org.neu.project.dto.Vehicle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * @author Sida Niu result of vehicle information in browse inventory page
 *         GroupLayout to place labels
 */

public class ResultPanel extends JPanel {

	private JPanel infoCombo;

	private JLabel picture;
	private Image image;
	private ImageIcon icon;

	private ButtonGroup group;
	private JRadioButton select;

	private JLabel id;
	private JLabel category;
	private JLabel year;
	private JLabel make;
	private JLabel model;
	private JLabel trim;
	private JLabel type;
	private JLabel price;
	private JLabel special;

	public ResultPanel(BrowseInventory frame) {

		// set result panel layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		group = new ButtonGroup();

		

		for (Vehicle vehicle : frame.getInventory()) {

			// create search result combo for one vehicle
			JPanel combo = new JPanel();
			combo.setLayout(new FlowLayout());
			combo.setBorder(BorderFactory.createTitledBorder("details "));

			// get vehicle picture
			picture = new JLabel();
//			picture.setIcon(resizeIconPicture(picture, vehicle));


			// add clickListener to radio button
			JPanel panel = showResultVehicle(vehicle);
			setJLabelSize(panel);
			JRadioButton button = new JRadioButton();
			button = getRadioButton(panel);
			ClickMeListener cml = new ClickMeListener(vehicle.getId(), frame);
			button.addActionListener(cml);
			group.add(button);

			// add picture and infoCobo to result combo
//			combo.add(picture);
			combo.add(panel);

			// add result combo to result panel
			add(combo);
				

		}
		

	}

	private JPanel showResultVehicle(Vehicle vehicle) {

		// create information combo panel
		infoCombo = new JPanel();
		GroupLayout layout = new GroupLayout(infoCombo);
		infoCombo.setLayout(layout);

		// radio button
		select = new JRadioButton("Select ");

		// information tags
		id = new JLabel("ID:   " + vehicle.getId());
		category = new JLabel("Category:   " + vehicle.getCategory());
		year = new JLabel("Year:   " + vehicle.getYear());
		make = new JLabel("Make:   " + vehicle.getMake());
		model = new JLabel("Model:   " + vehicle.getModel());
		trim = new JLabel("Trim:   " + vehicle.getTrim());
		type = new JLabel("Type:   " + vehicle.getType());
		price = new JLabel("Price:   " + vehicle.getPrice());
		special = new JLabel("Special:   ");

		// GroupLayout's Horizontal group
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

		// GroupLayout's vertical group
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

		return infoCombo;
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

	private void setJLabelSize(JPanel jpanel) {

		int count = jpanel.getComponentCount();

		for (int i = 0; i < count; i++) {

			Component comp = jpanel.getComponent(i);
			comp.setMaximumSize(new Dimension(100, 20));
			comp.setMinimumSize(new Dimension(100, 20));

		}

	}

	private ImageIcon resizeIconPicture(JLabel label, Vehicle vehicle){
		
		ImageAccess imgAccess = new ImageAccess(vehicle.getImagePath());
		List<ImageIcon> imageList = imgAccess.getImageList(vehicle);
		vehicle.setImageList(imageList);
		Image currentImage = imageList.get(0).getImage();
		icon = new ImageIcon(currentImage.getScaledInstance(200, 180,
				Image.SCALE_FAST));
		
		return icon;
	
	}
	
}

class ClickMeListener implements ActionListener {

	private String vehicleId;
	private BrowseInventory frame;

	public ClickMeListener(String vehicleId, BrowseInventory frame) {

		this.vehicleId = vehicleId;
		this.frame = frame;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		frame.setSelectedVehicleId(vehicleId);
		System.out.println("Car selected: " + vehicleId);

	}

}

//class SlideListener implements MouseListener {
//
//	private JLabel label;
//	private Vehicle vehicle;
//	private Image currentImage;
//	private ImageIcon icon;
//
//	public SlideListener(JLabel label, Vehicle vehicle) {
//
//		this.label = label;
//		this.vehicle = vehicle;
//
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//
//	}
//
//
//
//}
