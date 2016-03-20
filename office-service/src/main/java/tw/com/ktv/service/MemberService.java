package tw.com.ktv.service;

import tw.com.ktv.model.vo.Member;


public interface MemberService {

  /**
   * 檢查帳號密碼
   * @param username
   * @param pwd
   * @return
   * @throws Exception 
   */
  public Member chkLogin(String userName, String pwd) throws Exception;

  // 新增帳號

  // 修改帳號

  // 刪除帳號
}
