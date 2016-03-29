package tw.com.ktv.view.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import tw.com.ktv.util.UserUtils;

public class BaseController {

  @Context
  HttpServletRequest request;

  protected HashMap<String, Object> getModelAndView() throws Exception {

    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("pathTitle", request.getContextPath());
    model.put("menuHtml", UserUtils.getUser().getMenuHtml());

    return model;
  }
}
