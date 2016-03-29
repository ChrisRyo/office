package tw.com.ktv.view.bean;

import java.lang.reflect.InvocationTargetException;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

import lombok.Data;

import org.apache.commons.beanutils.BeanUtils;

import tw.com.ktv.constraint.Account;
import tw.com.ktv.constraint.PassWord;
import tw.com.ktv.model.vo.Member;

@Data
public class LoginBean {
  
  @NotNull
  @Account
  @QueryParam("userName")
  private String userName;

  @NotNull
  @PassWord
  @QueryParam("pwd")
  private String pwd;

  public Member getMember() {
    Member member = new Member();

    try {
      BeanUtils.copyProperties(member, this);
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return member;
  }
}
