var aa;

$(document).ready(function() {
	// getTree
	$.ajax({
	    url: _pathTitle + "/accountsIteam/getTree",
	    type: 'GET',
	    dataType: 'json',
	    contentType: "application/json; charset=utf-8",
	    success: function (json) { // 2016-03-12
	        aa = $('#treeview-checkable').treeview({
	          data: json.data,
	          showIcon: false,
	          showCheckbox: true,
	          showTags: true,
	          onNodeChecked: function(event, node) {
	            alert(node.id);
	          },
	          onNodeUnchecked: function (event, node) {
	            alert(node.id);
	          }
	        });
	    },
	    error: function (err) {
	        priv.log('request error: '.f(err));
	    }
	});
  //grid
  // AccountsIteamGrid.watable = GridUtils.initGrid(AccountsIteamGrid, true);
});

/**
 * chrisryo
 */
var AccountsIteamGrid = function() {
	return {

	}
}();