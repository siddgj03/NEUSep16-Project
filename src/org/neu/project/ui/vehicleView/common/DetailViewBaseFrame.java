package org.neu.project.ui.vehicleView.common;

import javax.swing.*;

/**
 * 
 * @author Rachel
 */
public abstract class DetailViewBaseFrame extends JFrame {
	private int width;
	private int height;

	public DetailViewBaseFrame(int width, int height) {
		this.width = width;
		this.height = height;
	}

	protected void setup() {
		setSize(width,height);
		setVisible(true);
		// Exits the running process on window close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centers the window on screen
		setLocationRelativeTo(null);
	}
	
	protected abstract void add();

}