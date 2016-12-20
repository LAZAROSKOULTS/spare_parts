<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%@ page import="java.util.HashMap,java.util.ArrayList,my.Dummy" %>
		
		<%
			String t_id = request.getParameter("id");
		Dummy db = new Dummy("String");//SELECT * from Transaction where id=t_id
		HashMap<String,Object> row = db.results.get(0);  
			Object id = row.get("coloumn1");//id
			Object cost = row.get("coloumn2");//cost
			Object date = row.get("coloumn3");//date
			String tran_id = (String) id;
			String tran_cost =(String) cost;
			String tran_date = (String) date;
			%>
			<h1>These are all the details for the transaction with id:<%=tran_id %></h1>
			<table>
			<tbody>
			
			<tr> <td>Transaction id<td> Part name <td>Quantity<td> Remaining <td> Storage</tr>

			<%
			Dummy db2 = new Dummy("String");//SELECT * from Join Transaction T on trans_parts P where T.id = P.t_id
			for(HashMap<String,Object> row2 : db.results){  
				Object p_id = row2.get("coloumn1");//Part_id
				Object p_quantity = row2.get("coloumn2");//P_quantity
				Object remaining = row2.get("coloumn3");//P_remaining
				Object Storage = row2.get("coloumn4");//P_storage
				String tran_p_id = (String) p_id;
				String tran_p_quantity =(String) p_quantity;
				String tran_remaining = (String) remaining;
				String tran_storage = (String) Storage;
		%>
			<tr>
			<td><%= tran_id %>
			<td><%= tran_p_id %>
			<td><%= tran_p_quantity %>
			<td><%= tran_remaining%>
			<td><%= tran_storage %>
			</tr>
		
		<%
		}
		%>
					</tbody>
			</table>
</body>
</html>