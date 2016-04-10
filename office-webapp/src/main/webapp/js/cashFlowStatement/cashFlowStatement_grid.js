/**
 * chrisryo
 */
 var ProfitLossAccountGrid = function() {
  return {
    init: function () {
      $('#gridProfitLossAccount').WATable({
        url: _pathTitle + "/profitLossAccount/query",      //Url to a webservice if not setting data manually as we do in this example
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
        stroe :{
          friendly: "店名",
        },
        profit :{
          friendly: "收入",
        },
        profitPercen: {
          friendly: "收入比",
        },
        loss: {
          friendly: "支出",
        },
        lossPercen: {
          friendly: "支出比",
        },
        real: {
          friendly: "淨利",
        },
        realPercen: {
          friendly: "淨利比",
        }
      }
    },
  }
}();