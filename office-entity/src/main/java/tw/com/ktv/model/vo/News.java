package tw.com.ktv.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import tw.com.ktv.util.UserUtils;


/**
 * The persistent class for the news database table.
 * 
 */
@Data
@Entity
@Table(name = "news")
@NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
public class News implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer seq;

  private String contents;

  private Integer status;

  private String title;

  private Integer type;

  @Column(name = "creat_time")
  private Timestamp creatTime;

  @Column(name = "creat_uid")
  private Integer creatUid;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "update_uid")
  private Integer updateUid;

  @PrePersist
  public void onCreate() {
    if (creatTime == null) {
      creatTime = new Timestamp(new Date().getTime());
    }

    if (creatUid == null) {
      creatUid = UserUtils.getUser().getUid();
    }
  }

  @PreUpdate
  public void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUid = UserUtils.getUser().getUid();
  }


}
