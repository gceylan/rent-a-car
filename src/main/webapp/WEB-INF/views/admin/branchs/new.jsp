<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>

<div class="row">
	<c:url var="addBranchUrl" value="/admin/branchs/new" />
	<form:form cssClass="form-horizontal" role="form" method="POST" accept-charset="UTF-8" action="${ addBranchUrl }" commandName="branchForm">
		<fieldset>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Şube Müdürünün Bilgileri</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="firstname" class="col-lg-3 control-label">Ad</label>
						<div class="col-lg-9">
							<form:input path="manager.firstname" cssClass="form-control" id="firstname" placeholder="Ad" />
							<p class="help-block"><form:errors path="manager.firstname" cssClass="text-danger"/></p>
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-lg-3 control-label">Soyad</label>
						<div class="col-lg-9">
							<form:input path="manager.lastname" cssClass="form-control" id="lastname" placeholder="Soyad" />
							<p class="help-block"><form:errors path="manager.lastname" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-lg-3 control-label">Email</label>
						<div class="col-lg-9">
							<form:input path="manager.email" cssClass="form-control" id="email" placeholder="Email" />
							<p class="help-block"><form:errors path="manager.email" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-lg-3 control-label">Kullanıcı Adı</label>
						<div class="col-lg-9">
							<form:input path="manager.username" cssClass="form-control" id="username" placeholder="Kullanıcı Adı" />
							<p class="help-block"><form:errors path="manager.username" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-lg-3 control-label">Parola</label>
						<div class="col-lg-9">
							<form:input path="manager.password" cssClass="form-control" id="password" placeholder="Parola" />
							<p class="help-block"><form:errors path="manager.password" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-lg-3 control-label">Roller</label>
						<div class="col-lg-9">
							<form:radiobuttons path="manager.role" cssClass="checkbox-inline"
								items="${ allRoles }" itemValue="name" itemLabel="name" />
		<%-- 					<form:checkboxes path="role" cssClass="checkbox-inline" --%>
		<%-- 						items="${ allRoles }" itemValue="name" itemLabel="name" /> --%>
							<p class="help-block"><form:errors path="manager.role" /></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Şube Bilgileri</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="branch.branchCode" class="col-lg-3 control-label">Şube Kodu</label>
						<div class="col-lg-9">
							<form:input path="branch.branchCode" cssClass="form-control" id="branch.branchCode" placeholder="Şube Kodu" />
							<p class="help-block"><form:errors path="branch.branchCode" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.name" class="col-lg-3 control-label">Şube Adı</label>
						<div class="col-lg-9">
							<form:input path="branch.name" cssClass="form-control" id="branch.name" placeholder="Şube Adı" />
							<p class="help-block"><form:errors path="branch.name" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.county" class="col-lg-3 control-label">İl</label>
						<div class="col-lg-9">
							<form:input path="branch.county" cssClass="form-control" id="branch.county" placeholder="İl" />
							<p class="help-block"><form:errors path="branch.county" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.town" class="col-lg-3 control-label">İlçe</label>
						<div class="col-lg-9">
							<form:input path="branch.town" cssClass="form-control" id="branch.town" placeholder="İlçe" />
							<p class="help-block"><form:errors path="branch.town" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.address" class="col-lg-3 control-label">Adres</label>
						<div class="col-lg-9">
							<form:input path="branch.address" cssClass="form-control" id="branch.address" placeholder="Adres" />
							<p class="help-block"><form:errors path="branch.address" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.phone" class="col-lg-3 control-label">Telefon</label>
						<div class="col-lg-9">
							<form:input path="branch.phone" cssClass="form-control" id="branch.phone" placeholder="Telefon" />
							<p class="help-block"><form:errors path="branch.phone" cssClass="text-danger" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="branch.postalCode" class="col-lg-3 control-label">Posta Kodu</label>
						<div class="col-lg-9">
							<form:input path="branch.postalCode" cssClass="form-control" id="branch.postalCode" placeholder="Posta Kodu" />
							<p class="help-block"><form:errors path="branch.postalCode" cssClass="text-danger" /></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		</fieldset>
		<div class="form-group">
			<div class="col-lg-12">
				<button type="submit" class="btn btn-default btn-block">Ekle</button>
			</div>
		</div>
	</form:form>
</div>