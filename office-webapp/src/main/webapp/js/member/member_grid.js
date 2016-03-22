/**
 * chrisryo
 */
var MemberGrid = function() {
  return {

    id: "gridMember",
    url: "/member/query",
    watable: new Object(),

    coldefs: function() {
      return {
        userName: {
          friendly: "帳號",
          unique: true
        },
        name: {
          friendly: "姓名",
        },
        phone: {
          friendly: "電話",
        },
        email: {
          friendly: "信箱",
        },
        addr: {
          friendly: "地址",
        },
        status: {
          friendly: "狀態",
        },
        permission: {
          friendly: "權限",
        },
        creatTime: {
          friendly: "新增時間",
          hidden: true,
        },
        creatUid: {
          friendly: "新增人員",
          hidden: true,
        },
        updateTime: {
          friendly: "修改時間",
          hidden: true,
        },
        updateUid: {
          friendly: "修改人員",
          hidden: true,
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

    rowClicked: function(data) {
      var row = data.row;
      for ( var o in row) {
        $("#" + _table1 + " [id=" + o + "]").val(row[o]).change();
      }
    },

    sourceFM: function(val, row) {
      var val = row.source;
      var name = $('#source option[value=' + val + ']').text();
      return name == "" ? row.val : name;
    },

    billStoreFM: function(val, row) {
      var val = row.billStore;
      var name = $('#billStore option[value=' + val + ']').text();
      return name == "" ? row.val : name;
    },
  }
}();