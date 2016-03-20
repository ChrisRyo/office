package tw.com.ktv.view.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/index")
public class IndexController extends BaseController {

  @GET
  public Viewable init() throws Exception {

    return new Viewable("/index/index_init", super.getModelAndView());
  }
}
