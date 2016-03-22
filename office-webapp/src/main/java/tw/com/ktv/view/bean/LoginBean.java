package tw.com.ktv.view.bean;

import javax.validation.constraints.NotNull;

import tw.com.ktv.constraint.Account;
import tw.com.ktv.constraint.PassWord;
import tw.com.ktv.model.vo.Member;

public class LoginBean {

  private Member member;

  public LoginBean() {
    this.member = new Member();
  }

  public Member getMember() {
    return this.member;
  }

  @NotNull
  @Account
  public String getUserName() {
    return this.member.getUserName();
  }

  public void setUserName(String userName) {
    this.member.setUserName(userName);
  }

  @NotNull
  @PassWord
  public String getPwd() {
    return this.member.getPwd();
  }

  public void setPwd(String pwd) {
    this.member.setPwd(pwd);
  }

}
