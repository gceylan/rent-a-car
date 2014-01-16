<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!-- bootstrap select before bootstrap v3 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.js"></script>

<script type="text/javascript">
	$(window).on('load', function() {
		$('.selectpicker').selectpicker();
	});
</script>

<!-- date time -->
<%-- <link href="${pageContext.request.contextPath}/resources/dtpicker/bootstrapv3/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"> --%>
<link href="${pageContext.request.contextPath}/resources/dtpicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<input id="contextPath" type="hidden" value="${ pageContext.request.contextPath }" />

<input id="d1" type="hidden" value='<fmt:formatDate value="${ rental.pickupDate }" pattern="yyyy-MM-dd HH:mm"/>'>
<input id="d2" type="hidden" value='<fmt:formatDate value="${ rental.returnDate }" pattern="yyyy-MM-dd HH:mm"/>'>

<c:if test="${ !empty message }">
	<div class="alert alert-warning alert-dismissable">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		<strong>${ message }</strong>
	</div>
</c:if>

<div class="row">
	<c:url var="action" value="/branch/reservations/edit/${ rental.id }" />
	<form:form id="editRentalForm" accept-charset="UTF-8" method="POST" commandName="rental" action="${ action }" cssClass="form-horizontal" role="form">
		<!-- hangi sayfadan gelindiyse, güncelleme sonunda o sayfaya dön -->
		<input type="hidden" name="path" value="${ from }">
		<fieldset>
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Rezervasyon Bilgileri</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
			   				<label class="col-lg-4 control-label">Rezervasyon Kodu</label>
			   				<div class="col-lg-8">
			   					<input id="resCode" class="form-control" size="16" type="text" value="${ rental.reservationCode }" readonly>
			   				</div>
			 			</div>
			 				
			 			<div class="form-group">
			   				<label class="col-lg-4 control-label">Rezervasyon Tarihi</label>
			   				<div class="col-lg-8">
			   					<input id="resDate" class="form-control" size="16" type="text" value='<fmt:formatDate type="both" dateStyle="long" timeStyle="medium" value="${ rental.reservationDate }" />' readonly>
			   				</div>
			 			</div>
					
						<div class="form-group">
							<label class="col-lg-4 control-label" for="selectbasic">Alış Yeri</label>
							<div class="col-lg-8">
								<select id="pickupLocationId" name="pickupLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
									<option value="-1">Alış Yerini Seçin</option>
									<c:forEach items="${ locations }" var="location">
										<c:choose>
											<c:when test="${ rental.pickupLocation.id eq location.id }">
												<option selected="selected" value="${ location.id }">${ location.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${ location.id }">${ location.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
											
						<div class="form-group">
							<label for="dtp_input1" class="col-lg-4 control-label">Alış Tarihi</label>
							<div class="input-group date form_datetime col-lg-8" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
								<input class="form-control" size="16" type="text" value="" readonly>
								<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
							</div>
							<input type="hidden" id="dtp_input1" name="pickupDateString" value="" /><br />
						</div>
						
						<div class="form-group">
							<label class="col-lg-4 control-label">Teslim Yeri</label>
							<div class="col-lg-8">
								<select id="returnLocationId" name="returnLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
									<option value="-1">Teslim Yerini Seçin</option>
									<c:forEach items="${ locations }" var="location">
										<c:choose>
											<c:when test="${ rental.returnLocation.id eq location.id }">
												<option selected="selected" value="${ location.id }">${ location.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${ location.id }">${ location.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="dtp_input2" class="col-lg-4 control-label">Teslim Tarihi</label>
							<div class="input-group date form_datetime2 col-lg-8" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
								<input class="form-control" size="16" type="text" value="" readonly>
								<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
							</div>
							<input type="hidden" id="dtp_input2" name="returnDateString" value="" /><br />
						</div>
						
						<div class="form-group">
			   				<label class="col-lg-4 control-label">Seçilen Araç</label>
			   				<div class="col-lg-8">
			   					<select id="selectedCarId" name="selectedCarId" class="selectpicker show-tick form-control" data-live-search="true" data-size="5" style="display: none;">
									<c:forEach items="${ cars }" var="c">
										<c:choose>
											<c:when test="${ rental.car.id eq c.id }">
												<option selected="selected" value="${ rental.car.id }">${c.licensePlate} - ${ c.brand } ${ c.model }</option>
											</c:when>
											<c:otherwise>
												<option value="${ c.id }">${c.licensePlate} - ${ c.brand } ${ c.model }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
			   				</div>
			 			</div>
					</div>
				</div>
			</div>
		
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Rezervasyon Müşteri Bilgileri</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
				   			<label class="col-lg-4 control-label">Ad</label>
				   			<div class="col-lg-8">
				   				<input class="form-control" size="16" type="text" value='${ rental.customerName }' readonly>
				   			</div>
				 		</div>
				 		<div class="form-group">
				   			<label class="col-lg-4 control-label">Soyad</label>
				   			<div class="col-lg-8">
				   				<input class="form-control" size="16" type="text" value='${ rental.customerSurname }' readonly>
				   			</div>
				 		</div>
				 		<div class="form-group">
				   			<label class="col-lg-4 control-label">Cep</label>
				   			<div class="col-lg-8">
				   				<input class="form-control" size="16" type="text" value='${ rental.customerPhone }' readonly>
				   			</div>
				 		</div>
				 		<div class="form-group">
				   			<label class="col-lg-4 control-label">E-Mail</label>
				   			<div class="col-lg-8">
				   				<input class="form-control" size="16" type="text" value='${ rental.customerEmail }' readonly>
				   			</div>
				 		</div>
					</div>
				</div>
			</div>
		</fieldset>
		
		<div class="col-lg-6">
			<input type="submit" class="btn btn-info btn-block" value="Güncelle">
		</div>
	</form:form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/dtpicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/dtpicker/js/locales/bootstrap-datetimepicker.tr.js" charset="UTF-8"></script>
<script type="text/javascript">
	$('.form_datetime').datetimepicker({
		language : 'tr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		pickerPosition : "bottom-left"
	});
	$('.form_datetime2').datetimepicker({
		language : 'tr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		pickerPosition : "bottom-left"
	});

	$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
	$(".form_datetime2").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
	
	$('.form_datetime').datetimepicker('update', new Date($('#d1').val()));
	$('.form_datetime2').datetimepicker('update', new Date($('#d2').val()));

</script>

<script src="http://bootstrapformhelpers.com/assets/js/bootstrap-formhelpers.min.js"></script>