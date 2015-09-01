<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Delete Employee</title>
	</head>
<body>
	<h2>Delete Employee</h2>
	<spring:url var="action" value='/employee/delete/${employee.id}' />
	<form:form commandName="employee" method="post" action="${action}" role="form">
		<table>
			<tr>
				<td>
					<form:label for="id" path="id" cssClass="" cssErrorClass="">
						<fmt:message key="employee.id" />
					</form:label>
				</td>
				<td>
					<form:input path="id" cssClass="" cssErrorClass="" readonly="true" />
					<form:errors path="id" cssClass="" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label for="name" path="name" cssClass="" cssErrorClass="">
						<fmt:message key="employee.name" />
					</form:label>
				</td>
				<td>
					<form:input path="name" cssClass="" cssErrorClass="" readonly="true" />
					<form:errors path="name" cssClass="" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label for="salary" path="salary" cssClass="" cssErrorClass="">
						<fmt:message key="employee.salary" />
					</form:label>
				</td>
				<td>
					<form:input path="salary" cssClass="" cssErrorClass="" readonly="true" />
					<form:errors path="salary" cssClass="" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label for="position" path="position" cssClass="" cssErrorClass="">
						<fmt:message key="employee.position" />
					</form:label>
				</td>
				<td>
					<form:select path="position" items="${positionEnum}" disabled="true" ></form:select>
					<form:errors path="position" cssClass="" />
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					<input type="submit" class="" name="save" id="save"  value="<fmt:message key="button.delete"/>"/>
					<input type="submit" class="" name="cancel" id="cancel"  value="<fmt:message key="button.cancel"/>"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>