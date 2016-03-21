package tw.com.ktv.enums;

/**
 * 
 * @author chrisryo
 *
 */
public enum JpqlTitle {
  LOGIN_PAGEPERMISSION("Login.pagePermission");

  private final String title;

  private JpqlTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

}
