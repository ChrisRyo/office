package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.ktv.exception.code.ValidCode;
import tw.com.ktv.model.dto.Page;
import tw.com.ktv.model.dto.Tree;
import tw.com.ktv.model.vo.AccountsIteam;
import tw.com.ktv.service.AccountsIteamService;
import tw.com.ktv.service.Impl.AccountsIteamServiceImpl;
import tw.com.ktv.view.bean.MemberBean;
import tw.com.ktv.view.message.ReturnMessage;

/**
 * 會計科目管理
 * 
 * @author chrisryo
 *
 */
@Path("/accountsIteam")
public class AccountsIteamController extends BaseController {

  private AccountsIteamService accountsIteamService = new AccountsIteamServiceImpl();

  @GET
  public Viewable init() throws Exception {

    return new Viewable("/accountsIteam/accountsIteam_init", super.getModelAndView());
  }

  @GET
  @Path("/query")
  public ReturnMessage getAccountsIteamList(@BeanParam MemberBean bean) throws Exception {

    Page page =
        accountsIteamService.getAccountsIteamPage(new AccountsIteam(), bean.getPageIndex(),
            bean.getPageSize(), true);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), page.getDataList(), page.getTotale());
  }

  @GET
  @Path("/getTree")
  // @Produces(MediaType.TEXT_PLAIN)
  public ReturnMessage getAccountsIteamTree(@BeanParam MemberBean bean) throws Exception {

    List<Tree> tree = accountsIteamService.getAccountsIteamTree(new AccountsIteam(), true);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), tree);
  }
}
