package tw.com.ktv.enums.temp;

import tw.com.ktv.enums.select.MenuEnum;

/**
 * 店鋪資料
 * 
 * @author chrisryo
 *
 */
public enum StoreEnum implements MenuEnum {
  歌辦(1), 歌樂(2), 歌牌(3), 歌路(4), 歌美(5), 歌神(6);

  private final int value;

  private StoreEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
