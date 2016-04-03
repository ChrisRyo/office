package tw.com.ktv.service.Impl;

import tw.com.ktv.dao.NewsDao;
import tw.com.ktv.dao.impl.NewsDaoImpl;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.News;
import tw.com.ktv.service.NewsService;

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
  public Page getNewsList(News entity, int pageIndex, int pageSize, boolean isLike) throws Exception {
    return newsDao.queryPage(entity, pageIndex, pageSize, isLike);
  }
}
