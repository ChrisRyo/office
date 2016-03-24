var _grid = "gridMember";

$(document).ready(function() {
  //grid
  MemberGrid.watable = gridUtils.initGrid(MemberGrid);
  
  dust.loadSource(dust.compile($("#_dust_li_tab").html(),"liBankTab"));
  
  dust.render("liBankTab", {"bankName":"yyyyyyyyyy"}, function(err, out) {       
    $("#dust_li_tab").append(out);
  });
});

/**
 * chrisryo
 */
var Member = function() {
	return {

	}
}();