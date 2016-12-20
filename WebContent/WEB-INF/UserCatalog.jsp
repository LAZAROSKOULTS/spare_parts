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
	<h1>ADD NEW USER:</h1>
	<form action="AddUser" method="POST">
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
	<h3>USERNAME	,	PASSWORD	,	EMAIL	,	ROLE</h3>
	<ul type="square">
		<% for(HashMap<String,Object> user : users) {%>
			<li> 
				<%=(String) user.get("username") %> , <%=(String) user.get("password") %> , <%=(String) user.get("email") %> , <%=(String) user.get("usertype") %>
				<form action="EditUser" method="POST">
				<select name="action">
					<option value="edit">EDIT</option>
					<option value="delete">DELETE</option>
				</select>
				<input type="submit" name="submit" value="DO IT!" />
				<input type="hidden" name="id" value="<%=user.get("id") %>" />
				</form>
			</li>
		<%}%>
	</ul>
</body>
</html>