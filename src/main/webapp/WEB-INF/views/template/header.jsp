<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<c:set var="isAdmin" value="/admin" />

<c:if test="${ logonUser.role.id ne 1 }" >
	<c:set var="isAdmin" value="/branch" />
</c:if>

<!-- Brand and toggle get grouped for better mobile display -->
<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	
	<!-- bir şuben den giriliyorsa, şube adını belirt -->
	<c:choose>
		<c:when test="${ !empty branch }">
			<a class="navbar-brand" href="<c:url value='${ isAdmin }' />">${ branch.name } | ${ branch.county } Şubesi</a>
		</c:when>
		<c:otherwise>
			<a class="navbar-brand" href="<c:url value='${ isAdmin }' />">Rent A Car</a>
		</c:otherwise>
	</c:choose>
</div>