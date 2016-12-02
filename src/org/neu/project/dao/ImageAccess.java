package org.neu.project.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.neu.project.dto.Vehicle;
/**
 * @author Rachel
 * */
public class ImageAccess implements ImageAccessMgt {
	String carImagePath;

	public ImageAccess(String path) {
		this.carImagePath = path;
	}

	@Override
	public List<ImageIcon> getImageList(Vehicle selectedVehicle) {
		List<ImageIcon> imageList = new ArrayList<ImageIcon>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(this.carImagePath));
			String path;

			BufferedImage img = null;
			while (true) {
				if ((path = bufferedReader.readLine()) == null) {
					break;
				}
			
				img = ImageIO.read(new File(path));
				ImageIcon icon = new ImageIcon(img);
				imageList.add(icon);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageList;
	}
}
