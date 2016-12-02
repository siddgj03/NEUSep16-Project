package org.neu.project.dao;

import java.util.List;

import javax.swing.ImageIcon;

import org.neu.project.dto.Vehicle;
/**
 * @author Rachel
 * */
public interface ImageAccessMgt {
	List<ImageIcon> getImageList(Vehicle selectedVehicle);
}
