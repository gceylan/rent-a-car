<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>

<c:if test="${ !empty branch }">
	<div class="panel-group" id="accordion">
	  <div class="panel panel-default">
	    <div class="panel-heading">
	      <h4 class="panel-title">
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	          Şube Bilgileri
	        </a>
	      </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse in">
	      <div class="panel-body">
     		Şube Kodu: ${ branch.branchCode } <br>
     		Şube Adı: ${ branch.name } <br>
     		İl: ${ branch.county } <br>
     		İlçe: ${ branch.town } <br>
     		Adres: ${ branch.address } <br>
     		Posta Kodu: ${ branch.postalCode } <br>
     		
     		<c:forEach items="${ branchManagers }" var="m">
     			Şube Müdürü: ${ m.firstname } ${ m.lastname }
     			Email: ${ m.email }
     		</c:forEach>
     		
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading">
	      <h4 class="panel-title">
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
	         Hizmet Noktaları
	        </a>
	      </h4>
	    </div>
	    <div id="collapseTwo" class="panel-collapse collapse">
	      <div class="panel-body">
	      	<c:forEach items="${ branch.servicePoints }" var="sp">
	      		${ sp.name } <br>
	      	</c:forEach>
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading">
	      <h4 class="panel-title">
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
	          Araçlar
	        </a>
	      </h4>
	    </div>
	    <div id="collapseThree" class="panel-collapse collapse">
	      <div class="panel-body">
	        <c:forEach items="${ branch.cars }" var="car">
	      		${ car.brand } ${ car.model } <br>
	      	</c:forEach>
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading">
	      <h4 class="panel-title">
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
	          Çalışanlar
	        </a>
	      </h4>
	    </div>
	    <div id="collapseFour" class="panel-collapse collapse">
	      <div class="panel-body">
	        <c:forEach items="${ branch.employees }" var="emp">
	      		${ emp.firstname } ${ emp.lastname } <br>
	      	</c:forEach>
	      </div>
	    </div>
	  </div>
	</div>
</c:if>