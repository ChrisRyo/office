package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 來源資料
 * 
 * @author chrisryo
 *
 */
public enum SourceEnum implements MenuEnum {
  八里大支出(1), 台北大支出(4);

  private final int value;

  private SourceEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

}
