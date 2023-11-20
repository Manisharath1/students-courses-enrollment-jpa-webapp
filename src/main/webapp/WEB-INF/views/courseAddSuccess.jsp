<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>course enrollment success</title>
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
	height: 120px;
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
	height: 200vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)), url('images/images3.jpg');
	background-repeat: no-repeat;
	background-size: cover;
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

/*####################################################################################################
	footer section
####################################################################################################*/
footer {
	width: 100%;
	height: 5vh;
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
		<h1>Welcome To Course Registration APP</h1>
		<nav class="navbar">
			<ul>
			<li><a href="${pageContext.request.contextPath}/view/courses">All Courses</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<br>
	<br>
	<h1><center>${reg}</center></h1>
	
	<main>
	<section>
	
   </section>
</main>
<!-- ######################################## footer content ########################################-->
	<footer>
		<a href="#">copy_write@manisha's_blog_spot</a>
	</footer>
</body>
</html>