<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<script type="text/x-template" id="_dust_modalform" >
<div class="modal fade" id="dialog_{name}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">{title}</h4>
                </div>
                <div class="modal-body">
                    <!-- 內容 -->

                    <div>
                        <form class="form-horizontal" id="form_modal_{name}">
                            <jsp:include page="dust_modal_form.jsp" />
                        </form>
                    </div>

                    <!-- 內容 end -->
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal"
                    value="取消"> <input type="button" id="saveDetail"
                    class="btn btn-primary" value="確認" onclick="expenses.save();">
                </div>
            </div>
        </div>
    </div>
</script>