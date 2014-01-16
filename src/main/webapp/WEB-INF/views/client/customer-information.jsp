<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="tr">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Rent A Car</title>

	<!-- bootstrap select before bootstrap v3 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.js"></script>
	
	<!-- bootstrap v3.0 -->
	<link href="${pageContext.request.contextPath}/resources/half-slider/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrapv3.js"></script>
	
	<!-- date time -->
	<link href="${pageContext.request.contextPath}/resources/dtpicker/bootstrapv3/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="${pageContext.request.contextPath}/resources/dtpicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	
	<!-- Add custom CSS here -->
	<link href="${pageContext.request.contextPath}/resources/half-slider/css/half-slider.css" rel="stylesheet">
	
	<link href="${pageContext.request.contextPath}/resources/modern-business.css" rel="stylesheet">
	
	<script type="text/javascript">
		$(window).on('load', function() {
			$('.selectpicker').selectpicker();
		});
	</script>

	<script type="text/javascript">
		$('#myCarousel').carousel({
			interval : 2000
		})
	</script>
	
	<style type="text/css">
		.reservation {
			margin: 0;
			position: initial;
		}
		
		.reservation .reservation-area {
			width: auto;
			position: initial;
		}
		
		.reservation .reservation-area .reservation-form {
			width: auto;
		}
		
		.navbar-inverse {
				background-color: #FFF;
				border-bottom: solid 1px #dcdcdc;
				opacity: 0.9;
				padding: 0;
				box-shadow: #dcdcdc 0 0 5px;
					-webkit-box-shadow: #dcdcdc 0 0 5px;
					-moz-box-shadow: #dcdcdc 0 0 5px;
					-ms-box-shadow: #dcdcdc 0 0 5px;
					-o-box-shadow: #dcdcdc 0 0 5px;
		}
		
		.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:hover, .navbar-inverse .navbar-nav>.active>a:focus {
			color: #FFF;
			background-color: #428bca;
			border-color: #357ebd;
		}
		
		.navbar-inverse .navbar-nav>li>a:hover {
			border-radius: 4px;
			background-color: #428bca;
			border-color: #357ebd;
		}
		
		#logo {
			width: 100px;
			height: 60px;
		}
		
		.navbar-nav {
			margin-top: 25px;
		}
		
		.navbar .navbar-nav li {
			margin: 0 5px 0;
		}
		
		.navbar .navbar-nav li a {
			display: inline-block;
			padding: 8px 16px;
			border-radius: 4px;
		}
	
	</style>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
          
          	<a class="navbar-brand" href="./">
          		<img id="logo" alt="" src="${ pageContext.request.contextPath }/resources/logo.jpg">
          	</a>
<!--           	<a class="" href="./"> -->
<!-- 				<img id="logo" alt="" src="./resources/logo.jpg"> -->
<!-- 		  	</a> -->
			</div>

        	<!-- Collect the nav links, forms, and other content for toggling -->
        	<div class="collapse navbar-collapse navbar-ex1-collapse">
          		<ul class="nav navbar-nav">
          			<li class="active"><a href="<c:url value='/' />">Ana Sayfa</a></li>
            		<li><a href="#">Hakkımızda</a></li>
            		<li><a href="#">Hizmetlerimiz</a></li>
            		<li><a href="#">İletişim</a></li>
            		<li><a href="#myModal" data-toggle="modal" data-target="#myModal">Rezervasyon İptali</a></li>
<!--             <li class="dropdown"> -->
<!--               <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a> -->
<!--               <ul class="dropdown-menu"> -->
<!--                 <li><a href="portfolio-1-col.html">1 Column Portfolio</a></li> -->
<!--                 <li><a href="portfolio-2-col.html">2 Column Portfolio</a></li> -->
<!--                 <li><a href="portfolio-3-col.html">3 Column Portfolio</a></li> -->
<!--                 <li><a href="portfolio-4-col.html">4 Column Portfolio</a></li> -->
<!--                 <li><a href="portfolio-item.html">Single Portfolio Item</a></li> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="dropdown"> -->
<!--               <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a> -->
<!--               <ul class="dropdown-menu"> -->
<!--                 <li><a href="blog-home-1.html">Blog Home 1</a></li> -->
<!--                 <li><a href="blog-home-2.html">Blog Home 2</a></li> -->
<!--                 <li><a href="blog-post.html">Blog Post</a></li> -->
<!--               </ul> -->
<!--             </li> -->
<!--             <li class="dropdown"> -->
<!--               <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a> -->
<!--               <ul class="dropdown-menu"> -->
<!--                 <li><a href="full-width.html">Full Width Page</a></li> -->
<!--                 <li><a href="sidebar.html">Sidebar Page</a></li> -->
<!--                 <li><a href="faq.html">FAQ</a></li> -->
<!--                 <li><a href="404.html">404</a></li> -->
<!--                 <li><a href="pricing.html">Pricing Table</a></li> -->
<!--               </ul> -->
<!--             </li> -->
          		</ul>
        	</div><!-- /.navbar-collapse -->
      	</div><!-- /.container -->
    </nav>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">Rezervasyon İptali</h4>
	      </div>
	      <div class="modal-body">
	      	
	      	<label for="resCode">Rezervasyon Kodunuz</label>
		    <input type="text" class="form-control" id="resCode" name="resCode" placeholder="Rezervasyon Kodunuz" />
	        
	        <div id="result" style="padding-top: 10px;"></div>
	      </div>
	      <div class="modal-footer">
	        <button id="modal-window" type="button" class="btn btn-default" data-dismiss="modal">Pencereyi Kapat</button>
	        <button type="button" class="btn btn-primary" onclick="cancelReservation()">İptal Et</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-4" style="padding-top: 100px;">
				<div class="reservation">
					<div class="reservation-area">
						<div class="reservation-form">
							<c:if test="${ !empty message }">
								<div class="alert alert-warning alert-dismissable">
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
									<strong> Uyarı! </strong><br/> ${ message }
								</div>
							</c:if>
					<form:form acceptCharset="UTF-8" action="search" commandName="rental" cssClass="form-vertical" method="get">
						<fieldset>
							<div class="form-group">
								<label class="col-md-6 control-label" for="selectbasic">Alış Yeri</label>
								<div class="col-md-12">
									<select id="pickupLocationId" name="pickupLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
										<option value="-1">Alış Yerini Seçin</option>
										<c:forEach items="${ servicePoints }" var="entry">
											<c:set var="branch" value="${ entry.key }" />
											<c:set var="allServicePoints" value="${ entry.value }" />
													
											<optgroup label="${ branch.county }">
												<c:forEach items="${ allServicePoints }" var="servPoint">
													<c:choose>
														<c:when test="${ rental.pickupLocation.id eq servPoint.id }">
															<option selected="selected" value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:when>
														<c:otherwise>
															<option value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</optgroup>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="dtp_input1" class="col-md-6 control-label">Alış Tarihi</label><br />
								<div id="#pickupdate" class="input-group date form_datetime col-md-12" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
									<input class="form-control" size="16" type="text" value="" readonly>
									<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
								</div>
								<input type="hidden" id="dtp_input1" name="pickupDateString" value="" /><br />
							</div>
							
							<div class="form-group">
								<label class="col-md-6 control-label">Teslim Yeri</label>
								<div class="col-md-12">
									<select id="returnLocationId" name="returnLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
										<option value="-1">Teslim Yerini Seçin</option>
										<c:forEach items="${ servicePoints }" var="entry">
											<c:set var="branch" value="${ entry.key }" />
											<c:set var="allServicePoints" value="${ entry.value }" />
													
											<optgroup label="${ branch.county }">
												<c:forEach items="${ allServicePoints }" var="servPoint">
													<c:choose>
														<c:when test="${ rental.returnLocation.id eq servPoint.id }">
															<option selected="selected" value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:when>
														<c:otherwise>
															<option value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</optgroup>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="dtp_input2" class="col-md-6 control-label">Teslim Tarihi</label><br />
								<div class="input-group date form_datetime2 col-md-12" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
									<input class="form-control" size="16" type="text" value="" readonly>
									<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
								</div>
								<input type="hidden" id="dtp_input2" name="returnDateString" value="" /><br />
							</div>
							
							<div class="form-group">
								<input type="submit" class="btn btn-info" value="Ara">
								<input type="reset" class="btn btn-default" value="Sıfırla">
							</div>
						</fieldset>
					</form:form>
					
					<input id="d1" type="hidden" value='<fmt:formatDate value="${ rental.pickupDate }" pattern="yyyy-MM-dd HH:mm"/>'>
					<input id="d2" type="hidden" value='<fmt:formatDate value="${ rental.returnDate }" pattern="yyyy-MM-dd HH:mm"/>'>
					</div>
					</div>
				</div>
			</div>

			<div class="col-lg-8 col-md-8 col-sm-8" style="padding-top: 60px;">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Temel Bilgiler<small> Aşağıdaki boşukları eksiksiz doldurun</small>
						</h1>
						<!-- customer information -->
						<form:form acceptCharset="UTF-8" action="add-rental" commandName="customerInf" cssClass="form-horizontal" method="post">
							<fieldset>
								<div class="form-group">
									<label for="name" class="col-md-2 control-label">Ad</label>
									<div class="col-md-5">
										<form:input path="name" id="name" placeholder="ad" cssClass="form-control" />
										<p class="help-block"><form:errors path="name" cssClass="text-danger" /></p>
									</div>
								</div>

								<div class="form-group">
									<label for="surname" class="col-md-2 control-label">Soyad</label>
									<div class="col-md-5">
										<form:input path="surname" id="surname" placeholder="soyad" cssClass="form-control" />
										<p class="help-block"><form:errors path="surname" cssClass="text-danger" /></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="phone" class="col-md-2 control-label">Cep Telf. Num</label>
									<div class="col-md-5">
										<form:input path="phone" id="phone" placeholder="telefon" cssClass="form-control bfh-phone" data-format="(ddd) ddd-dddd" />
										<p class="help-block"><form:errors path="phone" cssClass="text-danger" /></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="email" class="col-md-2 control-label">E-Mail</label>
									<div class="col-md-5">
										<form:input path="email" id="email" placeholder="email" cssClass="form-control" />
										<p class="help-block"><form:errors path="email" cssClass="text-danger" /></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="address" class="col-md-2 control-label">Adres</label>
									<div class="col-md-5">
										<form:textarea path="address" id="address" placeholder="adres detay" cssClass="form-control" />
										<p class="help-block"><form:errors path="address" cssClass="text-danger" /></p>
									</div>
								</div>
								
								<input type="submit" class="btn btn-info" value="Tamam">
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>	
		
		<footer>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; gceylan 2013 &middot; Home &middot; About &middot; Services &middot; Contact &middot; Rezervasyon İptal</p>
				</div>
			</div>
		</footer>
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

// 		var d1 = '${rental.pickupDate}';
// 		var d2 = '${rental.returnDate}';
		
// 		$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
// 		$('.form_datetime').datetimepicker('update', new Date(pickupDate));
// 		$('.form_datetime2').datetimepicker('update', new Date('2014-11-24 15:00'));

		$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
		$(".form_datetime2").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
		
		$('.form_datetime').datetimepicker('update', new Date($('#d1').val()));
		$('.form_datetime2').datetimepicker('update', new Date($('#d2').val()));

	</script>
	
	<script src="http://bootstrapformhelpers.com/assets/js/bootstrap-formhelpers.min.js"></script>

</body>
</html>