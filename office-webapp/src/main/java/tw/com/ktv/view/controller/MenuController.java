package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.ktv.enums.temp.CompanyEnum;
import tw.com.ktv.enums.temp.GovernmentEnum;
import tw.com.ktv.enums.temp.PayeeUnitEnum;
import tw.com.ktv.enums.temp.PlayerEnum;
import tw.com.ktv.enums.temp.SourceEnum;
import tw.com.ktv.enums.temp.StoreEnum;
import tw.com.ktv.model.dto.Menu;
import tw.com.ktv.util.EnumUtils;

@Path("/menu")
public class MenuController {

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("getEmenu/{type}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryStroe(@PathParam("type") String type) throws Exception {

    if ("queryStroe".equals(type)) {
      return EnumUtils.getEnumList(StoreEnum.values());
      
    } else if ("querySource".equals(type)) {
      return EnumUtils.getEnumList(SourceEnum.values());
      
    } else if ("queryPayeeUnit".equals(type)) {
      return EnumUtils.getEnumList(PayeeUnitEnum.values());
      
    } else if ("queryPlayer".equals(type)) {
      return EnumUtils.getEnumList(PlayerEnum.values());
      
    } else if ("queryCompany".equals(type)) {
      return EnumUtils.getEnumList(CompanyEnum.values());
      
    } else if ("queryGovernment".equals(type)) {
      return EnumUtils.getEnumList(GovernmentEnum.values());
      
    }

    return null;
  }


  // /**
  // * @return
  // * @throws Exception
  // */
  // @GET
  // @Path("queryPayee")
  // @Produces(MediaType.APPLICATION_JSON)
  // public List<Menu> queryPayee(@QueryParam("unit") int unit, @QueryParam("name") String name)
  // throws Exception {
  //
  // switch (unit) {
  // case 1:
  // return PlayerEnum.getMenu(name);
  // case 2:
  // return CompanyEnum.getMenu(name);
  // case 3:
  // return GovernmentEnum.getMenu(name);
  // default:
  // return new ArrayList<Menu>();
  // }
  // }
}
