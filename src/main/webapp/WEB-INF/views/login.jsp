<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<html>
<head>
<!-- Bootstrap core CSS -->
<link href="${ pageContext.request.contextPath }/resources/sb-admin/css/bootstrap.css" rel="stylesheet">

</head>
<body>

	<div class="container" style="margin-top: 100px;">
		<div class="row">
			<div class="container">
				<div class="col-sm-offset-4 col-sm-4 well">
					<form method="POST" accept-charset="UTF-8" action="<c:url value="j_spring_security_check" />">
						<legend>Sisteme Giriş</legend>
						
						<c:if test="${ error }">
							<div class="alert alert-danger">
								Geçersin Kullanıcı Adı ve/veya Parola
							</div>
						</c:if>
						
						<div class="control-group">
							<div class="controls">
								<input type="text" class="form-control"
									id="username" required="required"
									name="j_username"
									placeholder="Kullanıcı Adı"
									value="gceylan" />
							</div>
							<p class="help-block"></p>
						</div>
						
						<div class="control-group">
							<div class="controls">
								<input type="password" class="form-control"
									id="password" required="required"
									name="j_password"
									placeholder="Parola"
									value="12345678" />
							</div>
							<p class="help-block"></p>
						</div>
						
						<input type="submit" class="btn btn-primary btn-block" value="Login" >
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		document.getElementById('username').focus();
	</script>
</body>
</html>