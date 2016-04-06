package tw.com.ktv.model.dto;

import java.util.List;

import lombok.Data;

/**
 * bootstrap-treeview
 * 
 * @author chrisryo
 *
 */
@Data
public class Tree {
  
  private Integer id;
  
  /** 列表樹節點上的文本，通常是節點右邊的小圖標 */
  private String text;
  
  /** 列表樹節點上的圖標，通常是節點左邊的圖標。 */
  private String icon;
  
  /** 當某個節點被選擇後顯示的圖標，通常是節點左邊的圖標。 */
  private String selectedIcon;
  
  /** 結合全局enableLinks選項為列表樹節點指定URL。 */
  private String href;
  
  /** Default: true  指定列表樹的節點是否可選擇。設置為false將使節點展開，並且不能被選擇。 */
  private Boolean selectable;
  
  /** 一個節點的初始狀態。 */
  private State State;
  
  /** 節點的前景色，覆蓋全局的前景色選項。 */
  private String color;
  
  /** 節點的背景色，覆蓋全局的背景色選項。 */
  private String backColor;
  
  /** 通過結合全局showTags選項來在列表樹節點的右邊添加額外的信息。 */
  private String[] tags;
  
  /** 子節點 */
  private List<Tree> nodes;
  
  @Data
  private class State {
    /** 指示一個節點是否處於checked狀態，用一個checkbox圖標表示。 */
    private Boolean checked;
    /** 指示一個節點是否處於disabled狀態。 */
    private Boolean disabled;
    /** 指示一個節點是否處於展開狀態。 */
    private Boolean expanded;
    /** 指示一個節點是否可以被選擇。 */
    private Boolean selected;
  }

}
