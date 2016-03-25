package tw.com.ktv.service.Impl;

import java.util.ArrayList;
import java.util.List;

import tw.com.ktv.dao.MemberDao;
import tw.com.ktv.dao.impl.MemberDaoImpl;
import tw.com.ktv.memcached.Memcached;
import tw.com.ktv.memcached.MemcachedKey;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.service.MemberService;
import tw.com.ktv.util.UserUtils;

/**
 * Session Bean implementation class MemberBean
 */
public class MemberServiceImpl implements MemberService {

  private final static MemcachedKey memberFilterKey = MemcachedKey.MEMBER_FILLTER;
  private final static MemcachedKey memberInfoKey = MemcachedKey.MEMBER_INFO;

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
    
    List<Member> list = memberDao.queryByEntity(entity, false);

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
  public List<Member> getMemberList(Member member, boolean isLike) throws Exception {


    Integer uid = UserUtils.getUid();

    List<Member> memberList = new ArrayList<Member>();

    Member chkMember = Memcached.get(memberFilterKey, uid);

    if (chkMember != null && member.equals(chkMember)) {
      memberList = Memcached.get(memberInfoKey, uid);
    } else {
      memberList = memberDao.queryByEntity(member, isLike);
      Memcached.set(memberFilterKey, uid, member);
      Memcached.set(memberInfoKey, uid, memberList);
    }
    return memberList;
  }
}
