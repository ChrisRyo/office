package tw.com.ktv.view.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import tw.com.ktv.model.vo.PageMenuInfo;
import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.service.Impl.PageMenuInfoServiceImpl;
import tw.com.ktv.util.UserUtils;

public class BaseController {

  @Context
  HttpServletRequest request;

  protected HashMap<String, Object> getModelAndView() throws Exception {
   
    PageMenuInfoService service = new PageMenuInfoServiceImpl();

    List<PageMenuInfo> pageMenuInfoList = service.getPageMenuInfo(UserUtils.getUser().getUid());

    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("pathTitle", request.getContextPath());
    model.put("menuHtml", this.getPageMenuInfoHtml(pageMenuInfoList));
    
    return model;
  }
  
  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  private String getPageMenuInfoHtml(List<PageMenuInfo> list) throws Exception {
    
    String path =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();

    TreeMap<Integer, PageMenuInfo> parent = new TreeMap<Integer, PageMenuInfo>();
    TreeMap<Integer, List<PageMenuInfo>> child = new TreeMap<Integer, List<PageMenuInfo>>();

    // 分類
    for (PageMenuInfo info : list) {

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
        sb.append("<a href='"+path + childInfo.getUrl() +"'");
        sb.append("<i class='fa " + childInfo.getIcons() + "'></i>");
        sb.append(childInfo.getName());
        sb.append("</a>");
        sb.append("</li>");
      }

      sb.append("</ul></li>");
    }

    return sb.toString();
  }
}
