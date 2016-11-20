package ui.vehicleView;

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

import service.ImageFetchingRunnable;

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
	private static final Font font = new Font("", Font.ITALIC, 14);

	JPanel photoShowPanel;
	int imageIndex = 0;

	public PhotoPanel(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
		add();
	}

	private void add() {

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

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
		// color
		JLabel color = new JLabel(COLOR);
		JLabel colorValue = new JLabel(selectedVehicle.getColor());
		panel.add(color);
		panel.add(colorValue);
		panel.setPreferredSize(new Dimension(700, 300));

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
		panel.setPreferredSize(new Dimension(400, 300));
		return panel;
	}

	private Component getPhotoShowPanel() {
		photoShowPanel = new JPanel();
		photoShowPanel.setLayout(new BoxLayout(photoShowPanel, BoxLayout.Y_AXIS));
		photoShowPanel.add(getTitlePanel());
		photoShowPanel.add(getPhotoPanel());
		photoShowPanel.add(getArrowPanel());
		photoShowPanel.setPreferredSize(new Dimension(550, 300));
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
