package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.logic.exception.code.ValidCode;
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
  @Produces(MediaType.APPLICATION_JSON)
  public ReturnMessage getMemberList(@BeanParam MemberBean bean) throws Exception {

    List<Member> list =
        memberService
            .getMemberList(bean.getMember(), true, bean.getPageIndex(), bean.getPageSize());

    int count = memberService.queryCountBySql(bean.getMember(), true);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), list, count);
  }
}
