package tw.com.ktv.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import tw.com.ktv.enums.DateStyle;

/**
 * 
 * @author chrisryo
 *
 */
public class DateUtils {

  /**
   * dateFormat
   * 
   * @param date
   * @param style
   * @return
   * @throws Exception
   */
  public static String dateFormat(Date date, DateStyle style) {
    if (date == null) {
      return "";
    }
    return new SimpleDateFormat(style.getFormat()).format(date);
  }

}
