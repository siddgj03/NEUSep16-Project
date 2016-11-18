package ui.vehicleView;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class PhotoPanel extends BasePanel {
	private static final String BORDER_TITLE = "Current Offer";
	private static final String MSRP = "MSRP:";
	private static final String SALE_PRICE = "Sale Price:";
	private static final String SAVE = "Save:";
	private static final String SPECIAL_EXPIRES = "Special Expires:";
	private static final String PREVIOUS = "<<Previous";
	private static final String NEXT = "Next>>";
	private static final String SPECS_BORDER_TITLE = "Specifications";
	private static final String CATEGORY = "Category:";
	private static final String MAKE = "Make:";
	private static final String MODEL = "Model:";
	private static final String YEAR = "year:";
	private static final String COLOR = "Color:";
	private static final Font font = new Font("", Font.ITALIC,14);
	public PhotoPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		add();
	}

	private void add() {
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		
		this.add(getPhotoShowPanel());
		this.add(getCurrentOfferPanel());
		this.add(getSpecsPanel());

	}

	private Component getSpecsPanel() {
		TitledBorder title = new TitledBorder(SPECS_BORDER_TITLE);
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		JPanel panel = new JPanel();
		panel.setBorder(title);
		panel.setLayout(new GridLayout(5, 2));
		
	     //category
		JLabel category = new JLabel(CATEGORY);
		JLabel cateValue = new JLabel(selectedVehicle.getCategory());
		panel.add(category);
		panel.add(cateValue);
		//make
		JLabel make = new JLabel(MAKE);
		JLabel makeValue = new JLabel(selectedVehicle.getMake());
		panel.add(make);
		panel.add(makeValue);
		//model
		JLabel model = new JLabel(MODEL);
		JLabel modelValue = new JLabel(selectedVehicle.getModel());
		panel.add(model);
		panel.add(modelValue);
        //year
		JLabel year = new JLabel(YEAR);
		JLabel yearValue = new JLabel(selectedVehicle.getYear()+"");
		panel.add(year);
		panel.add(yearValue);
		//color
		JLabel color = new JLabel(COLOR);
		JLabel colorValue = new JLabel(selectedVehicle.getColor());
		panel.add(color);
		panel.add(colorValue);
		panel.setPreferredSize(new Dimension(700,300));
		
		return panel;
	}

	private Component getCurrentOfferPanel() {
		TitledBorder title = new TitledBorder(BORDER_TITLE);
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		JPanel panel = new JPanel();
		panel.setBorder(title);
		panel.setLayout(new GridLayout(4, 2));
		// MSRP
		
		JLabel msrp = new JLabel(MSRP);
		msrp.setFont(font);
		JLabel msrpValue = new JLabel(selectedVehicle.getMsrp() + "");
		panel.add(msrp);
		panel.add(msrpValue);
		// sale price
		JLabel salePrice = new JLabel(SALE_PRICE);
		salePrice.setFont(font);
		JLabel priceValue = new JLabel(selectedVehicle.getSale() + "");
		panel.add(salePrice);
		panel.add(priceValue);
		// save
		JLabel save = new JLabel(SAVE);
		save.setFont(font);
		JLabel saveValue = new JLabel(selectedVehicle.getSave() + "");
		panel.add(save);
		panel.add(saveValue);
		// expires
		JLabel expires = new JLabel(SPECIAL_EXPIRES);
		expires.setFont(font);
		JLabel date = new JLabel(selectedVehicle.getExpires() + "");
		panel.add(expires);
		panel.add(date);
		panel.setPreferredSize(new Dimension(400,300));
		return panel;
	}

	private Component getPhotoShowPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(getTitlePanel());
		panel.add(getPhotoPanel());
		panel.add(getArrowPanel());
		panel.setPreferredSize(new Dimension(550,300));
		return panel;
	}

	private Component getArrowPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		JButton goPre = new JButton(PREVIOUS);
		JButton goNext = new JButton(NEXT);
		panel.add(goPre);
		panel.add(goNext);
		return panel;
	}

	private Component getPhotoPanel() {
		BufferedImage img = null;
		JLabel label = null;
		try {
			img = ImageIO.read(new File(selectedVehicle.getImagePath()));
			ImageIcon icon = new ImageIcon(img);
			label = new JLabel(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return label;
	}

	private Component getTitlePanel() {
		JTextPane title = new JTextPane();
		title.setEnabled(false);
		title.setText(this.selectedVehicle.getTitle());
		return title;
	}

}
