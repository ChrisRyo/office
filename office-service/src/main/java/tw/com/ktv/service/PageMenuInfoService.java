package tw.com.ktv.service;

public interface PageMenuInfoService {

  /**
   * 取得用戶選單
   * 
   * @param uid
   * @param path
   * @return
   * @throws Exception
   */
  public String getPageMenuInfoHtml(Integer uid, String path) throws Exception;
}
