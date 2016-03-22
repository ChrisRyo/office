package tw.com.ktv.view.bean;

import javax.ws.rs.QueryParam;

import tw.com.ktv.model.dto.PageInfo;
import tw.com.ktv.model.vo.Member;

public class MemberBean extends PageInfo{

  private Member member;

  public MemberBean() {
    this.member = new Member();
  }
  
  public Member getMember() {
    return this.member;
  }

  @QueryParam("userName")
  public String getUserName() {
    return member.getUserName();
  }

  public void setUserName(String userName) {
    member.setUserName(userName);
  }

  @QueryParam("pwd")
  public String getPwd() {
    return member.getPwd();
  }

  public void setPwd(String pwd) {
    member.setPwd(pwd);
  }
  
  @QueryParam("name")
  public String getName() {
    return member.getName();
  }

  public void setName(String name) {
    member.setName(name);
  }
}
