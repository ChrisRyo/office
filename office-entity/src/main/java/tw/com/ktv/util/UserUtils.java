package tw.com.ktv.util;

import tw.com.ktv.model.dto.User;

/**
 * 
 * @author chrisryo
 *
 */
public abstract class UserUtils {
  private static final ThreadLocal<User> threadUser = new ThreadLocal<User>();
  private static final ThreadLocal<Integer> threadUid = new ThreadLocal<Integer>();

  public static User getUser() {
    return threadUser.get();
  }

  public static Integer getUid() {
    return threadUid.get();
  }

  public static void setUser(User userId) {
    threadUser.set(userId);
    threadUid.set(userId.getUid());
  }

  public static void removeUser() {
    threadUser.remove();
    threadUid.remove();
  }
}
