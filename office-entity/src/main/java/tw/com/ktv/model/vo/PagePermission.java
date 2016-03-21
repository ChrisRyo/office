package tw.com.ktv.model.vo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

import lombok.Data;


/**
 * The persistent class for the page_permission database table.
 * 
 */
@Data
@Entity
@Table(name = "page_permission")
@NamedQuery(name = "PagePermission.findAll", query = "SELECT p FROM PagePermission p")
public class PagePermission extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private PagePermissionPK id;

  @Column(name = "detele_mark")
  private Integer deteleMark;

}
