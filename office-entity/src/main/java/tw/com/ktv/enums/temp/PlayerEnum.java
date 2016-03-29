package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 員工資料
 * 
 * @author chrisryo
 *
 */
public enum PlayerEnum implements MenuEnum {
  林詩婷(1), 林誠耀(2), 林戴英(3), 林騰朵(4), 林一二(5);

  private final int value;

  private PlayerEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
