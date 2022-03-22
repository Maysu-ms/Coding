<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js"></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}

	/* function myRegister() {
	    confirm("Welcome for Registration!");
	}
	
	function myUpdate(){
	   confirm("Welcome for Update!");
	}
	
	function showMessage(){     
	    var message = confirm("Are you sure to register?");
	    if(message)                 
	    document.getElementById('message').innerHTML = "Registration completed.";    
	}
	
	function addListData(source,destination)
	{
	    var sourceList=document.getElementById(source.id);
	    var sourceSelect=sourceList.selectedIndex;
	    
	    var len=sourceList.length;
	    
	    if(sourceSelect!=-1)
	    {
	        for(i=0;i<len;i++)
	        {
	            var isExist = false;
	            var sourceText=sourceList.options[i].text;
	            var destinationList=document.getElementById(destination.id);
	            if(sourceList[i].selected)
	            {
	                for(var j=0;j<destinationList.length;j++)
	                {
	                    if(destinationList.options[j].text == sourceText)
	                    {
	                        isExist = true;
	                    }
	                }
	                if(!isExist)
	                {
	                    destinationList.options[destinationList.length]=new Option(sourceText,"0");     
	                }
	            }
	        }           
	    } */
	/*  }
	 function delListData(source)
	 {
	     var sourceList=document.getElementById(source.id);
	     for(var index=0;index<sourceList.length;index++){   
	         if (sourceList[index].selected) {
	             sourceList.remove(index);
	             delListData(source);
	         }
	     }
	 } */
</script>
</head>
<body class="main_body">

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
				
					<h3>Student Register</h3>
					<label id="errormsg"> ${error } ${success } </label><br />
					<br />
					<br />
					<form action="StudentRegister"  method="post">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel">Student No *</td>
							<td class="tblSingleInput"><input type="text" value="${bean.id }" class="txtlong" name="id" /></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Student Name *</td>
							<td class="tblSingleInput"><input type="text" value="${bean.name }" class="txtlong" name="name" />
						</tr>
						<tr>
							<td class="tblSingleLabel">Class Name *</td>
							<td class="tblSingleInput">
							<select id="expenseType" class="normal_sel" name="className" >
									<option></option>
									<c:forEach var="d" items="${list}">
											
										<!--	<c:if test="${bean.className==d.name}">selected</c:if>>${d.name}</option>   -->	
											<option>${d.name }</option>
										</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Registered Date *</td>
							<td class="tblSingleInput"><select id="expenseType" class="short_sel" name="year">
									<option>Year</option>
									<c:forEach var="i" begin="2020" end="2030">
									<option <c:if test="${bean.year!='Year' and bean.year==1 }" >selected</c:if>>${i }</option>
									</c:forEach>
									
									
							</select> <select id="expenseType" class="short_sel" name="month">
									<option>Month</option>
									<c:forEach var="i" begin="1" end="12">
									<option <c:if test="${bean.month!='Month' and bean.month==i}">selected</c:if>>${i }</option>
									
									</c:forEach>
							</select> <select id="expenseType" class="short_sel" name="day">
									<option>Day</option>
									<c:forEach var="i" begin="1" end="31">
									<option <c:if test="${bean.day !='Day' and bean.day==i }"> selected</c:if>>${i }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Status *</td>
							<td class="tblSingleInput"><select id="expenseType"
								class="normal_sel" name="status">
									<option></option>
									<option>Attending</option>
									<option>Passed</option>
									<option>Failed</option>
							</select></td>
						</tr>


					</table>
					<br />
					<div id="btnGroup">
						<input type="submit" value="Register" class="button" />
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>