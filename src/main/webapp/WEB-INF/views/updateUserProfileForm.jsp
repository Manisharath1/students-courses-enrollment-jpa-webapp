<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Courses</title>
<style type="text/css">

* {
	margin: 0px;
	padding: 0px;
}

/*####################################################################################################
	header section
    ####################################################################################################*/
header {
	margin: auto;
	/* border: 2px solid red; */
	background-color: #5d2e2e;
	height: 135px;
	/* border-radius: 10px; */
}

img {
	margin: auto;
	padding: 5px;
	display: block;
	width: 70px;
	border-radius: 40px;
}

h1 {
	text-align: center;
	margin: 0px;
	color: white;
	padding-top:20px;
}

.navbar {
	background-color: orange;
	/* border-radius: 10px; */
	/* border: 2px solid red; */
}

.navbar ul {
	overflow: auto;
	margin-top: 60px;
}

.navbar li {
	float: right;
	list-style: none;
	margin: 10px 20px;
}

.navbar li a {
	color: white;
	padding: 3px 30px;
	text-decoration: none;
}

.navbar li a:hover {
	color: orange
}

/*######################################################################################################
main or body content
######################################################################################################*/
main {
	width: 100%;
	height: 62.3vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)),url('/images/2.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-color:lightblue;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	color: white;
}

/* span {
	background-color: blue;
} */

section h3 {
	font-size: 35px;
	font-weight: 200;
	letter-spacing: 3px;
}

section h1 {
	margin: 30px 0 20px 0;
	font-size: 45px;
	font-weight: 700;
	text-shadow: 2px 1px 5px black;
	text-transform: uppercase;
}

section p {
	font-size: 25px;
	word-spacing: 2px;
	margin-bottom: 25px;
	text-shadow: 1px 1px 1px black;
}

section a {
	padding: 12px 30px;
	border-radius: 4px;
	outline: none;
	/*text-transform: uppercase;*/
	font-size: 13px;
	font-weight: 500;
	text-decoration: none;
	letter-spacing: 1px;
	color: white;
}

section .btn_login {
	background: orange;
}

section .btn_signup {
	background: orange;
}

.errormsg {
    color: red;
    font-style: bold;
}

/*main or body section endened */

/*####################################################################################################
	footer section
####################################################################################################*/
footer {
	width: 100%;
	height: 5vh;
	/*background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.1)), url('../images/showcase.jpg');*/
	/*background-repeat: no-repeat;*/
	/*background-size: cover;*/
	background-color: #5d2e2e;
	text-align: center;
	padding-top: 5px;
}

footer a {
	font-size: 15px;
	font-weight: 500;
	text-decoration: none;
	letter-spacing: 1px;
	color: white;
}
</style>
</head>
<body>
<!-- ######################################## Header  content  ################################## -->
	<header>
		<h1>Welcome To Course Enrollment APP</h1>
		<nav class="navbar">
			<ul>
				<li><a href="${pageContext.request.contextPath}/view/courses">All Courses</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<br>
 <h2 align="center">Welcome ${pageContext.request.userPrincipal.name} |  <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
	 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
     <!-- ######################################## main or body  content  ################################## -->
<main>
   <section>
	<h1><u>Edit My Profile Details</u></h1>
	<form:form method="POST" action="${pageContext.request.contextPath}/profile/update" modelAttribute="userReg">
		<table>
			<tr>
				<td>User Id</td>
				<td><form:input path="userid" readonly="true"/></td>
			</tr>
			<tr>
				<td>Login Username:</td>
				<td><form:input path="loginUsername" /></td>
				<td><form:errors path = "loginUsername" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path = "firstName" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
				<%-- <td><form:errors path = "lastName" cssClass = "errormsg" /></td> --%>
			</tr>
			<tr>
				<td>Email ID :</td>
				<td><form:input path="emailId" /></td>
				<td><form:errors path = "emailId" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><form:input path="mobileNo" /></td>
				<td><form:errors path = "mobileNo" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td>Date Of Birth :</td>
				<td width="40"><form:input type="date" path="dob"/></td>
				 <td><form:errors path = "dob" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
	</section>
	</main>
	<footer>
           <a href="#">copy_write@manisha's_blog_spot</a>
       </footer>
</body>
</html>
