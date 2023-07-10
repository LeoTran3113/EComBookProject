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
	Welcome to Book Details
	<hr>
	Id: ${book.id}
	<br> Name: ${book.name}
	<br> Title: ${book.title}
	<br> Author: ${book.author}
	<br> Stock: ${book.stock}
	<br> Price: ${book.price}
	<br>
	<input type="button" value="Add to Cart"
		onclick="window.location.href='cart?command=AddCart&bookId=${book.id}'" />

</body>
</html>