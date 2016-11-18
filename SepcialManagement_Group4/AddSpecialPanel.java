package SepcialManagement_Group4;

import SepcialManagement_Group4.InputValidNumberListener;
import SepcialManagement_Group4.Special;
import SepcialManagement_Group4.Specials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiqi on 2016/11/16.
 */
public class AddSpecialPanel extends JPanel {

    private JButton addInforButton;
    private JButton resetInfoButton;

    private JTextField specialTitleInfo;
    private JTextField discountValueInfo;
    private JTextField dicountPercentageInfo;
    private JTextField specialStartDateInfo;
    private JTextField specialEndDateInfo;
    private JTextField carYearInfo;
    private JTextField carMakeInfo;
    private JTextField carModelInfo;
    private JTextField trimInfo;
    private JTextField carMinPriceInfo;
    private JTextField carMaxPriceInfo;

    public AddSpecialPanel() {
        setLayout(new GridBagLayout());
        setBounds(20, 20, 600, 400);

        ComponetInitialize(new JLabel("Special Title："), 0, 0, 1, 1, false);
        specialTitleInfo = new JTextField();
        ComponetInitialize(specialTitleInfo, 1, 0, 3, 400, true);

        ComponetInitialize(new JLabel("Discount Value："), 0, 1, 1, 1, false);
        discountValueInfo = new JTextField();
        ComponetInitialize(discountValueInfo, 1, 1, 1, 130, true);
        discountValueInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Discount Percentage："), 2, 1, 1, 1, false);
        dicountPercentageInfo = new JTextField();
        ComponetInitialize(dicountPercentageInfo, 3, 1, 1, 0, true);
        dicountPercentageInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Start Date(yyyy/mm/dd)："), 0, 2, 1, 1, false);
        specialStartDateInfo = new JTextField();
        ComponetInitialize(specialStartDateInfo, 1, 2, 1, 0, true);

        ComponetInitialize(new JLabel("End Date："), 2, 2, 1, 1, false);
        specialEndDateInfo = new JTextField();
        ComponetInitialize(specialEndDateInfo, 3, 2, 1, 0, true);

        ComponetInitialize(new JLabel("Year："), 2, 3, 1, 1, false);
        carYearInfo = new JTextField();
        ComponetInitialize(carYearInfo, 3, 3, 1, 0, true);

        ComponetInitialize(new JLabel("Make："), 0, 3, 1, 1, false);
        carMakeInfo = new JTextField();
        ComponetInitialize(carMakeInfo, 1, 3, 1, 0, true);

        ComponetInitialize(new JLabel("Model："), 0, 4, 1, 1, false);
        carModelInfo = new JTextField();
        ComponetInitialize(carModelInfo, 1, 4, 1, 0, true);

        ComponetInitialize(new JLabel("Trim："), 2, 4, 1, 1, false);
        trimInfo = new JTextField();
        ComponetInitialize(trimInfo, 3, 4, 1, 0, true);

        ComponetInitialize(new JLabel("Min Price："), 0, 5, 1, 1, false);
        carMinPriceInfo = new JTextField();
        ComponetInitialize(carMinPriceInfo, 1, 5, 1, 0, true);
        carMinPriceInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Max Price："), 2, 5, 1, 1, false);
        carMaxPriceInfo = new JTextField();
        ComponetInitialize(carMaxPriceInfo, 3, 5, 1, 0, true);
        carMaxPriceInfo.addKeyListener(new InputValidNumberListener());

        addInforButton = new JButton();
        addInforButton.setText("Add");
        addInforButton.addActionListener(new AddSpecialActionListener());
        ComponetInitialize(addInforButton, 1, 6, 1, 5,false);

        resetInfoButton = new JButton();
        resetInfoButton.setText("Reset");
        resetInfoButton.addActionListener(new ResetActionListener());
        ComponetInitialize(resetInfoButton, 3, 6, 1, 5,false);
    }

    private void ComponetInitialize(JComponent component, int x, int y, int width, int ipadx, boolean fill) {
        GridBagConstraints gridBagConstrains = new GridBagConstraints();
        gridBagConstrains.gridx = x;
        gridBagConstrains.gridy = y;
        gridBagConstrains.insets = new Insets(5, 1, 3, 1);
        if (width > 1)
            gridBagConstrains.gridwidth = width;
        if (ipadx > 0)
            gridBagConstrains.ipadx = ipadx;
        if (fill)
            gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
        add(component, gridBagConstrains);
    }

    class ResetActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            specialTitleInfo.setText("");
            discountValueInfo.setText("");
            dicountPercentageInfo.setText("");
            specialStartDateInfo.setText("");
            specialEndDateInfo.setText("");
            carYearInfo.setText("");
            carMakeInfo.setText("");
            carModelInfo.setText("");
            trimInfo.setText("");
            carMinPriceInfo.setText("");
            carMaxPriceInfo.setText("");
        }
    }

    class AddSpecialActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            if (specialTitleInfo.getText().equals("") || (discountValueInfo.getText().equals("")
                    && dicountPercentageInfo.getText().equals(""))
                    || specialStartDateInfo.getText().equals("")) {
                JOptionPane.showMessageDialog(AddSpecialPanel.this, "please add necessary information");
                return;
            }
            Special newSpecial = new Special();
            newSpecial.setSpecialTitle(specialTitleInfo.getText());
            try {
                newSpecial.setSpecialStartDate(specialStartDateInfo.getText().trim());
                System.out.println(specialStartDateInfo.getText());
                if (discountValueInfo.getText() != null) {
                    newSpecial.setDiscountValue(Double.parseDouble(discountValueInfo.getText()));
                } else {
                    newSpecial.setDicountPercentage(Double.parseDouble(dicountPercentageInfo.getText()));
                }
                newSpecial.setSpecialStartDate(specialStartDateInfo.getText());
                if (specialEndDateInfo.getText() != null && specialEndDateInfo.getText().length() != 0) {
                    newSpecial.setSpecialEndDate(specialEndDateInfo.getText().trim());
                }
                if (carYearInfo.getText() != null) {
                    newSpecial.setCarYear(Integer.parseInt(carYearInfo.getText()));
                }
                if (carMakeInfo.getText() != null) {
                    newSpecial.setCarMake(carMakeInfo.getText());
                }
                if (carModelInfo.getText() != null) {
                    newSpecial.setCarModel(carModelInfo.getText());
                }
                if (trimInfo.getText() != null) {
                    newSpecial.setCarModel(trimInfo.getText());
                }
                if (carMinPriceInfo.getText() != null) {
                    newSpecial.setCarMinPrice(Double.parseDouble(carMinPriceInfo.getText()));
                }
                if (carMaxPriceInfo.getText() != null) {
                    newSpecial.setCarMaxPrice(Double.parseDouble(carMaxPriceInfo.getText()));
                }
                Specials.addSpeical(newSpecial);
            } catch (Exception ex) {
                System.out.println("Invalid date input");
            }
        }
    }

}
