package tw.com.ktv.service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tw.com.ktv.dao.NewsDao;
import tw.com.ktv.dao.impl.NewsDaoImpl;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.News;
import tw.com.ktv.service.NewsService;
import tw.com.ktv.util.EntityUtils;

/**
 * Session Bean implementation class MemberBean
 */
public class NewsServiceImpl implements NewsService {

  private NewsDao newsDao = new NewsDaoImpl();

  /**
   * 取得新聞列表
   * 
   * @param news
   * @param pageIndex
   * @param pageSize
   * @param isLike
   * @return
   * @throws Exception
   */
  @Override
  public Page getNewsList(News news, int pageIndex, int pageSize, boolean isLike) throws Exception {

    EntityManager em = newsDao.getEntityManager();

    String sql = EntityUtils.getQueryEntitySql(news, isLike);

    List<News> list = newsDao.queryByJpql(em.createQuery(sql), pageIndex, pageSize);

    long count = newsDao.queryCountByJpql(em.createQuery(EntityUtils.getSqlCountSql(sql)));

    return new Page(count, list);
  }
}
