<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<script type="text/x-template" id="_dust_tableform" >
    <div class="modal fade" id="table2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                        <form class="form-horizontal" id="{formId}">
                        {#data}
                            {@if cond="{$idx} % 2 == 0"}
                            <div class="form-group">
                            {/if}



                                {?.inputsource}
                                    {@select key=inputsource}

                                    <label class="col-sm-2 control-label">發生日期</label>
                                    <div class="col-sm-4 controls">
                                        <div class='input-group date' id='realDate_tool'>
                                            <input type='text' id='realDate' placeholder="YYYY-MM-DD" /> 
                                            <span class="input-group-addon"></span>
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </div>
                                    </div>
                                    <label class="col-sm-2 control-label">發生店家</label>
                                    <div class="col-sm-4 controls">
                                        <select id="realStore" class="select2 col-sm-4">
                                            <option value="">請選擇</option>
                                        </select>
                                    </div>

                                    {/select}
                                {:else}
                                {/.inputsource}




                            {@if cond="{$idx} % 2 == 1 || {$idx} == ({$len} - 1)"}
                            </div>
                            {/if}
                        {/data}
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