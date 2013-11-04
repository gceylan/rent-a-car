<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rent A Car</title>

<!-- bootstrap select before bootstrap v3 -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.js"></script>

<!-- bootstrap v3.0 -->
<link href="${pageContext.request.contextPath}/resources/half-slider/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<!-- date time -->
<link href="${pageContext.request.contextPath}/resources/dtpicker/bootstrapv3/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/dtpicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<!-- Add custom CSS here -->
<link href="${pageContext.request.contextPath}/resources/half-slider/css/half-slider.css" rel="stylesheet">

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

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="client">Classic Rent A Car</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#about">About</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="row" style="height: 400px;">
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			
			<div class="carousel-inner">
				<div class="item active fill">
					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg">
					<div class="carousel-caption"></div>
				</div>
				<div class="item fill">
					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg">
					<div class="carousel-caption">
						<h1>Caption 3</h1>
					</div>
				</div>
				<div class="item fill">
					<img alt="" src="${pageContext.request.contextPath}/resources/half-slider/main_banner.jpg">
					<div class="carousel-caption">
						<h1>Caption 3</h1>
					</div>
				</div>
			</div>
			
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="icon-prev"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="icon-next"></span>
			</a>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="reservation">
					<div class="reservation-area">
						<div class="reservation-form">
							<h4>Online Rezervasyon</h4>
							<form action="" class="form-horizontal" role="form">
								<fieldset>
									<div class="form-group">
										<label class="col-md-3 control-label" for="selectbasic">Alış Yeri</label>
										<div class="col-md-8">
											<select id="selectbasic" name="selectbasic" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
												<option>Alış Yerini Seçin</option>
												<c:forEach items="${ locations }" var="loc">
													<option>${ loc.name }</option>
												</c:forEach>
												<!-- example data -->
												<optgroup label="Samsun">
													<option>Yeşilyurt</option>
													<option>Büyük Otel</option>
													<option>Mecidiye</option>
												</optgroup>
												<optgroup label="Ankara">
													<option>Etimesgut</option>
													<option>ARNOVA</option>
													<option>Kızılören</option>
												</optgroup>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label for="dtp_input1" class="col-md-3 control-label">Alış Tarihi</label>
										<div class="input-group date form_datetime col-md-8" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
											<input class="form-control" size="16" type="text" value="" readonly>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
										</div>
										<input type="hidden" id="dtp_input1" value="" /><br />
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Teslim Yeri</label>
										<div class="col-md-8">
											<select id="selectbasic" name="selectbasic" class="selectpicker form-control" data-live-search="true" data-size="5" style="display: none;">
												<option>Teslim Yerini Seçin</option>
												<c:forEach items="${ locations }" var="loc">
													<option>${ loc.name }</option>
												</c:forEach>
												<!-- example data -->
												<optgroup label="Samsun">
													<option>Yeşilyurt</option>
													<option>Büyük Otel</option>
													<option>Mecidiye</option>
												</optgroup>
												<optgroup label="Ankara">
													<option>Etimesgut</option>
													<option>ARNOVA</option>
													<option>Kızılören</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="dtp_input2" class="col-md-3 control-label">Teslim Tarihi</label>
										<div class="input-group date form_datetime2 col-md-8" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
											<input class="form-control" size="16" type="text" value="" readonly>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
										</div>
										<input type="hidden" id="dtp_input2" value="" /><br />
									</div>

									<button type="submit" class="btn btn-info"> Ara </button>
									<button type="reset" class="btn btn-default"> Sıfırla </button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container" style="padding-top: 80px;">
		<div class="row section">
			<div class="col-lg-12">
				<h1>A Full Width Image Slider Template</h1>
				<p>This is a great starting point for yet another modern and
					stylish website. Here are some things to consider when working with
					this template:</p>
				<ul>
					<li>Unique Fonts</li>
					<li>Attractive Colors</li>
					<li>Content Spacing for Legibility and Design</li>
					<li>Decent Pictures that Still Load Quickly (less than 400KB
						for example)</li>
					<li>Make the Pictures INFORMATIVE</li>
					<li>Custom Styling for the Captions</li>
				</ul>
			</div>
		</div>

		<hr>

		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Company 2013 &middot; Facebook &middot;
					Twitter &middot; Google+</p>
			</div>
		</div>
		</footer>

	</div>
	<!-- /.container -->

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

</body>
</html>