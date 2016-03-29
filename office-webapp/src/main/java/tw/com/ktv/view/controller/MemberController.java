package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.service.MemberService;
import tw.com.ktv.service.Impl.MemberServiceImpl;
import tw.com.ktv.view.bean.MemberBean;
import tw.com.ktv.view.message.ReturnMessage;

@Path("/member")
public class MemberController extends BaseController {

  private MemberService memberService = new MemberServiceImpl();

  @GET
  public Viewable init() throws Exception {

    return new Viewable("/member/member_init", super.getModelAndView());
  }

  @GET
  @Path("/query")
  public ReturnMessage getMemberList(@BeanParam MemberBean bean) throws Exception {

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
