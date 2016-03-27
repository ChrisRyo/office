/**
 * chrisryo
 */
var NewsGrid = function() {
  return {

    id: "gridNews",
    url: "/news/query",
    watable: new Object(),

    coldefs: function() {
      return {
        seq: {
          friendly: "流水號",
          unique: true,
          hidden: true,
          noPicker : true,
          nonedit: true
        },
        type: {
          friendly: "類別",
          inputsource: "select2"
        },
        title: {
          friendly: "標題",
        },
        contents: {
          friendly: "內容",
          inputsource: "textarea"
        },
        creatTime: {
          friendly: "新增時間",
        },
        creatUid: {
          friendly: "新增人員",
        },
        updateTime: {
          friendly: "修改時間",
        },
        updateUid: {
          friendly: "修改人員",
        }
      }
    },

    formData: function() {
      return {
        "userName": $('#userName').val(),
        "name": $('#name').val(),
        "phone": $("#phone").val(),
        "email": $('#email').val(),
        "addr": $('#addr').val(),
        "status": $('#status').val(),
      };
    },

//    rowClicked: function(data) {
//      var row = data.row;
//      for ( var o in row) {
//        $("#" + _table1 + " [id=" + o + "]").val(row[o]).change();
//      }
//    },
//
//    sourceFM: function(val, row) {
//      var val = row.source;
//      var name = $('#source option[value=' + val + ']').text();
//      return name == "" ? row.val : name;
//    },
//
//    billStoreFM: function(val, row) {
//      var val = row.billStore;
//      var name = $('#billStore option[value=' + val + ']').text();
//      return name == "" ? row.val : name;
//    },
  }
}();