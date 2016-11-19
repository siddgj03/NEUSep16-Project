package ui.vehicleView;

import javax.swing.JPanel;

public class BasePanel extends JPanel {
	protected static int WIDTH = 1020;
	protected static int HEIGHT = 500;
    Vehicle selectedVehicle = null;
	BasePanel() {
		setUp();
		
	}

	private void setUp() {
		setSize(WIDTH, WIDTH);
		setVisible(true);
	}
}
