<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="roleId" value="${ logonUser.role.id }" />

<c:if test="${ roleId < 3 }">
	<p><a href="<c:url value='/branch/cars/new' />" class="btn btn-primary">Yeni Araç Ekle</a></p>
</c:if>

<c:if test="${ !empty allCars }">
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
				<th>Plaka</th>
				<th>Marka</th>
				<th>Model</th>
				<th>Araç Durumu</th>
				<th data-hide="phone,tablet">Araç Sahibi</th>
				<th data-hide="phone,tablet">Email/Telefon</th>
				<th>Günlük Fiyat</th>
				<c:if test="${ roleId < 3 }">
					<th>İşlemler</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ allCars }" var="car" varStatus="s">
				<tr>
					<td>${ s.count }</td>
					<td>${ car.licensePlate }</td>
					<td>${ car.brand }</td>
					<td>${ car.model }</td>
					<td>
						<c:choose>
							<c:when test="${ car.available }">
								<a href="<c:url value='/branch/cars/available/${ car.id }/0' />">
									<span class="label label-success">uygun</span>
								</a>
							</c:when>
							<c:otherwise>
								<span class="label label-danger">
									<a href="<c:url value='/branch/cars/available/${ car.id }/1' />">uygun değil</a>
								</span>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${ car.owner }</td>
					<td>${ car.ownerEmail }/ ${ car.ownerPhone }</td>
					<td>${ car.pricePerDay }TL</td>
					<c:if test="${ roleId < 3 }">
						<td>
							<div class="visible-md visible-lg visible-sm visible-xs action-buttons">
								<a class="blue" href="<c:url value='/branch/cars/show/${ car.id }' />">
									<i class="icon-zoom-in bigger-130"></i>
								</a>
								<a class="green" href="<c:url value='/branch/cars/edit/${ car.id }' />">
									<i class="icon-edit bigger-130"></i>
								</a>
								<a class="red" href="<c:url value='/branch/cars/delete/${ car.id }' />">
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('table').footable();
			$('.toggle').click(function() {
				$('.toggle').toggle();
				$('table').trigger($(this).data('trigger'))
				.trigger('footable_redraw');
			});
		});
	</script>
</c:if>