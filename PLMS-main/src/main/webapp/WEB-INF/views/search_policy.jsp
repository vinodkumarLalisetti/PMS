<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>SearchPolicy</title>
<link href="../resources/css/registerstyles.css" rel="stylesheet">
<link href="../resources/css/footer.css" rel="stylesheet">

<style>
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
.policytable {
	border-collapse: collapse;
	font-family: Arial;
	font-size: 11pt;
	align:center;
	height:20%;
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
</style>
</head>

<body>
<%@ include file="navbar.jsp" %>
	<div id="wrapper">
		<h1 align="center">Search Policy</h1>
		<form method="POST" action="${pageContext.request.contextPath}/user/searchpolicy"
			onsubmit="return Validate()" name="vform">
			<div id="gender_div">
				<label>Search By</label> <br> <select name="policySearchBy"
					required>
					<option value="">----Search By----</option>
					<option value="pid">ID</option>
					<option value="policyType">Type</option>
					<option value="policyName">Name</option>
					<option value="duration">Duration</option>
					<option value="companyName">Company Name</option>
				</select>
				<div id="gender_error"></div>
			</div>

			<div id="firstname_div">
				<label>Enter Search Value</label> <br> <input type="text"
					name="policySearchName" class="textInput" required>
				<div id="first_name_error"></div>
			</div>
			<div>
				<button type="submit" name="editpolicy" value="Search Policy"
					class="btn">Search Policy</button>
				<input type="reset" value="Reset" class="btn">
			</div>
		</form>
		
	<h3 align="center">${msg}</h3>
	<c:if test="${policies!=null}">
		<table class="policytable" 	align="center"; border="1">
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
					<td align="center"><a href="pay?pid=${policy.pid}&uid=${sessionScope.user.uid}&amount=${policy.amount}">Click here to Pay</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		</div>
		
</body>

</html>