package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.commons.lang.StringUtils;

import tw.com.ktv.model.dto.User;
import tw.com.ktv.model.vo.PageMenuInfo;
import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.service.Impl.PageMenuInfoServiceImpl;
import tw.com.ktv.util.UserUtils;

public class BaseController {

  @Context
  HttpServletRequest request;

  protected HashMap<String, Object> getModelAndView() throws Exception {

    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("pathTitle", request.getContextPath());
    model.put("menuHtml", this.getPageMenuInfoHtml());

    return model;
  }

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  protected String getPageMenuInfoHtml() throws Exception {

    if (StringUtils.isNotEmpty(UserUtils.getUser().getMenuHtml())) {
      return UserUtils.getUser().getMenuHtml();
    }

    PageMenuInfoService service = new PageMenuInfoServiceImpl();

    List<PageMenuInfo> pageMenuInfoList = service.getPageMenuInfo(UserUtils.getUser().getUid());

    String path = request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + request.getContextPath();

    TreeMap<Integer, PageMenuInfo> parent = new TreeMap<Integer, PageMenuInfo>();
    TreeMap<Integer, List<PageMenuInfo>> child = new TreeMap<Integer, List<PageMenuInfo>>();

    // 分類
    for (PageMenuInfo info : pageMenuInfoList) {

      int parentId = info.getParentId();
      int urlId = info.getUrlId();

      if (parentId == 0) {
        parent.put(urlId, info);
      } else {
        if (!child.containsKey(parentId)) {
          child.put(parentId, new ArrayList<PageMenuInfo>());
        }
        child.get(parentId).add(info);
      }
    }

    // add html
    StringBuffer sb = new StringBuffer();
    sb.append("<li class='active'>");
    sb.append("<a href='" + path + "/index'");
    sb.append("<i class='fa fa-home'></i>");
    sb.append("<span>   首頁</span>");
    sb.append("</a></li>");
    
    for (Integer key : parent.keySet()) {
      PageMenuInfo parentinfo = parent.get(key);

      sb.append("<li class='treeview'>");
      sb.append("<a href='#'>");
      sb.append("<i class='fa " + parentinfo.getIcons() + "'></i>");
      sb.append("<span>");
      sb.append(parentinfo.getName());
      sb.append("</span>");
      sb.append("<i class='fa fa-angle-left pull-right'></i></a>");

      List<PageMenuInfo> childList = child.get(key);
      sb.append("<ul class='treeview-menu' style='display: none;'>");

      for (PageMenuInfo childInfo : childList) {
        sb.append("<li>");
        sb.append("<a href='" + path + childInfo.getUrl() + "'");
        sb.append("<i class='fa " + childInfo.getIcons() + "'></i>");
        sb.append(childInfo.getName());
        sb.append("</a>");
        sb.append("</li>");
      }

      sb.append("</ul></li>");
    }
    
    String menuHtml = sb.toString();
    
    // 回寫
    User user = UserUtils.getUser();
    user.setMenuHtml(menuHtml);
    request.getSession().setAttribute(User.USER_SESSION, user);

    return menuHtml;
  }
}
