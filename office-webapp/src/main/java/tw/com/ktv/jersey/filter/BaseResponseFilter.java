package tw.com.ktv.jersey.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import tw.com.ktv.entityManager.EntityManagerHelper;
import tw.com.ktv.model.dto.User;
import tw.com.ktv.util.UserUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author chrisryo
 *
 */
@Provider
public class BaseResponseFilter implements ContainerResponseFilter {

  @Context
  HttpServletRequest request;

  @Context
  HttpServletResponse response;

  public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1)
      throws IOException {

    if (arg1.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
      response.sendRedirect("login");
      return;
    }

    // Google Json
    if (arg1.getMediaType() != null
        && MediaType.APPLICATION_JSON.equals(arg1.getMediaType().toString())) {
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      arg1.setEntity(gson.toJson(arg1.getEntity()));
    }

    // close connection
    EntityManagerHelper.closeConnection();

    // set user data
    if ("POST".equals(request.getMethod())) {
      request.getSession().setAttribute(User.USER_SESSION, UserUtils.getUser());
    }
  }
}
