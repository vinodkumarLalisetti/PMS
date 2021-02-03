<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>AdminRegistration</title>
<link href="../resources/css/registerstyles.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/registerscript.js" defer></script>
<link href="${pageContext.request.contextPath}/resources/css/footer.css"
	rel="stylesheet">
<style type="text/css">
.box {
  box-shadow:
  0 2.8px 2.2px rgba(0, 0, 0, 0.034),
  0 6.7px 5.3px rgba(0, 0, 0, 0.048),
  0 12.5px 10px rgba(0, 0, 0, 0.06),
  0 22.3px 17.9px rgba(0, 0, 0, 0.072),
  0 41.8px 33.4px rgba(0, 0, 0, 0.086),
  0 100px 80px rgba(0, 0, 0, 0.12);

  
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

</head>
<body>
	<%@ include file="navbar.jsp" %>
	
	<div class="box">
		<h2>Admin Registration From</h2>
		<form method="POST" action="registration"
			onsubmit="return Validate()" name="vform">
			<div id="firstname_div">
				<label>FirstName</label> <br> <input type="text"
					name="firstname" class="textInput">
				<div id="first_name_error"></div>
			</div>
			<div id="lastname_div">
				<label>LastName</label> <br> <input type="text" name="lastname"
					class="textInput">
				<div id="last_name_error"></div>
			</div>
			<div id="gender_div">
				<label>Gender</label> <br> <select name="gender" required>
					<option value="">Select Gender</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="trans">Trans</option>
				</select>
				<div id="gender_error"></div>
			</div>
			<div id="age_div">
				<label>Age</label><br> <input type="number" name="age"
					class="age">
				<div id="agr_error"></div>
			</div>
			<div id="phonenumber_div">
				<label>Contact Number</label> <br> <input type="tel"
					name="phonenumber" class="textInput">
				<div id="phonenumber_error"></div>
			</div>

			<div id="username_div">
				<label>UserName</label> <br> <input type="text" name="username"
					class="textInput">
				<div id="name_error"></div>
			</div>
			<div id="email_div">
				<label>Email</label> <br> <input type="email" name="email"
					class="textInput">
				<div id="email_error"></div>
			</div>
			<div id="password_div">
				<label>Password</label> <br> <input type="password"
					name="password" class="textInput">
			</div>
			<div id="pass_confirm_div">
				<label>Password confirm</label> <br> <input type="password"
					name="password_confirm" class="textInput">
				<div id="password_error"></div>
			</div>
			<hr>
			<div>
				<input type="submit" name="register" value="Register" class="btn">
				<input type="reset" value="Reset" class="btn">
			</div>
		</form>
	</div>
	
</body>
</html>