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

<% String t_id = request.getParameter("tran"); %>

 <h1>This is the transaction with id:<%=t_id %></h1>
		
		<%
			
		Dummy db = new Dummy("String");//SELECT * from Transaction where trans_id=t_id
		HashMap<String,Object> row = db.results.get(0);  
			
			Object amount = row.get("coloumn2");//amount
			Object customer_id = row.get("coloumn3");//customer_id
			Object status = row.get("coloumn4");//status
			Object employee_id = row.get("coloumn5");//employee_id
			Object entry_date = row.get("coloumn6");//entry_date
			
			String tran_amount =(String) amount;
			String tran_customer_id = (String) customer_id;
			String tran_status = (String) status;
			String tran_employee_id = (String) employee_id;
			String tran_entry_date = (String) entry_date;
			tran_status="Collected";
			%>
			<table border=2>
				<tr><td>AMOUNT<td>CUSTOMER_ID<td>STATUS<td>EMPLOYEE_ID<td>ENTRY_DATE</tr>
				<tr> <td><%=tran_amount %><td><%= tran_customer_id%><td><%=tran_status%><td><%=tran_employee_id %><td><%=tran_entry_date %> </tr>
				
			</table>
			
		<%
		if(tran_status.equals("Collected")){
		%>
		<table>
			<tr>
				<td>Make an discount:</td>
				<td>
					<form>
						<input type="text" name="disc">
						<input type="submit" value="SAVE">
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
			
			Dummy db2 = new Dummy("String");//SELECT * from Transactions where customer_id=customer_id && status="DONE"
			for(HashMap<String,Object> row2 : db2.results){ 

				Object id2 = row2.get("coloumn2");//id
				Object cost2 = row2.get("coloumn3");//cost
				Object entry_date2 = row2.get("coloumn4");//entry_date

				String tran_id2 = (String) id2;
				String tran_cost2 =(String) cost2;
				String tran_entry_date2 = (String) entry_date2;
				
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