<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<div class="row">
		<h1>
			<i class="fa fa-user"></i> USER FORM
		</h1>
	</div>
	<div class="row">
		<div class="large-11 columns">
			<spring:url value="/user-manager/do-add-user/" var="url"></spring:url>
			<c:set var="urlPhoto" value=""></c:set>
			<c:if test="${isEdit}">
				<spring:url value="/user-manager/do-edit-user/${user.id}" var="url"  ></spring:url>
				<c:set var="urlPhoto" value="${user.picture}"></c:set>
			</c:if>
			<form:form commandName="user" action="${url}" method="post"
				data-abide="data-abide"
				enctype="multipart/form-data">
				<div class="row">
					<div class="medium-3 columns">
						<label>username</label>
						<form:input path="id" required="required" pattern="[a-zA-Z0-9]+" />
						<small class="error">Username is cant be null or number</small>
					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns name-field">

						<label>name</label>
						<form:input path="name" required="required" pattern="[a-zA-Z]+" />
						<small class="error">Name is cant be null or number</small>

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns email-field">
						<label>email</label>
						<form:input path="email" type="email" required="required" />
						<small class="error">Wrong format for email</small>
					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns gender-field">
						<label>gender</label>

						<c:forEach items="${gender}" var="g">

							<span><form:radiobutton path="gender" value="${g}"
									required="required" />${g.value}</span>
						</c:forEach>
						<small class="error">gender is required</small>

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>address</label>
						<form:input path="address" />

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>is enable</label>
						<form:checkbox path="enabled" id="exampleCheckboxSwitch4"></form:checkbox>

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>password</label>
						<form:password path="password" />

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>Role</label> <select name="roleList">
							<c:forEach items="${roleList}" var="role">

								<option value="${role.id}"
									<c:if test="${isEdit && role.id== roleId}">selected="selected"</c:if>>${role.name}</option>
							</c:forEach>
						</select>

					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>Foto</label> 
						
						<input type="file" name="photo" value="${urlPhoto }">
					</div>
				</div>
				<div class="row">
					<a href="?cancel" class="button alert"><i class="fa fa-cancel"></i>
						cancel</a> <input type="submit" class="button success" value="save">



				</div>
			</form:form>

		</div>

	</div>
	<script src="<spring:url value='/resources/main.js'/>">
		
	</script>
	<script type="text/javascript">
		$(document).foundation();
	</script>
</body>
</html>