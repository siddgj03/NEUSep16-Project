package org.neu.project.ui.common;

import org.neu.project.ui.DealerUI;

import javax.swing.*;

/**
 * Shared class to create UI frames. Feel free to add anything that's missing.
 * - Ken
 */
public abstract class BaseFrame extends JFrame {
	private int width;
	private int height;

	public BaseFrame(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Separated the 4 base methods to allow constructor of child classes to setup variables first
	 */
	public void display() {
		create();
		add();
		addListener();
		setup();
	}

	private void setup() {
		setSize(width,height);
		setVisible(true);
		// Exits the running process on window close (only for the entry point)
//		if (this instanceof DealerUI) {
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		}
		// Centers the window on screen
		setLocationRelativeTo(null);
	}

	protected abstract void create();

	protected abstract void add();

	protected abstract void addListener();
}
