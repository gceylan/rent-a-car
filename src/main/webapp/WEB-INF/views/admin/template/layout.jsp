<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="tr">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title><tiles:insertAttribute name="title" /></title>

	<!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resources/sb-admin/css/bootstrap.css" rel="stylesheet">

	<!-- Add custom CSS here -->
	<link href="${pageContext.request.contextPath}/resources/sb-admin/css/sb-admin.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/sb-admin/font-awesome/css/font-awesome.min.css">
	<!-- Page Specific CSS -->
	<link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
		</nav>

		<div id="page-wrapper">
			<tiles:insertAttribute name="sub-menu" />
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	
	<!-- Bootstrap core JavaScript -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/sb-admin/js/bootstrap.js"></script>
    <!-- Page Specific Plugins -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/sb-admin/js/morris/chart-data-morris.js"></script>
    <script src="${pageContext.request.contextPath}/resources/sb-admin/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="${pageContext.request.contextPath}/resources/sb-admin/js/tablesorter/tables.js"></script>

    <!--[if lte IE 8]><script src="/rentacar/resources/js/excanvas.min.js"></script><![endif]-->
	<script src="${pageContext.request.contextPath}/resources/js/flot/jquery.flot.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/flot/jquery.flot.tooltip.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/flot/jquery.flot.resize.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/flot/jquery.flot.pie.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/flot/chart-data-flot.js"></script>

</body>
</html>