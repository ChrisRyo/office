package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.enums.highcharts.ChartTypeEnum;
import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.dto.Highcharts;
import tw.com.ktv.model.dto.Highcharts.Chart;
import tw.com.ktv.model.dto.Highcharts.Legend;
import tw.com.ktv.model.dto.Highcharts.Series;
import tw.com.ktv.model.dto.Highcharts.SeriesData;
import tw.com.ktv.model.dto.Highcharts.Subtitle;
import tw.com.ktv.model.dto.Highcharts.Title;
import tw.com.ktv.model.dto.Highcharts.Tooltip;
import tw.com.ktv.model.dto.Highcharts.XAxis;
import tw.com.ktv.view.message.ReturnMessage;

/**
 * 現金流量表
 * 
 * @author chrisryo
 *
 */
@Path("/cashFlowStatement")
public class CashFlowStatementController extends BaseController {

  private String[] stroes = {"歌美", "歌神", "歌詠", "歌嘟", "96", "音譜", "歌樂", "光明", "真好唱", "歌牌", "歌路",
      "圓通", "不見不散", "歌堡", "歌舞", "忘憂軒", "巴黎灣"};

  String[] profitLossNames = {"收入", "支出", "淨利"};

  private Integer[][] val1 = {
      {145861, 69668, 192109, 202300, 172925, 38946, 57109, 158655, 54403, 46088, 253533, 66200,
          1695, 242911, 36005, 0, 282751},
      {45231, 9999, 12109, 82300, 42925, 8946, 17109, 58655, 4403, 76088, 53533, 6200, 695, 42911,
          6005, 0, 82751},
      {10000, 50000, 423435, 235325, 35235, 23523, 235235, 325235, 23523, 12123, 65568, 35235,
          235235, 23423, 343, 0, 132523}};


  private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
      "Nov", "Dec"};

  private Integer[][] val2 = {
      {1000, 2000, 3000, 4000, 5000, 4000, 3000, 6000, 1000, 7000, 3000, 2000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {5000, 3000, 4000, 5000, 6000, 5000, 4000, 7000, 2000, 8000, 4000, 3000},
      {21000, 21000, 13000, 14000, 15000, 14000, 13000, 16500, 17000, 17000, 11000, 9000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},
      {11000, 21000, 13000, 14000, 15000, 14000, 13000, 16000, 11000, 17000, 31000, 21000},};



  @GET
  public Viewable init() throws Exception {

    return new Viewable("/cashFlowStatement/cashFlowStatement_init", super.getModelAndView());
  }

  @GET
  @Path("/query")
  public ReturnMessage query() throws Exception {
    Integer[] total = new Integer[val1.length];
    int index = 0;

    for (Integer[] vals : val1) {
      int totals = 0;
      for (Integer val : vals) {
        totals += val;
      }
      total[index++] = totals;
    }

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    for (int i = 0; i < stroes.length; i++) {
      Map<String, Object> map = new HashMap<String, Object>();

      int val11 = val1[0][i];
      int val12 = val1[1][i];
      int val13 = val1[2][i];
      long val11Percen = val11 * 100 / total[0];
      long val12Percen = val12 * 100 / total[1];
      long val13Percen = val13 * 100 / total[2];

      map.put("stroe", stroes[i]);
      map.put("profit", val11);
      map.put("profitPercen", val11Percen + "%");
      map.put("loss", val12);
      map.put("lossPercen", val12Percen + "%");
      map.put("real", val13);
      map.put("realPercen", val13Percen + "%");
      list.add(map);
    }

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, list.size());
  }

  @GET
  @Path("/queryColumn")
  public ReturnMessage queryColumn() throws Exception {

    Highcharts charts = new Highcharts();

    Chart chart = new Chart();
    chart.setType(ChartTypeEnum.COLUMN.getValue());

    Title title = new Title();
    title.setText("各店損益柱形圖");

    Subtitle subtitle = new Subtitle();
    subtitle.setText("105年");

    XAxis xAxis = new XAxis();
    xAxis.setCategories(stroes);

    Series[] seriess = new Series[profitLossNames.length];

    for (int i = 0; i < profitLossNames.length; i++) {
      Series series = new Series();
      series.setName(profitLossNames[i]);
      series.setData(val1[i]);

      seriess[i] = series;
    }

    // data set
    charts.setChart(chart);
    charts.setTitle(title);
    charts.setSubtitle(subtitle);
    charts.setXAxis(xAxis);
    charts.setSeries(seriess);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), charts);
  }

  @GET
  @Path("/queryPie")
  public ReturnMessage queryPie() throws Exception {

    String[][] center = { {"17%", "33%"}, {"50%", "33%"}, {"83%", "33%"}};

    Highcharts charts = new Highcharts();

    Chart chart = new Chart();
    chart.setType(ChartTypeEnum.PIE.getValue());

    Title title = new Title();
    title.setText("各店損益比例");

    Tooltip tooltip = new Tooltip();
    tooltip.setPointFormat("{series.name}: <b>{point.percentage:.1f}%</b>");

    Subtitle subtitle = new Subtitle();
    subtitle.setText("105年");

    Series[] seriess = new Series[profitLossNames.length];

    for (int y = 0; y < profitLossNames.length; y++) {

      Series series = new Series();
      series.setName(profitLossNames[y]);
      series.setCenter(center[y]);

      SeriesData[] seriesDatas = new SeriesData[stroes.length];
      for (int x = 0; x < stroes.length; x++) {
        SeriesData seriesData = new SeriesData();
        seriesData.setName(stroes[x]);
        seriesData.setY(val1[y][x]);
        seriesDatas[x] = seriesData;
      }
      series.setData(seriesDatas);
      seriess[y] = series;

    }

    // data set
    charts.setChart(chart);
    charts.setTitle(title);
    charts.setTooltip(tooltip);
    charts.setSubtitle(subtitle);
    charts.setSeries(seriess);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), charts);
  }

  @GET
  @Path("/queryLine")
  public ReturnMessage queryLine() throws Exception {

    Highcharts charts = new Highcharts();

    Chart chart = new Chart();
    chart.setType(ChartTypeEnum.Line.getValue());

    Title title = new Title();
    title.setText("105年度-月損益表");

    Legend legend = new Legend();
    legend.setLayout("vertical");
    legend.setAlign("right");

    XAxis xAxis = new XAxis();
    xAxis.setCategories(months);

    Series[] seriess = new Series[stroes.length];

    for (int i = 0; i < stroes.length; i++) {
      Series series = new Series();
      series.setName(stroes[i]);
      series.setData(val2[i]);

      seriess[i] = series;
    }

    // data set
    charts.setChart(chart);
    charts.setTitle(title);
    charts.setLegend(legend);
    charts.setXAxis(xAxis);
    charts.setSeries(seriess);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), charts);
  }
}
