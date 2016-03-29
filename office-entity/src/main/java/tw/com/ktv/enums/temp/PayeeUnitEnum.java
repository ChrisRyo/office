package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 單位資料
 * 
 * @author chrisryo
 *
 */
public enum PayeeUnitEnum implements MenuEnum {
  員工(1, PlayerEnum.class), 廠商(2, CompanyEnum.class), 政府單位(3, GovernmentEnum.class);

  private final int value;
  private final Class<?> enums;

  private PayeeUnitEnum(int value, Class<?> enums) {
    this.value = value;
    this.enums = enums;
  }
  
  @Override
  public int getValue() {
    return value;
  }


  public Class<?> getEnums() {
    return enums;
  }

  // /**
  // *
  // * @return
  // */
  // @SuppressWarnings("unchecked")
  // public static List<Menu> getDetailMenu(int unit, String name) {
  //
  // List<Menu> list = new ArrayList<Menu>();
  //
  // PayeeUnitEnum[] enums = PayeeUnitEnum.values();
  //
  // for (PayeeUnitEnum en : enums) {
  // if (en.getIndex() == unit) {
  // try {
  // Method method = en.getEnums().getMethod("getMenu", new Class[]{String.class});
  // list = (List<Menu>) method.invoke(en.getEnums(), name);
  // } catch (Exception e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // }
  // }
  // }
  //
  // return list;
  // }
}
