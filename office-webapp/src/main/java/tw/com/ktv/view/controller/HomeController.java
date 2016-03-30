package tw.com.ktv.view.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

/**
 * 首頁
 * @author chrisryo
 *
 */
@Path("/home")
public class HomeController extends BaseController {

  @GET
  public Viewable init() throws Exception {
    return new Viewable("/home/home_init", super.getModelAndView());
  }
}
