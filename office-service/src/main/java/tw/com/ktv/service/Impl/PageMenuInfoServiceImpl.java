package tw.com.ktv.service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tw.com.ktv.dao.PageMenuInfoDao;
import tw.com.ktv.dao.impl.PageMenuInfoDaoImpl;
import tw.com.ktv.enums.JpqlTitle;
import tw.com.ktv.logic.utils.PropertiesSqlUtils;
import tw.com.ktv.model.vo.PageMenuInfo;
import tw.com.ktv.service.PageMenuInfoService;

/**
 * Session Bean implementation class MemberBean
 */
public class PageMenuInfoServiceImpl implements PageMenuInfoService {

  private PageMenuInfoDao pageMenuInfoDao = new PageMenuInfoDaoImpl();

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public List<PageMenuInfo> getPageMenuInfo(Integer uid) throws Exception {

    EntityManager em = pageMenuInfoDao.getEntityManager();

    Query query =
        em.createQuery(PropertiesSqlUtils.getJpql(JpqlTitle.LOGIN_PAGEPERMISSION.getTitle()))
            .setParameter(1, uid);

    return (List<PageMenuInfo>) pageMenuInfoDao.queryByJpql(query);
  }
}
