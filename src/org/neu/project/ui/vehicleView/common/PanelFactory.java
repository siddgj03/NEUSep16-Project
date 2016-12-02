package org.neu.project.ui.vehicleView.common;

import javax.swing.JComponent;

import org.neu.project.dto.Vehicle;
import org.neu.project.ui.vehicleView.PhotoPanel;
import org.neu.project.ui.vehicleView.RatingPanel;
import org.neu.project.ui.vehicleView.SimilarPanel;
import org.neu.project.ui.vehicleView.SpecialPanel;
import org.neu.project.ui.vehicleView.TabPanel;
/**
 * @author Rachel
 * */
public class PanelFactory {
	Vehicle selectedVehicle = null;

	public PanelFactory(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}

	public JComponent getPanel(String type) {
		JComponent com = null;
		if (TabPanel.PHOTO.equals(type)) {
			com = new PhotoPanel(selectedVehicle);
		} else if (TabPanel.SPECIAL.equals(type)) {
			com = new SpecialPanel(selectedVehicle);
		} else if (TabPanel.SIMILAR.equals(type)) {
			com = new SimilarPanel(selectedVehicle);
		}else if (TabPanel.RATING.equals(type)) {
			com = new RatingPanel(selectedVehicle);
		}
		return com;
	}
}
