<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PaymentPolicy</title>
<link
	href="${pageContext.request.contextPath}/resources/css/loginstyles.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/footer.css"
	rel="stylesheet">

<style>
body {
  background: #EEF2F7;
    margin:0;
    padding:0;
    overflow:auto;
}

.policytable {
	border-collapse: collapse;
	font-family: Arial;
	font-size: 11pt;
	width:70%;
}

.policytable td {
	text-align: center;
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
	<h1 align="center">Payment Details</h1>
	<table align="center" class="policytable" align="left" border="1">
		<tr>
			<th>Payment ID</th>
			<th>Policy ID</th>
			<th>User ID</th>
			<th>Bill Date</th>
			<th>Due Date</th>
			<th>Amount</th>
			<th>Fine</th>
			<th>Payment Status</th>
			<th>Total Amount to Pay</th>

		</tr>
		<tr>
			<td><c:out value="${pay.payid}" /></td>
			<td><c:out value="${pay.policyid}" /></td>
			<td><c:out value="${pay.uid}" /></td>
			<td><c:out value="${pay.billDate}" /></td>
			<td><c:out value="${pay.dueDate}" /></td>
			<td><c:out value="${pay.amount}" /></td>
			<td><c:out value="${pay.fine}" /></td>
			<td><c:out value="${pay.status}" /></td>
			<td><c:out value="${pay.amount+pay.fine}" /></td>			
		</tr>
	</table>
<hr>
	<c:if test="${pay.status=='pending' }">
		<form method="POST"
			action="${pageContext.request.contextPath}/user/proceedpay"
			accept-charset="UTF-8">
			<div class="container">
				<h1>Choose Mode of Payment</h1>
				<hr>
				<input type="hidden" name="payid" value="${pay.payid }" /> <input
					type="radio" name="mode" value="UPI"> <label for="upi">UPI</label><br>
				<input type="radio" name="mode" value="CreditCard" required> <label
					for="creditcard">CreditCard</label><br> <input type="radio"
					name="mode" value="DebitCard"> <label for="debitcard">DebitCard</label>
				<br>
				<input type="radio" name="mode" value="netBank"> 
				<label for="netBank">NetBanking</label> 
					<select name="bankname"	class="form-control" required>
					<option selected="selected" value="0">Choose Bank</option>
					<option value="1">ALLAHABAD BANK</option>
					<option value="2">ANDHRA BANK</option>
					<option value="3">AXIS BANK</option>
					<option value="29">STATE BANK OF INDIA</option>
					<option value="4">BANK OF BARODA</option>
					<option value="29">UCO BANK</option>
					<option value="29">UNION BANK OF INDIA</option>
					<option value="5">BANK OF INDIA</option>
					</select> 
					<hr>
				<label for="psw"><b>Enter UPI/Credit/DebitCard Number</b></label>
				<input type="text" placeholder="Enter Number" name="pin" style="width:50%" required />
				
				<div class="clearfix">
					<button type="submit"  class="signupbtn">Pay Now</button>
				</div>
			</div>
		</form>
	</c:if>
	
	<c:if test="${pay.status=='success'}">
		<hr>
		<h2 style="color:green" align="center">Payment already done, no need to pay again</h2>
		<h2 align="center">Thank You</h2>
	</c:if>
</body>
</html>