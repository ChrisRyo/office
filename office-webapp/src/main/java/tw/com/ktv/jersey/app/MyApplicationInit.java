package tw.com.ktv.jersey.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tw.com.ktv.model.sys.SysData;
import tw.com.ktv.utils.PropertiesJpqlUtils;

public class MyApplicationInit {

  public MyApplicationInit() {
    this.setPropJpql();
  }

  /**
   * jpql
   */
  private void setPropJpql() {
    SysData.propJpql = new Properties();

    InputStream fis = PropertiesJpqlUtils.class.getResourceAsStream("/jpql.properties");
    try {
      SysData.propJpql.load(fis);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
