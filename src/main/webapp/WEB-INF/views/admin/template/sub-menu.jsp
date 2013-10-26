<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>

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
<%-- 				<li class="active"><a href="${ pageContext.request.contextPath }/admin/${ selectedNav.menu.url }"><i class="${ selectedNav.menu.icon }"></i> ${ selectedNav.menu.name }</a></li> --%>
				<li class="active"><i class="${ selectedNav.menu.icon }"></i> ${ selectedNav.menu.name }</li>
			</c:if>
			
		</ol>
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			${ selectedNav.menu.description }
		</div>
	</div>
</div>
<!-- /.row -->