<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap,java.util.ArrayList,util.DataBase" %>
<%! DataBase db = (DataBase) getServletContext().getAttribute("DataBase"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<body>

<% String t_id = request.getParameter("tran"); %>

 <h1>This is the transaction with id:<%=t_id %></h1>
		
		<%
		ArrayList<HashMap<String,Object>> results = db.fetch("SELECT * from Transactions where trans_id=t_id");
		HashMap<String,Object> row = results.get(0);  
		String tran_amount =(String) row.get("amount");//amount
		String tran_customer_id = (String) row.get("customer_id");//customer_id
		String tran_status = (String) row.get("status");//status
		String tran_employee_id = (String) row.get("employee_id");//employee_id
		String tran_entry_date = (String) row.get("entry_date");//entry_date
			%>
			<table border=2>
				<tr><td>AMOUNT<td>CUSTOMER_ID<td>STATUS<td>EMPLOYEE_ID<td>ENTRY_DATE</tr>
				<tr> <td><%=tran_amount %><td><%= tran_customer_id%><td><%=tran_status%><td><%=tran_employee_id %><td><%=tran_entry_date %> </tr>
				
			</table>
			
		<%
		if(tran_status.equals("Collected")){
		%>
		<br>
		<table>
			<tr>
				<td>Make a percentage discount:</td>
				<td>
					<form action="../UpdateTransaction" method="post">
						<input type="text"  name="disc">%.
						<input type="submit" value="SAVE">
						<input type="hidden" value="<%=t_id%>"name="tran_id">
						<input type="hidden" value="<%=tran_amount%>" name="amount">
					</form>
				</td>
				
			</tr>
		</table>
		
		<%
		}
		%>	
			
			<h2>These are the previous transactions of this customer:</h2>
			<table border=1>
				<tr><td>CUSTOMER_ID<td>ID<td>COST<td>ENTRY_DATE</tr>
			<%
			
			results = db.fetch("SELECT * from transactions where customer_id=customer_id AND status='DONE'");
			for(HashMap<String,Object> row2 : results){ 

				String tran_id2 = (String) row2.get("id");//id
				String tran_cost2 =(String) row2.get("cost");//cost
				String tran_entry_date2 = (String) row2.get("entry_date");//entry_date	
			%>
			
			<tr>
				<td><%=tran_customer_id %>
				<td><%=tran_id2%>
				<td><%=tran_cost2%>
				<td><%=tran_entry_date2%>
			</tr>
			
			<%
			}
			%>
			
			</table>
			
			
</body>
</html>