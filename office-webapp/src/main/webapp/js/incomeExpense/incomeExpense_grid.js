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
      return {
        accountDate: {
          friendly: "帳目日期",
          inputsource: "date-range",
          unique: true
        },
        accountStroe: {
          friendly: "帳目店家",
        },
        incomeAmt: {
          friendly: "結算總收入",
        },
        expenseAmt: {
          friendly: "結算總支出",
        },
        creatTime: {
          friendly: "新增時間",
          inputsource: "date-range",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        creatUid: {
          friendly: "新增人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        updateTime: {
          friendly: "修改時間",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        updateUid: {
          friendly: "修改人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
      }
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
      return {
      	seq: {
          friendly: "流水號",
          unique: true,
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        accountDate: {
          friendly: "帳目日期",
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        accountStroe: {
          friendly: "帳目店家",
          hidden: true,
          nonsearch: "nosend",
          nonedit: true,
          noPicker : true,
        },
        realStroe: {
          friendly: "發生店家",
        },
        realPenson: {
          friendly: "發生班別",
        },
		    invoiceDatetime: {
          friendly: "請款時間",
        },
        paymentDatetime: {
          friendly: "結清時間",
        },
        payeeUnit: {
          friendly: "請款單位",
        },
        payee: {
          friendly: "請款人",
        },
        accountsIteam: {
          friendly: "會計科目",
        },
        accountsDetail: {
          friendly: "科目內容",
        },
        price: {
          friendly: "單價",
        },
        quantity: {
          friendly: "數量",
        },
        unit: {
          friendly: "單位",
        },
        amt: {
          friendly: "金額",
        },
        chkStatus: {
          friendly: "審核狀態",
        },
        mark: {
          friendly: "備註",
        },
        filePath: {
          friendly: "檔案路徑",
          nonsearch: "nosend",
        },
        creatTime: {
          friendly: "新增時間",
          inputsource: "date-range",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        creatUid: {
          friendly: "新增人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        updateTime: {
          friendly: "修改時間",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
        updateUid: {
          friendly: "修改人員",
          nonsearch: "nosend",
          nonedit: "nosend",
          hidden: true,
        },
      }
    },
  }
}();