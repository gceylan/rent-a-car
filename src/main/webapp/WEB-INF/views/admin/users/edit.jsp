<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="row">
	<div class="col-lg-6">
		<form:form cssClass="form-horizontal" role="form" commandName="user" method="post" accept-charset="ISO-8859-9" action="${ pageContext.request.contextPath }/admin/users/edit/${ user.id }">
			<div class="form-group">
				<label for="firstname" class="col-lg-3 control-label">Ad</label>
				<div class="col-lg-9">
					<form:input path="firstname" cssClass="form-control" id="firstname" placeholder="Ad" />
					<p class="help-block"><form:errors path="firstname" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-lg-3 control-label">Soyad</label>
				<div class="col-lg-9">
					<form:input path="lastname" cssClass="form-control" id="lastname" placeholder="Soyad" />
					<p class="help-block"><form:errors path="lastname" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-lg-3 control-label">Email</label>
				<div class="col-lg-9">
					<form:input path="email" cssClass="form-control" id="email" placeholder="Email" />
					<p class="help-block"><form:errors path="email" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-3 control-label">Kullanıcı Adı</label>
				<div class="col-lg-9">
					<form:input path="username" cssClass="form-control" id="username" placeholder="Kullanıcı Adı" />
					<p class="help-block"><form:errors path="username" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-3 control-label">Parola</label>
				<div class="col-lg-9">
					<form:input path="password" cssClass="form-control" id="password" placeholder="Parola" />
					<p class="help-block"><form:errors path="password" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-lg-3 control-label">Roller</label>
				<div class="col-lg-9">
					<form:checkboxes path="roles" cssClass="checkbox-inline"
						items="${ allRoles }" itemValue="name" itemLabel="name" />
					<p class="help-block"><form:errors path="roles" /></p>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-offset-3 col-lg-9">
					<input type="submit" class="btn btn-primary" value="Güncelle" />
				</div>
			</div>
		</form:form>
	</div>
</div>