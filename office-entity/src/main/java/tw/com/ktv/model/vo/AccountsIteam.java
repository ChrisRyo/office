package tw.com.ktv.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import tw.com.ktv.util.UserUtils;


/**
 * The persistent class for the accounts_iteam database table.
 * 
 */
@Data
@Entity
@Table(name = "accounts_iteam")
@NamedQuery(name = "AccountsIteam.findAll", query = "SELECT a FROM AccountsIteam a")
public class AccountsIteam implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "accounts_id")
  private Integer accountsId;

  @Column(name = "accounts_detail")
  private String accountsDetail;

  @Column(name = "accounts_name")
  private String accountsName;

  @Column(name = "accounts_parent_id")
  private Integer accountsParentId;

  @Column(name = "accounts_status")
  private Integer accountsStatus;

  @Column(name = "creat_time")
  private Timestamp creatTime;

  @Column(name = "creat_uid")
  private Integer creatUid;

  @Column(name = "profit_loss_type")
  private Integer profitLossType;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "update_uid")
  private Integer updateUid;

  @PrePersist
  public void onCreate() {
    creatTime = new Timestamp(new Date().getTime());
    creatUid = UserUtils.getUser().getUid();
  }

  @PreUpdate
  public void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUid = UserUtils.getUser().getUid();
  }
}
