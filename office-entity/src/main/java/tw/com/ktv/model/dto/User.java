package tw.com.ktv.model.dto;

import lombok.Data;
import lombok.experimental.Delegate;
import tw.com.ktv.model.vo.Member;

/**
 * 
 * @author chrisryo
 *
 */
@Data
public class User {

  public final static String USER_SESSION = "userInfo";
  
  private String menuHtml;

  @Delegate
  private Member member;

  public User() {
    this.member = new Member();
  }
}
