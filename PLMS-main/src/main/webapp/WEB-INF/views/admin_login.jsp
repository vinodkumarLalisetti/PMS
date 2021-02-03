<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<style>

#modal_window {
	display: none;
	z-index: 200;
	position: fixed;
	left: 50%;
	top: 50%;
	width: 360px;
	overflow: auto;
	padding: 10px 20px;
	background: #fff;
	border: 5px solid #999;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

#modal_wrapper.overlay #modal_window {
	display: block;
}

</style>
<body>

	<div id="modal_window">
			<!-- <div style="text-align: right;">
				<a id="modal_close1" href="#" style="color: red">close <b>X</b></a>
			</div> -->
			<div>
				<form id="modal_login" method="POST" action="${pageContext.request.contextPath}/admin/login"
					accept-charset="UTF-8">
					<div class="container">
						<h1>Admin Login</h1>
						<p>Please login with your credentials</p>
						<hr>
						<label for="email"><b>Login</b></label> <input type="text"
							placeholder="Enter Username" name="username" required> <label
							for="psw"><b>Password</b></label> <input type="password"
							placeholder="Enter Password" name="password" required> <label>
							<input type="checkbox" checked="checked" name="remember"
							style="margin-bottom: 15px"> Remember me
						</label>

					<!-- 	<p>
							By creating an account you agree to our <a href="#"
								style="color: dodgerblue">Terms & Privacy</a>.
						</p> -->

						<div class="clearfix">
							<button type="submit" class="signupbtn">login</button>

							<button type="button" class="cancelbtn" id="modal_close">Cancel</button>

							<button type="button" class="signup"
								onclick="openPage('${pageContext.request.contextPath}/admin/register')">SignUp</button>

						</div>
					</div>

				</form>
			</div>

		</div>
		<!-- #modal_window -->
		

</body>
</html>