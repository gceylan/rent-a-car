<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<ul class="nav nav-tabs" id="myTab">
	<li class="active"><a href="#empInf" data-toggle="tab">Kişisel Bilgilerim</a></li>
	<li><a href="#passwd" data-toggle="tab">Parola Değiştir</a></li>
</ul>
<div class="tab-content">
	<div class="tab-pane active" id="empInf">
		<p>${ logonUser.firstname }</p>
		<p>${ logonUser.lastname }</p>
		<p>${ logonUser.username }</p>
		<p>${ logonUser.email }</p>
	</div>
	<div class="tab-pane" id="passwd">
		Parola değiştirme ekranı
	</div>
</div>