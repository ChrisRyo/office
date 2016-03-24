<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<!-- 自訂 css (位置要固定)-->
<jsp:include page="../common/topmenu.jsp" />

<!-- Main content -->
<div id="memberForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>使用者管理</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
				<li class="active">Here</li>
			</ol>
		</section>
		<section class="content">
			<!-- grid-->
			<div class="box box-default" id="table1Grid">
				<div class="box-header with-border">
					<h3 class="box-title">Member Table</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="control-group">
						<input class="btn btn-primary btn-sm" type="button" value="新增"
							onclick="expenses.openModel(1);" /> <input
							class="btn btn-warning btn-sm" type="button" value="修改"
							onclick="expenses.openModel(2);" /> <input
							class="btn btn-danger btn-sm" type="button" value="刪除"
							onclick="expensesSubmit.deleteDetail();" />
					</div>
					<div id="gridMember" style="width: 100%"></div>
				</div>
			</div>
			<div class="tabbable">
				<ul class="nav nav-tabs nav-tabs-lg" id="dust_li_tab">
					<script type="text/x-template" id="_dust_li_tab">
						<input value={bankName}>
					</script>
				</ul>
			</div>
		</section>
	</div>
</div>
<!-- /.content -->
<jsp:include page="../common/endmenu.jsp" />
<jsp:include page="../common/footer.jsp" />
<!-- 自訂 js (位置要固定)-->
<script type="text/javascript" src="js/member/member.js"></script>
<script type="text/javascript" src="js/member/member_grid.js"></script>
</body>
</html>
