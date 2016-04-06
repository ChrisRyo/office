<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/header_grid.jsp" />
<!-- 自訂 css (位置要固定)-->
<link rel="stylesheet"
	href="plugins/bootstrap-treeview/css/bootstrap-treeview.css">

<jsp:include page="../common/topmenu.jsp" />

<!-- Main content -->
<div id="profitLossAccountForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>損益表</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
				<li class="active">Here</li>
			</ol>
		</section>
		<section class="content">
			<!-- BAR CHART -->
	          <div class="box box-success">
	            <div class="box-header with-border">
	              <h3 class="box-title">損益比較表</h3>

	              <div class="box-tools pull-right">
	                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	                </button>
	              </div>
	            </div>
	            <div class="box-body">
	              <div id="barChart" style="margin: 0 auto"></div>
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /.box -->

	        <!-- PAI CHART -->
	          <div class="box box-success">
	            <div class="box-header with-border">
	              <h3 class="box-title">各店損益比率</h3>

	              <div class="box-tools pull-right">
	                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	                </button>
	                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
	              </div>
	            </div>
	            <div class="box-body">
	              <div id="lineChart" style="margin: 0 auto"></div>
	            </div>
	            <!-- /.box-body -->
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
<!-- ChartJS 1.0.1 -->
<script type="text/javascript" src="plugins/jquery-highcharts/js/highcharts.js"></script>
<script type="text/javascript" src="plugins/jquery-highcharts/js/highcharts-3d.js"></script>
<!-- bootstrap-treeview -->
<script type="text/javascript" src="plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>

<script type="text/javascript" src="js/utils/chartUtils.js"></script>
<script type="text/javascript" src="js/profitLossAccount/profitLossAccount.js"></script>
</body>
</html>
