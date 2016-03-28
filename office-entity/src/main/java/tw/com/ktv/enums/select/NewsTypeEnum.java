package tw.com.ktv.enums.select;

import tw.com.ktv.enums.MenuEnum;


/**
 * 
 * @author chrisryo
 *
 */
public enum NewsTypeEnum implements MenuEnum {
  公告(1), 活動(2);

  private final int index;

  private NewsTypeEnum(int index) {
    this.index = index;
  }

  @Override
  public int getIndex() {
    return index;
  }

}
