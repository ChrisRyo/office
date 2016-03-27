package tw.com.ktv.service;

import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.News;


public interface NewsService {

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
  public Page getNewsList(News news, int pageIndex, int pageSize, boolean isLike) throws Exception;

  // 新增帳號

  // 修改帳號

  // 刪除帳號
}
