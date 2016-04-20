package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.view.message.ReturnMessage;

/**
 * 現金流量表
 * 
 * @author chrisryo
 *
 */
@Path("/cashFlowStatement")
public class CashFlowStatementController extends BaseController {

  @GET
  public Viewable init() throws Exception {

    return new Viewable("/cashFlowStatement/cashFlowStatement_init", super.getModelAndView());
  }
  
  @GET
  @Path("/query1")
  public ReturnMessage query1() throws Exception {
    String[] val1 = {"2015-04-23"      , "2015-05-01"  , "2015-06-01"   , "2015-07-01"  , "2015-08-01"  , "2015-09-01"  , "2015-10-01"  , "2015-11-01"  , "2015-12-01"};
    String[] val2 = {"3,014,829", "3,734,895", "4,688,716" , "6,438,366", "7,266,670", "7,370,550", "7,351,307", "7,351,307", "7,351,307"};
    String[] val3 = {"1,881,565", "1,853,101", "1,847,546" , "847,547"  , "123,123"  , "0"        , "0"        , "0", "0"};
    String[] val4 = {"1,161,499", "899,280"  , "97,896"    , "19,243"   , "19,243"   , "19,243"   , "6,666"    , "0", "0"};
    String[] val5 = {"3,734,895", "4,688,716", "6,438,366" , "7,266,670", "7,370,550", "7,351,307", "7,344,641", "7,351,307", "7,351,307"};
    
    
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    for (int i = 0 ; i < val1.length ; i++) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("date", val1[i]);
      map.put("cash", val2[i]);
      map.put("income", val3[i]);
      map.put("expenses", val4[i]);
      map.put("realCash", val5[i]);
      list.add(map);
    }


    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, list.size());
  }
  
  @GET
  @Path("/query2")
  public ReturnMessage query2() throws Exception {
    String[] val1 = {"2015-05-21", "2015-05-31", "2015-06-07", "2015-07-11", "2015-08-06", "2015-08-21", "2015-09-17"};
    String[] val2 = {"2015-01-11", "2014-12-30", "2015-01-08", "2015-02-09", "2015-03-02", "2014-04-11", "2015-04-11"};
    String[] val3 = {"14,232", "14,232", "5,555", "999,999", "45,767", "678,657", "123,123"};
    String[] val4 = {"貨款收入", "個人借款", "個人借款", "餐卷期滿", "投資期滿", "個人借款", "個人借款"};
    
    
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    for (int i = 0 ; i < val1.length ; i++) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("payDate", val1[i]);
      map.put("happenDate", val2[i]);
      map.put("amt", val3[i]);
      map.put("mark", val4[i]);
      list.add(map);
    }


    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, list.size());
  }

  @GET
  @Path("/query3")
  public ReturnMessage query3() throws Exception {
    String[] val1 = {"2015-05-12", "2015-05-30", "2015-06-02", "2015-07-20", "2015-08-01", "2015-08-21", "2015-10-17"};
    String[] val2 = {"2015-04-11", "2015-03-30", "2015-04-10", "2015-04-01", "2015-01-11", "2014-12-14", "2015-01-11"};
    String[] val3 = {"56,789", "205,430", "80,1384", "78,653", "11,343", "1,234", "6,666"};
    String[] val4 = {"木工款項", "電費款項", "房租款項", "進貨款項", "投資款項", "木工款項", "木工款項"};
    
    
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    for (int i = 0 ; i < val1.length ; i++) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("payDate", val1[i]);
      map.put("happenDate", val2[i]);
      map.put("amt", val3[i]);
      map.put("mark", val4[i]);
      list.add(map);
    }


    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, list.size());
  }
}
