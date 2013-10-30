<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="action" value="${ pageContext.request.contextPath }/admin/locations/new" />

<div class="row">
	<div class="col-lg-6">
		<form:form cssClass="form-horizontal" role="form" method="post" accept-charset="ISO-8859-9" action="${ action }" commandName="location">
			<div class="form-group">
				<label for="name" class="col-lg-3 control-label">Hizmet Noktası Adı</label>
				<div class="col-lg-9">
					<form:input path="name" cssClass="form-control" id="name" placeholder="Hizmet Noktası Adı" />
					<p class="help-block"><form:errors path="name" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-lg-3 control-label">Adres</label>
				<div class="col-lg-9">
					<form:input path="address" cssClass="form-control" id="address" placeholder="Adres" />
					<p class="help-block"><form:errors path="address" /></p>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-3 col-lg-9">
					<button type="submit" class="btn btn-default">Ekle</button>
				</div>
			</div>
		</form:form>
	</div>
</div>