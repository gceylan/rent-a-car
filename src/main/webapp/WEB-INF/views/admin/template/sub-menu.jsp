<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="col-lg-12">
		<h1>
			${ selectedNav.menu.name } <small>${ selectedNav.menu.shortDescription }</small>
		</h1>
		<ol class="breadcrumb">
			<c:if test="${ selectedNav.menu.name eq 'Dashboard' }">
				<li class="active"><i class="icon-dashboard"></i> Dashboard</li>
			</c:if>
			
			<c:if test="${ selectedNav.menu.name ne 'Dashboard' }">
				<li><a href="${ pageContext.request.contextPath }/admin"><i class="icon-dashboard"></i> Dashboard</a></li>
<%-- 				<li class="active"><a href="${ pageContext.request.contextPath }/${ selectedNav.menu.url }"><i class="${ selectedNav.menu.icon }"></i> ${ selectedNav.menu.name }</a></li> --%>
				<li class="active"><i class="${ selectedNav.menu.icon }"></i> ${ selectedNav.menu.name }</li>
				<li class="active"><i class=""></i> ${ selectedNav.menu.shortDescription }</li>
			</c:if>
			
		</ol>
	</div>
	
	<!-- şimdilik böyle idare etsin -->
	<c:if test="${fn:length(selectedNav.subMenus) eq 0}">
		<div class="col-lg-12">
			<div class="alert alert-info alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				${ selectedNav.menu.description }
			</div>
		</div>
	</c:if>
	
	<c:if test="${fn:length(selectedNav.subMenus) gt 0}">
		<div class="col-lg-6">
			<div class="alert alert-info alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				${ selectedNav.menu.description }
			</div>
		</div>
	</c:if>
		
	<!-- SubMenu leri burada oluştur -->
	<div class="col-lg-6" style="float: right;">
		<c:forEach items="${ selectedNav.subMenus }" var="subMenu">
			<a href="${ pageContext.request.contextPath }/${ subMenu.url }" class="btn btn-primary">${ subMenu.name }</a>
		</c:forEach>
	</div>
</div>
<!-- /.row -->