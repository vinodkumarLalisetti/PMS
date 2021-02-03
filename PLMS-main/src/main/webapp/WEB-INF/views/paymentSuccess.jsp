<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Success</title>
</head>
<body style="background-color: rgb(255, 228, 191)">
	<h1>Dear <c:out value="${sessionScope.user.firstname}" />, your Payment is successfull!!!</h1>
	<h3>ThankYou for using PLMS</h3>
	<h2><a href="home">click here to navigate to your home page</a></h2>
</body>
</html>