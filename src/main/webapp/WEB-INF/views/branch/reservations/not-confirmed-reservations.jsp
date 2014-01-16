<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="demo-container">
	<div class="tab-content">
		<div class="tab-pane active" id="demo">
			<p>
				<a href="#" class="get_data">yenile</a> | 
				<a href="#" id="clearFootable">temizle</a> | 
				<a href="#" id="addMoreData">peşine ekle</a>
			</p>
			<p>
				Search: <input id="filter" type="text" />
				Status:
				<select class="filter-status">
					<option></option>
					<option value="active">Onaysız</option>
					<option value="disabled">Onaylı</option>
				</select>
				<a href="#clear" class="clear-filter" title="clear filter">[clear]</a>
				<a href="#api" class="filter-api" title="Filter using the Filter API">[filter API]</a>
			</p>
			<a style="display: inline;" data-trigger="footable_expand_all" class="toggle" href="#collapse">Aç</a>
			<a data-trigger="footable_collapse_all" class="toggle" style="display: none;" href="#collapse">Kapa</a>
<!-- 				<table class="table demo" data-filter="#filter" data-page-size="7"> -->
			<table class="table table-bordered table-hover toggle-circle" data-filter="#filter" data-page-size="6" data-page-previous-text="önceki" data-page-next-text="sonraki">
				<thead>
					<tr>
						<th data-toggle="true">Sıra</th>
						<th data-hide="all">Araç</th>
						<th>Müşteri Adı</th>
						<th>Müşteri Soyadı</th>
						<th data-hide="all">Cep Telefonu</th>
						<th data-hide="all">Email</th>
						<th data-hide="phone,tablet">Rezv. Tarihi, Rezv. Kodu</th>
						<th data-hide="all">Alış Tarihi</th>
						<th data-hide="all">Alış Yeri</th>
						<th data-hide="all">Teslim Tarihi</th>
						<th data-hide="all">Teslim Yeri</th>
						<th>Status</th>
						<c:if test="${ logonUser.role.id < 3 }">
							<th>İşlemler</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<!-- datalar datalar :) -->
				</tbody>
				<tfoot class="hide-if-no-paging">
					<tr>
						<td colspan="13">
							<div class="pagination pagination-centered"></div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('table').footable();
		$('.toggle').click(function() {
			$('.toggle').toggle();
			$('table').trigger($(this).data('trigger')).trigger('footable_redraw');
		});

		getAllRentalsJSON();

		$('table').footable().on('click', '.confirm', function(e) {
			event.stopPropagation();
          	var footable = $('table').data('footable');
          	var row = $(this).parents('tr:first');
			if (confirm("Onaylıyor musunuz?")) {
				this.click;
				$.ajax({
					type: "GET",
		            url: $(event.target).attr("href"),
                    success: function() {
                      	footable.removeRow(row);
               	    },
               		error: function(e){
     					alert('Error: ' + e);
     				}
                });
			}
			event.preventDefault();
		});

		// seçilen satırı sil
		$('table').footable().on('click', '.row-delete', function(e) {
			event.stopPropagation();
			//get the footable object
          	var footable = $('table').data('footable');
          	//get the row we are wanting to delete
          	var row = $(this).parents('tr:first');
   		    /*
   		    * Tüm satırları seçmek için var rows = $(table tbody > tr)
   		    * footable.removeRow(rows);
   		    */
		    var deleteLink = $("a:contains('DELETE')");

			if(confirm("Do you want to delete?")) {
			    this.click;

			    $.ajax({
				    type: "GET",
		            url: $(event.target).attr("href"),
                    success: function() {
                      	footable.removeRow(row);
               	    }
                });
			}

			event.preventDefault();
		});
	});

	function clearFootable() {
		// footable' ı getir 
		var footable = $('table').data('footable');

		// tüm satırları seç
		var rows = $('table tbody > tr');

		$.each(rows, function(key, row) {
			footable.removeRow(row);
		});

		// Tüm satırları sil
// 		footable.removeRow(rows);
// 		$('table').trigger('footable_redraw');
// 		setInterval(clearFootable(), 10);
	}

	$('#clearFootable').click(function(e) {
		clearFootable();
	});
	
	$('.get_data').click(function(e) {
		clearFootable();
		getAllRentalsJSON();
	});

	function getAllRentalsJSON() {
		var roleId = '${logonUser.role.id}';
		var contextPath = '${pageContext.request.contextPath}';
		var editUrl = contextPath + "/branch/reservations/edit/";
		var deleteUrl = contextPath + "/branch/reservations/delete/";
		var confirmUrl = contextPath + "/branch/reservations/confirm/";

		$.ajax({
		 	headers: { 
	            'Accept': 'application/json',
	            'Content-Type': 'application/json' 
	        },
	        type : 'GET',
			url : contextPath + "/branch/reservations/json-not-confirmed",
			success : function(rentals) {
				$.each(rentals, function(key, rental) {
					var row = '<tr>';

					row += '<td>' + (key + 1) + '</td>';
					row += '<td>' + rental.car.licensePlate + " - " + rental.car.brand + " " + rental.car.model + '</td>';
	                row += '<td>' + rental.customerName + '</td>';
	                row += '<td>' + rental.customerSurname + '</td>';
	                row += '<td>' + rental.customerPhone + '</td>';
	                row += '<td>' + rental.customerEmail + '</td>';
	                row += '<td>' + $.format.date(new Date(rental.reservationDate), "dd/MM/yyyy HH:mm:ss") + ', ' + rental.reservationCode + '</td>';
	                row += '<td>' + $.format.date(new Date(rental.pickupDate), "dd/MM/yyyy HH:mm:ss") + '</td>';
	                row += '<td>' + rental.pickupLocation.name + '</td>';
	                row += '<td>' + $.format.date(new Date(rental.returnDate), "dd/MM/yyyy HH:mm:ss") + '</td>';
	                row += '<td>' + rental.returnLocation.name + '</td>';

	                if (rental.confirmed)
	                	row += '<td> Onaylı </td>';
	                else {
		                // eğer rezervasyon onaylanamadan, günü geçmiş ise, bunu belirt
		                if (rental.pickupDate < new Date()) {
		                	row += '<td><span class="label label-warning">Günü Geçmiş | Onaylanamaz</span></td>';
			            } else {
			            	row += '<td><a class="confirm" href="' + confirmUrl + rental.id + '">Onayla</a></td>';
				        }
		            }

	                if (roleId < 3) {
	                	row += '<td class="footable-last-column"><a class="row-delete" href="' + deleteUrl + rental.id + '">DELETE</a> | '
	                	 + '<a class="" href="' + editUrl + rental.id + '?from=${selectedNav.menu.url}">UPDATE</a></td>';
		            }
	                
	                row += '</tr>';

	                $('table tbody').append(row).trigger('footable_redraw');
				});
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});
		
		setTimeout(getAllRentalsJSON, 20 * 1000);

		var footable = $('table').data('footable');
		// tüm satırları seç
		var rows = $('table tbody > tr');
		
		rows.fadeOut(1000, function() {
            $(this).remove();
        }); 
	}

	$('#addMoreData').click(function(e) {
		getAllRentalsJSON();
	});
</script>