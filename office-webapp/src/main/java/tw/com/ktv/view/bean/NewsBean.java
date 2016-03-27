package tw.com.ktv.view.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.ws.rs.QueryParam;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.beanutils.BeanUtils;

import tw.com.ktv.model.vo.News;
import tw.com.ktv.view.bean.common.PageInfo;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewsBean extends PageInfo {

  @QueryParam("seq")
  private Integer seq;

  @QueryParam("type")
  private Integer type;

  @QueryParam("title")
  private String title;
  
  @QueryParam("contents")
  private String contents;
  
  @QueryParam("creatTime")
  private Date creatTime;
  
  @QueryParam("creatUid")
  private Integer creatUid;
  
  @QueryParam("updateTime")
  private Date updateTime;
  
  @QueryParam("updateUid")
  private Integer updateUid;

  public News getNews() {
    News news = new News();

    try {
      BeanUtils.copyProperties(news, this);
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return news;
  }
}
