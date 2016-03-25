package tw.com.ktv.view.bean;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.QueryParam;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.view.bean.common.PageInfo;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberBean extends PageInfo {

  @QueryParam("userName")
  private String userName;

  @QueryParam("pwd")
  private String pwd;

  @QueryParam("name")
  private String name;

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
