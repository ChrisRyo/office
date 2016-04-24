package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 帳目分類
 * 
 * @author chrisryo
 *
 */
public enum AccountTypeEnum implements MenuEnum {
  分店(1), 大支出(2);

  private final int value;

  private AccountTypeEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

}
