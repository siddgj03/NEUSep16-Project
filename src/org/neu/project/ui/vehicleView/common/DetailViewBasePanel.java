package org.neu.project.ui.vehicleView.common;


import javax.swing.JPanel;

import org.neu.project.dto.Vehicle;
/**
 * @author Rachel
 * */
public abstract class DetailViewBasePanel extends JPanel {
	protected static int WIDTH = 1020;
	protected static int HEIGHT = 500;
	protected static final String MSRP = "MSRP:";
	protected static final String SALE_PRICE = "Sale Price:";
	protected static final String SAVE = "Save:";
	protected static final String SPECIAL_EXPIRES = "Special Expires:";
	protected static final String PREVIOUS = "<<Previous";
	protected static final String NEXT = "Next>>";
	protected static final String SPECS_BORDER_TITLE = "Specifications";
	protected static final String CATEGORY = "Category:";
	protected static final String MAKE = "Make:";
	protected static final String MODEL = "Model:";
	protected static final String YEAR = "Year:";
	protected static final String BODY_TYPE = "Body Type:";
	protected static final String TRIM = "Trim:";
    protected Vehicle selectedVehicle = null;
    protected DetailViewBasePanel() {
		setUp();
		
	}
    protected abstract void add();
	private void setUp() {
		setSize(WIDTH, WIDTH);
		setVisible(true);
		
	}
}
