<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse navbar-ex1-collapse">
	<ul class="nav navbar-nav side-nav">
		<c:forEach items="${ navigations }" var="nav">
			<c:set var="menu" value="${ nav.menu }" />
			<c:set var="subMenus" value="${ nav.subMenus }" />
			
			<c:set var="isActive" value="" />
			
			<c:if test="${ selectedNav.menu eq menu }">
				<c:set var="isActive" value="active" />
			</c:if>
			
			<li class="${ isActive }">
				<a href="${ contextPath }/${ menu.url }">
					<i class="${ menu.icon }"></i> ${ menu.name }
				</a>
			</li>
		</c:forEach>
	</ul>

	<ul class="nav navbar-nav navbar-right navbar-user">
		<li class="dropdown messages-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="icon-envelope"></i> Messages <span class="badge">7</span> <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li class="dropdown-header">7 New Messages</li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li class="message-preview"><a href="#"> <span
						class="avatar"><img src="http://placehold.it/50x50"></span>
						<span class="name">John Smith:</span> <span class="message">Hey
							there, I wanted to ask you something...</span> <span class="time"><i
							class="icon-time"></i> 4:34 PM</span>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">View Inbox <span class="badge">7</span></a></li>
			</ul></li>
		<li class="dropdown alerts-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="icon-bell-alt"></i> Alerts <span class="badge">3</span> <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#">Default <span class="label label-default">Default</span></a></li>
				<li><a href="#">Primary <span class="label label-primary">Primary</span></a></li>
				<li><a href="#">Success <span class="label label-success">Success</span></a></li>
				<li><a href="#">Info <span class="label label-info">Info</span></a></li>
				<li><a href="#">Warning <span class="label label-warning">Warning</span></a></li>
				<li><a href="#">Danger <span class="label label-danger">Danger</span></a></li>
				<li class="divider"></li>
				<li><a href="#">View All</a></li>
			</ul></li>
		<li class="dropdown user-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="icon-user"></i> ${ logonUser.firstname } ${ logonUser.lastname } <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#"><i class="icon-user"></i> Profile</a></li>
				<li><a href="#"><i class="icon-envelope"></i> Inbox <span
						class="badge">7</span></a></a></li>
				<li><a href="#"><i class="icon-gear"></i> Settings</a></li>
				<li class="divider"></li>
				<li><a href="${ pageContext.request.contextPath }/logout"><i class="icon-power-off"></i> Log Out</a></li>
			</ul></li>
	</ul>
</div>
<!-- /.navbar-collapse -->