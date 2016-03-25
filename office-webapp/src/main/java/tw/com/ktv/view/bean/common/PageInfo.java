package tw.com.ktv.view.bean.common;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class PageInfo {

  @QueryParam("pageIndex")
  private int pageIndex;
  
  @QueryParam("pageSize")
  private int pageSize;

  private String sort;
}
