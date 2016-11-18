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
 * Created by qiqi on 2016/11/16.
 */
public class AddSpecialPanel extends JPanel {

    private JButton addInforButton;
    private JButton resetInfoButton;

    private JTextField specialTitleInfo;
    private JTextField discountValueInfo;
    private JTextField discountPercentageInfo;
    private JTextField specialStartDateInfo;
    private JTextField specialEndDateInfo;
    private JTextField carYearInfo;
    private JComboBox carMakeInfo;
    private JComboBox carModelInfo;
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
        carYearInfo = new JTextField();
        ComponetInitialize(carYearInfo, 3, 3, 1, 0, true);
        carYearInfo.addKeyListener(new InputValidNumberListener());

        ComponetInitialize(new JLabel("Make："), 0, 3, 1, 1, false);
        carMakeInfo = new JComboBox();
        ComponetInitialize(carMakeInfo, 1, 3, 1, 0, true);
        carMakeInfo.addItem("All");				carMakeInfo.addItem("Acura");		carMakeInfo.addItem("Alfa Romeo");	carMakeInfo.addItem("AM General");
        carMakeInfo.addItem("Aston Martin");	carMakeInfo.addItem("Audi");		carMakeInfo.addItem("Bentley");		carMakeInfo.addItem("BMW");
        carMakeInfo.addItem("Bugatti");			carMakeInfo.addItem("Buick");		carMakeInfo.addItem("Cadillac");	carMakeInfo.addItem("Chevrolet");
        carMakeInfo.addItem("Chrysler");		carMakeInfo.addItem("Daewoo");		carMakeInfo.addItem("Dodge");		carMakeInfo.addItem("Eagle");
        carMakeInfo.addItem("Ferrari");			carMakeInfo.addItem("FIAT");		carMakeInfo.addItem("Fisker");		carMakeInfo.addItem("Ford");
        carMakeInfo.addItem("Genesis");			carMakeInfo.addItem("Geo");			carMakeInfo.addItem("GMC");			carMakeInfo.addItem("Honda");
        carMakeInfo.addItem("HUMMER");			carMakeInfo.addItem("Hyundai");		carMakeInfo.addItem("Infiniti");	carMakeInfo.addItem("Isuzu");
        carMakeInfo.addItem("Jaguar");			carMakeInfo.addItem("Jeep");		carMakeInfo.addItem("Kia");			carMakeInfo.addItem("Lamborghini");
        carMakeInfo.addItem("Land Rover");		carMakeInfo.addItem("Lexus");		carMakeInfo.addItem("Lincoln");		carMakeInfo.addItem("Lotus");
        carMakeInfo.addItem("Maserati");		carMakeInfo.addItem("Maybach");		carMakeInfo.addItem("Mazda");		carMakeInfo.addItem("McLaren");
        carMakeInfo.addItem("Mercedes-Benz");	carMakeInfo.addItem("Mercury");		carMakeInfo.addItem("MINI");		carMakeInfo.addItem("Mitsubishi");
        carMakeInfo.addItem("Nissan");			carMakeInfo.addItem("Oldsmobile");	carMakeInfo.addItem("Panoz");		carMakeInfo.addItem("Plymouth");
        carMakeInfo.addItem("Pontiac");			carMakeInfo.addItem("Porsche");		carMakeInfo.addItem("Ram");			carMakeInfo.addItem("Rolls-Royce");
        carMakeInfo.addItem("Saab");			carMakeInfo.addItem("Saturn");		carMakeInfo.addItem("Scion");		carMakeInfo.addItem("Smart");
        carMakeInfo.addItem("Spyker");			carMakeInfo.addItem("Subaru");		carMakeInfo.addItem("Suzuki");		carMakeInfo.addItem("Tesla");
        carMakeInfo.addItem("Toyota");			carMakeInfo.addItem("Volkswagen");	carMakeInfo.addItem("Volvo");

        ComponetInitialize(new JLabel("Model："), 0, 4, 1, 1, false);
        carModelInfo = new JComboBox();
        ComponetInitialize(carModelInfo, 1, 4, 1, 0, true);
        carModelInfo.addItem("All");		carModelInfo.addItem("Convertible");	carModelInfo.addItem("Coupe");				carModelInfo.addItem("Crossover");
        carModelInfo.addItem("Diesel"); 	carModelInfo.addItem("Hatchback");		carModelInfo.addItem("Hybrid/Electric");	carModelInfo.addItem("Luxury");
        carModelInfo.addItem("Minivan"); 	carModelInfo.addItem("Sedan");			carModelInfo.addItem("SUV");				carModelInfo.addItem("Truck");
        carModelInfo.addItem("Wagon");

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
            discountPercentageInfo.setText("");
            specialStartDateInfo.setText("");
            specialEndDateInfo.setText("");
            carYearInfo.setText("");
            trimInfo.setText("");
            carMinPriceInfo.setText("");
            carMaxPriceInfo.setText("");
        }
    }



    class AddSpecialActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            if (specialTitleInfo.getText().equals("") || (discountValueInfo.getText().equals("")
                    && discountPercentageInfo.getText().equals(""))
                    || specialStartDateInfo.getText().equals("")) {
                JOptionPane.showMessageDialog(AddSpecialPanel.this, "please add necessary information");
                return;
            }
            Special newSpecial = new Special();
            newSpecial.setSpecialTitle(specialTitleInfo.getText());
            try {
                newSpecial.setSpecialStartDate(specialStartDateInfo.getText().trim());
                if (discountValueInfo.getText() != null) {
                    newSpecial.setDiscountValue(Double.parseDouble(discountValueInfo.getText()));
                } else {
                    newSpecial.setDicountPercentage(Double.parseDouble(discountPercentageInfo.getText()));
                }
                newSpecial.setSpecialStartDate(specialStartDateInfo.getText());
                if (specialEndDateInfo.getText() != null && specialEndDateInfo.getText().length() != 0) {
                    newSpecial.setSpecialEndDate(specialEndDateInfo.getText().trim());
                }
                if (carYearInfo.getText() != null) {
                    newSpecial.setCarYear(Integer.parseInt(carYearInfo.getText()));
                }
                newSpecial.setCarMake(carMakeInfo.getSelectedItem().toString());
                newSpecial.setCarModel(carModelInfo.getSelectedItem().toString());
                if (trimInfo.getText() != null) {
                    newSpecial.setCarModel(trimInfo.getText());
                }
                if (carMinPriceInfo.getText() != null) {
                    newSpecial.setCarMinPrice(Double.parseDouble(carMinPriceInfo.getText()));
                }
                if (carMaxPriceInfo.getText() != null) {
                    newSpecial.setCarMaxPrice(Double.parseDouble(carMaxPriceInfo.getText()));
                } else {
                    newSpecial.setCarMaxPrice(null);
                }
                Specials.addSpeical(newSpecial);
                addToFile(Specials.getList(),"C:\\Users\\qiqi\\IdeaProjects\\NEU_Final_Project\\a.txt");
                JOptionPane.showMessageDialog(null, "New Special Generated!", "Conformation Dialog", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                System.out.println("Invalid date input");
            }
        }
        private void addToFile(ArrayList<Special> specials, String output) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
            writer.write(specials.toString());
        }
    }

}
