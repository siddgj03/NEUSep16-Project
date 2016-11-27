import javax.swing.*;
import java.awt.*;

/**
 * Created by zhikunxu on 16/11/26.
 */
public class SpecialPanel extends JPanel {


    protected JButton infoButton;
    protected JButton operateButton;

    protected JTextField specialTitleInfo;
    protected JComboBox discountValueOrPercentage;
    protected JTextField valueOrPercentage;
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

        ComponetInitialize(new JLabel("Special Title£º"), 0, 0, 1, 1, false);
        specialTitleInfo = new JTextField();
        ComponetInitialize(specialTitleInfo, 1, 0, 3, 400, true);

        ComponetInitialize(new JLabel("Discount Value£º"), 0, 1, 1, 1, false);
        discountValueOrPercentage = new JComboBox();
        ComponetInitialize(discountValueOrPercentage, 1, 1, 1, 130, true);
        discountValueOrPercentage.addItem("Discount Value");
        discountValueOrPercentage.addItem("Discount Percentage");

        ComponetInitialize(new JLabel("Value/Percentage£º"), 2, 1, 1, 1, false);
        valueOrPercentage = new JTextField();
        ComponetInitialize(valueOrPercentage, 3, 1, 1, 0, true);
        valueOrPercentage.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Start Date(yyyy/mm/dd)£º"), 0, 2, 1, 1, false);
        specialStartDateInfo = new JTextField();
        ComponetInitialize(specialStartDateInfo, 1, 2, 1, 0, true);

        ComponetInitialize(new JLabel("End Date(yyyy/mm/dd)£º"), 2, 2, 1, 1, false);
        specialEndDateInfo = new JTextField();
        ComponetInitialize(specialEndDateInfo, 3, 2, 1, 0, true);

        ComponetInitialize(new JLabel("Year£º"), 2, 3, 1, 1, false);
        carYearInfo = new JComboBox();
        ComponetInitialize(carYearInfo, 3, 3, 1, 0, true);

        int carYearListSize=carYearList.getCarYearList().size();
        for(int i=0; i<carYearListSize; i++){
            carYearInfo.addItem(carYearList.getCarYearList().get(i));
        }

        ComponetInitialize(new JLabel("Make£º"), 0, 3, 1, 1, false);
        carMakeInfo = new JComboBox();
        ComponetInitialize(carMakeInfo, 1, 3, 1, 0, true);

        int carMakeListSize=carMakeList.getCarMakeList().size();
        for(int i=0; i<carMakeListSize; i++){
            carMakeInfo.addItem(carMakeList.getCarMakeList().get(i));
        }

        ComponetInitialize(new JLabel("Model£º"), 0, 4, 1, 1, false);
        carModelInfo = new JComboBox();
        ComponetInitialize(carModelInfo, 1, 4, 1, 0, true);

        int carTypeListSize=carTypeList.getCarTypeList().size();
        for(int i=0; i<carTypeListSize; i++){
            carModelInfo.addItem(carTypeList.getCarTypeList().get(i));
        }

        ComponetInitialize(new JLabel("Trim£º"), 2, 4, 1, 1, false);
        trimInfo = new JTextField();
        ComponetInitialize(trimInfo, 3, 4, 1, 0, true);

        ComponetInitialize(new JLabel("Min Price£º"), 0, 5, 1, 1, false);
        carMinPriceInfo = new JTextField();
        ComponetInitialize(carMinPriceInfo, 1, 5, 1, 0, true);
        carMinPriceInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Max Price£º"), 2, 5, 1, 1, false);
        carMaxPriceInfo = new JTextField();
        ComponetInitialize(carMaxPriceInfo, 3, 5, 1, 0, true);
        carMaxPriceInfo.addKeyListener(new InputValidNumberListener());

    }

    protected void ComponetInitialize(JComponent component, int x, int y, int width, int ipadx, boolean fill) {
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

   }