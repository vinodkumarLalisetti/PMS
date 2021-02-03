<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<style>

#modal_window1 {
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

#modal_wrapper.overlay #modal_window1 {
	display: block;
}
</style>
<body>

	<div id="modal_window1">
			<!-- <div style="text-align: right;">
				<a id="modal_close1" href="#" style="color: red">close <b>X</b></a>
			</div> -->
			<div>
				<form id="modal_login1" method="POST" action="${pageContext.request.contextPath}/user/login"
					accept-charset="UTF-8">
					<div class="container">
						<h1>User Login</h1>
						<p>Please login with your credentials</p>
						<hr>
						<label for="email"><b>Login</b></label> <input type="text"
							placeholder="Enter Username" name="username" required> <label
							for="psw"><b>Password</b></label> <input type="password"
							placeholder="Enter Password" name="password" required> <label>
							<input type="checkbox" checked="checked" name="remember"
							style="margin-bottom: 15px"> Remember me
						</label>

						<p>
							By creating an account you agree to our <a href="#"
								style="color: dodgerblue">Terms & Privacy</a>.
						</p>

						<div class="clearfix">
							<button type="submit" class="signupbtn">login</button>

							<button type="button" class="cancelbtn" id="modal_close1">Cancel</button>

							<button type="button" class="signup"
								onclick="openPage('${pageContext.request.contextPath}/user/register')">signup</button>

						</div>
					</div>

				</form>
			</div>

		</div>
		<!-- #modal_window -->

<script type="text/javascript">
var modal_init = function() {

	var modalWrapper = document.getElementById("modal_wrapper");
	var modalWindow = document.getElementById("modal_window1");

	var openModal = function(e) {
		modalWrapper.className = "overlay";
		var overflow = modalWindow.offsetHeight
				- document.documentElement.clientHeight;
		if (overflow > 0) {
			modalWindow.style.maxHeight = (parseInt(window
					.getComputedStyle(modalWindow).height) - overflow)
					+ "px";
		}
		modalWindow.style.marginTop = (-modalWindow.offsetHeight) / 2 + "px";
		modalWindow.style.marginLeft = (-modalWindow.offsetWidth) / 2 + "px";
		e.preventDefault ? e.preventDefault() : e.returnValue = false;
	};

	var closeModal = function(e) {
		modalWrapper.className = "";
		e.preventDefault ? e.preventDefault() : e.returnValue = false;
	};

	var clickHandler = function(e) {
		if (!e.target)
			e.target = e.srcElement;
		if (e.target.tagName == "div") {
			if (e.target.id != "modal_window1")
				closeModal(e);
		}
	};

	var keyHandler = function(e) {
		if (e.keyCode == 27)
			closeModal(e);
	};

	if (document.addEventListener) {
		
		document.getElementById("modal_open1").addEventListener("click",
				openModal, false);
		
		document.getElementById("modal_close1").addEventListener("click",
				closeModal, false);
		document.addEventListener("click", clickHandler, false);
		document.addEventListener("keydown", keyHandler, false);
	} else {
		document.getElementById("modal_open1").attachEvent("onclick", openModal);

		document.getElementById("modal_close1").attachEvent("onclick",
				closeModal);
		document.attachEvent("onclick", clickHandler);
		document.attachEvent("onkeydown", keyHandler);
	}

};

if (document.addEventListener) {
	document.addEventListener("DOMContentLoaded", modal_init, false);
} else {
	document.getElementById("modal_login1").attachEvent("onclick", checkForm);
	window.attachEvent("onload", modal_init);
}
</script>

</body>
</html>