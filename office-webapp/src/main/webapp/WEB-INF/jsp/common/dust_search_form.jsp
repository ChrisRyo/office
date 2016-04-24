<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

{#data}
{?.nonsearch}
    {@select key=nonsearch}
        {@eq value="nosend" }
        {/eq}
        {@default}
            <input type="text" id="{mark}_{col}" name="{mark}_{col}"/>
        {/default}                
    {/select}
{:else}
	<div class="col-sm-3">
        <label for="{mark}_{col}"><b>{friendly}</b></label>
	{?.inputsource}
    	{@select key=inputsource}
        	{@eq value="select2"}
                <div>
            		<select id="{mark}_{col}" name="{mark}_{col}" class="select2" data-menu-path="{menu_path}">
    					<option value="">請選擇</option>
    				</select>
                </div>
        	{/eq}
            {@eq value="date-range"}
                <div class="input-group">
                <input type="text" id="{mark}_{col}" name="{mark}_{col}" class="form-control date-range input-sm">
                <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                </div>
                </div>
            {/eq}
        	{@eq value="textarea"}
                <input type="text" id="{mark}_{col}" name="{mark}_{col}" class="form-control input-sm">
        	{/eq}
    	{/select}
	{:else}
        <input type="text" id="{mark}_{col}" name="{mark}_{col}" class="form-control input-sm">        
	{/.inputsource}
	</div>
{/.nonsearch}
{/data}