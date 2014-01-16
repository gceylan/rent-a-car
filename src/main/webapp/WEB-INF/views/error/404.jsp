<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value='/resources/sb-admin/css/bootstrap.css" rel="stylesheet' />">
</head>
<body>
	<div class="container" align="center">
		<div class="row">
			<div class="span12">
				<div class="hero-unit center">
					<h2>
						Sayfa Bulunamadı! <small><font face="Tahoma" color="red">Hata 404</font></small>
						<br><br>
						<a href="<c:url value="/" />" class="btn btn-large btn-info">
							<i class="icon-home icon-white"></i> Ana Sayfa
						</a>
						<img class="img-responsive" src="<c:url value='/resources/404_2.jpg' />">
					</h2>
				</div>
				<br />
			</div>
		</div>
	</div>
</body>
</html>