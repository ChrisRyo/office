package tw.com.ktv.service;

import java.util.List;

import tw.com.ktv.model.vo.PageMenuInfo;



public interface PageMenuInfoService {

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  public List<PageMenuInfo> getPageMenuInfo(Integer uid) throws Exception;
}
