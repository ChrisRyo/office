package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 廠商資料
 * 
 * @author chrisryo
 *
 */
public enum CompanyEnum implements MenuEnum {
  鴻海(1), 奇美(2), 大立光(3), 水電木工(4), 好樂潔(5), 台塑(6);

  private final int value;

  private CompanyEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

}
