<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<style type="text/css">
.center {
	margin: auto;
}

h2, h3 {
	text-align: center;
	color: blue;
}
</style>
</head>
<body>
	<div style="color: red;">${Error}</div>
	<div><jsp:include page="header.html"></jsp:include></div>
	<form action="AddBookServlet" method="post">

		<table class="center">
			<tr>
				<td>Book Code</td>
				<td><input type="text" name="code" value=${bean.bookCode}></td>
			</tr>
			<tr>
				<td>Book Title</td>
				<td><input type="text" name="title" value=${bean.bookTitle }></td>
			</tr>
			<tr>
				<td>Book Author</td>
				<td><input type="text" name="author" value=${bean.bookAuthor }></td>
			</tr>
			<tr>
				<td>Book Price</td>
				<td><input type="text" name="price" value=${bean.bookPrice }></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
</body>
</html>