package tw.com.ktv.view.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.service.Impl.PageMenuInfoServiceImpl;
import tw.com.ktv.util.UserUtils;

public class BaseController {

  @Context
  HttpServletRequest request;

  private PageMenuInfoService pageMenuInfoService = new PageMenuInfoServiceImpl();

  protected HashMap<String, Object> getModelAndView() throws Exception {

    String path = request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + request.getContextPath();

    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("pathTitle", request.getContextPath());
    model.put("menuHtml",
        pageMenuInfoService.getPageMenuInfoHtml(UserUtils.getUser().getUid(), path));

    return model;
  }
}
