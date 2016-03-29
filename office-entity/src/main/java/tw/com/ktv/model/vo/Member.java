package tw.com.ktv.model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the member database table.
 * 
 */
@Data
@Entity
@Table(name = "member")
@NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")
@EqualsAndHashCode(callSuper=true)
public class Member extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer uid;

  @Column(name = "user_name")
  private String userName;
  
  private String pwd;
  
  private String name;
  
  private String email;
  
  private String phone;

  private String addr;

  private Integer status;

  @Column(name = "login_ip")
  private String loginIp;

  @Column(name = "login_time")
  private Date loginTime;
}
