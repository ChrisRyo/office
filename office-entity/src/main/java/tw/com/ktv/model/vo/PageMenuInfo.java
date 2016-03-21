package tw.com.ktv.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the page_menu_info database table.
 * 
 */
@Data
@Entity
@Table(name = "page_menu_info")
@NamedQuery(name = "PageMenuInfo.findAll", query = "SELECT p FROM PageMenuInfo p")
public class PageMenuInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "url_id")
  private Integer urlId;

  @Column(name = "creat_time")
  private Timestamp creatTime;

  private String func;
  
  private String icons;

  private String name;

  @Column(name = "parent_id")
  private Integer parentId;

  private Integer status;

  @Column(name = "update_time")
  private Timestamp updateTime;

  private String url;

}
