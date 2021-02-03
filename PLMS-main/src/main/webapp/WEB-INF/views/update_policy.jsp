<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdatePolicy</title>
<link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
<style>
.policytable {
	border-collapse: collapse;
	font-family: Arial;
	font-size: 11pt;
}

.policytable td {
	text-align: left;
	padding: 7px;
	width: 150px;
}

.policytable tr:nth-child(odd) {
	background-color: #D9E1F2;
}

.policytable tr:nth-child(even) {
	background-color: #FFFFFF;
}

.policytable th {
	text-align: center;
	padding: 7px;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #4472C4;
}
body {
  background: #EEF2F7;
    margin:0;
    padding:10px auto;
    overflow:auto;
}
footer {
	position: absolute;
	width: 100%;
	height:10%;
	bottom: 0;
	margin:0;
	color: white;
	background-color: #939596;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp" %>
	
	<c:if test="${!empty policies}">
		<h2>List of Policies</h2>
		
		<table class="policytable" align="center" border="1">
			<tr>
				<th>Policy ID</th>
				<th>Policy Name</th>
				<th>Policy Type</th>
				<th>Duration(years)</th>
				<th>Policy Amount</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${policies}" var="policy">
				<tr>
					<td><c:out value="${policy.pid}" /></td>
					<td><c:out value="${policy.policyName}" /></td>
					<td><c:out value="${policy.policyType}" /></td>
					<td><c:out value="${policy.duration}" /></td>
					<td><c:out value="${policy.amount}" /></td>
					<td align="center"><a href="editpolicy?pid=${policy.pid}">Edit</a>
						| <a href="deletepolicy?pid=${policy.pid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	
</body>
</html>