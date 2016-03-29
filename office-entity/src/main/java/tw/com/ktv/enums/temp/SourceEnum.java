package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 來源資料
 * 
 * @author chrisryo
 *
 */
public enum SourceEnum implements MenuEnum {
  八里大支出(1), 八里未付款(2), 八里店內(3), 台北大支出(4), 台北未付款(5), 台北店內(6), 台北損益_總(6), 倉庫(6), 調貨(7);

  private final int value;

  private SourceEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

}
