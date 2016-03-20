package tw.com.ktv.util;

import tw.com.ktv.model.dto.User;

/**
 * 
 * @author chrisryo
 *
 */
public abstract class UserUtils {
  private static final ThreadLocal<User> threadUser = new ThreadLocal<User>();

  public static User getUser() {
    return threadUser.get();
  }

  public static void setUser(User userId) {
    threadUser.set(userId);
  }

  public static void removeUser() {
    threadUser.remove();
  }
}
