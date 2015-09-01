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
		<div class="large-11 columns">
			<spring:url value="/schedule-manager/add/" var="url"></spring:url>
			<c:if test="${isEdit}">
				<spring:url value="/schedule-manager/do-edit/${schedule.id}"
					var="url"></spring:url>
			</c:if>
			<form:form commandName="schedule" action="${url}" method="post">
				<div class="row">
					<div class="medium-3 columns">

						<label>lesson name</label>
						<form:select path="lesson.id">
						<c:forEach items="${lessonList}" var="les">
							<form:option value="${les.id}">${les.name}</form:option>
						</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>room</label>
						<form:select path="room.id">
						<c:forEach items="${roomList}" var="ro">
							<form:option value="${ro.id}">${ro.name}</form:option>
						</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>section</label>
						<form:select path="section.id">
						<c:forEach items="${sectionList}" var="sec">
							<form:option value="${sec.id}">${sec.startAt}-${sec.endAt}</form:option>
						</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="row">
					<div class="medium-3 columns">
						<label>trainer</label>
						<form:select path="trainer.id">
						<c:forEach items="${trainerList}" var="tr">
							<form:option value="${tr.id}">${tr.user.name}</form:option>
						</c:forEach>
						</form:select>
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
</body>
</html>