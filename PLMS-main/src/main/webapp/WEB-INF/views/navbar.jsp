<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<head>
<title>Home</title>
<link href="${pageContext.request.contextPath}/resources/css/homestyles.css" rel="stylesheet">
<style type="text/css">
.adminloginmodal {
	display: none;
}

.userloginmodal {
	display: none;
}

.visible {
	display: block;
}
</style>
<script type="text/javascript">
		function showadminLoginHandler()

		{
			//alert("hai");
			const modalWindow = document.querySelector('.adminloginmodal');
			const modalWindow1 = document.querySelector('.userloginmodal');
			modalWindow.classList.add('visible');
			modalWindow1.classList.remove('visible');

		}
		function showuserLoginHandler()

		{
			//alert("ushai");	
			const modalWindow = document.querySelector('.userloginmodal');
			const modalWindow1 = document.querySelector('.adminloginmodal');
			modalWindow.classList.add('visible');
			modalWindow1.classList.remove('visible');
		}
		function openPage(pageURL) {
			window.location.href = pageURL;
		}
	</script>
</head>
<body>
	<div class="nav">
			<a href="home">Home</a> 
			<c:if test="${sessionScope.person==null}">
			<a id="modal_open1" href="#" onclick="showuserLoginHandler()">UserLogin</a> 
			<a id="modal_open" href="#" onclick="showadminLoginHandler()">AdminLogin</a>
			</c:if>
			
			<c:if test="${sessionScope.person=='admin'}">
			<a href="createpolicy" >Create Policy</a>
			<a href="updatepolicy">Update Policy</a>
			</c:if>
			
			<c:if test="${sessionScope.person=='user'}">
			<a href="searchpolicy">Search Policy</a>
			<a href="policypayment">Policy Payment</a>
			</c:if>
			<c:if test="${sessionScope.person!=null}">
			<a href="${pageContext.request.contextPath}/${sessionScope.person}/logout">Logout</a>
			</c:if>
			<a href="#">About Us</a>
			<a href="#">Contact</a>
	</div>
		
		
</body>