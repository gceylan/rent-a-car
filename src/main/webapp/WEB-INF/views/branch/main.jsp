<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="row">
	<div class="col-lg-3">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<i class="icon-comments icon-5x"></i>
					</div>
					<div class="col-xs-6 text-right">
						<p id="notConfirmedRentalCount" class="announcement-heading">0</p>
						<p class="announcement-text">Onay Bekleyenler</p>
					</div>
				</div>
			</div>
			<a href="<c:url value='/branch/reservations/not-confirmed' />">
				<div class="panel-footer announcement-bottom">
					<div class="row">
						<div class="col-xs-6">Onay Bekleyenler</div>
						<div class="col-xs-6 text-right">
							<i class="icon-circle-arrow-right"></i>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3">
		<div class="panel panel-warning">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<i class="icon-check icon-5x"></i>
					</div>
					<div class="col-xs-6 text-right">
						<p id="completedRentalCount" class="announcement-heading">0</p>
						<p class="announcement-text">Tamamlanmış Kiralamalar</p>
					</div>
				</div>
			</div>
			<a href="<c:url value='/branch/reservations/completed' />">
				<div class="panel-footer announcement-bottom">
					<div class="row">
						<div class="col-xs-6">Tamamlanmış Kiralamalar</div>
						<div class="col-xs-6 text-right">
							<i class="icon-circle-arrow-right"></i>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<i class="icon-tasks icon-5x"></i>
					</div>
					<div class="col-xs-6 text-right">
						<p id="notCompletedRentalCount" class="announcement-heading">0</p>
						<p class="announcement-text">Günü Yaklaşanlar</p>
					</div>
				</div>
			</div>
			<a href="<c:url value='/branch/reservations/confirmed' />">
				<div class="panel-footer announcement-bottom">
					<div class="row">
						<div class="col-xs-6">Günü Yaklaşanlar</div>
						<div class="col-xs-6 text-right">
							<i class="icon-circle-arrow-right"></i>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3">
		<div class="panel panel-success">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<i class="icon-comments icon-5x"></i>
					</div>
					<div class="col-xs-6 text-right">
						<p id="nowDoingRentalCount" class="announcement-heading">0</p>
						<p class="announcement-text">Şu anda Gerçekleşenler</p>
					</div>
				</div>
			</div>
			<a href="<c:url value='/branch/reservations/now-doing' />">
				<div class="panel-footer announcement-bottom">
					<div class="row">
						<div class="col-xs-6">Şu anda Gerçekleşenler</div>
						<div class="col-xs-6 text-right">
							<i class="icon-circle-arrow-right"></i>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-bar-chart"></i> Traffic Statistics: October 1, 2013
					- October 31, 2013
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-area"></div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Traffic Sources: October 1,
					2013 - October 31, 2013
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-donut"></div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-time"></i> Recent Activity
				</h3>
			</div>
			<div class="panel-body">
				<div class="list-group">
					<a href="#" class="list-group-item"> <span class="badge">just
							now</span> <i class="icon-calendar"></i> Calendar updated
					</a> <a href="#" class="list-group-item"> <span class="badge">4
							minutes ago</span> <i class="icon-comment-alt"></i> Commented on a post
					</a> <a href="#" class="list-group-item"> <span class="badge">23
							minutes ago</span> <i class="icon-truck"></i> Order 392 shipped
					</a> <a href="#" class="list-group-item"> <span class="badge">46
							minutes ago</span> <i class="icon-money"></i> Invoice 653 has been paid
					</a> <a href="#" class="list-group-item"> <span class="badge">1
							hour ago</span> <i class="icon-user"></i> A new user has been added
					</a> <a href="#" class="list-group-item"> <span class="badge">2
							hours ago</span> <i class="icon-check"></i> Completed task: "pick up dry
						cleaning"
					</a> <a href="#" class="list-group-item"> <span class="badge">yesterday</span>
						<i class="icon-globe"></i> Saved the world
					</a> <a href="#" class="list-group-item"> <span class="badge">two
							days ago</span> <i class="icon-check"></i> Completed task: "fix error on
						sales page"
					</a>
				</div>
				<div class="text-right">
					<a href="#">View All Activity <i
						class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-money"></i> Recent Transactions
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table
						class="table table-bordered table-hover table-striped tablesorter">
						<thead>
							<tr>
								<th>Order # <i class="icon-sort"></i></th>
								<th>Order Date <i class="icon-sort"></i></th>
								<th>Order Time <i class="icon-sort"></i></th>
								<th>Amount (USD) <i class="icon-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>3326</td>
								<td>10/21/2013</td>
								<td>3:29 PM</td>
								<td>$321.33</td>
							</tr>
							<tr>
								<td>3325</td>
								<td>10/21/2013</td>
								<td>3:20 PM</td>
								<td>$234.34</td>
							</tr>
							<tr>
								<td>3324</td>
								<td>10/21/2013</td>
								<td>3:03 PM</td>
								<td>$724.17</td>
							</tr>
							<tr>
								<td>3323</td>
								<td>10/21/2013</td>
								<td>3:00 PM</td>
								<td>$23.71</td>
							</tr>
							<tr>
								<td>3322</td>
								<td>10/21/2013</td>
								<td>2:49 PM</td>
								<td>$8345.23</td>
							</tr>
							<tr>
								<td>3321</td>
								<td>10/21/2013</td>
								<td>2:23 PM</td>
								<td>$245.12</td>
							</tr>
							<tr>
								<td>3320</td>
								<td>10/21/2013</td>
								<td>2:15 PM</td>
								<td>$5663.54</td>
							</tr>
							<tr>
								<td>3319</td>
								<td>10/21/2013</td>
								<td>2:13 PM</td>
								<td>$943.45</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="text-right">
					<a href="#">View All Transactions <i
						class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
	(function workerNotConfirmedRentalCount() {
	  $.post('${pageContext.request.contextPath}/branch/not-confirmed-rental-count', function(data) {
	    // Now that we've completed the request schedule the next one.
	    $('#notConfirmedRentalCount').html(data);
	    setTimeout(workerNotConfirmedRentalCount, 5000);
	  });
	})();

	/*
	uzun ajax kodu, yukarıda kısaltılmışı
	$.ajax({ 
		type: 'POST',
		url: '${pageContext.request.contextPath}/branch/not-confirmed-rental-count',
		asyn: false,
		success: function(result) {
			$('#notConfirmedRentalCount').html(result);
		}, 
		error: function() {
			$('#notConfirmedRentalCount').html("999");
		} 
	});
	*/

	(function workerCompletedRentalCount() {
	  $.post('${pageContext.request.contextPath}/branch/completed-rental-count', function(data) {
	    // Now that we've completed the request schedule the next one.
	    $('#completedRentalCount').html(data);
	    setTimeout(workerCompletedRentalCount, 5000);
	  });
	})();

	/*
	$.ajax({ 
		type: 'POST',
		url: '${pageContext.request.contextPath}/branch/completed-rental-count',
		asyn: false,
		success: function(result) {
			$('#completedRentalCount').html(result);
		}, 
		error: function() {
			$('#completedRentalCount').html("999");
		} 
	});
	*/

	(function workerNotCompletedRentalCount() {
	  $.post('${pageContext.request.contextPath}/branch/not-completed-rental-count', function(data) {
	    // Now that we've completed the request schedule the next one.
	    $('#notCompletedRentalCount').html(data);
	    setTimeout(workerNotCompletedRentalCount, 5000);
	  });
	})();

	/*
	$.ajax({ 
		type: 'POST',
		url: '${pageContext.request.contextPath}/branch/not-completed-rental-count',
		asyn: false,
		success: function(result) {
			$('#notCompletedRentalCount').html(result);
		}, 
		error: function() {
			$('#notCompletedRentalCount').html("999");
		} 
	});
	*/

	(function workerNowDoingRentalCount() {
	  $.post('${pageContext.request.contextPath}/branch/now-doing-rental-count', function(data) {
	    // Now that we've completed the request schedule the next one.
	    $('#nowDoingRentalCount').html(data);
	    setTimeout(workerNowDoingRentalCount, 5000);
	  });
	})();

// kısa ajax isteği
// 	$.post("${pageContext.request.contextPath}/branch/now-doing-rental-count", function(data){
// 		alert("Yüklenen veri: " + data);
// 	});
			
});
</script>