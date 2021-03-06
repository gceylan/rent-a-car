<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="row">
	<div class="col-lg-6">
		<c:url var="action" value="/branch/employees/edit/${ employee.id }" />
		<form:form cssClass="form-horizontal" role="form" method="post" accept-charset="UTF-8" action="${ action }" commandName="employee">
			<div class="form-group">
				<label for="firstname" class="col-lg-3 control-label">Ad</label>
				<div class="col-lg-9">
					<form:input path="firstname" cssClass="form-control" id="firstname" placeholder="Ad" />
					<p class="help-block"><form:errors path="firstname" cssClass="text-danger" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-lg-3 control-label">Soyad</label>
				<div class="col-lg-9">
					<form:input path="lastname" cssClass="form-control" id="lastname" placeholder="Soyad" />
					<p class="help-block"><form:errors path="lastname" cssClass="text-danger" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-lg-3 control-label">Email</label>
				<div class="col-lg-9">
					<form:input path="email" cssClass="form-control" id="email" placeholder="Email" />
					<p class="help-block"><form:errors path="email" cssClass="text-danger" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-lg-3 control-label">Kullanıcı Adı</label>
				<div class="col-lg-9">
					<form:input path="username" cssClass="form-control" id="username" placeholder="Kullanıcı Adı" />
					<p class="help-block"><form:errors path="username" cssClass="text-danger" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-3 control-label">Parola</label>
				<div class="col-lg-9">
					<form:input path="password" cssClass="form-control" id="password" placeholder="Parola" />
					<p class="help-block"><form:errors path="password" cssClass="text-danger" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="" class="col-lg-3 control-label">Roller</label>
				<div class="col-lg-9">
					<form:radiobuttons path="role" cssClass="checkbox-inline"
						items="${ allRoles }" itemValue="name" itemLabel="name" />
<%-- 					<form:checkboxes path="role" cssClass="checkbox-inline" --%>
<%-- 						items="${ allRoles }" itemValue="name" itemLabel="name" /> --%>
					<p class="help-block"><form:errors path="role" cssClass="text-danger" /></p>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-9">
					<button type="submit" class="btn btn-default">Güncelle</button>
				</div>
			</div>
		</form:form>
	</div>
</div>