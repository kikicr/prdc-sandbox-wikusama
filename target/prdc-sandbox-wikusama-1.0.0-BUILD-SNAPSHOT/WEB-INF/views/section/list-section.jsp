<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
<link rel="stylesheet"
	href="<spring:url value='/resources/vendor/foundation-5.5.2/css/normalize.css'/>">
<link rel="stylesheet"
	href="<spring:url value='/resources/vendor/foundation-5.5.2/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="<spring:url value='/resources/vendor/font-awesome-4.4.0/css/font-awesome.min.css'/>">
<link rel="stylesheet" href="<spring:url value='/resources/main.css'/>">
<script src="<spring:url value='/resources/jquery.min.js'/>"></script>
<script
	src="<spring:url value='/resources/vendor/foundation-5.5.2/js/foundation.min.js'/>"></script>

</head>
<body>
	<div class="top-bar-less"></div>
	<nav class="top-bar" data-topbar role="navigation">
	<ul class="title-area">
		<li class="name">
			<h1>
				<a href="#"><img alt=""
					src="<spring:url value='/resources/img/wikusamafest.png'/>"
					class="logo" /> <strong style="font-weight: bolder;">Wikufest</strong></a>
			</h1>
		</li>
		<!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
		<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
	</ul>
	<section class="top-bar-section">

	<ul class="right">
		<li class="has-form" id="login-has"><a
			href="<c:url value='/j_spring_security_logout'/>" id="btn-login"
			class="alert button"><i class="fa fa-close"></i> Sign out</a></li>
	</ul>
	</section> </nav>
	<div class="grid-block">
		<nav class="large-3 medium-4 columns">
		<div class="sidebar">
			<div class="hide-for-small">
				<ul class="side-nav">
					<li><img src="http://placehold.it/100x100"></li>
					<li><strong>Menu</strong></li>
					<li class="divider"></li>
					<<li><strong><i class="fa fa-users"></i> Manager</strong></li>
					<li><a href="<c:url value='/user-manager'/>">User manager</a></li>
					<li><a href="<c:url value='/role-manager'/>">role manager</a></li>
					<li><a href="<c:url value='/lesson-manager'/>">lesson
							manager</a></li>
					<li><a href="<c:url value='/room-manager'/>">room manager</a></li>
					<li><a href="<c:url value='/section-manager'/>">section
							manager</a></li>
					<li><a href="<c:url value='/schedule-manager'/>">schedule
							manager</a></li>
						
				</ul>
			</div>
		</div>
		</nav>
		<div class="large-9 medium-8 columns">
			<table>
				<thead>
				<caption>
					<span>Lesson Manager</span>
					<div class="medium-8 columns">
						<a href="<spring:url value="/section-manager/add/" />"
							class="button success tiny"><i class="fa fa-plus"></i> add</a> <a
							href="<spring:url value="/report/pdf" />"
							class="button success tiny"><i class="fa fa-print"></i> to
							PDF</a>
					</div>
				</caption>
				<th>Section ID</th>
				<th>Section Name</th>
				<th>Start At</th>
				<th>Until</th>
				<th>Action</th>
				</thead>
				<tbody>
					<c:forEach items="${sectionList}" var="section">
						<tr>
							<td>${section.id}</td>
							<td>${section.name}</td>
							<td>${section.startAt}</td>
							<td>${section.endAt}</td>
							<td><a class="button tiny"
								href="<spring:url value='/section-manager/edit/${section.id}'/>"><i
									class="fa fa-edit"></i> edit</a> <a class="button alert tiny hapus"
								id="<spring:url value='/section-manager/delete/${section.id}::${section.id}'/>"><i
									class="fa fa-eraser"></i> delete</a></td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id="msg"></div>

	</div>
	<script src="<spring:url value='/resources/mainlib.js'/>">
		
	</script>
	<script>
		$(".hapus").click(function() {
			var idResults = this.id.split("::");
			foundationHelper.alert.alertShow(idResults[0], idResults[1]);

		});
		foundationHelper.alert.alertBoxCreate("#msg");
	</script>
</body>
</html>