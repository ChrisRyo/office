package tw.com.ktv.jersey.app;

import java.io.IOException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import tw.com.ktv.jersey.filter.BaseRequestFilter;
import tw.com.ktv.jersey.filter.BaseResponseFilter;
import tw.com.ktv.jersey.interceptors.BaseReadInterceptor;
import tw.com.ktv.jersey.interceptors.BaseWriteInterceptor;
import tw.com.ktv.jersey.mapper.ConstraintViolationsExceptionMapper;
import tw.com.ktv.utils.PropertiesSqlUtils;

public class MyApplication extends ResourceConfig {
  public MyApplication() {

    // Resources
    packages("tw.com.ktv.view.controller");

    // Filter.
    register(BaseRequestFilter.class);
    register(BaseResponseFilter.class);
    
    register(BaseReadInterceptor.class);
    register(BaseWriteInterceptor.class);

    // MVC.
    register(MvcFeature.class);

    // Bean Validation
    register(ConstraintViolationsExceptionMapper.class);

    // JSP
    register(JspMvcFeature.class);
    property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");

    // init
    try {
      new PropertiesSqlUtils();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
