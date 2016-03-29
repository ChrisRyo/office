<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<script type="text/x-template" id="_dust_datatableform" >
    <div class="box box-default">
        <div class="box-header with-border">

            <div class="control-group" id="datatable_button_{name}">
                <input id="insert_button_{name}" class="btn btn-primary btn-xs" type="button" value="新增"
                onclick="GridUtils.insert('{name}');" /> 

                <input id="update_button_{name}" class="btn btn-warning btn-xs" type="button" value="修改"
                onclick="GridUtils.update('{name}');" /> 

                <input id="delete_button_{name}" class="btn btn-danger btn-xs" type="button" value="刪除"
                onclick="GridUtils.delete('{name}');" />
            </div>

            <span id="datatable_text_{name}"><h3 class="box-title">{title}</h3></span>

            <div class="box-tools pull-right">
                <button class="btn btn-box-tool" data-widget="collapse">
                    <i class="fa fa-minus"></i>
                </button>
            </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div id="{name}" style="overflow-x:auto;overflow-y:hidden;"></div>
        </div>
    </div>
</script>