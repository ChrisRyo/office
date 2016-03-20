package tw.com.ktv.logic.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertiesUtils {

//  private final static Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);

  /**
   * 
   * @param val
   * @return
   */
  public static String getSql(String title, Object... val) {
    String sql = "";
    try {
      Properties prop = new Properties();
      InputStream fis = PropertiesUtils.class.getResourceAsStream("/jpql.properties");
      prop.load(fis);
      sql = prop.getProperty(title);
    } catch (IOException e) {
//      LOGGER.error(e.getMessage());
    }

    return MessageFormat.format(sql, val);
  }

}
