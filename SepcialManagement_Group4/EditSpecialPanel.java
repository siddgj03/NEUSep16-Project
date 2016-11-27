import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EditSpecialPanel extends SpecialPanel {
	private int specialId;
	private int dealerId;
	public Specials specialList;

	public EditSpecialPanel(int specialId, int dealerId) throws Exception {
		setDealerId(dealerId);
		setSpecialId(specialId);
		String filePath = "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//2.rtf";
		System.out.println("This is filePath: " + filePath);
		specialList = new Specials(filePath.trim(), dealerId);
		infoButton = new JButton("Save");
		infoButton.addActionListener(new SaveSpecialActionListener());
		ComponetInitialize(infoButton, 1, 6, 1, 5, false);
		operateButton = new JButton();
		operateButton.setText("Delete");
		operateButton.addActionListener(new DeleteActionListener());
		ComponetInitialize(operateButton, 3, 6, 1, 5, false);
		readFromFile();
	}

	private void readFromFile() throws Exception {
		String input = "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//" + dealerId + ".rtf";
		BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
		while (true) {
			try {
				String line = reader.readLine();
				String[] arr = line.split("\\|");
				if (Integer.parseInt(arr[0]) == specialId) {
					Special newSpecial = StringToSpecial.toSpecial(line);
					fillBlank(newSpecial);
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void fillBlank(Special special) {
		specialTitleInfo.setText(special.getSpecialTitle());
		valueOrPercentage.setText(special.getDicountPercentage() == null ? special.getDiscountValue() + "" : special.getDicountPercentage() + "");
		specialStartDateInfo.setText(special.dateToString(special.getSpecialStartDate()) + "");
		specialEndDateInfo.setText(special.dateToString(special.getSpecialEndDate()) + "");
		trimInfo.setText(special.getTrim());
		carYearInfo.setSelectedItem(special.getCarYear());
		carMakeInfo.setSelectedItem(special.getCarMake());
		carModelInfo.setSelectedItem(special.getCarModel());
		carMinPriceInfo.setText(special.getCarMinPrice() + "");
		carMaxPriceInfo.setText(special.getCarMaxPrice() + "");

	}

	public int getSpecialId() {
		return specialId;
	}

	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	class DeleteActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			specialList.getList().set(specialId - 1, new Special());
			JOptionPane.showMessageDialog(EditSpecialPanel.this, "Delete successfully");
			try {
				WriteToFile.addToFile(specialList.getList(), "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//" + dealerId + ".rtf");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	class SaveSpecialActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			if (specialTitleInfo.getText().equals("")
					|| valueOrPercentage.getText().equals("")
					|| specialStartDateInfo.getText().equals("")) {
				JOptionPane.showMessageDialog(EditSpecialPanel.this, "please add necessary information");

				if (specialTitleInfo.getText().equals("")) {
					specialTitleInfo.setText("*");
					specialTitleInfo.setBackground(Color.RED);
				}
				if (valueOrPercentage.getText().equals("")) {
					valueOrPercentage.setText("*");
					valueOrPercentage.setBackground(Color.RED);
				}
				if (specialStartDateInfo.getText().equals("")) {
					specialStartDateInfo.setText("*");
					specialStartDateInfo.setBackground(Color.RED);
				}
				return;
			}
			Special newSpecial = new Special();

			newSpecial.setSpecialTitle(specialTitleInfo.getText());
			try {
				newSpecial.setSpecialStartDate(specialStartDateInfo.getText().trim());

				if (specialEndDateInfo.getText() != null && specialEndDateInfo.getText().length() != 0) {
					newSpecial.setSpecialEndDate(specialEndDateInfo.getText().trim());
				} else {
					newSpecial.setSpecialEndDate("2099/12/31");
				}

				if (discountValueOrPercentage.getSelectedItem().toString().equals("Discount Value")) {
					newSpecial.setDiscountValue(valueOrPercentage.getText());
				} else {
					newSpecial.setDiscountPercentage(valueOrPercentage.getText());
				}

				newSpecial.setCarYear(carYearInfo.getSelectedItem().toString());

				newSpecial.setCarMake(carMakeInfo.getSelectedItem().toString());

				newSpecial.setCarModel(carModelInfo.getSelectedItem().toString());

				if (trimInfo.getText() != null) {
					newSpecial.setCarModel(trimInfo.getText());
				}

				if (carMinPriceInfo.getText() != null) {
					newSpecial.setCarMinPrice(carMinPriceInfo.getText());
				}

				if (carMaxPriceInfo.getText() != null) {
					newSpecial.setCarMaxPrice(carMaxPriceInfo.getText());
				}
				specialList.getList().set(specialId, newSpecial);
				WriteToFile.addToFile(specialList.getList(), "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//" + dealerId + ".rtf");
				JOptionPane.showMessageDialog(null, "Save successfully!", "Conformation Dialog",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				System.out.println("Invalid date input");
			}
		}
	}
}
