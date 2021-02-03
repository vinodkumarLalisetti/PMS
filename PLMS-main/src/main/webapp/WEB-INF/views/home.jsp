<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="${pageContext.request.contextPath}/resources/css/homestyles.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/loginstyles.css" rel="stylesheet">


<script src="${pageContext.request.contextPath}/resources/js/loginmodalscript.js" defer></script>
<style type="text/css">
body {
  background: #d1fcae;
    margin:0;
    padding:0;
    overflow:auto;
}

marquee{
margin:2rem;}
</style>
</head>

<body>
 	
 	<div id="modal_wrapper">
		
		<%@ include file="navbar.jsp" %>		
	<h2><marquee>Welcome To Policy Management System</marquee></h2>
		<c:if test="${sessionScope.person!=null}">
		<h2 align="center"> Hi, ${sessionScope.person} ${sessionScope.user.firstname}</h2>
		</c:if>

		<section class="adminloginmodal">
			<%@ include file="admin_login.jsp"%>
		</section>
		<section class="userloginmodal">
			<%@ include file="user_login.jsp"%>
		</section>

	</div>
	<!-- #modal_wrapper -->
</body>



</html>