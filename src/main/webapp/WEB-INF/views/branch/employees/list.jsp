<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="roleId" value="${ logonUser.role.id }" />

<c:if test="${ roleId < 3 }">
	<p><a href="<c:url value='/branch/employees/new' />" class="btn btn-primary">Yeni Çalışan Ekle</a></p>
</c:if>

<p>
	Arama Yap: <input id="filter" type="text" />
</p>
<a style="display: inline;" data-trigger="footable_expand_all" class="toggle" href="#collapse">Aç</a>
<a data-trigger="footable_collapse_all" class="toggle" style="display: none;" href="#collapse">Kapa</a>
<table class="table table-bordered table-hover toggle-circle" data-filter="#filter" data-page-size="6" data-page-previous-text="önceki" data-page-next-text="sonraki">
	<thead>
		<tr>
			<th data-toggle="true">Sıra</th>
			<th>Kullanıcı Adı</th>
			<th>Ad</th>
			<th>Soyad</th>
			<th data-hide="phone,tablet">Email</th>
			<th data-hide="phone,tablet">Rol</th>
			<c:if test="${ roleId < 3 }">
				<th data-hide="phone,tablet">Durum</th>
				<th>İşlemler</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ allEmployees }" var="emp" varStatus="s">
			<tr>
				<td>${ s.count }</td>
				<td>${ emp.username }</td>
				<td>${ emp.firstname }</td>
				<td>${ emp.lastname }</td>
				<td>${ emp.email }</td>
				<td>
					<c:choose>
						<c:when test="${ emp.role.name eq 'Şube Müdürü' }">
							<span class="label label-primary">${ emp.role.name }</span>
						</c:when>
						<c:otherwise>
							<span class="label label-default">${ emp.role.name }</span>
						</c:otherwise>
					</c:choose>
				</td>
				<c:if test="${ roleId < 3 }">
					<td>
						<c:if test="${ emp.role.name ne 'Şube Müdürü' }">
							<c:choose>
								<c:when test="${ emp.enabled }">
									<a href="<c:url value='/branch/employees/enabled/${ emp.id }/false' />">
										<span class="label label-success">Sisteme Girebilir</span>
									</a>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">
										<a href="<c:url value='/branch/employees/enabled/${ emp.id }/true' />">Sisteme Giremez</a>
									</span>
								</c:otherwise>
							</c:choose>
						</c:if>
					</td>
					<td>
						<div class="visible-md visible-lg visible-sm visible-xs action-buttons">
							<a class="blue" href="<c:url value='/branch/employees/profile/${ emp.id }' />">
								<i class="icon-zoom-in bigger-130"></i>
							</a>
							<a class="green" href="<c:url value='/branch/employees/edit/${ emp.id }' />">
								<i class="icon-pencil bigger-130"></i>
							</a>
							<c:if test="${ emp.role.name ne 'Şube Müdürü' }">
								<a class="red" href="<c:url value='/branch/employees/delete/${ emp.id }' />">
									<i class="icon-trash bigger-130"></i>
								</a>
							</c:if>
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
			$('table').trigger($(this).data('trigger')).trigger('footable_redraw');
		});
	})
</script>