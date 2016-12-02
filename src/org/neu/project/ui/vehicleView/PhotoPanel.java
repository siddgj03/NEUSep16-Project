package org.neu.project.ui.vehicleView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import org.neu.project.dto.Vehicle;
import org.neu.project.service.ImageFetchingRunnable;
import org.neu.project.ui.vehicleView.common.DetailViewBasePanel;
/**
 * @author Rachel
 * */
public class PhotoPanel extends DetailViewBasePanel {
	private static final String BORDER_TITLE = "Current Offer";
	private static final Font font = new Font("", Font.ITALIC, 14);
	private static final Font titleFont = new Font("", Font.BOLD, 16);
	private static final Font nameFont = new Font("", Font.BOLD, 16);
	
	JPanel photoShowPanel;
	int imageIndex = 0;

	public PhotoPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		this.setBackground(Color.WHITE);
		add();
	}

	 protected void add() {

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

		this.add(getPhotoShowPanel());
		this.add(getCurrentOfferPanel());
		this.add(getSpecsPanel());

	}

	private Component getSpecsPanel() {
		TitledBorder title = new TitledBorder(SPECS_BORDER_TITLE);
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		title.setTitleFont(titleFont);
		JPanel panel = new JPanel();
		panel.setBorder(title);
		panel.setLayout(new GridLayout(6, 2));

		// category
		JLabel category = new JLabel(CATEGORY);
		JLabel cateValue = new JLabel(selectedVehicle.getCategory());
		panel.add(category);
		panel.add(cateValue);
		// make
		JLabel make = new JLabel(MAKE);
		JLabel makeValue = new JLabel(selectedVehicle.getMake());
		panel.add(make);
		panel.add(makeValue);
		// model
		JLabel model = new JLabel(MODEL);
		JLabel modelValue = new JLabel(selectedVehicle.getModel());
		panel.add(model);
		panel.add(modelValue);
		// year
		JLabel year = new JLabel(YEAR);
		JLabel yearValue = new JLabel(selectedVehicle.getYear() + "");
		panel.add(year);
		panel.add(yearValue);
		// body type
		JLabel bodyType = new JLabel(BODY_TYPE);
		JLabel typeValue = new JLabel(selectedVehicle.getBodyType());
		panel.add(bodyType);
		panel.add(typeValue);
		// trim
		JLabel trim = new JLabel(TRIM);
		JLabel trimValue = new JLabel(selectedVehicle.getTrim());
		panel.add(trim);
		panel.add(trimValue);
		panel.setPreferredSize(new Dimension(700, 300));
        panel.setBackground(Color.WHITE);
		return panel;
	}

	private Component getCurrentOfferPanel() {
		TitledBorder title = new TitledBorder(BORDER_TITLE);
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		title.setTitleFont(titleFont);
		JPanel panel = new JPanel();
		panel.setBorder(title);
		panel.setLayout(new GridLayout(4, 2));
		// MSRP

		JLabel msrp = new JLabel(MSRP);
		msrp.setFont(font);
		JLabel msrpValue = new JLabel(selectedVehicle.getPrice() + "");
		panel.add(msrp);
		panel.add(msrpValue);
		// sale price
		JLabel salePrice = new JLabel(SALE_PRICE);
		salePrice.setFont(font);
		// TODO:get sale price from special
//		JLabel priceValue = new JLabel(selectedVehicle.getSalePrice());
		JLabel priceValue = new JLabel("23990.0");
		panel.add(salePrice);
		panel.add(priceValue);
		// save
		JLabel save = new JLabel(SAVE);
		save.setFont(font);
//		JLabel saveValue = new JLabel((selectedVehicle.getPrice() - selectedVehicle.getSalePrice()s) + "");
		JLabel saveValue = new JLabel((selectedVehicle.getPrice() - 23990.0) + "");
		panel.add(save);
		panel.add(saveValue);
		// expires
		JLabel expires = new JLabel(SPECIAL_EXPIRES);
		expires.setFont(font);
		// TODO:get expires from special
//		JLabel date = new JLabel(selectedVehicle.getExpireDate());
        JLabel date = new JLabel("12/31/2016");
		panel.add(expires);
		panel.add(date);
		panel.setPreferredSize(new Dimension(400, 300));
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private Component getPhotoShowPanel() {
		photoShowPanel = new JPanel();
		photoShowPanel.setLayout(new BoxLayout(photoShowPanel, BoxLayout.Y_AXIS));
		photoShowPanel.add(getTitlePanel());
		photoShowPanel.add(getPhotoPanel());
		photoShowPanel.add(getArrowPanel());
		photoShowPanel.setPreferredSize(new Dimension(550, 300));
		photoShowPanel.setBackground(Color.WHITE);
		return photoShowPanel;
	}

	private Component getArrowPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		JButton goPre = new JButton(PREVIOUS);
		JButton goNext = new JButton(NEXT);

		goNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageIndex++;
				replaceImage();
				if (!goPre.isEnabled())
					goPre.setEnabled(true);
				if (imageIndex == (selectedVehicle.getImageList().size() - 1)) {
					goNext.setEnabled(false);
				}
			}
		});
		goPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageIndex--;
				replaceImage();
				if (!goNext.isEnabled())
					goNext.setEnabled(true);
				if (imageIndex == 0) {
					goPre.setEnabled(false);
				}
			}
		});
		goPre.setEnabled(false);
		panel.add(goPre);
		panel.add(goNext);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private Component getPhotoPanel() {
		JLabel photoLabel = new JLabel("loading");
		photoLabel.setPreferredSize(new Dimension(500, 260));
		Thread imageFetching = new Thread(new ImageFetchingRunnable(selectedVehicle, photoShowPanel));
		imageFetching.start();
		return photoLabel;
	}

	private Component getTitlePanel() {
		JTextPane title = new JTextPane();
		title.setEnabled(false);
		title.setText(this.selectedVehicle.getTitle());
		title.setFont(nameFont);
		return title;
	}

	private void replaceImage() {
		photoShowPanel.remove(1);
		List<ImageIcon> imageList = selectedVehicle.getImageList();
		if (imageIndex < imageList.size()) {
			JLabel photoLabel = new JLabel(imageList.get(imageIndex));
			photoShowPanel.add(photoLabel, 1);
			photoShowPanel.updateUI();
		}
	}
}
