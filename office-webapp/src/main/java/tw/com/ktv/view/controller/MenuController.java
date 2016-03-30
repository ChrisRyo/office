package tw.com.ktv.view.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.ktv.enums.select.MenusEnum;
import tw.com.ktv.model.dto.Menu;

/**
 * 下拉選單
 * @author chrisryo
 *
 */
@Path("/menu")
public class MenuController {

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("getEmenu/{path}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryStroe(@PathParam("path") String path) throws Exception {

    MenusEnum[] menus = MenusEnum.values();

    for (MenusEnum menu : menus) {
      if (menu.getPath().equals(path)) {
        return menu.getMenuList();
      }
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
