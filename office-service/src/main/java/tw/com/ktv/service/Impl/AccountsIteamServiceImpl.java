package tw.com.ktv.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import tw.com.ktv.dao.AccountsIteamDao;
import tw.com.ktv.dao.impl.AccountsIteamDaoImpl;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.dto.Tree;
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

  /**
   * 取得會計科目 樹
   * 
   * @param AccountsIteam
   * @param isLike
   * @return
   * @throws Exception
   */
  @Override
  public List<Tree> getAccountsIteamTree(AccountsIteam entity, boolean isLike) throws Exception {
    List<AccountsIteam> list = accountsIteamDao.queryByEntity(entity, isLike);

    // 分類
    TreeMap<Integer, List<AccountsIteam>> map = new TreeMap<Integer, List<AccountsIteam>>();

    for (AccountsIteam vo : list) {
      int parentId = vo.getAccountsParentId();
      if (!map.containsKey(parentId)) {
        map.put(parentId, new ArrayList<AccountsIteam>());
      }

      map.get(parentId).add(vo);
    }

    List<Tree> treeList = new ArrayList<Tree>();
    this.getTree(treeList, map, 0);
    return treeList;
  }

  private void getTree(List<Tree> treeList, TreeMap<Integer, List<AccountsIteam>> map,
      Integer parentId) {
    List<AccountsIteam> list = map.get(parentId);

    for (AccountsIteam entity : list) {
      Tree tree = new Tree();
      tree.setId(entity.getAccountsId());
      tree.setText(entity.getAccountsId() + " " + entity.getAccountsName());
      String[] tags =
          entity.getAccountsDetail() != null ? entity.getAccountsDetail().split("、") : null;
      tree.setTags(tags);

      // 檢查有沒有子項目
      if (map.containsKey(entity.getAccountsId())) {
        tree.setNodes(new ArrayList<Tree>());
        // 遞迴
        this.getTree(tree.getNodes(), map, entity.getAccountsId());
      }

      treeList.add(tree);
    }
  }
}
