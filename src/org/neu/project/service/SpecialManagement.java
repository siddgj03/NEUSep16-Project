package org.neu.project.service;

import org.neu.project.dao.StringToSpecial;
import org.neu.project.dto.Special;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by qiqi on 2016/11/15.
 */
public class SpecialManagement {
  public ArrayList<Special> specialList = new ArrayList<>();
  private String dealerId;

  public SpecialManagement(String inputFile, String dealId) {
    setDealerId(dealId);
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(new File(inputFile)));
      while (true) {
        String line = reader.readLine();
        System.out.println(line);
        if (line == null || line.equals("")) break;
        specialList.add(StringToSpecial.toSpecial(line));
        System.out.println(specialList.size());
      }
      reader.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public SpecialManagement() {

  }

  public ArrayList<Special> getList() {
    return specialList;
  }

  public void addSpeical(Special special) {
//    special.setSpecialID(specialList.size() + 1);
    specialList.add(special);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Special s : specialList) {
      sb.append(s + "\n");
    }
    return sb.toString();
  }

  public String getDealerId() {
    return dealerId;
  }

  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }

}