
$(document).ready(function() {
	// getbar
	$.ajax({
	    url: _pathTitle + "/profitLossAccount/queryColumn",
	    type: 'GET',
	    dataType: 'json',
	    contentType: "application/json; charset=utf-8",
	    success: function (json) {
	    	$('#barChart').highcharts(json.data);
	    },
	    error: function (err) {
	        priv.log('request error: '.f(err));
	    }
	});

	// getpie
	$.ajax({
	    url: _pathTitle + "/profitLossAccount/queryPie",
	    type: 'GET',
	    dataType: 'json',
	    contentType: "application/json; charset=utf-8",
	    success: function (json) {
	    	$('#pieChart').highcharts(json.data);
	    },
	    error: function (err) {
	        priv.log('request error: '.f(err));
	    }
	});

	// getLine
	$.ajax({
	    url: _pathTitle + "/profitLossAccount/queryLine",
	    type: 'GET',
	    dataType: 'json',
	    contentType: "application/json; charset=utf-8",
	    success: function (json) {
	    	$('#lineChart').highcharts(json.data);
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