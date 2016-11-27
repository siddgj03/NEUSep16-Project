import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * edit line 61 81 106.
 * edit line 158 179.
 */
public class AddSpecialPanel extends SpecialPanel {
    private int dealerId;

    AddSpecialPanel() {
        infoButton = new JButton("Add");
        infoButton.addActionListener(new AddSpecialActionListener());
        ComponetInitialize(infoButton, 1, 6, 1, 5, false);
        operateButton = new JButton();
        operateButton.setText("Reset");
        operateButton.addActionListener(new ResetActionListener());
        ComponetInitialize(operateButton, 3, 6, 1, 5, false);
    }

    class ResetActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            specialTitleInfo.setText("");
            specialTitleInfo.setBackground(Color.WHITE);
            discountValueOrPercentage.setBackground(Color.WHITE);
            valueOrPercentage.setText("");
            valueOrPercentage.setBackground(Color.WHITE);
            specialStartDateInfo.setText("");
            specialStartDateInfo.setBackground(Color.WHITE);
            specialEndDateInfo.setText("");
            trimInfo.setText("");
            carMinPriceInfo.setText("");
            carMaxPriceInfo.setText("");
        }
    }

    class AddSpecialActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            if (specialTitleInfo.getText().equals("") || valueOrPercentage.getText().equals("")
                    || specialStartDateInfo.getText().equals("")) {
                JOptionPane.showMessageDialog(AddSpecialPanel.this, "please add necessary information");

                if (specialTitleInfo.getText().equals("")) {
                    specialTitleInfo.setText("*");
                    specialTitleInfo.setBackground(Color.RED);
                }
                if (valueOrPercentage.getText().equals("")) {
                    valueOrPercentage.setText("*");
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

                Specials specialList = new Specials("C://Users//qiqi//IdeaProjects//NEU_Final_Project//" + dealerId + ".rtf", dealerId);
                specialList.addSpeical(newSpecial);
                WriteToFile.addToFile(specialList.getList(), "C://Users//qiqi//IdeaProjects//NEU_Final_Project//" + dealerId + ".rtf");
                JOptionPane.showMessageDialog(null, "New Special Generated!", "Conformation Dialog", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                System.out.println("Invalid date input");
            }
        }
    }
}



