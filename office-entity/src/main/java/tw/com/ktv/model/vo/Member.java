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
 * The persistent class for the member database table.
 * 
 */
@Data
@Entity
@Table(name = "member")
@NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")
public class Member extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private Integer uid;

  @Column(name = "user_name")
  private String userName;
  
  private String pwd;
  
  private String name;
  
  private String email;
  
  private String phone;

  private String addr;

  private Short status;

  @Column(name = "login_ip")
  private String loginIp;

  @Column(name = "login_time")
  private Timestamp loginTime;
}
