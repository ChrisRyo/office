package tw.com.ktv.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import tw.com.ktv.model.dto.Menu;

public class EnumUtils {


  @SuppressWarnings("rawtypes")
  public static List<Menu> getEnumList(Enum[] enums) {

    int val = -1;
    List<Menu> list = new ArrayList<Menu>();

    for (Enum e : enums) {
      Method m;
      try {
        m = e.getClass().getMethod("getIndex");
        val = (int) m.invoke(e);
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      list.add(new Menu(val, e.name()));
    }
    return list;

  }
}
