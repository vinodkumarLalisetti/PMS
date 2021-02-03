var firstname = document.forms['vform']['policyname'];
var lastname = document.forms['vform']['policytype'];
var username = document.forms['vform']['companyname'];


// SELECTING ALL ERROR DISPLAY ELEMENTS
var firstname_error = document.getElementById('first_name_error');
var lastname_error = document.getElementById('last_name_error');
var name_error = document.getElementById('name_error');


// event handler functions
function policytNameCheck() {
	if (firstname.value != "") {
		firstname.style.border = "1px solid #5e6e66";
		document.getElementById('firstname_div').style.color = "#5e6e66";
		first_name_error.innerHTML = "";
		return true;
	}
}
function policyTypeCheck() {
	if (lastname.value != "") {
		lastname.style.border = "1px solid #5e6e66";
		document.getElementById('lastname_div').style.color = "#5e6e66";
		last_name_error.innerHTML = "";
		return true;
	}
}

function policyCompanyNameCheck() {
	if (username.value != "") {
		username.style.border = "1px solid #5e6e66";
		document.getElementById('username_div').style.color = "#5e6e66";
		name_error.innerHTML = "";
		return true;
	}
}


// SETTING ALL EVENT LISTENERS
firstname.addEventListener('blur', policytNameCheck, true);
lastname.addEventListener('blur', policyTypeCheck, true);
username.addEventListener('blur', policyCompanyName, true);

// validation function
function Validate() {
	var b=true;
	if (firstname.value == "") {
		firstname.style.border = "1px solid red";
		document.getElementById('firstname_div').style.color = "red";
		first_name_error.textContent = "Policy Name is required";
		firstname.focus();
		b=false;
	}
	if (lastname.value == "") {
		lastname.style.border = "1px solid red";
		document.getElementById('lastname_div').style.color = "red";
		last_name_error.textContent = "Policy Type is required";
		lastname.focus();
		b= false;
	}
		// validate userName
	if (username.value=="") {
		username.style.border = "1px solid red";
		document.getElementById('username_div').style.color = "red";
		name_error.textContent = "Company Name is required";
		username.focus();
		b= false;
	}
	
	if(!b)alert("Please update the highlighted manadatory field(s)");
	return b;
}