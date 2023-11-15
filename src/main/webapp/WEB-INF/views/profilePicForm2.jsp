<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee | Sign up</title>
<!-- Font Icon -->
<link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<center>
		<!-- <h3>Spring Boot Image Upload & Download Example</h3> -->
	</center>
	<!-- Sign up form -->
	<section class="signup">
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h3 class="form-title">Choose Your Profile Picture:</h3>
					<br>
					<form class="register-form" name="register-form" id="register-form">
				
						<div class="form-group">
							<label for="attachment"><i class="zmdi zmdi-file"></i></label> <input
								type="file" name="file" accept="*" id="file" />
							<div class="help-block" id="error_file"></div>
						</div>
						<div class="form-group form-button">
							<input type="button" id="signup" class="form-submit"
								value="Upload" />
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="/images/signup-image.jpg" alt="sing up image">
					</figure>
					<div style="display: flex; justify-content: space-between;">
						<a href="${pageContext.request.contextPath}/home" class="signup-image-link"> Home</a>
						<a href="${pageContext.request.contextPath}/view/profile">My Profile</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- JS -->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>