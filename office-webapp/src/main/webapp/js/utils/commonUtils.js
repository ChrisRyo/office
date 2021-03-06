/**
 * chrisryo
 */
var CommonUtils = function() {
  return {
    /*
     * 自動將json欄位寫入grid中 (欄位必須相同)
     * 
     * @param gridId string @param jsonjson
     */
    autoJsonToGrid: function(gridId, json) {

      $("#" + gridId).jqGrid("clearGridData", true);
      for ( var i in json) {
        if (json[i]["id"] != null) {
          for ( var o in json[i]["id"]) {
            json[i][o] = json[i]["id"][o];
          }
        }
        $("#" + gridId).jqGrid('addRowData', i + 1, json[i]);
      }
    },

    getMenu: function(path, selectObj) {
      var url = "/menu/getEmenu/";

      $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: _pathTitle + url + path,
        dataType: "json",
        success: function(json) {
          for ( var o in json) {
            selectObj.append('<option value="' + json[o].id + '">' + json[o].text + '</option>');
          }
        },
        error: function(xhr, ajaxOptions, thrownError) {
          alert(xhr.status);
          alert(thrownError);
        }
      });
    },
  }
}();

/**
 * AJAX 遮罩
 * 必要参数 (blockUI = “id")
 */
$(document).bind("ajaxSend", function(event, xhr, settings){
        if (settings.blockUI) {
          BlockuiUtils.blockUI({
            target: settings.blockUI,
            boxed: true,
          });
        }
}).bind("ajaxComplete", function(event, xhr, settings){
        BlockuiUtils.unblockUI(settings.blockUI);
});