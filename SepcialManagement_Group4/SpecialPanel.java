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
 * Created by zhikunxu on 16/11/26.
 */
public class SpecialPanel extends JPanel {


    protected JButton infoButton;
    protected JButton resetInfoButton;

    protected JTextField specialTitleInfo;
    protected JTextField discountValueInfo;
    protected JTextField discountPercentageInfo;
    protected JTextField specialStartDateInfo;
    protected JTextField specialEndDateInfo;
    protected JComboBox carYearInfo;
    protected JComboBox carMakeInfo;
    protected JComboBox carModelInfo;
    protected JTextField trimInfo;
    protected JTextField carMinPriceInfo;
    protected JTextField carMaxPriceInfo;

    public SpecialPanel()  {
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
        discountPercentageInfo = new JTextField();
        ComponetInitialize(discountPercentageInfo, 3, 1, 1, 0, true);
        discountPercentageInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Start Date(yyyy/mm/dd)："), 0, 2, 1, 1, false);
        specialStartDateInfo = new JTextField();
        ComponetInitialize(specialStartDateInfo, 1, 2, 1, 0, true);

        ComponetInitialize(new JLabel("End Date(yyyy/mm/dd)："), 2, 2, 1, 1, false);
        specialEndDateInfo = new JTextField();
        ComponetInitialize(specialEndDateInfo, 3, 2, 1, 0, true);

        ComponetInitialize(new JLabel("Year："), 2, 3, 1, 1, false);
        carYearInfo = new JComboBox();
        ComponetInitialize(carYearInfo, 3, 3, 1, 0, true);

        int carYearListSize=carYearList.getCarYearList().size();
        for(int i=0; i<carYearListSize; i++){
            carYearInfo.addItem(carYearList.getCarYearList().get(i));
        }

        ComponetInitialize(new JLabel("Make："), 0, 3, 1, 1, false);
        carMakeInfo = new JComboBox();
        ComponetInitialize(carMakeInfo, 1, 3, 1, 0, true);

        int carMakeListSize=carMakeList.getCarMakeList().size();
        for(int i=0; i<carMakeListSize; i++){
            carMakeInfo.addItem(carMakeList.getCarMakeList().get(i));
        }

        ComponetInitialize(new JLabel("Model："), 0, 4, 1, 1, false);
        carModelInfo = new JComboBox();
        ComponetInitialize(carModelInfo, 1, 4, 1, 0, true);

        int carTypeListSize=carTypeList.getCarTypeList().size();
        for(int i=0; i<carTypeListSize; i++){
            carModelInfo.addItem(carTypeList.getCarTypeList().get(i));
        }

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

        infoButton = new JButton();
        ComponetInitialize(infoButton, 1, 6, 1, 5,false);

        resetInfoButton = new JButton();
        resetInfoButton.setText("Reset");
        resetInfoButton.addActionListener(new SpecialPanel.ResetActionListener());
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
            specialTitleInfo.setBackground(Color.WHITE);
            discountValueInfo.setText("");
            discountValueInfo.setBackground(Color.WHITE);
            discountPercentageInfo.setText("");
            discountPercentageInfo.setBackground(Color.WHITE);
            specialStartDateInfo.setText("");
            specialStartDateInfo.setBackground(Color.WHITE);
            specialEndDateInfo.setText("");
            trimInfo.setText("");
            carMinPriceInfo.setText("");
            carMaxPriceInfo.setText("");
        }
    }
}
