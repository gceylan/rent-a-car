<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>

<p>
	<a href="<c:url value='/admin/branchs/new' />" class="btn btn-primary">Yeni Şube Ekle</a>
</p>

<c:if test="${ !empty allBranchs }">
	<div class="table-responsive">
		<table class="table table-bordered table-hover table-striped tablesorter">
			<thead>
				<tr>
					<th class="header"> sıra <i class="icon-sort"></i></th>
					<th class="header"> il <i class="icon-sort"></i></th>
					<th class="header"> ilçe <i class="icon-sort"></i></th>
					<th class="header"> telefon <i class="icon-sort"></i></th>
					<th class="header"> posta codu <i class="icon-sort"></i></th>
					<th class="header"> müdür <i class="icon-sort"></i></th>
					<th class="header"> şube kodu <i class="icon-sort"></i></th>
					<th class=""> işlemler </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ allBranchs }" var="entry" varStatus="s">
					<c:set var="branch" value="${ entry.key }" />
					<c:set var="managers" value="${ entry.value }" />
					<tr>
						<td>${ s.count }</td>
						<td>${ branch.county }</td>
						<td>${ branch.town }</td>
						<td>${ branch.phone }</td>
						<td>${ branch.postalCode }</td>
						<td>
							<c:forEach items="${ managers }" var="manager">
								<b>${ manager.firstname } ${ manager.lastname }</b>
							</c:forEach>
						</td>
						<td>${ branch.branchCode }</td>
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a class="blue" href="<c:url value='/admin/branchs/show/${ branch.id }' />">
									<i class="icon-zoom-in bigger-130"></i>
								</a>
								<a class="green" href="<c:url value='/admin/branchs/edit/${ branch.id }' />">
									<i class="icon-edit bigger-130"></i>
								</a>
								<a class="red" href="<c:url value='/admin/branchs/delete/${ branch.id }' />">
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