<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- search -->
<script type="text/x-template" id="_dust_searchform" >
    <form class="form-horizontal" id="form_search_{name}">
        <div class="box box-default collapsed-box">
            <div class="box-header with-border">

                <input id="search_button_{name}" class="btn btn-info btn-xs" type="button" value="查詢"
                onclick="GridUtils.search('{name}');" />
                <span id="search_text_{name}"><h3 class="box-title">查詢欄</h3></span>

                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
            </div>
            <div class="box-body">
                <div class="form-group">
                    <jsp:include page="dust_search_form.jsp" />
                </div>
            </div>
        </div>
    </form>
</script>