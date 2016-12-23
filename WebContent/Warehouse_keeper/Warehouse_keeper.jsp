<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap,java.util.ArrayList,util.DataBase" %>
<%! DataBase db = (DataBase) getServletContext().getAttribute("DataBase"); %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse_keeper</title>
</head>
<body>
<h1>Hello!</h1>
<p>There is all the transactions!</p>

	<table border=2>
		<tr><td>ID<td>COST<td>STATUS</tr>
	<% 
	ArrayList<HashMap<String,Object>> results = db.fetch("SELECT id , amount, status from transactions where status='collecting'");//
		for(HashMap<String,Object> row : results){  
			Object id = row.get("id");//id
			Object cost = row.get("amount");//cost
			Object status = row.get("status");//status
			int tran_id = (int) id;
			String tran_cost =(String) cost;
			String tran_status =(String) status;
	%>
	
		
		<tr> 
		<td> <%= tran_id %> 
		<td> <%=tran_cost %>
		<td> <%=tran_status %>
		
		
		<td>
		<form action="TransactionDetails.jsp" method="post">
		<input type="submit" value="Details!"/>
		<input type="hidden" name="tran" value="<%=id%>"/>
		</form>
		
		</tr>
	
	<%
		}
	%>
	</table>
	<br>
	        <form action="../LogoutServlet" method="post">
                <input type="submit" value="Logout">
        </form>
</body>
</html>