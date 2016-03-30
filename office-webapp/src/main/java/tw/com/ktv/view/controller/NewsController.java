package tw.com.ktv.view.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.service.NewsService;
import tw.com.ktv.service.Impl.NewsServiceImpl;
import tw.com.ktv.view.bean.NewsBean;
import tw.com.ktv.view.message.ReturnMessage;

/**
 * 公告列表
 * @author chrisryo
 *
 */
@Path("/news")
public class NewsController extends BaseController {

  private NewsService newsService = new NewsServiceImpl();

  @GET
  public Viewable init() throws Exception {

    return new Viewable("/news/news_init", super.getModelAndView());
  }

  @GET
  @Path("/query")
  public ReturnMessage getNewsList(@BeanParam NewsBean bean) throws Exception {

    Page page =
        newsService.getNewsList(bean.getNews(), bean.getPageIndex(), bean.getPageSize(), true);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), page.getDataList(), page.getTotale());
  }
}
