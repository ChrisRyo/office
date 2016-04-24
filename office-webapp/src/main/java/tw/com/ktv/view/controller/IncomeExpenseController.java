package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.view.bean.MemberBean;
import tw.com.ktv.view.message.ReturnMessage;

/**
 * 收支表作業
 * @author chrisryo
 *
 */
@Path("/incomeExpense")
public class IncomeExpenseController extends BaseController {
  @GET
  public Viewable init() throws Exception {
    return new Viewable("/incomeExpense/incomeExpense_init", super.getModelAndView());
  }
  
  @GET
  @Path("/queryMain")
  public ReturnMessage getMainList(@BeanParam MemberBean bean) throws Exception {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    Map<String, Object> m = new HashMap<String, Object>();
    m.put("accountDate", "2016-03-01");
    m.put("accountType", "1");
    m.put("accountStroe", "1");
    m.put("incomeAmt", "9999");
    m.put("expenseAmt", "4444");
    
    list.add(m);
    
    Map<String, Object> m2 = new HashMap<String, Object>();
    m2.put("accountDate", "2016-03-01");
    m2.put("accountType", "2");
    m2.put("accountStroe", "2");
    m2.put("incomeAmt", "8888");
    m2.put("expenseAmt", "8899");
    
    list.add(m2);
    
    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, 2);
  }
  
  @GET
  @Path("/queryIncome")
  public ReturnMessage getIncomeList(@BeanParam MemberBean bean) throws Exception {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    for (int i = 0 ; i < 10 ; i++) {
      Map<String, Object> m = new HashMap<String, Object>();
      m.put("seq", "444222333000" + i );
      m.put("accountDate", "2016-03-01");
      m.put("accountStroe", String.valueOf(i % 3));
      m.put("realStroe", i + 1);
      m.put("realPenson", 1);
      m.put("invoiceDatetime", "2016-02-28 0" + i + ":30:00");
      m.put("paymentDatetime", i % 3 == 0 ? "" : "2016-03-01 0" + i + ":20:00");
      m.put("payeeUnit", String.valueOf(i % 3));
      m.put("payee", String.valueOf(i % 3));
      m.put("accountsIteam", "1.2.1.2");
      m.put("accountsDetail", "產品");
      m.put("price", "20");
      m.put("quantity", "2");
      m.put("unit", "個");
      m.put("amt", "40");
      m.put("chkStatus", "0");
      m.put("mark", "");
      m.put("filePath", "");
      m.put("creatTime", "");
      m.put("creatUid", "");
      m.put("updateTime", "");
      m.put("updateUid", "");
      list.add(m);
    }

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, 9);
  }
  
  @GET
  @Path("/queryExpense")
  public ReturnMessage getExpensesList(@BeanParam MemberBean bean) throws Exception {

    List<Member> list = new ArrayList<Member>();
    
    for (int i = 0 ; i < 10 ; i++) {
      Member m = new Member();
      m.setUserName("user" + i);
      m.setName("測試" + i);
      m.setEmail("test"+i+"@gmail.com");
      m.setPhone("091"+i+"-888-999");
      m.setAddr("測試地址測試地址"+i);
      m.setStatus(0);
      m.setLoginTime(new Date());
      m.setLoginIp("127.0.0.1");
      list.add(m);
    }

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, 9);
  }
}
