package tw.com.ktv.util;

import java.util.List;

/**
 * 
 * @author chrisryo
 *
 */
public class DataUtils {

  /**
   * subList
   * @param <E>
   * 
   * @param date
   * @param pageIndex
   * @param pageSize
   * @return
   * @throws Exception
   */
  public static <E> List<E> subList(List<E> list, int pageIndex, int pageSize) {
    
    int total = list.size();
    int start = (pageIndex - 1) * pageSize;
    int end = pageIndex * pageSize;
    
    return list.subList(start, end > total ? total : end);
  }

}
