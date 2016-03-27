package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.logic.exception.code.ValidCode;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.vo.News;
import tw.com.ktv.service.NewsService;
import tw.com.ktv.service.Impl.NewsServiceImpl;
import tw.com.ktv.view.bean.NewsBean;
import tw.com.ktv.view.message.ReturnMessage;

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

    Page page = newsService.getNewsList(bean.getNews(), bean.getPageIndex(), bean.getPageSize(), true);

    // int count = NewsService.queryCountBySql(bean.getNews(), true);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), page.getDataList(), page.getTotale());
  }
}
