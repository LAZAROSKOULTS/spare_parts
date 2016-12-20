<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap,java.util.ArrayList,my.Dummy" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Here is all the system's users:</h1>

<table>
<tbody>
		<tr> 
			<td>User_name</td>
			<td>id</td>
			<td>role</td>
		</tr>
	<%
	Dummy db = new Dummy("String");//SELECT * from Users
	for(HashMap<String,Object> row : db.results){  
		Object id = row.get("coloumn1");//id
		Object username = row.get("coloumn2");//username
		Object role = row.get("coloumn3");//role
		String user_id = (String) id;
		String user_username =(String) username;
		String user_role =(String) role;

	
		%>
		<tr>
			<td><%= user_username %> <td><%= user_id %> <td><%= user_role %>
			

			<td><form action="Delete.jsp" method="post">
					<input type="submit" value="Delete"/>
					<input type="hidden" name="id" value="<%=user_id %>" />
				</form>
		
			<td><form action="" method="post">
					<input type="submit" value="Update"/>
					<input type="hidden" name= "user" value="<%=user_id %>" />
				</form>
		
		</tr>
		<% 
			}
		%>
	</tbody>
</table>
</body>
</html>