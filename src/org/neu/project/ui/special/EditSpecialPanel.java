package org.neu.project.ui.special;

import org.neu.project.dao.WriteSpecialToFile;
import org.neu.project.dto.Special;
import org.neu.project.service.SpecialManagement;
import org.neu.project.utils.StringToDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.neu.project.utils.DateToString.dateToString;

//import static org.neu.project.utils.StringToDate;

/*
 * edit  22 29 87 156
 */

public class EditSpecialPanel extends BasePanelForManageSpecial {
  private String dealerId;
  private SpecialManagement specials;
  private Special specialNeedToEditOrDelete;
  public String defaultPath=System.getProperty("user.dir")+"/SpecialData/";
  
  public EditSpecialPanel(Special special, String dealerId) throws Exception {
    setDealerId(dealerId);
    specials = new SpecialManagement(defaultPath + dealerId + ".txt", dealerId);
    infoButton = new JButton("Save");
    infoButton.addActionListener(new SaveSpecialActionListener());
    ComponetInitialize(infoButton, 1, 6, 1, 5, false);
    operateButton = new JButton();
    operateButton.setText("Delete");
    operateButton.addActionListener(new DeleteActionListener());
    ComponetInitialize(operateButton, 3, 6, 1, 5, false);
    specialNeedToEditOrDelete = special;
    fillBlank(specialNeedToEditOrDelete);
  }

  private void fillBlank(Special special) {
    specialTitleInfo.setText(special.getSpecialTitle());
    valueOrPercentage.setText(special.getDicountPercentage() == null ? special.getDiscountValue() + "" : special.getDicountPercentage() + "");
    specialStartDateInfo.setText(dateToString(special.getSpecialStartDate()) + "");
    specialEndDateInfo.setText(dateToString(special.getSpecialEndDate()) + "");
    trimInfo.setText(special.getTrim());
    carYearInfo.setSelectedItem(special.getCarYear());
    carMakeInfo.setSelectedItem(special.getCarMake());
    carModelInfo.setSelectedItem(special.getCarModel());
    carMinPriceInfo.setText(special.getCarMinPrice() + "");
    carMaxPriceInfo.setText(special.getCarMaxPrice() + "");
  }


//  private void readFromFile() throws Exception {
//    String input = "C://Users//qiqi//IdeaProjects//NEU_Final_Project//src//" + dealerId + ".rtf";
//    BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
//    while (true) {
//      try {
//        String line = reader.readLine();
//        String[] arr = line.split("\\|");
//        if (Integer.parseInt(arr[0]) == specialId) {
//          Special newSpecial = StringToSpecial.toSpecial(line);
//          fillBlank(newSpecial);
//          break;
//        }
//      } catch (IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//
//    }
//  }

  public String getDealerId() {
    return dealerId;
  }

  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }

  //delete
  class DeleteActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
      specials.getList().remove(findIndex(specialNeedToEditOrDelete));
      JOptionPane.showMessageDialog(EditSpecialPanel.this, "Delete successfully");
      try {
        WriteSpecialToFile.addToFile(specials.getList(), defaultPath + getDealerId() + ".txt");
        new ViewSpecialsUI(getDealerId());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  //edit
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
        	if (StringToDate.stringToDate(specialEndDateInfo.getText()).before(StringToDate.stringToDate(specialStartDateInfo.getText()))) {
        		JOptionPane.showMessageDialog(null, "End date could not be late than start date", "Date error", JOptionPane.ERROR_MESSAGE);
        		return;
        	} 
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
        newSpecial.setSpecialID(specialNeedToEditOrDelete.getSpecialID());
        newSpecial.setDealerWebID(getDealerId());
        specials.getList().set(findIndex(specialNeedToEditOrDelete), newSpecial);
        WriteSpecialToFile.addToFile(specials.getList(), defaultPath + getDealerId() + ".txt");
        JOptionPane.showMessageDialog(null, "Save successfully!", "Conformation Dialog",
          JOptionPane.INFORMATION_MESSAGE);
        new ViewSpecialsUI(getDealerId());
      } catch (Exception ex) {
        System.out.println("Invalid date input");
      }
    }
  }
  private int findIndex(Special special){
	  int index=Integer.MIN_VALUE;
	  for(int i=0;i< specials.getList().size();i++){
	  if(specials.getList().get(i).getSpecialID().equals(special.getSpecialID())){
		  index=i;break;
	  }
	  } 
	  return index;
  }
}
