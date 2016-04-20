<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/header_grid.jsp" />
<!-- 自訂 css (位置要固定)-->
<!-- GRID -->
<link rel="stylesheet" href="plugins/jquery-watable/css/watable.css">

<jsp:include page="../common/topmenu.jsp" />

<!-- Main content -->
<div id="cashFlowStatementForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>現金流量表</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
				<li class="active">Here</li>
			</ol>
		</section>
		<section class="content">
			<!-- serach-->
			<div id="search_gridMember">
				<jsp:include page="../common/dust_search.jsp" />
			</div>

			<!-- grid1 -->
            <div class="box box-default">
		        <div class="box-header with-border">
		            <span><h3 class="box-title">現金表 &nbsp;&nbsp;&nbsp;&nbsp;</h3></span>
		            <div class="box-tools pull-right">
		                <button class="btn btn-box-tool" data-widget="collapse">
		                    <i class="fa fa-minus"></i>
		                </button>
		            </div>
		        </div>
		        <!-- /.box-header -->
		        <div class="box-body">
		            <div id="gridCashFlowStatement1"></div>
		        </div>
		    </div>

		    <!-- grid2 -->
		    <div class="col-md-6" >
	            <div class="box box-default">
			        <div class="box-header with-border">
			            <span><h3 class="box-title">預期收入表 &nbsp;&nbsp;&nbsp;&nbsp;</h3></span>
			            <div class="box-tools pull-right">
			                <button class="btn btn-box-tool" data-widget="collapse">
			                    <i class="fa fa-minus"></i>
			                </button>
			            </div>
			        </div>
			        <!-- /.box-header -->
			        <div class="box-body">
			            <div id="gridCashFlowStatement2"></div>
			        </div>
			    </div>
		    </div>

		    <!-- grid3 -->
		    <div class="col-md-6" >
	            <div class="box box-default">
			        <div class="box-header with-border">
			            <span><h3 class="box-title">預期支出表 &nbsp;&nbsp;&nbsp;&nbsp;</h3></span>
			            <div class="box-tools pull-right">
			                <button class="btn btn-box-tool" data-widget="collapse">
			                    <i class="fa fa-minus"></i>
			                </button>
			            </div>
			        </div>
			        <!-- /.box-header -->
			        <div class="box-body">
			            <div id="gridCashFlowStatement3"></div>
			        </div>
			    </div>
		    </div>
	        <!-- /.box -->
		</section>
	</div>
</div>
<!-- /.content -->
<jsp:include page="../common/endmenu.jsp" />
<jsp:include page="../common/footer.jsp" />
<jsp:include page="../common/footer_grid.jsp" />

<!-- 自訂 js (位置要固定)-->
<!-- GRID -->
<script src="plugins/jquery-watable/js/jquery.watable.js"></script>
<!-- ChartJS 1.0.1 -->
<script type="text/javascript" src="plugins/jquery-highcharts/js/highcharts.js"></script>

<script type="text/javascript" src="js/utils/chartUtils.js"></script>
<script type="text/javascript" src="js/cashFlowStatement/cashFlowStatement.js"></script>
<script type="text/javascript" src="js/cashFlowStatement/cashFlowStatement_grid.js"></script>
</body>
</html>
