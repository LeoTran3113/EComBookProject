<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="coding.mentor.entity.Book"%>    
<%@page import="coding.mentor.service.BookService"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchList</title>
</head>
<body>

Welcome to Search List

<hr>

<ul>
<c:forEach var="bookSearch" items="${listS}">

<li>${bookSearch.name} - ${bookSearch.id} - ${bookSearch.categoryId}</li>	

</c:forEach>

</ul>
</body>
</html>