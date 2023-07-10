<%@page import="coding.mentor.entity.Book"%>
<%@page import="coding.mentor.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

		
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	Welcome to Book List

	<ul>
	<c:forEach var="book" items="${bookList}">
	<a href="book-list.jsp?categoryId=${category.id}">
	<li>${book.name} - ${book.id} - ${book.categoryId}</li>	
	</a>
	</c:forEach>
		
	</ul>
</body>
</html>