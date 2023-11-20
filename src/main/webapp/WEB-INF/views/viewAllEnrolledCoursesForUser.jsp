<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>My Courses</title>
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
	background-color: #5d2e2e;
	height: 115px;
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
	padding-top: 25px;
	padding-bottom: 20px;
	text-decoration: underline;
}

.navbar {
	background-color: orange; //
	padding-top: 10px;
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
	color: orange
}

/*######################################################################################################
main or body content
######################################################################################################*/
main {
	width: 100%;
	height: 70vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)),
		url('/images/2.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-color: lightblue;
	background-color: lightblue;
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
	font-size: 35px;
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
	background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.1)),
		url('../images/showcase.jpg');
	background-repeat: no-repeat;
	background-size: cover;
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
		<h1>Welcome To Course Registration APP</h1>
		<nav class="navbar">
			<ul>
				<li><a href="${pageContext.request.contextPath}/view/profile">My
						Profile</a></li>
				<li><a href="${pageContext.request.contextPath}/view/courses">All
						Courses</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<br>
	<h2 align="center">
		Welcome ${pageContext.request.userPrincipal.name} | <a
			onclick="document.forms['logoutForm'].submit()">Logout</a>
	</h2>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</c:if>
	<!-- ######################################## Body  content  ################################## -->
	<main>


		<section>

			<br>

			<form action="<c:url value="/user/search/enrolled/topic"/>">
				<h3 color="green">Search By Topic Name:</h3>
				<input type="text" name="topicName"
					placeholder="Enter topic name name" />
				<button>Search</button>
			</form>

			<br>

			<H1 color="green">My Enrolled Courses</H1>


			<table border="1">
				<thead>
					<tr>
						<th>Course Name</th>
						<th>Topic Name</th>
						<th>Refer Text</th>
						<th>Refer Video</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${enrolledCourseList}" var="course">
						<tr>
							<td align="center">${course.courseName}</td>
							<td align="center">${course.topicName}</td>
							<td><a target="_blank" href="${course.refUrlText}">Ref
									Url Text</a></td>
							<td><a target="_blank" href="${course.refUrlVideo}">Ref
									Url video</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</main>
	<!-- ######################################## footer content ########################################-->
	<footer>
		<a href="#">copy_write@manisha_blog_spot</a>
	</footer>
</body>
</html>