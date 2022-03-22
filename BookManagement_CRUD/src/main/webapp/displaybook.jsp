<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
<style type="text/css">
		
		table,th,td{
			border:1px solid blue;
			border-collapse:collapse;
		}
		
		.btm{
		margin-left: auto;
		margin-right: auto;
		}
		
		.center{
		margin: auto;
		}
		
		table{
		width: 100%;
		}
		
		th{
		background: black;
		color: white;
		}
</style>
</head>
<body>
<div style="color: blue;">${msg}</div>
<jsp:include page="header.html"></jsp:include>
	<table class="center">
		
		<tr>
			<th>Book Code</th>
			<th>Book Title</th>
			<th>Book Author</th>
			<th>Book Price</th>
			<th>Action</th>
			
		</tr>
		
		<c:forEach items="${requestScope.list}" var="data">
			
			<tr>
				<td>${data.bookCode}</td>
				<td>${data.bookTitle}</td>
				<td>${data.bookAuthor}</td>
				<td>${data.bookPrice}</td>
				<td>
					<a href="UpdateServlet?code=${data.bookCode}">Update</a>
				
					
					<a href="deleteBookServlet?code=${data.bookCode}" class="btm">Delete</a>
				</td>		
				
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>