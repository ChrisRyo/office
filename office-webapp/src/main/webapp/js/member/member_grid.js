/**
 * chrisryo
 */
var MemberGrid = function() {
  return {

    id: "gridMember",
    url: "/member/query",
    watable: new Object(),
    title: "用戶列表",

    coldefs: function() {
      return {
        userName: {
          friendly: "帳號",
          unique: true
        },
        name: {
          friendly: "姓名",
        },
        email: {
          friendly: "信箱",
        },
        phone: {
          friendly: "電話",
        },
        addr: {
          friendly: "地址",
        },
        loginTime: {
          friendly: "最近登入時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        loginIp: {
          friendly: "最近登入IP",
          nonedit: "nosend",
        },
        status: {
          friendly: "狀態",
          nonedit: "nosend",
        },
        creatTime: {
          friendly: "新增時間",
          inputsource: "date-range",
          nonedit: "nosend",
          hidden: true,
        },
        creatUid: {
          friendly: "新增人員",
          nonedit: "nosend",
          hidden: true,
        },
        updateTime: {
          friendly: "修改時間",
          inputsource: "date-range",
          nonedit: "nosend",
          hidden: true,
        },
        updateUid: {
          friendly: "修改人員",
          nonedit: "nosend",
          hidden: true,
        },
        permission: {
          friendly: "頁面權限",
          nonedit: "nosend",
          nonsearch: "nosend",
          format: MemberGrid.formatPermission
        },
      }
    },

    formatPermission: function(){
      return "<input type='button' class='btn bg-purple btn-xs' value='明細'>";
    },
  }
}();