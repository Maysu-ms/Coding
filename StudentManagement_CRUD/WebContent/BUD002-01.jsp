<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Update</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js"></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}

	function deleteStudent() {
		var isOk = confirm("Are you sure to delete?");
		if (isOk) {
			document.getElementById("myform").action = "StudentDeleteServlet";
			document.getElementById("myform").submit();
		}
	}
</script>
</head>
<body class="main_body">

	<%-- <jsp:include page="header.jsp" /> --%>
	<div id="header">
		<div id="title">
			<a href="M00001.jsp">Student Registration Assignment</a>
		</div>
		<div id="menuLoginTime">
			<table>
				<tr>
					<td>User</td>
					<td>:${name }</td>
				</tr>
				<tr>
					<td>Current Date</td>
					<td>: ${date }</td>
				</tr>
			</table>
		</div>
		<input id="btn_logout" class="button" type="button" value="Logout"
			onclick="location.href='LGN001.jsp'">
	</div>

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>Student Update</h3>
					<label id="errormsg"> ${err} </label> <label style="color: blue;">${msg}</label>
					<br />
					<br />
					<br />
					<form action="StudentUpdateServlet" method="post" id="myform">
						<input type="hidden" name="id" class="txtlong" value="${bean.id}" />
						<table class="tableForm">
							<tr height="30px">
								<td class="tblSingleLabel">Student No.</td>
								<td class="tblSingleInput">${bean.id}</td>
							</tr>



							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><input type="text" name="name"
									class="txtlong" value="${bean.name}" /></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" name="className">
										<option></option>
										<c:forEach var="list" items="${applicationScope.classlist}">
											<option
												<c:if test="${bean.className==list.name}">selected</c:if>>${list.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Registered Date *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="short_sel" name="year">
										<option>Year</option>
										<c:forEach var="i" begin="2020" end="2030">
											<option
												<c:if test="${bean.year!='Year' and bean.year==i}">selected</c:if>>${i}</option>
										</c:forEach>

								</select> <select id="expenseType" class="short_sel" name="month">
										<option>Month</option>
										<c:forEach var="i" begin="1" end="12">
											<option
												<c:if test="${bean.month!='Month' and bean.month==i}">selected</c:if>>${i}</option>
										</c:forEach>
								</select> <select id="expenseType" class="short_sel" name="day">
										<option>Day</option>
										<c:forEach var="i" begin="1" end="31">
											<option
												<c:if test="${bean.day!='Day' and bean.day==i}">selected</c:if>>${i}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><select id="expenseType"
									class="normal_sel" name="status">
										<option></option>
										<option
											<c:if test="${bean.status=='Attending'}">selected</c:if>>Attending</option>
										<option <c:if test="${bean.status=='Passed'}">selected</c:if>>Passed</option>
										<option <c:if test="${bean.status=='Failed'}">selected</c:if>>Failed</option>
								</select></td>
							</tr>
						</table>
						<br />
						<div id="btnGroup">
							<input type="submit" value="Update" class="button" /> <input
								type="button" value="Delete" id="delete" class="button"
								onclick="deleteStudent()" />
					</form>
					<input type="button" value="Back" class="button"
						onclick="window.location.replace('BUD001.jsp')" />

				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>