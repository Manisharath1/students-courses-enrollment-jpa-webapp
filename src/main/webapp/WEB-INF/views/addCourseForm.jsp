<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
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
	height: 115px;
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
	margin-top: 0px;
	color: white;
	padding-top:20px;
	text-decoration: underline;
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
	padding: 5px 30px;
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
	height: 65.3vh;
	/* background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)),url('images/images.jpg');
	background-repeat: no-repeat;
	background-size: cover; */
	background-color:lightblue;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	color: black;
}

/* span {
	background-color: blue;
}
 */
section h3 {
	font-size: 35px;
	font-weight: 200;
	letter-spacing: 3px;
}

section h1 {
	margin: 10px 0 10px 0;
	font-size: 45px;
	font-weight: 700;
	text-shadow: 2px 1px 5px black;
	text-transform: uppercase;
}

section p {
	font-size: 25px;
	word-spacing: 2px;
	margin-bottom: 10px;
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
	color: blue;
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
	<header>
		<!-- <img src="static/images/punya.PNG" alt="photo"> -->
		<h1>Welcome To Course Enrollment App</h1>
		<nav class="navbar">
			<ul>
				<li><a href="${pageContext.request.contextPath}/view/courses">All Courses</a></li>
				<%-- <li><a href="${pageContext.request.contextPath}/view/enrolledcourses">My EnrolledCourses</a></li> --%>
				<li><a href="${pageContext.request.contextPath}/view/profile">My Profile</a></li>
			</ul>
		</nav>
	</header>
	<h2 align="center">
		Welcome ${pageContext.request.userPrincipal.name} | <a
			onclick="document.forms['logoutForm'].submit()">Logout</a>
	</h2>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</c:if>
	<main>
		<section>
			<h1>
				<u> Add New Course </u>
			</h1>
			<form:form action="${pageContext.request.contextPath}/course/save" method="POST" modelAttribute="course">
				<table>
					<tr>
						<td>Course Name :</td>
						<td><form:input path="courseName" /></td>
						<td><form:errors path="courseName" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Topic Name :</td>
						<td><form:input path="topicName" /></td>
						<td><form:errors path="topicName" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Ref Url Text :</td>
						<td><form:input path="refUrlText" /></td>
						<td><form:errors path="refUrlText" cssClass="errormsg" /></td>
					</tr>
					<%-- <tr>
						<td>Contact Date Of Birth :</td>
						<td><form:input type="date" path="contactDob" /></td>
						<td><form:errors path="contactDob" cssClass="errormsg" /></td>
					</tr> --%>
					<tr>
						<td>Ref Url Video :</td>
						<td><form:input path="refUrlVideo" /></td>
						<td><form:errors path="refUrlVideo" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="reset"
							value="Reset" />&nbsp;<input type="submit" value="Save" /></td>
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