package tw.com.ktv.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the page_permission database table.
 * 
 */
@Data
@Entity
@Table(name = "page_permission")
@NamedQuery(name = "PagePermission.findAll", query = "SELECT p FROM PagePermission p")
@EqualsAndHashCode(callSuper=true)
public class PagePermission extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private PagePermissionPK id;

  @Column(name = "detele_mark")
  private Integer deteleMark;

}
