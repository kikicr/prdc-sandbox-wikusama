<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List of Employee</title>
	</head>
<body>
	<h2>List of Employee</h2>
	<c:choose>
		<c:when test="${not empty employees}">
			<a href="<c:url value='/employee/add' />" title="Add">Add Employee</a><br />
			<table border="1">
				<tr>
					<td><fmt:message key="employee.id" /></td>
					<td><fmt:message key="employee.name" /></td>
					<td><fmt:message key="employee.salary" /></td>
					<td><fmt:message key="employee.position" /></td>
					<td><fmt:message key="form.action" /></td>
				</tr>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.salary}</td>
						<td>${emp.position}</td>
						<td>
							<a href="<c:url value='/employee/edit/${emp.id}' />" title="Edit">Edit</a>&nbsp;
							<a href="<c:url value='/employee/delete/${emp.id}' />" title="Delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<c:out value="No Data in the Employee"></c:out> 
			<a href="<c:url value='/employee/add' />" title="Add">Add Employee</a>
		</c:otherwise>
	</c:choose>
</body>
</html>