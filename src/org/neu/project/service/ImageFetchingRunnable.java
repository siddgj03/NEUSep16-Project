package org.neu.project.service;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.neu.project.dao.ImageAccess;
import org.neu.project.dao.ImageAccessMgt;
import org.neu.project.dto.Vehicle;
/**
 * @author Rachel
 * */
public class ImageFetchingRunnable implements Runnable {
	Vehicle selectedVehicle;
	JPanel photoShowPanel;
	public ImageFetchingRunnable(Vehicle selectedVehicle,JPanel photoShowPanel){
		this.selectedVehicle = selectedVehicle;
		this.photoShowPanel = photoShowPanel;
	}

	@Override
	public void run() {
		ImageAccessMgt imgAccess = new ImageAccess(this.selectedVehicle.getImagePath());
		List<ImageIcon> imageList = imgAccess.getImageList(selectedVehicle);
		selectedVehicle.setImageList(imageList);
		JLabel photoLabel = new JLabel(imageList.get(0));
		this.photoShowPanel.remove(1);
		this.photoShowPanel.add(photoLabel,1);
		this.photoShowPanel.updateUI();
	}

}
