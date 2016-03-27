<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

{#data}
{?.nonedit}
    {@select key=nonedit}
        {@eq value="nosend" }
        {/eq}
        {@default}
            <input type="text" id="{col}" name="{col}"/>
        {/default}                
    {/select}
{:else}
	<div class="col-sm-2">
	<laber for="{col}"><b>{friendly}</b></laber>
	{?.inputsource}
    	{@select key=inputsource}
        	{@eq value="select2"}
                <div>
            		<select id="{col}" name="{col}" class="select2">
    					<option value="">請選擇</option>
    				</select>
                </div>
        	{/eq}
            {@eq value="date-range"}
                <input type="text" id="{col}" name="{col}" class="form-control date-range input-sm">
            {/eq}
        	{@eq value="textarea"}
         
        	{/eq}
    	{/select}
	{:else}
        <input type="text" id="{col}" name="{col}" class="form-control input-sm">        
	{/.inputsource}
	</div>
{/.nonedit}
{/data}