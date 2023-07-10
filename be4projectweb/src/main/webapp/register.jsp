<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="form-group">
		<form action="register" method="post">
			<label>User Name</label> <input name="user" type="text"
				class="form-control" placeholder="User Name"> <br> <label>Password</label>
			<input name="pass" type="password" class="form-control"
				placeholder="Password"> <br> <label>Repeat
				Password</label> <input name="repass" type="password" class="form-control"
				placeholder="Repeat Password"><br> <label>Email<input
				name="email" type="text" class="form-control" placeholder="Email">
			</label><br>


			<button type="submit" class="btn btn-secondary">Register</button>

		</form>
	</div>
</body>
</html>