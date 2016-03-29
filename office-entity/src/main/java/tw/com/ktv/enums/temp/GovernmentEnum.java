package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 政府單位
 * 
 * @author chrisryo
 *
 */
public enum GovernmentEnum implements MenuEnum {
  臺北市政府(1), 新北市政府(2), 總統府(3), 府府府府府(4);

  private final int value;

  private GovernmentEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}