package src.org.neu.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiqi on 2016/11/28.
 */
public class DateToString {
  public static String dateToString(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String dateString = sdf.format(date);
    return dateString;
  }
}
