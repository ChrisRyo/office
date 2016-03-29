/**
 * chrisryo
 */
 var GridUtils = function() {
  return {

    initGrid: function(grid, genModel) {
      var id = grid.id;
      var title = grid.title;

      this.initHtml(id, title);

      var waTable = $('#'+id).WATable({
        url: _pathTitle + grid.url,      //Url to a webservice if not setting data manually as we do in this example
        urlData: new Object(),   //Any data you need to pass to the webservice
        urlPost: false,             //Use POST httpmethod to webservice. Default is GET.
        debug:false,                //Prints some debug info to console
        dataBind: true,             //Auto-updates table when changing data row values. See example below. (Note. You need a column with the 'unique' property)
        pageSize: 10,               //Initial pagesize
        //pageSizePadding: true,      //Pads with empty rows when pagesize is not met
        transition: 'slide',      //Type of transition when paging (bounce, fade, flip, rotate, scroll, slide).Requires https://github.com/daneden/animate.css.
        //transitionDuration: 0.2,  //Duration of transition in seconds.
        //filter: true,               //Show filter fields
        sorting: true,              //Enable sorting
        sortEmptyLast:true,         //Empty values will be shown last
        columnPicker: true,         //Show the columnPicker button
        pageSizes: [10,20,30,50],   //Set custom pageSizes. Leave empty array to hide button.
        hidePagerOnEmpty: true,     //Removes the pager if data is empty.
        checkboxes: true,           //Make rows checkable. (Note. You need a column with the 'unique' property)
        checkAllToggle:false,        //Show the check-all toggle
        preFill: true,              //Initially fills the table with empty rows (as many as the pagesize).
        rownumbers: true,
        data:{
          cols: grid.coldefs(),
          rows:[]
        },
        types: { //type specific options
          string: {},
          number: {},
          bool: {},
          date: {}
        },
        tableCreated: grid.tableCreated,
        rowClicked: function (data) {
          if (typeof grid.rowClicked == 'function') {
            grid.rowClicked.call($(this), data)
          }
        },
        columnClicked: grid.columnClicked,
        pageChanged: grid.pageChanged,
        pageSizeChanged: grid.pageSizeChanged
      }).data('WATable');  //This step reaches into the html data property to get the actual WATable object. Important if you want a reference to it as we want here.

      if (genModel)
        this.creatDialog(grid);

      return waTable;
    },

    initHtml: function(id, title) {
      // add grid html
      dust.loadSource(dust.compile($("#_dust_datatableform").html(),"dustDatatableform"));
      dust.render("dustDatatableform", {name:id, "title":title}, function(err, out) {       
        $("#datatable_"+id).append(out);
      });

      // event
      var datatableId = "#datatable_" + id;
      $("#datatable_text_" + id).hide();
      $(datatableId).find(":button[data-widget='collapse']").click(function(){
        if($(this).find(".fa-minus").size() > 0) {
          $("#datatable_text_" + id).show();
          $("#datatable_button_" + id).hide();
        } else {
          $("#datatable_text_" + id).hide();
          $("#datatable_button_" + id).show();
        }
      });
    },

    creatDialog: function(grid){
      var id = grid.id;
      var title = grid.title;
      var select2;
      var daterange;

      var i = 0;
      var coldefs = grid.coldefs();
      var colArray = new Array();
      for (var o in coldefs) {
        coldefs[o].col = o;
        colArray[i++] = coldefs[o];
      }

      // add html
      var dataSearchObj = {"mark":"Q", "title":title, "name":id, "data":colArray};
      var dataModalObj = {"mark":"M", "title":title, "name":id, "data":colArray};

      dust.loadSource(dust.compile($("#_dust_searchform").html(),"dustSearchForm"));
      dust.render("dustSearchForm", dataSearchObj, function(err, out) {       
        $("#search_"+id).append(out);
      });

      dust.loadSource(dust.compile($("#_dust_modalform").html(),"dustModalForm"));
      dust.render("dustModalForm", dataModalObj, function(err, out) {       
        $("#modal_"+id).append(out);
      });

      // event
      var searchId = "#form_search_" + id;
      $("#search_text_" + id).hide();
      $(searchId).find(":button[data-widget='collapse']").click(function(){
        if($(this).find(".fa-minus").size() > 0) {
          $("#search_text_" + id).show();
          $("#search_button_" + id).hide();
        } else {
          $("#search_text_" + id).hide();
          $("#search_button_" + id).show();
        }
      }).click();

      var modalId = "#form_modal_" + id;
      var tableId = searchId + ", " + modalId;

      // select2
      this.select2(tableId);

      //Date range picker
      this.daterange(tableId);
    },
    
    select2: function(tableId) {
      var _obj = $(tableId).find(".select2");
      if (_obj.size() > 0) {
        _obj.each(function(index, ele){
          var path = $(ele).attr("data-menu-path");
          commonUtils.getMenu(path, $(this));
        });

        _obj.select2({
          width: '100%'
        });
      }
    },

    daterange: function(tableId) {
      var _obj = $(".date-range");
      if (_obj.size() > 0) {
        _obj.daterangepicker({format: 'YYYY/MM/DD'})
          .inputmask("9999/99/99 - 9999/99/99", {"placeholder": "yyyy/mm/dd - yyyy/mm/dd"});
      }
    },

    search: function(gridId) {

    },

    insert: function(gridId) {
      $("#dialog_" + gridId).modal("show");
    },

    update: function(gridId) {
      $("#dialog_" + gridId).modal("show");
    },

    delete: function(gridId) {

    },
  }
}();