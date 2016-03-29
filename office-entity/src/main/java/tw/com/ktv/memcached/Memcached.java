//package tw.com.ktv.memcached;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//import net.rubyeye.xmemcached.MemcachedClientBuilder;
//import net.rubyeye.xmemcached.XMemcachedClientBuilder;
//import net.rubyeye.xmemcached.exception.MemcachedException;
//import net.rubyeye.xmemcached.utils.AddrUtil;
//
///**
// * memcached
// * /usr/local/bin/memcached -d -m 2048  -u root -p 12111 -c 1024 -P /tmp/memcached.pid
// */
//public class Memcached {
//
//  private static MemcachedClient getMemcached() {
//    try {
//      MemcachedClientBuilder builder =
//          new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
//      return builder.build();
//    } catch (IOException e) {
//      //
//      return null;
//    }
//  }
//
//  @SuppressWarnings("unchecked")
//  public static <T> T get(MemcachedKey keyForStore, String subKey)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(subKey);
//    return (T) getMemcached().get(sb.toString());
//  }
//
//  @SuppressWarnings("unchecked")
//  public static <T> T get(MemcachedKey keyForStore, Integer uid)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(uid.toString());
//    return (T) getMemcached().get(sb.toString());
//  }
//
//  public static void set(MemcachedKey keyForStore, String subKey, Object storedObject)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(subKey);
//    getMemcached().set(sb.toString(), keyForStore.getKeepSeconds(), storedObject);
//  }
//
//  public static void set(MemcachedKey keyForStore, Integer uid, Object storedObject)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(uid.toString());
//    getMemcached().set(sb.toString(), keyForStore.getKeepSeconds(), storedObject);
//  }
//
//  public static void delete(MemcachedKey keyForStore, String subKey)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(subKey);
//    getMemcached().delete(sb.toString());
//  }
//  
//  public static void delete(MemcachedKey keyForStore, Integer uid)
//      throws TimeoutException, InterruptedException, MemcachedException {
//    StringBuilder sb = new StringBuilder();
//    sb.append(keyForStore.getKey());
//    sb.append(uid.toString());
//    getMemcached().delete(sb.toString());
//  }
//}
