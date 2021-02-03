var firstname = document.forms['vform']['firstname'];
var lastname = document.forms['vform']['lastname'];
var gender = document.forms['vform']['gender'];
var phonenumber = document.forms['vform']['phonenumber']
var username = document.forms['vform']['username'];
var email = document.forms['vform']['email'];
var password = document.forms['vform']['password'];
var password_confirm = document.forms['vform']['password_confirm'];

// SELECTING ALL ERROR DISPLAY ELEMENTS
var firstname_error = document.getElementById('first_name_error');
var lastname_error = document.getElementById('last_name_error');
var firstname_error = document.getElementById('gender_error');
var phoneerror = document.getElementById('phonenumber_error');
var name_error = document.getElementById('name_error');
var email_error = document.getElementById('email_error');
var password_error = document.getElementById('password_error');

// event handler functions
function firstNameCheck() {
	if (firstname.value != "") {
		firstname.style.border = "1px solid #5e6e66";
		document.getElementById('firstname_div').style.color = "#5e6e66";
		first_name_error.innerHTML = "";
		return true;
	}
}
function lastNameCheck() {
	if (lastname.value != "") {
		lastname.style.border = "1px solid #5e6e66";
		document.getElementById('lastname_div').style.color = "#5e6e66";
		last_name_error.innerHTML = "";
		return true;
	}
}
function phoneCheck() {
	if (phonenumber.value != "") {
		phonenumber.style.border = "1px solid #5e6e66";
		document.getElementById('phonenumber_div').style.color = "#5e6e66";
		last_name_error.innerHTML = "";
		return true;
	}
}

function userNameCheck() {
	if (username.value != "") {
		username.style.border = "1px solid #5e6e66";
		document.getElementById('username_div').style.color = "#5e6e66";
		name_error.innerHTML = "";
		return true;
	}
}
function emailCheck() {
	if (email.value != "") {
		email.style.border = "1px solid #5e6e66";
		document.getElementById('email_div').style.color = "#5e6e66";
		email_error.innerHTML = "";
		return true;
	}
}
function passwordCheck() {
	if (password.value != "") {
		password.style.border = "1px solid #5e6e66";
		document.getElementById('pass_confirm_div').style.color = "#5e6e66";
		document.getElementById('password_div').style.color = "#5e6e66";
		password_error.innerHTML = "";
		return true;
	}
	if (password.value === password_confirm.value) {
		password.style.border = "1px solid #5e6e66";
		document.getElementById('pass_confirm_div').style.color = "#5e6e66";
		password_error.innerHTML = "";
		return true;
	}
}

// SETTING ALL EVENT LISTENERS
firstname.addEventListener('blur', firstNameCheck, true);
lastname.addEventListener('blur', lastNameCheck, true);
phonenumber.addEventListener('blur', phoneCheck, true);
username.addEventListener('blur', userNameCheck, true);
email.addEventListener('blur', emailCheck, true);
password.addEventListener('blur', passwordCheck, true);

// validation function
function Validate() {
	var b=true;
	if (firstname.value == "") {
		firstname.style.border = "1px solid red";
		document.getElementById('firstname_div').style.color = "red";
		first_name_error.textContent = "Firstname is required";
		firstname.focus();
		b=false;
	}
	if (lastname.value == "") {
		lastname.style.border = "1px solid red";
		document.getElementById('lastname_div').style.color = "red";
		last_name_error.textContent = "Lastname is required";
		lastname.focus();
		b= false;
	}
	if (phonenumber.value == "") {
		phonenumber.style.border = "1px solid red";
		document.getElementById('phonenumber_div').style.color = "red";
		phonenumber_error.textContent = "Contact Number is required";
		username.focus();
		b= false;
	}

	// validate userName
	if (username.value.length < 3) {
		username.style.border = "1px solid red";
		document.getElementById('username_div').style.color = "red";
		name_error.textContent = "Username must be at least 3 characters";
		username.focus();
		b= false;
	}
	// validate email
	if (email.value == "") {
		email.style.border = "1px solid red";
		document.getElementById('email_div').style.color = "red";
		email_error.textContent = "Email is required";
		email.focus();
		b= false;
	}
	// validate password
	if (password.value == "") {
		password.style.border = "1px solid red";
		document.getElementById('password_div').style.color = "red";
		password_confirm.style.border = "1px solid red";
		password_error.textContent = "Password is required";
		password.focus();
		b= false;
	}
	// check if the two passwords match
	if (password.value != password_confirm.value) {
		password.style.border = "1px solid red";
		document.getElementById('pass_confirm_div').style.color = "red";
		password_confirm.style.border = "1px solid red";
		password_error.innerHTML = "The two passwords do not match";
		b= false;
	}
	if(!b)alert("Please update the highlighted manadatory field(s)");
	return b;
}