package tw.com.ktv.enums.highcharts;

/**
 * 
 * @author chrisryo
 *
 */
public enum ChartTypeEnum {

  /** 線性圖*/
  Line("line"),
  
  /** 柱狀圖 */
  COLUMN("column"),
  
  /** 圓餅圖 */
  PIE("pie");

  private final String value;

  private ChartTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
