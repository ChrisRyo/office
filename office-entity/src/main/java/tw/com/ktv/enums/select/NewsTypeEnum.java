package tw.com.ktv.enums.select;



/**
 * 
 * @author chrisryo
 *
 */
public enum NewsTypeEnum implements MenuEnum {
  公告(1), 活動(2);

  private final int value;

  private NewsTypeEnum(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}
