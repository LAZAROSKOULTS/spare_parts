<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page import="java.util.HashMap,java.util.ArrayList,my.Dummy" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>These are all the parts of storage</h3>
<table border=2>
	<tr>
		<td>NAME
		<td>ID
		<td>COST
		<td>AVAILABILITY
	</tr>
<%

				Dummy db = new Dummy("String");//SELECT * from sparePart 
				for(HashMap<String,Object> row : db.results){ 
				Object name  = row.get("coloumn2");//p_name
				Object id  = row.get("coloumn2");//p_id
				Object cost  = row.get("coloumn2");//p_cost
				Object availability  = row.get("coloumn2");//availability

				String p_name  =(String) name;
				String p_id  =(String) id;
				String p_cost  =(String) cost;
				String p_available  =(String) availability;
				
				%>
				
				
				<tr>
					<td><%=p_name %>
					<td><%=p_id %>
					<td><%=p_cost %>
					<td><%=p_available %>
				</tr>
				
				
				<%
				}
				%>
</table>
</body>
</html>