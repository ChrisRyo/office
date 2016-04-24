package tw.com.ktv.enums.select;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import tw.com.ktv.enums.temp.AccountTypeEnum;
import tw.com.ktv.enums.temp.CompanyEnum;
import tw.com.ktv.enums.temp.GovernmentEnum;
import tw.com.ktv.enums.temp.PayeeUnitEnum;
import tw.com.ktv.enums.temp.PlayerEnum;
import tw.com.ktv.enums.temp.SourceEnum;
import tw.com.ktv.enums.temp.StoreEnum;
import tw.com.ktv.model.dto.Menu;



/**
 * 
 * @author chrisryo
 *
 */
public enum MenusEnum {
  /** 店鋪資料 */
  STROE("querystroe", StoreEnum.values()),

  /** 帳目分類 */
  ACCOUNT_TYPE("accountType", AccountTypeEnum.values()),

  /** 來源資料 */
  SOURCE("querysource", SourceEnum.values()),

  /** 單位資料 */
  PAYEE_UNIT("querypayeeunit", PayeeUnitEnum.values()),

  /** 員工資料 */
  PLAYER("queryplayer", PlayerEnum.values()),

  /** 廠商資料 */
  COMPANY("querycompany", CompanyEnum.values()),

  /** 政府單位 */
  GOVERNMENT("querygovernment", GovernmentEnum.values()),

  /** 新聞類型資料 */
  NEWS_TYPE("querynewstype", NewsTypeEnum.values());


  private final String path;

  private final Enum<?>[] enums;

  private MenusEnum(String path, Enum<?>[] enums) {
    this.path = path;
    this.enums = enums;
  }

  /**
   * 取url路徑
   * 
   * @return
   */
  public String getPath() {
    return path;
  }

  /**
   * 取下拉選單
   * 
   * @return
   */
  public List<Menu> getMenuList() {

    int val = -1;
    List<Menu> list = new ArrayList<Menu>();

    for (Enum<?> e : this.enums) {
      Method m;
      try {
        m = e.getClass().getMethod("getValue");
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
