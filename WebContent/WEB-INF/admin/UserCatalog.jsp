<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap,java.util.ArrayList,util.DataBase" %>

<%! //Initialization of user catalogue
	DataBase DB = (DataBase) getServletContext().getAttribute("DataBase");
	//All users must appear to the admin!!!
	ArrayList<HashMap<String,Object>> users = DB.fetch("SELECT * FROM user");
	//Roles Must be specific for it to work...
	ArrayList<HashMap<String,Object>> roles = DB.fetch("SELECT * FROM role");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage System Users</title>
</head>
<body>
	<form action="AdminDispatch" method="POST">
		<input type="submit" value="Return"/>
		<input type="hidden" name="Action" value="Return" />
	</form>
	<h1>ADD NEW USER:</h1>
	<form action="AdminDispatch" method="POST">
		<input type="hidden" name="Action" value="NewUser" />
		USERNAME : <input type="text" name="username"><br/>
		PASSWORD : <input type="text" name="password"><br/>
		E-MAIL   : <input type="text" name="email"><br/>
		ROLE     : <select name="NUrole">
			<% for(HashMap<String,Object> role : roles){%>
				<option value="<%=(String)role.get("usertype")%>"><%=(String)role.get("usertype")%></option>
			<%}%>
		</select><br/>
	</form>
	<br/>
	<h1>HERE ARE THE USERS!!!</h1>
	<table border="1" bordercolor="green">
		<tr> 
			<td>User_name</td>
			<td>id</td>
			<td>role</td>
		</tr>
		<% for(HashMap<String,Object> user : users) {%>
			<tr>
				<td><%=(String) user.get("username") %></td> <td><%=(String) user.get("id") %></td> <td><%=(String) user.get("usertype") %></td> 
				<td><form action="AdminDispatch" method="POST">
					<input type="submit" value="Delete"/>
					<input type="hidden" name="id" value="<%=user.get("id") %>" />
					<input type="hidden" name="Action" value="Delete" />
				</form></td>
				<td><form action="AdminDispatch" method="POST">
					<input type="submit" value="Update"/>
					<input type="hidden" name="id" value="<%=user.get("id") %>" />
					<input type="hidden" name="Action" value="Update" />
				</form>
			</tr>
		<%}%>
	</table>
</body>
</html>