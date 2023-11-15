<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="setProfilePic" method="post"
		enctype="multipart/form-data">
		Select File: <input type="file" name="file" /> <input type="submit"
			value="Upload File" />
	</form>
	<!-- JS -->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>