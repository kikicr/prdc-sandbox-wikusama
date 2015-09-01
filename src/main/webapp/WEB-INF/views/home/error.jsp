<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
<link rel="stylesheet" href="<spring:url value='resources/vendor/foundation-5.5.2/css/normalize.css'/>">
<link rel="stylesheet" href="<spring:url value='resources/vendor/foundation-5.5.2/css/foundation.min.css'/>">
<link rel="stylesheet" href="<spring:url value='resources/vendor/font-awesome-4.4.0/css/font-awesome.min.css'/>">
<link rel="stylesheet" href="<spring:url value='resources/main.css'/>">
<script src="<spring:url value='resources/jquery.min.js'/>"></script>
<script src="<spring:url value='resources/vendor/foundation-5.5.2/js/foundation.min.js'/>"></script>

</head>
<body>
<div class="row">
	<h1>${error}</h1>
	<h2>${errorMsg}</h2>
	<p>to back home,<a href="<spring:url value='/login'/>">click here</a></p>
</div>
<!-- script -->
<script src="<spring:url value='resources/main.js'/>">


</script>
</body>
</html>