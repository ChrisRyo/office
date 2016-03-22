package tw.com.ktv.service.Impl;

import java.util.List;

import tw.com.ktv.dao.MemberDao;
import tw.com.ktv.dao.impl.MemberDaoImpl;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.service.MemberService;

/**
 * Session Bean implementation class MemberBean
 */
public class MemberServiceImpl implements MemberService {

  private MemberDao memberDao = new MemberDaoImpl();

  /**
   * 檢查帳號密碼
   * 
   * @param username
   * @param pwd
   * @return
   * @throws Exception
   */
  @Override
  public Member chkLogin(String userName, String pwd) throws Exception {

    Member entity = new Member();
    entity.setUserName(userName);
    entity.setPwd(pwd);
    @SuppressWarnings("unchecked")
    List<Member> list = (List<Member>) memberDao.queryByEntity(entity, false);

    return list == null ? null : list.get(0);
  }

  /**
   * 取得用戶資料
   * 
   * @param member
   * @param isLike
   * @param index
   * @param size
   * @return
   * @throws Exception
   */
  @Override
  public List<Member> getMemberList(Member member, boolean isLike, Integer index, Integer size)
      throws Exception {
    @SuppressWarnings("unchecked")
    List<Member> list = (List<Member>) memberDao.queryByEntity(member, isLike, index, size);
    return list;
  }
}
