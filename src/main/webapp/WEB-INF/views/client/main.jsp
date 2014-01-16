<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="tr">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="gceylan">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<!-- bootstrap select before bootstrap v3 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery1-10-1.js"></script>
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
	
	<script type='text/javascript'>
	    $(document).ready(function() {
	         $('.carousel').carousel({
	             interval: 7000
	         });
	    });    
	</script>
	
	<style type="text/css">
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
	
	<div id="myCarousel" class="carousel slide">
      <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg');"></div>
            <div class="carousel-caption">
              <h1>Modern Business - A Bootstrap 3 Template</h1>
            </div>
          </div>
          <div class="item">
            <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/half-slider/b1.jpg');"></div>
            <div class="carousel-caption">
              <h1>Ready to Style &amp; Add Content</h1>
            </div>
          </div>
          <div class="item">
            <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/half-slider/b3.jpg');"></div>
            <div class="carousel-caption">
              <h1>Additional Layout Options at <a href="http://startbootstrap.com">http://startbootstrap.com</a></h1>
            </div>
          </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
          <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
          <span class="icon-next"></span>
        </a>
    </div>
    
<!-- 	<div class="row" style="height: 400px;"> -->
<!-- 		<div id="myCarousel" class="carousel slide"> -->
<!-- 			<ol class="carousel-indicators"> -->
<!-- 				<li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 				<li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 				<li data-target="#myCarousel" data-slide-to="2"></li> -->
<!-- 			</ol> -->
			
<!-- 			<div class="carousel-inner"> -->
<!-- 				<div class="item active fill"> -->
<%-- 					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg"> --%>
<!-- 					<div class="carousel-caption"></div> -->
<!-- 				</div> -->
<!-- 				<div class="item fill"> -->
<%-- 					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg"> --%>
<!-- 					<div class="carousel-caption"> -->
<!-- 						<h1>Caption 3</h1> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="item fill"> -->
<%-- 					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg"> --%>
<!-- 					<div class="carousel-caption"> -->
<!-- 						<h1>Caption 3</h1> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
<!-- 			<a class="left carousel-control" href="#myCarousel" data-slide="prev"> -->
<!-- 				<span class="icon-prev"></span> -->
<!-- 			</a> -->
<!-- 			<a class="right carousel-control" href="#myCarousel" data-slide="next"> -->
<!-- 				<span class="icon-next"></span> -->
<!-- 			</a> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="reservation">
					<div class="reservation-area">
						<div class="reservation-form">
							<h4>Online Rezervasyon</h4>
							<c:if test="${ !empty message }">
								<div class="alert alert-warning alert-dismissable">
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
									<strong>Uyarı!</strong> ${ message }
								</div>
							</c:if>
							
							<c:url var="action" value='search' />
							
							<form:form acceptCharset="UTF-8" action="${ action }" commandName="rental" cssClass="form-horizontal" method="get">
								<fieldset>
									<div class="form-group">
										<label class="col-md-3 control-label" for="selectbasic">Alış Yeri</label>
										<div class="col-md-9">
<%-- 											<form:select path="pickupLocation" cssClass="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;"> --%>
<%-- 												<form:option value="NONE" label="--- Alış Yerini Seçin ---"/> --%>
<%-- 												<form:options items="${locations}" itemValue="id" itemLabel="name" /> --%>
<%-- 											</form:select> --%>
											<select id="pickupLocationId" name="pickupLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
												<option value="-1">Alış Yerini Seçin</option>
<%-- 												<c:forEach items="${ servicePoints }" var="sp"> --%>
<%-- 													<option data-subtext="${ sp.branch.county }" value="${ sp.id }">${ sp.name }</option> --%>
<%-- 												</c:forEach> --%>
												
												<c:forEach items="${ servicePoints }" var="entry">
													<c:set var="branch" value="${ entry.key }" />
													<c:set var="allServicePoints" value="${ entry.value }" />
													
													<optgroup label="${ branch.county }">
														<c:forEach items="${ allServicePoints }" var="servPoint">
															<option value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:forEach>
													</optgroup>
<%-- 													<option data-subtext="${ sp.branch.county }" value="${ sp.id }">${ sp.name }</option> --%>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label for="dtp_input1" class="col-md-3 control-label">Alış Tarihi</label>
										<div class="input-group date form_datetime col-md-9" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
											<input class="form-control" size="16" type="text" value="" readonly>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
										</div>
										<input type="hidden" id="dtp_input1" name="pickupDateString" value="" /><br />
									</div>
									
									<div class="form-group">
										<label class="col-md-3 control-label">Teslim Yeri</label>
										<div class="col-md-9">
											<select id="returnLocationId" name="returnLocationId" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
												<option value="-1">Teslim Yerini Seçin</option>
												<c:forEach items="${ servicePoints }" var="entry">
													<c:set var="branch" value="${ entry.key }" />
													<c:set var="allServicePoints" value="${ entry.value }" />
													
													<optgroup label="${ branch.county }">
														<c:forEach items="${ allServicePoints }" var="servPoint">
															<option value="${ servPoint.id }" data-subtext="${ servPoint.branch.county }">${ servPoint.name }</option>
														</c:forEach>
													</optgroup>
<%-- 													<option data-subtext="${ sp.branch.county }" value="${ sp.id }">${ sp.name }</option> --%>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="dtp_input2" class="col-md-3 control-label">Teslim Tarihi</label>
										<div class="input-group date form_datetime2 col-md-9" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
											<input class="form-control" size="16" type="text" value="" readonly>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
										</div>
										<input type="hidden" id="dtp_input2" name="returnDateString" value="" /><br />
									</div>

									<input type="submit" class="btn btn-primary" value="Ara">
									<input type="reset" class="btn btn-default" value="Sıfırla">
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${ !empty rentalInf }">
		<div class="modal fade" id="rentalResultModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        		<h4 class="modal-title" id="myModalLabel">Rezervasyonunuz İletildi</h4>
		      		</div>
		      		<div class="modal-body">
						<p>
		        			Sayın <b>${rentalInf.customerName} ${rentalInf.customerSurname},</b>
		        		</p>
		        		
		        		<p>
		        			<b>
		        				<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${rentalInf.pickupDate}" /> -
		        				<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${rentalInf.returnDate}" />
		        			</b>
		        			tarihleri arasına yapmış olduğunuz 
		        			<b>
		        				${rentalInf.pickupLocation.name} - ${rentalInf.returnLocation.name}</b> rezervasyonunuz kaydedildi.
		        		</p>
		        		<p>
		        			Yöneticinin onayından sonra rezervasyon kodunuz mail adresine iletilecektir.
		        		</p>
		        		<p>
		        			İyi günler dileriz...
		        		</p>
		      		</div>
		      		<div class="modal-footer">
		        		<button type="button" class="btn btn-default" data-dismiss="modal">Pencereyi Kapat</button>
		      		</div>
		    	</div>
		  	</div>
		</div>
	</c:if>
	
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<h3><i class="fa fa-check-circle"></i> Bootstrap 3 Built</h3>
					<p>The 'Modern Business' website template by <a href="http://startbootstrap.com">Start Bootstrap</a> is built with <a href="http://getbootstrap.com">Bootstrap 3</a>. Make sure you're up to date with latest Bootstrap documentation!</p>
				</div>
				<div class="col-lg-4 col-md-4">
					<h3><i class="fa fa-pencil"></i> Ready to Style &amp; Edit</h3>
					<p>You're ready to go with this pre-built page structure, now all you need to do is add your own custom stylings! You can see some free themes over at <a href="http://bootswatch.com">Bootswatch</a>, or come up with your own using <a href="http://getbootstrap.com/customize/">the Bootstrap customizer</a>!</p>
				</div>
				<div class="col-lg-4 col-md-4">
					<h3><i class="fa fa-folder-open"></i> Many Page Options</h3>
					<p>This template features many common pages that you might see on a business website. Pages include: about, contact, portfolio variations, blog, pricing, FAQ, 404, services, and general multi-purpose pages.</p>
				</div>
			</div>
		</div>
    </div>
    
    <div class="section-colored text-center">

      <div class="container">

        <div class="row">
          <div class="col-lg-12">
            <h2>Modern Business: A Clean &amp; Simple Full Website Template by Start Bootstrap</h2>
            <p>A complete website design featuring various single page templates from Start Bootstraps library of free HTML starter templates.</p>
            <hr>
          </div>
        </div><!-- /.row -->

      </div><!-- /.container -->

    </div><!-- /.section-colored -->

    <div class="section">

      <div class="container">

        <div class="row">
          <div class="col-lg-12 text-center">
            <h2>Display Some Work on the Home Page Portfolio</h2>
            <hr>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <a href="portfolio-item.html"><img class="img-responsive img-home-portfolio" src="http://placehold.it/700x450"></a>
          </div>
        </div><!-- /.row -->

      </div><!-- /.container -->

    </div><!-- /.section -->

    <div class="section-colored">

      <div class="container">

        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <h2>Modern Business Features Include:</h2>
            <ul>
              <li>Bootstrap 3 Framework</li>
              <li>Mobile Responsive Design</li>
              <li>Predefined File Paths</li>
              <li>Working PHP Contact Page</li>
              <li>Minimal Custom CSS Styles</li>
              <li>Unstyled: Add Your Own Style and Content!</li>
              <li>Font-Awesome fonts come pre-installed!</li>
              <li>100% <strong>Free</strong> to Use</li>
              <li>Open Source: Use for any project, private or commercial!</li>
            </ul>
          </div>
          <div class="col-lg-6 col-md-6 col-sm-6">
            <img class="img-responsive" src="http://placehold.it/700x450/ffffff/cccccc">
          </div>
        </div><!-- /.row -->

      </div><!-- /.container -->

    </div><!-- /.section-colored -->

    <div class="section">

      <div class="container">

        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <img class="img-responsive" src="http://placehold.it/700x450">
          </div>
          <div class="col-lg-6 col-md-6 col-sm-6">
            <h2>Modern Business Features Include:</h2>
            <ul>
              <li>Bootstrap 3 Framework</li>
              <li>Mobile Responsive Design</li>
              <li>Predefined File Paths</li>
              <li>Working PHP Contact Page</li>
              <li>Minimal Custom CSS Styles</li>
              <li>Unstyled: Add Your Own Style and Content!</li>
              <li>Font-Awesome fonts come pre-installed!</li>
              <li>100% <strong>Free</strong> to Use</li>
              <li>Open Source: Use for any project, private or commercial!</li>
            </ul>
          </div>
        </div><!-- /.row -->

      </div><!-- /.container -->

    </div><!-- /.section -->

    <div class="container">

      <div class="row well">
        <div class="col-lg-8 col-md-8">
          <h4>'Modern Business' is a ready-to-use, Bootstrap 3 updated, multi-purpose HTML theme!</h4>
          <p>For more templates and more page options that you can integrate into this website template, visit Start Bootstrap!</p>
        </div>
        <div class="col-lg-4 col-md-4">
          <a class="btn btn-lg btn-primary pull-right" href="http://startbootstrap.com">See More Templates!</a>
        </div>
      </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="container">

      <hr>

      <footer>
        <div class="row">
          <div class="col-lg-12">
            <p>Copyright &copy; Company 2013</p>
          </div>
        </div>
      </footer>

    </div><!-- /.container -->

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
</script>

<script type="text/javascript">
	// iptal işlemi
	function cancelReservation() {
		var resCode = $('#resCode').val();

		if (resCode.length == 0) {
			$('#result').html('<p class="text-danger"> Rezervasyon kodunuzu girmediniz! </p>');
			return;
		}
		
		var contextPath = '${pageContext.request.contextPath}';

		$.ajax({
			type: "POST",
			url: contextPath + "/cancel-reservation",
			data: "resCode=" + resCode,
			success: function(response){
				$('#result').html(response);
				$('#resCode').val('');
			},
			error: function(e){
				alert('Error: ' + e);
			}
		});
					
	}

	// pencere kapatıldığında, orada yazılanlar gizlensin
	$('#modal-window').click(function() {
		$('#result').html('');
	});

	$('#rentalResultModal').modal('show');
</script>

</body>
</html>