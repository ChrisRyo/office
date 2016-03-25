package tw.com.ktv.jersey.interceptors;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * 
 * @author chris
 *
 */
@Provider
public class BaseWriteInterceptor implements WriterInterceptor {

  @Override
  public void aroundWriteTo(WriterInterceptorContext context)
      throws IOException, WebApplicationException {
    context.proceed();
  }
}
