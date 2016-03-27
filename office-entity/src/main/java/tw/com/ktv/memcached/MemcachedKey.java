package tw.com.ktv.memcached;

public enum MemcachedKey {
  
  PAGEMENU_INFO("pagemenu_info", 3600),
  
  NEWS_INFO("news_info", 3600),
  NEWS_FILLTER("news_fillter", 3600),
  
  MEMBER_INFO("member_info", 3600),
  MEMBER_FILLTER("member_fillter", 3600);
  
  private final String keyForStore;
  private final int keepSeconds;

  MemcachedKey(String keyForStore, int keepSeconds) {
    this.keyForStore = keyForStore;
    this.keepSeconds = keepSeconds;
  }

  public String getKey() {
    return keyForStore;
  }

  public int getKeepSeconds() {
    return keepSeconds;
  }

}
