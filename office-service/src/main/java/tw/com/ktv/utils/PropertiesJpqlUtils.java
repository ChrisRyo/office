package tw.com.ktv.utils;

import java.text.MessageFormat;

import tw.com.ktv.model.sys.SysData;

public class PropertiesJpqlUtils {

  /**
   * 
   * @param val
   * @return
   */
  public static String getJpql(String title) {
    return SysData.propJpql.getProperty(title);
  }

  /**
   * 
   * @param val
   * @return
   */
  public static String getSql(String title, Object... val) {
    String sql = SysData.propJpql.getProperty(title);
    return MessageFormat.format(sql, val);
  }

}
