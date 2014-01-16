<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="tr">
<head>
<!-- 	<meta charset="UTF-8"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<title><tiles:insertAttribute name="title" /></title>

	<!-- Bootstrap core CSS -->
	<link href="<c:url value='/resources/sb-admin/css/bootstrap.css' />" rel="stylesheet">

	<!-- Add custom CSS here -->
	<link href="<c:url value='/resources/sb-admin/css/sb-admin.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/sb-admin/font-awesome/css/font-awesome.min.css' />" rel="stylesheet">
	
	<!-- Page Specific CSS -->
	<link href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css" rel="stylesheet">
	
	<!-- date formater , menüde Uyarı tarihleri için-->
	<script src="<c:url value='/resources/bootstrap/js/jquery.js' />"></script>
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
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.js"></script>
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
	
	<!-- date formater , menüde Uyarı tarihleri için-->
	<script src="${pageContext.request.contextPath}/resources/dtpicker/js/jquery.dateFormat-1.0.js" type="text/javascript"></script>

</body>
</html>