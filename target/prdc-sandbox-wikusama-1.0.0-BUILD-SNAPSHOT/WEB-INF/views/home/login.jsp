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
	<div class="top-bar-less"></div>
	<nav class="top-bar" data-topbar role="navigation">
  <ul class="title-area">
    <li class="name">
      <h1><a href="#"><img alt="" src="<spring:url value='resources/img/wikusamafest.png'/>" class="logo"/> <strong style="font-weight: bolder;">Wikufest</strong></a></h1>
    </li>
     <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
  </ul>
  <section class="top-bar-section">

    <ul class="right">
    	<li class="has-form" id="login-has">
     	<a href="javascript:void(0)" id="btn-login" class="alert button" data-reveal-id="firstModal"><i class="fa fa-user"></i> Sign in</a>	
    	</li>
    </ul>
  </section>
</nav>
<!-- login modal -->
<div id="firstModal" class="reveal-modal tiny" data-reveal aria-labelledby="firstModalTitle" aria-hidden="true" role="dialog">
  
  <h2  id="firstModalTitle"><i class="fa fa-sign-in"></i> sign in</h2>
 	<form method="post" action="<c:url value='/j_spring_security_check' />">
 	 <div class="row collapse">
    <div class="small-4 large-3 columns">
      <span class="prefix"><i class="fa fa-user"></i>Username</span>
    </div>
    <div class="small-8 large-9 columns">
      <input type="text" name="username" placeholder="123/774.700">
    </div>
  </div>
   <div class="row collapse">
    <div class="small-4 large-3 columns">
      <span class="prefix"> <i class="fa fa-key"></i>password</span>
    </div>
    <div class="small-8 large-9	 columns">
      <input type="password" name="password" placeholder="your password">
    </div>
  </div>
  <div class="row">
  		
  		<div class="small-12 large-12 columns" style="text-align: right;color:#354b60">
      	<input type="checkbox">remember me
    </div>
  </div>
  <div class="row" >
  	  		<button class="button small-12 large-12 columns" style="background: #d35400"><i class="fa fa-unlock"></i> Sign in</button>
  	
  </div>
  </form>
   <a class="close-reveal-modal" aria-label="Close">&#215;</a>
</div>
<div class="row" style="background:url(../img/header-overlay.png) no-repeat"></div>
<!-- end of login modal -->

<!-- script -->
<script src="<spring:url value='resources/main.js'/>">


</script>
</body>
</html>