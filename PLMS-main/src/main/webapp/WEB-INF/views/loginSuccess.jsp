<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body style="background-color: #06631c">
	<h1>Dear <c:out value="${sessionScope.user.firstname}" />, your login is successfull!!!</h1>
	<h2><a href="home">click here to navigate to your home page</a></h2>
</body>
</html>