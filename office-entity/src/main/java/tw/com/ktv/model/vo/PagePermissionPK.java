package tw.com.ktv.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the page_permission database table.
 * 
 */
@Data
@Embeddable
public class PagePermissionPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  private Integer uid;

  @Column(name = "url_id")
  private Integer urlId;
}
