package org.neu.project.ui.special;

import NEU_Project.DAO.WriteSpecialToFile;
import NEU_Project.DTO.Special;
import NEU_Project.Service.SpecialManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 * edit line 61 81 106.
 * edit line 158 179.
 * <p>
 * <p>
 * edit 22 120 124
 */
public class AddSpecialPanel extends BasePanelForManageSpecial {
  private String dealerId;
  public String defaultPath = System.getProperty("user.dir") + "/SpecialData/";


  public AddSpecialPanel(String dealerId) {
    setDealerId(dealerId);
    infoButton = new JButton("Add");
    infoButton.setBorderPainted(false);
    infoButton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    infoButton.addActionListener(new AddSpecialActionListener());
    ComponetInitialize(infoButton, 1, 6, 1, 5, false);
    operateButton = new JButton();
    operateButton.setText("Reset");
    operateButton.setBorderPainted(false);
    operateButton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    operateButton.addActionListener(new ResetActionListener());
    ComponetInitialize(operateButton, 3, 6, 1, 5, false);
  }

  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }

  public String getDealerId() {
    return dealerId;
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
      newSpecial.setDealerWebID(getDealerId());

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
        //����ǰ��·��
        SpecialManagement specials = new SpecialManagement(defaultPath + getDealerId() + ".txt", dealerId);
        newSpecial.setSpecialID((UUID.randomUUID().toString()).substring(0, 8));
        specials.getList().add(newSpecial);
        //����ǰ��·��
        WriteSpecialToFile.addToFile(specials.getList(), defaultPath + getDealerId() + ".txt");
        JOptionPane.showMessageDialog(null, "New Special Generated!", "Conformation Dialog", JOptionPane.INFORMATION_MESSAGE);
        new ViewSpecialsUI(getDealerId());
      } catch (Exception ex) {
        System.out.println("Invalid date input");
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("Add Special");
    frame.add(new AddSpecialPanel("gmps-xyz"));
    frame.setSize(700, 300);

//      ImageIcon background = new ImageIcon("C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//Picture.jpg");
//
//      JLabel label = new JLabel(background);
//
//      label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
//
//      JPanel imagePanel = (JPanel) frame.getContentPane();
//      imagePanel.setOpaque(false);
//      frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
    frame.setVisible(true);
  }
}


