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
      return [ 
        {
          col: "userName",
          friendly: "帳號",
          unique: true
        },
        {
          col: "name",
          friendly: "姓名",
        },
        {
          col: "email",
          friendly: "信箱",
        },
        {
          col: "phone",
          friendly: "電話",
        },
        {
          col: "addr",
          friendly: "地址",
        },
        {
          col: "loginTime",
          friendly: "最近登入時間",
          inputsource: "date-range",
          nonedit: "nosend",
        },
        {
          col: "loginIp",
          friendly: "最近登入IP",
          nonedit: "nosend",
        },
        {
          col: "status",
          friendly: "狀態",
          nonedit: "nosend",
        },
        {
          col: "creatTime",
          friendly: "新增時間",
          inputsource: "date-range",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "creatUid",
          friendly: "新增人員",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateTime",
          friendly: "修改時間",
          inputsource: "date-range",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateUid",
          friendly: "修改人員",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "permission",
          friendly: "頁面權限",
          nonedit: "nosend",
          nonsearch: "nosend",
          format: MemberGrid.formatPermission
        },
      ]
    },

    formatPermission: function(){
      return "<input type='button' class='btn bg-purple btn-xs' value='明細'>";
    },
  }
}();