package tw.com.ktv.view.controller;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.service.Impl.PageMenuInfoServiceImpl;
import tw.com.ktv.util.UserUtils;

@Path("/index")
public class IndexController extends BaseController {

  @GET
  public Viewable init() throws Exception {

    PageMenuInfoService service = new PageMenuInfoServiceImpl();

    String menuHtml = service.getPageMenuInfoHtml(UserUtils.getUser().getUid());

    HashMap<String, Object> map = super.getModelAndView();
    map.put("menuHtml", menuHtml);

    return new Viewable("/index/index_init", map);
  }
}
