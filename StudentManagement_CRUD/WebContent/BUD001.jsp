<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD001)Student Search</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js"></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();

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
					<h3>Student Search Page</h3>
					<form action="StudentSearchServlet">
						<table class="tableForm">
							<tr>
								<td class="tblLabel">Student No.</td>
								<td class="tblInputShort"><input type="text" name="id"
									class="txt" /></td>
								<td class="tblLabel">Student Name</td>
								<td class="tblInputShort"><input type="text" name="name"
									class="txt" /></td>
								</tr >
								<tr>
									<td class="tblLabel">Class Name</td>
									<td class="tblInputNormal" colspan="3"><input type="text"
										id="companyName" name="className" class="txtlong" /></td>
								</tr>
						</table>
						<br /> <input type="submit" value="Search" class="button" /> <input
							type="button" value="Reset" onclick="UBD001.jsp" class="button" />
						<br />
						<br />
						<div id="errormsg">
							<label id="message">${err}</label>
						</div>
						<label style="color: blue;">${msg}</label>
					</form>
					<div id="list">
						<form name="listForm">
							<Br />
							<Br /> <br />
							<table class="resultTable">
								<c:if test="${stulist!=null}">
									<tr class="tblHeader">
										<th width="5%">No</th>
										<th width="10%">Student No</th>
										<th width="25%">Student Name</th>
										<th width="40%">Class Name</th>
										<th width="10%">Registered Date</th>
										<th width="10%">Status</th>
									</tr>
								</c:if>
								<c:forEach var="list" items="${stulist}" varStatus="a">
									<tr>
										<td>${a.count}</td>
										<td>${list.studentId}</td>
										<td><a
											href="StudentUpdateServlet?name=${list.studentName}">${list.studentName}
										</a></td>
										<td>${list.className}</td>
										<td>${list.registerDate}</td>
										<td>${list.status}</td>
									</tr>
								</c:forEach>
							</table>
							<br />

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>