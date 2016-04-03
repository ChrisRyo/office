/**
 * chrisryo
 */
var InExMainGrid = function() {
  return {

    id: "gridInExMain",
    url: "/incomeExpense/queryMain",
    watable: new Object(),
    title: "收支總",

    coldefs: function() {
      return [
        {
          col: "accountDate",
          friendly: "帳目日期",
          inputsource: "date-range",
          unique: true
        },
        {
          col: "accountStroe",
          friendly: "帳目店家",
        },
        {
          col: "incomeAmt",
          friendly: "結算總收入",
        },
        {
          col: "expenseAmt",
          friendly: "結算總支出",
        },
        {
          col: "creatTime",
          friendly: "新增時間",
          inputsource: "date-range",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "creatUid",
          friendly: "新增人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateTime",
          friendly: "修改時間",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateUid",
          friendly: "修改人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
      ]
    },
  }
}();

var IncomeGrid = function() {
  return {

    id: "gridIncome",
    url: "/incomeExpense/queryIncome",
    watable: new Object(),
    title: "收入明細",

    coldefs: function() {
      return [
      	{
          col: "seq",
          friendly: "流水號",
          unique: true,
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        {
          col: "accountDate",
          friendly: "帳目日期",
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        {
          col: "accountStroe",
          friendly: "帳目店家",
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        {
          col: "realStroe",
          friendly: "發生店家",
        },
        {
          col: "realPenson",
          friendly: "發生班別",
        },
		    {
          col: "invoiceDatetime",
          friendly: "請款時間",
        },
        {
          col: "paymentDatetime",
          friendly: "結清時間",
        },
        {
          col: "payeeUnit",
          friendly: "請款單位",
        },
        {
          col: "payee",
          friendly: "請款人",
        },
        {
          col: "accountsIteam",
          friendly: "會計科目",
        },
        {
          col: "accountsDetail",
          friendly: "科目內容",
        },
        {
          col: "price",
          friendly: "單價",
        },
        {
          col: "quantity",
          friendly: "數量",
        },
        {
          col: "unit",
          friendly: "單位",
        },
        {
          col: "amt",
          friendly: "金額",
        },
        {
          col: "chkStatus",
          friendly: "審核狀態",
        },
        {
          col: "mark",
          friendly: "備註",
        },
        {
          col: "filePath",
          friendly: "檔案路徑",
          nonsearch: "nosend",
        },
        {
          col: "creatTime",
          friendly: "新增時間",
          inputsource: "date-range",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "creatUid",
          friendly: "新增人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateTime",
          friendly: "修改時間",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        {
          col: "updateUid",
          friendly: "修改人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
      ]
    },
  }
}();