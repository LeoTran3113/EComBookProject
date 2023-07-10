
<%@page import="coding.mentor.entity.Category"%>
<%@page import="coding.mentor.service.CategoryService"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.sub-body-category {
	float: left;
	width: 30%;
	padding: 10px;
	/* Should be removed. Only for demonstration */
}

.sub-body-book {
	float: left;
	width: 70%;
	padding: 10px;
	/* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.body:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<span><div>
			<c:if test="${not empty session}">
				<li><a>Hello ${session.acc} </a></li>
			</c:if>
			<a href="http://localhost:8080/be4projectweb/login.jsp">
				<button
					onclick="document.getElementById('id01').style.display='block'"
					style="width: auto;">Login</button>
			</a>
		</div>
		<div>
			<a href="http://localhost:8080/be4projectweb/register.jsp">
				<button
					onclick="document.getElementById('id01').style.display='block'"
					style="width: auto;">Register</button>
			</a>
		</div></span>
	<div class="header">
		<form action="home">
			<input type="text" name="bookName"> <input type="submit"
				value="search">
		</form>




	</div>
	<%-- lay so luong book trong cart tu session --%>
	<c:set var="cart" value="${sessionScope.cart}" />

	<%-- Tinh tong so luong book trong cart --%>
	<c:set var="totalQuantity" value="0" />
	<c:if test="${not empty cart}">
		<c:forEach var="entry" items="${cart}">
			<c:set var="totalQuantity"
				value="${totalQuantity + entry.value.getQuantity()}" />
		</c:forEach>
	</c:if>
	<a href="cart?command=ViewCart">Cart(${totalQuantity})</a>



	<br>
	<hr>
	<div class="body">
		<div class="sub-body-category">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>

		<div clas s="sub-body-book">
			<c:if test="${empty bookList}"> This Category is not available</c:if>
			<c:if test="${not empty bookList}">
				<ul>
					<c:forEach var="book" items="${bookList}">
						<a href="bookDetail?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
</body>
<hr>
<div class="footer">ThIS IS CODING MENTOR CLASS</div>
</html>