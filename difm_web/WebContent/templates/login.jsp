<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Login</title>
		
		<link rel="stylesheet" href="../css/reset.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />
		<link href="lightbox/css/lightbox.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans|Baumans' rel='stylesheet' type='text/css'/>
		
		<script src="js/modernizr.js"></script>
		<script src="js/respond.min.js"></script>
		
		<!-- include extern jQuery file but fall back to local file if extern one fails to load !-->
		<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">window.jQuery || document.write('<script type="text\/javascript" src="js\/1.7.2.jquery.min"><\/script>')</script>
		
		<script src="lightbox/js/lightbox.js"></script>
		<script src="js/prefixfree.min.js"></script>
		<script src="js/jquery.slides.min.js"></script>
		<script>
		    function show()
		    {
		      var div2 = document.getElementById("register");
		      var div1 = document.getElementById("login");
		      div1.className="hide";
		      div2.className="showregister";
		    }
		</script>
	</head>
	
	<body>
	
	<header>
	
	</header>
	
	  
	    <div id="login" class="show">
   	
	   	<c:set var="pageTitle" value="Please Login" scope="request"/>
		<c:url value="/login" var="loginUrl"/>
		
		<form action="${loginUrl}" method="post" class="customform">
		    <c:if test="${param.error != null}">
		        <div class="alert alert-error">
		            Failed to login.
		            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		              Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		            </c:if>
		        </div>
		    </c:if>
		    <c:if test="${param.logout != null}">
		        <div class="alert alert-success">
		            You have been logged out.
		        </div>
		    </c:if>
		    <ul>
		    <li>
		    <!-- <label for="username">Username</label>-->
		    <input type="email" id="username" name="username" placeholder = "Username/Email" class="username"/>
		    </li>
		    <li>
		    <!-- <label for="password">Password</label> -->
		    <input type="password" id="password" name="password" placeholder = "Password" class="password"/>
		    </li>
		    <li>
		    <input id="submit" class="input" name="submit" type="submit" value="Login"/>
		    <a href="javascript:show();" class="link1">Register</a>
		    <a href="forgotpassword.jsp" class="link1">Forgot Password</a>
		    </li>
		    </ul>
		
		</form>
		</div>
		<div id="register" class="hide">
		</div>
		<div id="forgotpassword">
		</div>
	</body>
</html>