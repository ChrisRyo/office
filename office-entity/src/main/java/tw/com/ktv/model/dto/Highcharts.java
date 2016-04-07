package tw.com.ktv.model.dto;

import lombok.Data;

/**
 * Jquery Highcharts
 * 
 * @author chrisryo
 *
 */
@Data
public class Highcharts {

  /** 基本設定 */
  private Chart chart;

  /** 標題 */
  private Title title;

  /** 副標題 */
  private Subtitle subtitle;

  /** 提示信息 */
  private Tooltip tooltip;

  /** 版權信息 (預設填入) */
  private Credits credits = new Credits();

  /** x軸內容 */
  private XAxis xAxis;

  /** y軸內容 */
  private YAxis yAxis;

  /** 圖例選項 */
  private Legend legend;

  /** 數據 */
  private Series[] series;

  // json.plotOptions = plotOptions;
  // json.credits = credits;

  /** 基本設定物件 */
  @Data
  public static class Chart {
    private String type;
  }

  /** 標題物件 */
  @Data
  public static class Title {
    private String text;
  }

  /** 副題物件 */
  @Data
  public static class Subtitle {
    private String text;
  }

  /** 提示信息物件 */
  @Data
  public static class Tooltip {
    private String valueSuffix;
    private String pointFormat;
  }

  /** 版權信息 */
  @Data
  public static class Credits {
    /** 是否允許顯示版權信息 */
    private Boolean enabled = false;
    /** 版權所有的鏈接 */
    private String href;
    /** 版權信息顯示文字 */
    private String text;
  }

  /** X軸物件 */
  @Data
  public static class XAxis {
    private String[] categories;
  }

  /** Y軸物件 */
  @Data
  public static class YAxis {
    private Title title;

    private PlotLines[] plotLines;
  }

  /** 圖例選項物件 */
  @Data
  public static class Legend {
    /** 是否顯示圖例 (true) */
    private Boolean enabled;
    /** 顯示形式，支持水平horizontal和垂直vertical (horizontal) */
    private String layout;
    /** 對齊方式 (center) */
    private String align;
    /** 圖例背景色 */
    private String backgroundColor;
    /** 圖例邊框顏色 (#909090) */
    private String borderColor;
    /** 圖例邊框角度 (5) */
    private Integer borderRadius;
    /** 是否可以浮動，配合x，y屬性 (false) */
    private Boolean floating;
    /** 是否顯示陰影 (false) */
    private Boolean shadow;
    /** 設置圖例內容樣式 */
    private String style;

    // private String verticalAlign;
  }

  /** 數據物件 */
  @Data
  public static class Series {
    /** 數據列類型，支持 area, areaspline, bar, column, line, pie, scatter or spline */
    private String type;
    /** 顯示數據列的名稱。 */
    private String name;
    /**
     * 顯示在圖表中的數據列，Integer[] or SeriesData[]
     */
    private Object[] data;
  }
  
  /** 數據資料物件 */
  @Data
  public static class SeriesData {
    private String name;
    private Integer y;
    private Boolean sliced;
    private Boolean selected;
  }
  
  /**
   * 
   */
  @Data
  public static class PlotLines {
    private Integer value;
    private Integer width;
    private String color;
  }

}
