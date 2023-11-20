<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>My Blog</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	background-image: url("2.jpeg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
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
	padding-top: 25px;
	text-decoration: underline;
}

.navbar {
	background-color: orange;
}

.navbar ul {
	overflow: auto;
	margin-top: 57px;
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
	height: 74.3vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)),
		url('/images/2.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-color: lightblue;
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
<body
	background="https://1.bp.blogspot.com/-sTxAHAxirGM/WVbAe2098nI/AAAAAAABENs/_I5sYMYgLOUzaIE7FfF4qdGX-hoAkq9SgCLcBGAs/s1600/Blog_20170624_113552.jpg">
	<!-- ######################################## Header  content  ################################## -->
	<header>
		<h1 color="cyan">Welcome To Courses Enrollment APP</h1>
		<nav class="navbar">
			<ul>
				<li><a href="${pageContext.request.contextPath}/view/courses">All
						Courses</a></li>
				<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/register/form">Register</a></li>
				<%-- <li><a href="${pageContext.request.contextPath}/view/contacts">My Contacts</a></li> --%>

				<%-- <li><a href="${pageContext.request.contextPath}/homePage">Home</a></li> --%>
			</ul>
		</nav>
	</header>
	<!-- ######################################## main or body  content  ################################## -->
	<main>
		<section>

			<h3>Thank You for visiting this site</h3>
			<h1 color="green">Online Learning Made Easy</h1>
			<p>Better Way To Upgrade Your Skills</p>
			<a href="register/form" class="btn_signup">Sign Up</a> -->
		</section>
	</main>
	<!-- ######################################## footer content ########################################-->
	<footer>
		<a href="#">copy_write@Manisha_blog_spot</a>
	</footer>

</body>
</html>