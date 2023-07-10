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
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Application<br> Login Page
			</h2>
		
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="login" method="get">
					<h1><p {color: red;} class="text-danger">${message}</p></h1>

					<div class="form-group">
						<label>User Name</label> <input name="user" type="text"
							class="form-control" placeholder="User Name">
					</div>
					<div class="form-group">
						<label>Password</label> <input name="password" type="password"
							class="form-control" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-black">Login</button>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>