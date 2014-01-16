<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="roleId" value="${ logonUser.role.id }" />

<c:if test="${ roleId < 3 }">
	<p><a href="<c:url value='/branch/service-points/new' />" class="btn btn-primary">Yeni Hizmet Noktası Ekle</a></p>
</c:if>

<c:if test="${ !empty allServicePoints }">
	<p>
		Arama Yap: <input id="filter" type="text" />
	</p>
	<a style="display: inline;" data-trigger="footable_expand_all" class="toggle" href="#collapse">Aç</a>
	<a data-trigger="footable_collapse_all" class="toggle" style="display: none;" href="#collapse">Kapa</a>
	<table class="table table-bordered table-hover toggle-circle"
		data-filter="#filter" data-page-size="6"
		data-page-previous-text="önceki" data-page-next-text="sonraki">
		<thead>
			<tr>
				<th data-toggle="true">Sıra</th>
				<th>Ad</th>
				<th data-hide="phone">Adres</th>
				<c:if test="${ roleId < 3 }">
					<th>İşlemler</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ allServicePoints }" var="sp" varStatus="s">
				<tr>
					<td>${ s.count }</td>
					<td>${ sp.name }</td>
					<td>${ sp.address }</td>
					<c:if test="${ roleId < 3 }">
						<td>
							<div class="visible-md visible-lg visible-sm visible-xs action-buttons">
								<a class="green" href="<c:url value='/branch/service-points/edit/${ sp.id }' />">
									<i class="icon-pencil bigger-130"></i>
								</a> <a class="red" href="<c:url value='/branch/service-points/delete/${ sp.id }' />">
									<i class="icon-trash bigger-130"></i>
								</a>
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="hide-if-no-paging">
			<tr>
				<td colspan="13">
					<div class="pagination pagination-centered"></div>
				</td>
			</tr>
		</tfoot>
	</table>
</c:if>

<script type="text/javascript">
	$(document).ready(function() {
		$('table').footable();
		$('.toggle').click(function() {
			$('.toggle').toggle();
			$('table').trigger($(this).data('trigger')).trigger('footable_redraw');
		});
	})
</script>