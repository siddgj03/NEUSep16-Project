package org.neu.project.ui.vehicleView;

import java.awt.Color;

import javax.swing.JTabbedPane;

import org.neu.project.dto.Vehicle;
import org.neu.project.ui.vehicleView.common.PanelFactory;

/**
 * @author Rachel
 * */
public class TabPanel extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	public static final String PHOTO = "Photo";
	public static final String SPECIAL = "Specials";
	public static final String SIMILAR = "Similar";
	public static final String RATING = "Rating";
	
	public TabPanel(Vehicle selectedVehicle) {
		PanelFactory factory = new PanelFactory(selectedVehicle);
		this.add(PHOTO, factory.getPanel(PHOTO));
		this.add(SPECIAL, factory.getPanel(SPECIAL));
		this.add(SIMILAR, factory.getPanel(SIMILAR));
		this.add(RATING, factory.getPanel(RATING));
		this.setBackground(Color.WHITE);
		setUp();
	}

	private void setUp() {
		this.setSize(DetailView.scrWidth, DetailView.scrHeight);
		this.setVisible(true);

	}
}
