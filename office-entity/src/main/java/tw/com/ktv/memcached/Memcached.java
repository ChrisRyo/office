package tw.com.ktv.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * memcached
 */
public class Memcached {

  private static MemcachedClient getMemcached() {
    try {
      // TODO: store memcached address in server property
      return new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
    } catch (IOException e) {
      //
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T get(MemcachedKey keyForStore, String subKey) {
    StringBuilder sb = new StringBuilder();
    sb.append(keyForStore.getKey());
    sb.append(subKey);
    return (T) getMemcached().get(sb.toString());
  }

  public static void set(MemcachedKey keyForStore, String subKey, Object storedObject) {
    StringBuilder sb = new StringBuilder();
    sb.append(keyForStore.getKey());
    sb.append(subKey);
    getMemcached().set(sb.toString(), keyForStore.getKeepSeconds(), storedObject);
  }

  public static void delete(MemcachedKey keyForStore, String subKey) {
    StringBuilder sb = new StringBuilder();
    sb.append(keyForStore.getKey());
    sb.append(subKey);
    getMemcached().delete(sb.toString());
  }
}
