<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> File Upload</title>
</head>
<body>
<form:form method="POST" modelAttribute="fileUpload" enctype="multipart/form-data" action="fileUploadPage">
Please select a file to upload :
<input type="file" name="file" />
<input type="submit" value="upload" />
</form:form>

</body>
</html>