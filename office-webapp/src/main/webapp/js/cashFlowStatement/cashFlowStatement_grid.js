/**
 * chrisryo
 */
 var CashFlowStatementGrid1 = function() {
  return {
    init: function () {
      $('#gridCashFlowStatement1').WATable({
        url: _pathTitle + "/cashFlowStatement/query1",      //Url to a webservice if not setting data manually as we do in this example
        urlPost: false,             //Use POST httpmethod to webservice. Default is GET.
        noFoot: true,
        data:{
          cols: this.coldefs(),
          rows:[]
        },
      }).data('WATable');  //This step reaches into the html data property to get the actual WATable object. Important if you want a reference to it as we want here.

    },

    coldefs: function() {
      return {
        date :{
          friendly: "時間",
        },
        cash :{
          friendly: "總餘額",
        },
        income: {
          friendly: "預期收入",
        },
        expenses: {
          friendly: "預期支出",
        },
        realCash: {
          friendly: "可用餘額",
        },
      }
    },
  }
}();

var CashFlowStatementGrid2 = function() {
  return {
    init: function () {
      $('#gridCashFlowStatement2').WATable({
        url: _pathTitle + "/cashFlowStatement/query2",      //Url to a webservice if not setting data manually as we do in this example
        urlPost: false,             //Use POST httpmethod to webservice. Default is GET.
        noFoot: true,
        data:{
          cols: this.coldefs(),
          rows:[]
        },
      }).data('WATable');  //This step reaches into the html data property to get the actual WATable object. Important if you want a reference to it as we want here.

    },

    coldefs: function() {
      return {
        payDate :{
          friendly: "預期結清時間",
        },
        happenDate :{
          friendly: "發生時間",
        },
        amt: {
          friendly: "金額",
        },
        mark: {
          friendly: "備註",
        },
      }
    },
  }
}();


var CashFlowStatementGrid3 = function() {
  return {
    init: function () {
      $('#gridCashFlowStatement3').WATable({
        url: _pathTitle + "/cashFlowStatement/query3",      //Url to a webservice if not setting data manually as we do in this example
        urlPost: false,             //Use POST httpmethod to webservice. Default is GET.
        noFoot: true,
        data:{
          cols: this.coldefs(),
          rows:[]
        },
      }).data('WATable');  //This step reaches into the html data property to get the actual WATable object. Important if you want a reference to it as we want here.

    },

    coldefs: function() {
      return {
        payDate :{
          friendly: "預期結清時間",
        },
        happenDate :{
          friendly: "發生時間",
        },
        amt: {
          friendly: "金額",
        },
        mark: {
          friendly: "備註",
        },
      }
    },
  }
}();