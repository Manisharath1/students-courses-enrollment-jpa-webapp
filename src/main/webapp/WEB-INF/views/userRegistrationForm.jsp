<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
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
	height: 120px;
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
	padding-top:25px;
	text-decoration:underline;
}

.navbar {
	background-color: orange;
	/* border-radius: 10px; */
	/* border: 2px solid red; */
}

.navbar ul {
	overflow: auto;
	margin-top: 50px;
}

.navbar li {
	float: right;
	list-style: none;
	margin: 5px 10px;
}

.navbar li a {
	color: white;
	padding: 3px 30px;
	text-decoration: none;
}

.navbar li a:hover {
	color: orange;
}

/*######################################################################################################
main or body content
######################################################################################################*/
main {
	width: 100%;
	height: 74.3vh;
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

span {
	background-color: blue;
}

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
		<!-- <img src="static/images/punya.PNG" alt="photo"> -->
		<h1>Welcome To Course Enrollment APP</h1>
		<nav class="navbar">
			<ul>
			<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<center>${resp}</center>
	<main>
	<section>
	<h1><u>User Registration Form</u></h1>
	<form:form action="${pageContext.request.contextPath}/register/save" method="post" modelAttribute="userRegForm">
		<table>
			<tr>
				<td align="right">First Name:</td>
				<td><form:input path="firstName" /></td>
				 <td><form:errors path = "firstName" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right">Last Name:</td>
				<td><form:input path="lastName"/></td>
				 <td><form:errors path = "lastName" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right">Email ID:</td>
				<td><form:input path="emailId"/></td>
				 <td><form:errors path = "emailId" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right"> Mobile No:</td>
				<td><form:input path="mobileNo"/></td>
				 <td><form:errors path = "mobileNo" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right">Date Of Birth:</td>
				<td><form:input type="date" path="dob" size="90"/></td>
				 <td><form:errors path = "dob" cssClass = "errormsg" /></td>
			</tr>
			 <tr>
				<td align="right">Login Username:</td>
				<td><form:input path="loginUsername" /></td>
				 <td><form:errors path = "loginUsername" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right">Login Password:</td>
				<td><form:password path="loginPassword" /></td>
				 <td><form:errors path = "loginPassword" cssClass = "errormsg" /></td>
			</tr>
			<tr>
				<td align="right">Admin Code(Optional):</td>
				<td><form:password path="adminCode" /></td>
				<%--  <td><form:errors path = "adminCode" cssClass = "errormsg" /></td> --%>
			</tr>
			<tr>
				<td></td>
				<td colspan="3" align="right"><input type="reset" value="Reset" />&nbsp;&nbsp;<input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</section>
</main>
<!-- ######################################## footer content ########################################-->
	<footer>
		<a href="#">copy_write@punya_blog_spot</a>
	</footer>
</body>
</html>