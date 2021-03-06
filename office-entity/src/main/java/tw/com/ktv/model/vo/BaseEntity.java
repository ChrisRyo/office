package tw.com.ktv.model.vo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import tw.com.ktv.util.UserUtils;

/**
 * The persistent class for the expenses database table.
 * 
 */
@Data
public abstract class BaseEntity {

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
