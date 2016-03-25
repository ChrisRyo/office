package tw.com.ktv.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import tw.com.ktv.dao.PageMenuInfoDao;
import tw.com.ktv.dao.impl.PageMenuInfoDaoImpl;
import tw.com.ktv.enums.JpqlTitle;
import tw.com.ktv.logic.utils.PropertiesSqlUtils;
import tw.com.ktv.memcached.Memcached;
import tw.com.ktv.memcached.MemcachedKey;
import tw.com.ktv.model.vo.PageMenuInfo;
import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.util.UserUtils;

/**
 * Session Bean implementation class MemberBean
 */
public class PageMenuInfoServiceImpl implements PageMenuInfoService {

  private final static MemcachedKey pageMenuInfoKey = MemcachedKey.PAGEMENU_INFO;

  private PageMenuInfoDao pageMenuInfoDao = new PageMenuInfoDaoImpl();

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @param path
   * @return
   * @throws Exception
   */
  public String getPageMenuInfoHtml(Integer uid, String path) throws Exception {

    String html = (String) Memcached.get(pageMenuInfoKey, uid);

    if (StringUtils.isEmpty(html)) {

      EntityManager em = pageMenuInfoDao.getEntityManager();

      Query query =
          em.createQuery(PropertiesSqlUtils.getJpql(JpqlTitle.LOGIN_PAGEPERMISSION.getTitle()))
              .setParameter(1, uid);

      List<PageMenuInfo> pageMenuInfoList = pageMenuInfoDao.queryByJpql(query);

      html = this.getPageMenuInfoHtml(path, pageMenuInfoList);

      Memcached.set(pageMenuInfoKey, uid, html);

    }

    return html;
  }

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  private String getPageMenuInfoHtml(String path, List<PageMenuInfo> pageMenuInfoList)
      throws Exception {

    if (StringUtils.isNotEmpty(UserUtils.getUser().getMenuHtml())) {
      return UserUtils.getUser().getMenuHtml();
    }

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

    return sb.toString();
  }
}
