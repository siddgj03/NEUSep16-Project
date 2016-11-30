package src.org.neu.project.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiqi on 2016/11/28.
 */
public class StringToDate {
  public static Date stringToDate(String s) throws Exception {
    if (s == null) {
      return null;
    }
    DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    try {
      Date resultDate = date.parse(s + " 00:00:00");
      return resultDate;
    } catch (Exception e) {
      System.out.println("Invalid Date Input");
      e.printStackTrace();
    }
    return null;
  }
}
