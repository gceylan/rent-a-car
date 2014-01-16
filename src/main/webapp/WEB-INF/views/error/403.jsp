<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="${ pageContext.request.contextPath }/resources/sb-admin/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container" align="center">
		<div class="row">
			<div class="span12">
				<div class="hero-unit center">
					<h2>
						Bu sayfayı görüntülemeye yetkiniz yok! <small>
						<font face="Tahoma" color="red">Hata 403</font></small>
						<br><br>
						<a href="<c:url value="/logout" />" class="btn btn-large btn-info">
							<i class="icon-home icon-white"></i> Çıkış
						</a>
					</h2>
				</div>
				<br />
			</div>
		</div>
	</div>
</body>
</html>