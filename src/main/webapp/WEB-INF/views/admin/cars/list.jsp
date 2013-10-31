<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="context" value="${ pageContext.request.contextPath }" />

<p>
	<a href="${ context }/admin/cars/new" class="btn btn-primary">Yeni Araç Ekle</a>
</p>

<c:if test="${ !empty allCars }">
	<div class="table-responsive">
		<table class="table table-bordered table-hover table-striped tablesorter">
			<thead>
				<tr>
					<th class="header"> sıra <i class="icon-sort"></i></th>
					<th class="header"> plaka <i class="icon-sort"></i></th>
					<th class="header"> marka <i class="icon-sort"></i></th>
					<th class="header"> model <i class="icon-sort"></i></th>
					<th class="header"> Araç Sahibi <i class="icon-sort"></i></th>
					<th class="header"> Email / Telefon <i class="icon-sort"></i></th>
					<th class="header"> günlük fiyat <i class="icon-sort"></i></th>
					<th class=""> işlemler </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ allCars }" var="car" varStatus="s">
					<tr>
						<td>${ s.count }</td>
						<td>${ car.licensePlate }</td>
						<td>${ car.brand }</td>
						<td>${ car.model }</td>
						<td>${ car.owner }</td>
						<td>${ car.ownerEmail } / ${ car.ownerPhone }</td>
						<td>${ car.pricePerDay } TL</td>
						<td>
							<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
								<a class="green" href="${ context }/admin/cars/edit/${ car.id }">
									<i class="icon-edit bigger-130"></i>
								</a>
								<a class="red" href="${ context }/admin/cars/delete/${ car.id }">
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