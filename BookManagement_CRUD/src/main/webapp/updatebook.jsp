<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<style type="text/css">
.center {
	margin: auto;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.html"></jsp:include>
	</div>
	<div style="color: red;">${Error }</div>
	<div>
		<form action="UpdateServlet" method="post">
			<table class="center">
				<tbody>
					<tr>
						<td>Book Code</td>
						<td><input type="text" name="code" value=${res.bookCode }
							readonly="readonly"></td>

					</tr>
					<tr>
						<td>Book Title</td>
						<td><input type="text" name="title" value=${res.bookTitle }></td>

					</tr>
					<tr>
						<td>Book Author</td>
						<td><input type="text" name="author" value=${res.bookAuthor }></td>

					</tr>
					<tr>
						<td>Book Price</td>
						<td><input type="text" name="price" value=${res.bookPrice }></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Update"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>