<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<li><strong><i class="fa fa-users"></i> Manager</strong></li>
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
			<div class="row" style="padding: 2%">
				<div class="large-4 columns">
					<ul class="breadcrumbs">
						<li>admin</li>
						<li>user-manager</li>
					</ul>
				</div>
			</div>


			<div class="large-4">
				<table role="grid">
					<caption>

						<div class="medium-8 columns">
							<div class="row">
								<div class="small-2 columns text-right">
									<label class="right-label">action :</label>
								</div>
								<div class="small-10 columns text-left">
									<a id="<spring:url value="/user-manager/add-user/" />"
										class="button success tiny form-opener"><i
										class="fa fa-plus"></i> add</a> <a href="
									<spring:url value="/report/pdf" />
									" class="button success tiny"><i class="fa fa-print"></i> to
									PDF</a>
									<button class="button success" id="upload">import</button>

								</div>
							</div>
						</div>
						<span class="medium-4 columns">
							<div class="row">
								<div class="small-6 columns left">
									<label class="right-label">page limit :</label>
								</div>
								<div class="small-6 columns">
									<input type="number" value="${pageLimit}" />
								</div>
							</div>
						</span>
					</caption>
					<thead>

						<th>username</th>
						<th>name</th>
						<th>email</th>
						<th>gender</th>
						<th>address</th>
						<th>status</th>
						<th>role</th>
						<th>foto</th>
						<th>Action</th>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
								<td>${user.email}</td>
								<td>${user.gender}</td>
								<td>${user.address}</td>
								<td>${user.enabled}</td>

								<td><c:forEach items="${user.role}" var="role">
							${role.name}
						</c:forEach></td>
								<td><img style="max-width: 50px; max-height: 50px"
									src="${user.picture}"></td>
								<td><a class="button tiny form-opener"
									id="<spring:url value='/user-manager/edit/${user.id}'/>"><i
										class="fa fa-edit"></i> edit</a> <a
									class="button alert tiny hapus"
									id="<spring:url value='/user-manager/delete/${user.id}::${user.id}'/>"><i
										class="fa fa-eraser"></i> delete</a></td>
								<td></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<ul class="pagination">
					<li class="arrow unavailable"><a href="">&laquo;</a></li>

					<c:forEach begin="1" end="${totalPage}" var="page">
						<li><a
							href="<c:url value='/user-manager/list-user/${pageLimit}/${page}'/>">${page}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="msg"></div>
		<!-- upload modal -->
		<div id="uploadModal" class="reveal-modal" data-reveal
			aria-labelledby="modalTitle" role="dialog">
			<h2 id="modalTitle">Upload Excel</h2>
			<spring:url value='/user-manager/import/' var="uploadUrl"/>
			<form:form method="post"
				action="${uploadUrl }"
				enctype="multipart/form-data">
				<input type="file" name="excel">
				<button class="button primary"><i class="fa fa-upload"></i> Upload</button>
			</form:form>
		</div>
		<!-- form modal -->
		<div id="myModal" class="reveal-modal" data-reveal
			aria-labelledby="modalTitle" aria-hidden="true" role="dialog">

		</div>
		<!-- end -->
	</div>
	<script src="<spring:url value='/resources/mainlib.js'/>">
		
	</script>
	<script>
		$(".hapus").click(function() {
			var idResults = this.id.split("::");
			foundationHelper.alert.alertShow(idResults[0], idResults[1]);

		});
		$(".form-opener").click(function() {
			$("#myModal").foundation('reveal', 'open', this.id);
		});
		foundationHelper.alert.alertBoxCreate("#msg");
		$("#upload").click(function(){
			$(this).attr("disable","disable");
			$(this).html("uploading");
			$("#uploadModal").foundation('reveal', 'open');
		});
	</script>
</body>
</html>