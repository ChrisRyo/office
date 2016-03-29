package tw.com.ktv.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.dto.User;
import tw.com.ktv.model.vo.Member;
import tw.com.ktv.service.MemberService;
import tw.com.ktv.service.PageMenuInfoService;
import tw.com.ktv.service.Impl.MemberServiceImpl;
import tw.com.ktv.service.Impl.PageMenuInfoServiceImpl;
import tw.com.ktv.util.UserUtils;
import tw.com.ktv.view.bean.LoginBean;
import tw.com.ktv.view.message.ReturnMessage;


/**
 * 
 * @author chrisryo
 * 
 *         註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/login")
public class LoginController extends BaseController {

  @Context
  HttpServletRequest request;

  private MemberService membrtService = new MemberServiceImpl();

  private PageMenuInfoService pageMenuInfoService = new PageMenuInfoServiceImpl();

  @GET
  public Viewable init() throws Exception {
    return new Viewable("/login");
  }

  /**
   * login
   * 
   * @return
   * @throws Exception
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public ReturnMessage login(LoginBean bean) throws Exception {

    Member member = membrtService.chkLogin(bean.getUserName(), bean.getPwd());

    if (member == null) {
      return new ReturnMessage(ValidCode.VALID_FAIL.getCode(), "帳號或密碼錯誤！");
    }

    User user = new User();
    // 會員資料
    user.setMember(member);

    // 路徑
    user.setPath(request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + request.getContextPath());

    // 選單
    user.setMenuHtml(pageMenuInfoService.getPageMenuInfoHtml(member.getUid(), user.getPath()));
    
    UserUtils.setUser(user);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), request.getContextPath() + "/home");
  }

}
