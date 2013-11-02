<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="context" value="${ pageContext.request.contextPath }" />

<p>
	<a href="${ context }/admin/users/new" class="btn btn-primary">Yeni Kullanıcı Ekle</a>
</p>

<c:if test="${ !empty users }">
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
				<c:forEach items="${ users }" var="u" varStatus="s">
					<tr>
						<td>${ s.count }</td>
						<td>${ u.username }</td>
						<td>${ u.firstname }</td>
						<td>${ u.lastname }</td>
						<td>${ u.email }</td>
						<td>${ u.role.name }</td>
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a class="blue" href="${ context }/admin/users/profil/${ u.username }">
									<i class="icon-zoom-in bigger-130"></i>
								</a>
								<a class="green" href="${ context }/admin/users/edit/${ u.id }">
									<i class="icon-pencil bigger-130"></i>
								</a>
								<a class="red" href="${ context }/admin/users/delete/${ u.id }">
									<i class="icon-trash bigger-130"></i>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>