package tw.com.ktv.service;

import java.util.List;

import tw.com.ktv.model.vo.Member;


public interface MemberService {

  /**
   * 檢查帳號密碼
   * 
   * @param username
   * @param pwd
   * @return
   * @throws Exception
   */
  public Member chkLogin(String userName, String pwd) throws Exception;

  /**
   * 取得用戶資料
   * 
   * @param member
   * @param isLike
   * @return
   * @throws Exception
   */
  public List<Member> getMemberList(Member member, boolean isLike) throws Exception;

  // 新增帳號

  // 修改帳號

  // 刪除帳號
}
