<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="action" value="${ pageContext.request.contextPath }/admin/cars/edit/${ car.id }" />

<div class="row">
	<div class="col-lg-6">
		<form:form accept-charset="ISO-8859-9" commandName="car" action="${ action }" method="post" cssClass="form-horizontal" role="form">
			<div class="form-group">
				<label for="licensePlate" class="col-lg-3 control-label">Plaka</label>
				<div class="col-lg-9">
					<form:input path="licensePlate" cssClass="form-control" id="licensePlate" placeholder="Plaka" />
					<p class="help-block"><form:errors path="licensePlate" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="brand" class="col-lg-3 control-label">Marka</label>
				<div class="col-lg-9">
					<form:input path="brand" cssClass="form-control" id="brand" placeholder="Marka" />
					<p class="help-block"><form:errors path="brand" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="model" class="col-lg-3 control-label">Model</label>
				<div class="col-lg-9">
					<form:input path="model" cssClass="form-control" id="model" placeholder="Model" />
					<p class="help-block"><form:errors path="model" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="color" class="col-lg-3 control-label">Renk</label>
				<div class="col-lg-9">
					<form:input path="color" cssClass="form-control" id="color" placeholder="Renk" />
					<p class="help-block"><form:errors path="color" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="owner" class="col-lg-3 control-label">Araç Sahibi</label>
				<div class="col-lg-9">
					<form:input path="owner" cssClass="form-control" id="owner" placeholder="Araç Sahibi" />
					<p class="help-block"><form:errors path="owner" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="ownerEmail" class="col-lg-3 control-label">Araç Sahibi - Email</label>
				<div class="col-lg-9">
					<form:input path="ownerEmail" cssClass="form-control" id="ownerEmail" placeholder="Email" />
					<p class="help-block"><form:errors path="ownerEmail" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="ownerPhone" class="col-lg-3 control-label">Araç Sahibi - Telefon</label>
				<div class="col-lg-9">
					<form:input path="ownerPhone" cssClass="form-control" id="ownerPhone" placeholder="Telefon" />
					<p class="help-block"><form:errors path="ownerPhone" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="pricePerDay" class="col-lg-3 control-label">Günlük Fiyat</label>
				<div class="col-lg-9">
					<form:input path="pricePerDay" cssClass="form-control" id="pricePerDay" placeholder="Günlük Fiyat" />
					<p class="help-block"><form:errors path="pricePerDay" /></p>
				</div>
			</div>			
			<div class="form-group">
				<div class="col-lg-offset-3 col-lg-9">
					<button type="submit" class="btn btn-default">Aracı Güncelle</button>
				</div>
			</div>
		</form:form>
	</div>
</div>