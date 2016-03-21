package tw.com.ktv.service;



public interface PageMenuInfoService {

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  public String getPageMenuInfoHtml(Integer uid) throws Exception;
}
