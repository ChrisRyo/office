<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/header_grid.jsp" />
<!-- 自訂 css (位置要固定)-->
<jsp:include page="../common/topmenu.jsp" />

<!-- Main content -->
<div id="newsForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>用戶列表管理</h1>
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

			<!-- grid-->
			<div id="datatable_gridMember">
				<jsp:include page="../common/dust_datatable.jsp" />
			</div>
		</section>
		<!-- dialog -->
		<div id="modal_gridMember">
			<jsp:include page="../common/dust_modal.jsp" />
		</div>
	</div>
</div>
<!-- /.content -->
<jsp:include page="../common/endmenu.jsp" />
<jsp:include page="../common/footer.jsp" />
<jsp:include page="../common/footer_grid.jsp" />

<!-- 自訂 js (位置要固定)-->
<script type="text/javascript" src="js/member/member.js"></script>
<script type="text/javascript" src="js/member/member_grid.js"></script>
</body>
</html>
