package tw.com.ktv.service.Impl;

import java.util.List;

import tw.com.ktv.dao.NewsDao;
import tw.com.ktv.dao.impl.NewsDaoImpl;
import tw.com.ktv.memcached.MemcachedKey;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.News;
import tw.com.ktv.service.NewsService;
import tw.com.ktv.util.DataUtils;

/**
 * Session Bean implementation class MemberBean
 */
public class NewsServiceImpl implements NewsService {

  private final static MemcachedKey newsFilterKey = MemcachedKey.NEWS_FILLTER;
  private final static MemcachedKey newsInfoKey = MemcachedKey.NEWS_INFO;

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
    List<News> list = newsDao.queryByEntity(news, newsFilterKey, newsInfoKey, true);
    
    return new Page(list.size(), DataUtils.subList(list, pageIndex, pageSize));
  }
}
