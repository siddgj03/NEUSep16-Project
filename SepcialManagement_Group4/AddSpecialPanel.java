import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * edit line 61 81 106.
 * edit line 158 179.
 */
public class AddSpecialPanel extends SpecialPanel {

    AddSpecialPanel(){
        infoButton = new JButton("Add");
        infoButton.addActionListener(new AddSpecialActionListener());
    }

    class AddSpecialActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            if (specialTitleInfo.getText().equals("") || (discountValueInfo.getText().equals("")
                    && discountPercentageInfo.getText().equals(""))
                    || specialStartDateInfo.getText().equals("")) {
                JOptionPane.showMessageDialog(AddSpecialPanel.this, "please add necessary information");

                if (specialTitleInfo.getText().equals("")) {
                	specialTitleInfo.setText("*");
            		specialTitleInfo.setBackground(Color.RED);
                }
                if (discountValueInfo.getText().equals("")) {
                	discountValueInfo.setText("*");
            		discountValueInfo.setBackground(Color.RED);
                }
                if (discountPercentageInfo.getText().equals("")) {
                	discountPercentageInfo.setText("*");
            		discountPercentageInfo.setBackground(Color.RED);
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

                if (discountValueInfo.getText() != null) {
                    newSpecial.setDiscountValue(Double.parseDouble(discountValueInfo.getText()));
                } else {
                    newSpecial.setDiscountPercentage(Double.parseDouble(discountPercentageInfo.getText()));
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

                Specials.addSpeical(newSpecial);
                addToFile(Specials.getList(),"C://Users//qiqi//IdeaProjects//NEU_Final_Project//b.txt");
                JOptionPane.showMessageDialog(null, "New Special Generated!", "Conformation Dialog", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                System.out.println("Invalid date input");
            }
        }

        private void addToFile(ArrayList<Special> specials, String output) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
            for (Special special: specials) {
                writer.write(special.toString());
                writer.newLine();
            }
            writer.close();
        }
    }

}
