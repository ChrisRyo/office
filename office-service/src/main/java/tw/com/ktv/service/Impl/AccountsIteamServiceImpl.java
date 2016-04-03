package tw.com.ktv.service.Impl;

import tw.com.ktv.dao.AccountsIteamDao;
import tw.com.ktv.dao.impl.AccountsIteamDaoImpl;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.AccountsIteam;
import tw.com.ktv.service.AccountsIteamService;

/**
 * Session Bean implementation class MemberBean
 */
public class AccountsIteamServiceImpl implements AccountsIteamService {

  private AccountsIteamDao accountsIteamDao = new AccountsIteamDaoImpl();

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
  @Override
  public Page getAccountsIteamPage(AccountsIteam entity, int pageIndex, int pageSize, boolean isLike)
      throws Exception {

    return accountsIteamDao.queryPage(entity, pageIndex, pageSize, isLike);
  }
}
