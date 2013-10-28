<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="table-responsive">
	<table class="table table-bordered table-hover table-striped tablesorter">
		<thead>
			<tr>
				<th class="header">sıra <i class="icon-sort"></i></th>
				<th class="header">kullanıcı adı <i class="icon-sort"></i></th>
				<th class="header">ad <i class="icon-sort"></i></th>
				<th class="header">soyad <i class="icon-sort"></i></th>
				<th class="header">email <i class="icon-sort"></i></th>
				<th class="header">rol <i class="icon-sort"></i></th>
				<th class="header">işlemler <i class="icon-sort"></i></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ !empty users }">
				<c:forEach items="${ users }" var="u" varStatus="s">
					<tr>
						<td>${ s.count }</td>
						<td>${ u.username }</td>
						<td>${ u.firstname }</td>
						<td>${ u.lastname }</td>
						<td>${ u.email }</td>
						<td>
							<c:forEach items="${ u.roles }" var="r">
								<label>${ r.name }</label>
							</c:forEach>
						</td>
						<td>
							C-R-U-D
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>