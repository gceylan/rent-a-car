<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- dikkat -->
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse navbar-ex1-collapse">
	<ul class="nav navbar-nav side-nav">
		<c:forEach items="${ navigations }" var="nav">
			<c:set var="menu" value="${ nav.menu }" />
			<c:set var="subMenus" value="${ nav.subMenus }" />
			
			<c:set var="isActive" value="" />
			
			<c:if test="${ selectedNav.menu eq menu }">
				<c:set var="isActive" value="active" />
			</c:if>
			
			<!-- left-slidebar -->
			<li class="${ isActive }">
				<a href="${ contextPath }/${ menu.url }">
					<i class="${ menu.icon }"></i> ${ menu.name }
				</a>
			</li>
		</c:forEach>
	</ul>

	<ul class="nav navbar-nav navbar-right navbar-user">
		<li class="dropdown messages-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="icon-envelope"></i> Mesajlar <span class="badge">7</span> <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li class="dropdown-header">7 New Messages</li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">View Inbox <span class="badge"></span></a></li>
			</ul>
		</li>
		<li class="dropdown messages-dropdown"><a id="alerts" href="#" class="dropdown-toggle" data-toggle="dropdown">
			<i class="icon-bell-alt"></i> Şu Anda Gerçekleşenler <span class="badge"><div class="nowDoing"></div></span>
				<b class="caret"></b></a>
				<ul id="nowDoingRentals" class="dropdown-menu">
					<!-- burayı ajax besliyor -->
				</ul>
		</li>
		<li class="dropdown messages-dropdown"><a id="alerts" href="#" class="dropdown-toggle" data-toggle="dropdown">
			<i class="icon-bell-alt"></i> Günü Yaklaşanlar <span class="badge"><div class="alertCount"></div></span>
				<b class="caret"></b></a>
				<ul id="alertsContent" class="dropdown-menu">
					<!-- burayı ajax besliyor -->
				</ul>
		</li>
		<li class="dropdown user-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="icon-user"></i> ${ logonUser.firstname } ${ logonUser.lastname } <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="${ contextPath }/branch/employees/profile/${ logonUser.id }"><i class="icon-user"></i> Profil</a></li>
				<li><a href="#"><i class="icon-envelope"></i> Gelen Kutusu <span
						class="badge">7</span></a></a></li>
				<li><a href="${ contextPath }/branch/employees/settings/${ logonUser.id }"><i class="icon-gear"></i> Ayarlar</a></li>
				<li class="divider"></li>
				<li><a href="${ pageContext.request.contextPath }/logout"><i class="icon-power-off"></i> Çıkış</a></li>
			</ul>
		</li>
	</ul>
</div>
<!-- /.navbar-collapse -->

<!-- uyarıları her 5 dk da bir kontrol et/güncelle,
yaklaşan kiralamalar bu yolla admine bildirilecek,
gerekirse mail atılacak -->
<script type="text/javascript">
$(document).ready(function() {
// 	$('#alerts').click(function(){		
// 		test();
// 	});

	getConfirmedAndNotCompletedRentals();
	getNowDoingRentals();

	function getNowDoingRentals() {
		$('#nowDoingRentals').html('');
		var i = 0;
		
		$.ajax({
			url : "${contextPath}/branch/reservations/json-now-doing",
			dataType : 'json',
			success : function(rentals) {
				$('.nowDoing').html(rentals.length);
				$('#nowDoingRentals').append('<li class="dropdown-header">Şu Anda Gerçekleşen Kiralamalalar</li>');
				$.each(rentals, function(key, rental) {
					if (i++ < 5) {
						var row = '<li class="message-preview">';
						row += '<a href="${contextPath}/branch/reservations/now-doing">';
						row += '<span class="name">' + rental.customerName + ' ' + rental.customerSurname + '\' adına:</span>';
						row += '<span class="message">' + $.format.date(new Date(rental.pickupDate), "dd/MM/yyyy") + ' tarihindeki kiralama başladı</span>';
						row += '<span class="time"><i class="icon-time"></i> ' + $.format.date(new Date(rental.pickupDate), "HH:mm") + ' - ' + $.format.date(new Date(rental.returnDate), "HH:mm") + '</span></a></li>';
						row += '<li class="divider"></li>';

						$('#nowDoingRentals').append(row);
					}
				});
				$('#nowDoingRentals').append('<li><a href="${contextPath}/branch/reservations/now-doing"> Gerçekleşen Kiralama Sayısı <span class="badge">' + rentals.length + '</span></a></li>');
			}
		});

		setTimeout(getNowDoingRentals, 20 * 1000);
	}

	function getConfirmedAndNotCompletedRentals() {
		$('#alertsContent').html('');
		var i = 0;
		
		$.ajax({
			url : "${contextPath}/branch/reservations/alerts",
			dataType : 'json',
			success : function(rentals) {
				$('.alertCount').html(rentals.length);
				$('#alertsContent').append('<li class="dropdown-header">Yaklaşan ilk 5 kiralama</li>');
				$.each(rentals, function(key, rental) {
					// ilk 5 yaklaşan kiralama
					if (i++ < 5) {
						var row = '<li class="message-preview">';
						row += '<a href="${contextPath}/branch/reservations/confirmed">';
						row += '<span class="name">' + rental.customerName + ' ' + rental.customerSurname + '\' adına:</span>';
						row += '<span class="message">' + $.format.date(new Date(rental.pickupDate), "dd/MM/yyyy") + ' tarihinde rezervasyon var</span>';
						row += '<span class="time"><i class="icon-time"></i> ' + $.format.date(new Date(rental.pickupDate), "HH:mm") + ' - ' + $.format.date(new Date(rental.returnDate), "HH:mm") + '</span></a></li>';
						row += '<li class="divider"></li>';

						$('#alertsContent').append(row);
					}
				});
				$('#alertsContent').append('<li><a href="${contextPath}/branch/reservations/confirmed">Yaklaşan Kiralama Sayısı <span class="badge">' + rentals.length + '</span></a></li>');
			}
		});

		setTimeout(getConfirmedAndNotCompletedRentals, 20 * 1000);
	}
	
});
</script>