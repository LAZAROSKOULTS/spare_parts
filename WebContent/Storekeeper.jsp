<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello!</h1>
<p>There is all the transactions!</p>
<%@ page import="java.util.HashMap,java.util.ArrayList,my.Dummy" %>
	
	
	
	<% 
		Dummy db = new Dummy("String");//SELECT id , cost from Transactions
		for(HashMap<String,Object> row : db.results){  
			Object id = row.get("coloumn1");//id
			Object cost = row.get("coloumn2");//cost
			String tran_id = (String) id;
			String tran_cost =(String) cost;
	%>
	<table>
		
		<tr> 
		<td> <%= tran_id %> 
		<td> <%=tran_cost %>
		
		
		<td>
		<form action="Storekeeper/TransactionDetails.jsp" method="post">
		<input type="submit" value="Details!"/>
		<input type="hidden" name="tran" value="<%=id%>"/>
		</form>
		</td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>