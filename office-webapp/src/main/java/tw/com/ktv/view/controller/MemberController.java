package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.model.vo.Member;

@Path("/member")
public class MemberController extends BaseController {

  @GET
  public Viewable init() throws Exception {
    
    return new Viewable("/member/member_init", super.getModelAndView());
  }
  
  @GET
  @Path("/query")
  public List<Member> getMemberList () {
    return null;
  }
}
