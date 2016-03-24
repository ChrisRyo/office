package tw.com.ktv.memcached;

public enum MemcachedKey {
  MEMBER_INFO("member", 0);

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
