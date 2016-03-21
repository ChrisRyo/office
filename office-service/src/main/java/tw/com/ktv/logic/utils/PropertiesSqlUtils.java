package tw.com.ktv.logic.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertiesSqlUtils {

  // private final static Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);

  public static Properties prop = new Properties();

  public PropertiesSqlUtils() throws IOException {
    InputStream fis = PropertiesSqlUtils.class.getResourceAsStream("/jpql.properties");
    prop.load(fis);
  }

  /**
   * 
   * @param val
   * @return
   */
  public static String getJpql(String title) {
    return prop.getProperty(title);
  }

  /**
   * 
   * @param val
   * @return
   */
  public static String getSql(String title, Object... val) {
    String sql = prop.getProperty(title);
    return MessageFormat.format(sql, val);
  }

}
