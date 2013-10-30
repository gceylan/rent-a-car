<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="context" value="${ pageContext.request.contextPath }" />

<p>
	<a href="${ context }/admin/locations/new" class="btn btn-primary">Yeni Hizmet Noktası Ekle</a>
</p>

<c:if test="${ !empty locations }">
	<div class="table-responsive">
		<table class="table table-bordered table-hover table-striped tablesorter">
			<thead>
				<tr>
					<th class="header">sıra <i class="icon-sort"></i></th>
					<th class="header">ad <i class="icon-sort"></i></th>
					<th class="header">adres <i class="icon-sort"></i></th>
					<th class="header">işlemler <i class="icon-sort"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ locations }" var="l" varStatus="s">
					<tr>
						<td>${ s.count }</td>
						<td>${ l.name }</td>
						<td>${ l.address }</td>
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a class="green" href="${ context }/admin/locations/edit/${ l.id }">
									<i class="icon-pencil bigger-130"></i>
								</a>
								<a class="red" href="${ context }/admin/locations/delete/${ l.id }">
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