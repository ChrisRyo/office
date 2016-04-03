package tw.com.ktv.service;

import java.util.List;

import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.dto.Tree;
import tw.com.ktv.model.vo.AccountsIteam;


public interface AccountsIteamService {

  /**
   * 取得會計科目表
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

  /**
   * 取得會計科目 樹
   * 
   * @param AccountsIteam
   * @param isLike
   * @return
   * @throws Exception
   */
  public List<Tree> getAccountsIteamTree(AccountsIteam entity, boolean isLike) throws Exception;

  // 修改帳號

  // 刪除帳號
}
