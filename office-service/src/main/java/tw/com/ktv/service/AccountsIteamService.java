package tw.com.ktv.service;

import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.AccountsIteam;


public interface AccountsIteamService {

  /**
   * 取得新聞列表
   * 
   * @param AccountsIteam
   * @param pageIndex
   * @param pageSize
   * @param isLike
   * @return
   * @throws Exception
   */
  public Page getAccountsIteamPage(AccountsIteam entity, int pageIndex, int pageSize, boolean isLike)
      throws Exception;

  // 新增帳號

  // 修改帳號

  // 刪除帳號
}
