<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="tr">
<head>
<title><tiles:insertAttribute name="title" /></title>

<meta charset="utf-8">
<meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/sb-admin/css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${pageContext.request.contextPath}/resources/sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/sb-admin/font-awesome/css/font-awesome.min.css">

<link href="${pageContext.request.contextPath}/resources/footable/css/footable.core.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/footable/js/footable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/footable/js/footable.sort.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/footable/js/footable.filter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/footable/js/footable.paginate.js" type="text/javascript"></script>

<!-- date formater -->
<script src="${pageContext.request.contextPath}/resources/dtpicker/js/jquery.dateFormat-1.0.js" type="text/javascript"></script>
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
	
	<script src="${pageContext.request.contextPath}/resources/sb-admin/js/bootstrap.js"></script>
</body>
</html>