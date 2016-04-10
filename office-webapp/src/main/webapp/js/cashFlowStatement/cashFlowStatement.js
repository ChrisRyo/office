
$(document).ready(function() {
	// getList
	ProfitLossAccountGrid.init();
	$("#gridProfitLossAccount tfoot").remove();

	$("#profitLossBox1 a[href='#tab_2']").click(function(){
		if ($("#barChart").find(".highcharts-container").size() < 1) {
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
		}
	});

	$("#profitLossBox1 a[href='#tab_3']").click(function(){
		if ($("#pieChart").find(".highcharts-container").size() < 1) {
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
var ProfitLossAccount = function() {
	return {

	}
}();