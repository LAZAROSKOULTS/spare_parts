<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap,java.util.ArrayList,util.DataBase" %>
<%! DataBase db =  (DataBase) getServletContext().getAttribute("DataBase");
	
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supervisor</title>
</head>
<body>
<h1>These are all the transactions!</h1>

<table border=2>
	<tr> <td>ID <td>COST <td>CUSTOMER_ID <td>ENTRY_DATE <td>EMPLOYEE_ID </tr>
	<%
	ArrayList<HashMap<String,Object>> results = db.fetch("SELECT * from Transactions where status='collected'");
	for(HashMap<String,Object> row : results){  
		String tran_id = (String) row.get("id");
		String tran_cost =(String) row.get("cost");
		String tran_customer_id =(String) row.get("customer_id");
		String tran_entry_date =(String) row.get("entry_date");
		String tran_empolyee_id =(String) row.get("employee_id");
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
		<input type="hidden" name="tran" value="<%=tran_id%>"/>
	</form>
	</tr>
	<%
	}
	%>
	</table>
	
</body>
</html>