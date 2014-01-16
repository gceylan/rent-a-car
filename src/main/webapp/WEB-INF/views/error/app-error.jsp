<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value='/resources/sb-admin/css/bootstrap.css" rel="stylesheet' />">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="hero-unit center">
					<h2 align="center">
						Uygulama Hatası! <small><font face="Tahoma" color="red">Uygulama Hatası</font></small>
						<a href="<c:url value="/" />" class="btn btn-large btn-info">
							<i class="icon-home icon-white"></i> Ana Sayfa
						</a>
					</h2>
					<p>
						<c:if test="${ !empty errorMessage }">
							<c:out value="${ errorMessage }" />
						</c:if>
					</p>
				</div>
				<br />
			</div>
		</div>
	</div>
</body>
</html>