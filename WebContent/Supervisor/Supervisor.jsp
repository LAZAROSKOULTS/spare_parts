<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap,java.util.ArrayList,my.Dummy" %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supervisor</title>
</head>
<body>
<h1>This is all the transactions!</h1>

<table border=2>
	<tr> <td>ID <td>COST <td>CUSTOMER_ID <td>ENTRY_DATE <td>EMPLOYEE_ID </tr>
	<%
	Dummy db = new Dummy("String");//SELECT * from Transactions where status="collected"
	for(HashMap<String,Object> row : db.results){  
		Object id = row.get("coloumn1");//id
		Object cost = row.get("coloumn2");//cost
		Object customer_id = row.get("coloumn3");//customer_id
		Object entry_date = row.get("coloumn4");//entry_date
		Object employee_id = row.get("coloumn5");//employee_id
		String tran_id = (String) id;
		String tran_cost =(String) cost;
		String tran_customer_id =(String) customer_id;
		String tran_entry_date =(String) entry_date;
		String tran_empolyee_id =(String) employee_id;
	%>
	<tr>
	
	<td><%= tran_id%>
	<td><%= tran_cost%>
	<td> <%=tran_customer_id%>
	<td><%= tran_entry_date%>
	<td><%=tran_empolyee_id%>
	
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
	
</body>
</html>