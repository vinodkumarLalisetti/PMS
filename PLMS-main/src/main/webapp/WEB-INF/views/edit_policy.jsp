<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Policy</title>
<link href="../resources/css/registerstyles.css" rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/registerscript.js"
	defer></script>
<link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
<style type="text/css">
body {
  background: #EEF2F7;
  
    margin:0;
    padding:0;
    overflow:auto;
}
</style>
</head>

<body>
<%@ include file="navbar.jsp" %>
	<div id="wrapper" style="box-shadow: 12px 12px 2px 1px rgba(0, 0, 255, .2);">
		<h2>Edit Policy</h2>
		<form method="POST" action="editpolicy" onsubmit="return Validate()"
			name="vform">
			<input type="hidden" name="pid" value="${policy.pid}"/>
			<div id="firstname_div">
				<label>Policy Name</label> <br> <input type="text"
					name="policyname" class="textInput" value="${policy.policyName}">
				<div id="first_name_error"></div>
			</div>
			<div id="lastname_div">
				<label>Policy Type</label> <br> <input type="text"
					name="policytype" class="textInput" value="${policy.policyType}">
				<div id="last_name_error"></div>
			</div>
			<div id="gender_div">
				<label>Policy Duration</label> <br> <select
					name="policyduration" required>
					<option value="${policy.duration}">${policy.duration}</option>
					<c:forEach begin="1" end="10" varStatus="loop">
						<option value="${loop.index}">${loop.index}</option>
					</c:forEach>
				</select>
				<div id="gender_error"></div>
			</div>
			<div id="age_div">
				<label>Policy Amount</label><br> <input type="number"
					name="policyamount" class="textInput" value="${policy.amount}">
				<div id="agr_error"></div>
			</div>
			<input type="hidden" name="companyname" value="${policy.companyName}" />
			<div>
				<input type="submit" name="editpolicy" value="Edit Policy"
					class="btn"> <input type="reset" value="Reset" class="btn">
			</div>
		</form>
	</div>
	
</body>
</html>