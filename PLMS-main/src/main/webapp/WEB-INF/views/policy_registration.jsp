<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>PolicyRegistration</title>
<link href="../resources/css/registerstyles.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/registerscript.js"
	defer></script>
</head>
<style type="text/css">
.box {
  box-shadow:
  0 2.8px 2.2px rgba(0, 0, 0, 0.034),
  0 6.7px 5.3px rgba(0, 0, 0, 0.048),
  0 12.5px 10px rgba(0, 0, 0, 0.06),
  0 22.3px 17.9px rgba(0, 0, 0, 0.072),
  0 41.8px 33.4px rgba(0, 0, 0, 0.086),
  0 100px 80px rgba(0, 0, 0, 0.12)
;

  
  min-height: 200px;
  padding:20px;
  width: 30vw;
  margin: 30px auto;
  background: ;
  border-radius: 5px;
  
 
}


body {
  background: #EEF2F7;
  position:relative; 
    margin:0;
    padding:0;
    overflow:auto;
}

footer {
	position: relative;
	width: 100%;
	height:8%;
	bottom: 0;
	color: white;
	background-color: #939596;
}

</style>

<body>
<%@ include file="navbar.jsp" %>
	<div id="wrapper">
		<h2>Policy Registration From</h2>
		<form method="POST" action="policyregistration"
			onsubmit="return Validate()" name="vform">
			<div id="firstname_div">
				<label>Policy Name</label> <br> <input type="text"
					name="policyname" class="textInput">
				<div id="first_name_error"></div>
			</div>
			<div id="lastname_div">
				<label>Policy Type</label> <br> <input type="text"
					name="policytype" class="textInput">
				<div id="last_name_error"></div>
			</div>
			<div id="gender_div">
				<label>Policy Duration</label> <br> <select
					name="policyduration" required>
					<option value="">Select Duration(in years)</option>
					<c:forEach begin="1" end="10" varStatus="loop">
						<option value="${loop.index}">${loop.index}</option>
					</c:forEach>
				</select>
				<div id="gender_error"></div>
			</div>
			<div id="age_div">
				<label>Policy Amount</label><br> 
				<input type="number" name="policyamount" class="textInput">
				<div id="agr_error"></div>
			</div>
			<div id="username_div">
				<label>Company Name</label> <br> <input type="text"
					name="companyname" class="textInput">
				<div id="name_error"></div>
			</div>
			<div>
				<input type="submit" name="createpolicy" value="Create Policy" class="btn">
				<input type="reset" value="Reset" class="btn">
			</div>
		</form>
	</div>
	
</body>
</html>