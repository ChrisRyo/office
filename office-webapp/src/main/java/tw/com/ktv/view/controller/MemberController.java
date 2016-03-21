package tw.com.ktv.view.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/member")
public class MemberController extends BaseController {

  @GET
  public Viewable init() throws Exception {
    return new Viewable("/member/member_init", super.getModelAndView());
  }
}
