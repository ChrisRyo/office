<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- search -->
<script type="text/x-template" id="_dust_searchform" >
    <form class="form-horizontal" id="form_search_{name}">
        <div class="box box-default">
            <div class="box-header with-border">
                <h3 class="box-title">查詢欄</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse">
                        <i class="fa fa-minus"></i>
                    </button>
                </div>
            </div>
            <div class="box-body">
                <div class="form-group">
                    <jsp:include page="dust_form.jsp" />
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                    <input class="btn btn-info btn-sm" type="button" value="查詢"
                        onclick="expensesSubmit.findMain();" />
                    </div>
                </div>
            </div>
        </div>
    </form>
</script>