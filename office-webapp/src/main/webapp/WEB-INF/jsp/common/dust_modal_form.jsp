<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

{#data}
{?.nonedit}
    {@select key=nonedit}
        {@eq value="nosend" }
        {/eq}
        {@default}
            <input type="text" id="{mark}_{col}" name="{mark}_{col}"/>
        {/default}                
    {/select}
{:else}
    <div class="form-group">
        <div class="col-sm-3 bg-navy-active color-palette"><span><b>{friendly}</b></span></div>
        <div class="col-sm-9 controls">
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
                    <input type="text" id="{mark}_{col}" name="{mark}_{col}" class="form-control date-range input-sm">
                {/eq}
            	{@eq value="textarea"}
                    <textarea rows="{textarea_height}" style="width:100%" id="{mark}_{col}" name="{mark}_{col}"></textarea>
            	{/eq}
        	{/select}
    	{:else}
            <input type="text" id="{mark}_{col}" name="{mark}_{col}" class="form-control input-sm">        
    	{/.inputsource}
    	</div>
    </div>
{/.nonedit}
{/data}