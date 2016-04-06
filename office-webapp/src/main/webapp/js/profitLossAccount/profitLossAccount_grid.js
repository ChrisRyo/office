/**
 * chrisryo
 */
 var AccountsIteamGrid = function() {
  return {

    id: "gridAccountsIteam",
    url: "/accountsIteam/query",
    watable: new Object(),
    title: "會計科目",

    coldefs: function() {
      return [
      {
        col: "accountsId",
        friendly: "會計科目",
        unique: true,
      },
      {
        col: "accountsParentId",
        friendly: "上層科目",
      },
      {
        col: "accountsName",
        friendly: "科目名稱",
      },
      {
        col: "accountsDetail",
        friendly: "科目明細",
      },
      {
        col: "profitLossType",
        friendly: "損益計算方式",
      },
      {
        col: "accountsStatus",
        friendly: "狀態",
      },
      {
        col: "creatTime",
        friendly: "新增時間",
        inputsource: "date-range",
        nonedit: "nosend",
      },
      {
        col: "creatUid",
        friendly: "新增人員",
        nonedit: "nosend",
      },
      {
        col: "updateTime",
        friendly: "修改時間",
        inputsource: "date-range",
        nonedit: "nosend",
      },
      {
        col: "updateUid",
        friendly: "修改人員",
        nonedit: "nosend",
      } ]
    },
  }
}();