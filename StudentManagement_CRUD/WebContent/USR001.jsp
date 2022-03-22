<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search </title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js" ></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js" ></script>
<script type="text/javascript">
	window.onload=function()
    {
    	menu();
    }

      /*   var param = getPara( 'flag');
        if(param==1)
        {
            document.getElementById('list').style.display="block";           
        }
        else
        {
            document.getElementById('list').style.display="none";
        }
    }

    function searchList(flag)
    {
        if(flag==1){
             document.getElementById('list').style.display="block";
        
        }else{
            document.getElementById('list').style.display="none";
           
        }
    }
	function resetForm()
	{
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display="none";
	}
 */
	function checkDelete()
    {
        var con = confirm("Are you sure to delete?");
        /*  if(con)
        {
            window.location.replace('USR001.jsp?flag=1')
        }  */

    }
	
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
                    <td>: ${name }</td>
                </tr>
                <tr>
                    <td>Current Date</td><td>:  ${date }</td>
                </tr>
            </table>
        </div>
        <input id="btn_logout" class="button" type="button" value="Logout" onclick="location.href='LGN001.jsp'">    
    </div>

    <div id="container"> 
            <div id="left_menu">
            	<!-- menu html code exist the menu function of general.js -->
            </div>
            <div id="main_contents">     
                <div id="contents">
                <div class="search_form">
				<h3>User Search</h3>
				<form action="UserSearch" method="get">
				<table class="tableForm">
					<tr>
						<td class="tblLabel"><label>User ID</label></td>
						<td class="tblInputNormal"><input type="text" id="txtUserId" name="id" class="txt" value=""/>	</td>
	
						<td class="tblLabel">User Name	</td>
						<td class="tblInputNormal"><input type="text" id="txtUserName" name="name" class="txt" value="" /></td>
						
					</tr>
				</table>
				<br/>
				<input type="submit" value="Search" class="button" />     
 <a href="USR002.jsp"> <input type="button" value="Add" class="button" id="userInsert" /> </a> 
 <a href="USR001.jsp"> <input type="button" value="Reset" class="button" id="userInsert" /> </a> 
				 
				
				</form>
				<br/>
				<br/>	
				<div id="errormsg">
					<label id="message">${error } ${success }</label>
				</div>
			</div>   

                <br/><br/><br/>
			<div id="list">
				<form name="listForm" >
					<table class="resultTable">
					<c:if test="${requestScope.list != null }">
						<tr class="tblHeader">
							<th width="1%">Update</th>
							<th width="1%">Delete</th>
							<th width="12%">User ID</th>
							<th width="24%">User Name</th>
							
						</tr>
						</c:if>
						<c:forEach var="data" items="${requestScope.list}">
						<tr>
						<td><a href="UserUpdate?id=${data.id }"><input type="button" value="Update" id="userUpdate" class="button" /></a></td>
						<td><a href="UserDelete?id=${data.id }"><input type="button" value="Delete" class="button" id="delete" /></a></td>
						
						
						<td>${data.id }</td>
						<td>${data.name }</td>
						</tr>
						</c:forEach>
						
						
						<!-- <tr>
						 	<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
                           
							<td>U000001</td>
							<td>Kyaw Kyaw</td>                
						</tr>
						<tr>
						 	<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
	                            		<input type="button" value="Update" class="button" id="userUpdate" />
	                        	</a>
                        	</td>
                           
							<td> U000002</td>
							<td>Zaw Zaw</td>
						</tr>
						<tr>
                            <td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
	                            	<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
							<td>U000003</td>
							<td>Aung Aung</td>
						</tr>
						<tr>
                            <td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
							<td> U000004</td>
							<td>Maung Maung</td>
						</tr>
						<tr>
                            <td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
							<td>U000005</td>
							<td>Ko Ko</td>
						</tr>
						<tr>
                            <td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
                            <td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
							<td> U000006</td>
							<td>Aung Kyaw</td>
						</tr>
						<tr>
							<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
	                            	<input type="button" value="Update" class="button" id="userUpdate" />
	                        	</a>
                        	</td>
							<td>U000007</td>
							<td>Ko Ko</td>
						</tr>
						<tr>
							<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
                        	<td> U000008</td>
							<td>Nwe Nwe</td>
						</tr>
						<tr>
							<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
							<td> U000009</td>
							<td>Tin Tin</td>
						</tr>
						<tr>
							<td>
                             	<input type="button" value="Delete" id="delete" class="button" onClick="javascript:checkDelete()" />
                            </td>
							<td>
								<a href="USR002-01.jsp">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
                            
							<td> U000010</td>
							<td>Aye Aye</td>
						</tr> -->
					</table>
				</form>
			</div>    

            </div>
            </div>
                
            </div> 
            <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
     </div>
</body>
</html>