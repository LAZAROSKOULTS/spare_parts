<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap,java.util.ArrayList,util.DataBase"%>
<%! DataBase db = (DataBase) getServletContext().getAttribute("DataBase"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
		<%
		String t_id = request.getParameter("tran");
		boolean ready = true ;
		ArrayList<HashMap<String,Object>> results = db.fetch("SELECT * from transactions where trans_id=t_id");//
		HashMap<String,Object> row = results.get(0);  
			
		String tran_amount =(String) row.get("amount");//amount
		String tran_customer_id = (String) row.get("customer_id");//customer_id
		String tran_status = (String) row.get("status");//status
		String tran_supervisor_id = (String) row.get("supervisor_id");//supervisor_id
		String tran_employee_id = (String) row.get("employee_id");//employee_id
		String tran_entry_date = (String) row.get("est_date");//est_date
		String tran_est_date = (String) row.get("entry_date");//entry_date
			
			%>
			<h1>These are all the details for the transaction with id:<%=t_id %></h1>
			<table border=1>
			<tr><td> ID<td>AMOUNT<td>CUSTOMER_ID<td>STATUS<td>SUPERVISOR_ID<td>EMPLOYEE_ID<td>ENTRY_DATE<td>EST_DATE </tr>
			<tr><td> <%=t_id %> <td><%=tran_amount%><td><%=tran_customer_id%><td><%=tran_status%><td><%=tran_supervisor_id%><td><%=tran_employee_id%><td><%=tran_entry_date%><td><%=tran_est_date %></tr>
			</table>
			<br>
			<br>
			This is the list of Parts:
			<table border=2>
			<tbody>
			
			<tr><td> Part name<td>Part id <td>Quantity<td> Remaining <td> Storage<td>Action</tr>

			<%
			results = db.fetch("SELECT * from  transactions T JOIN ON trans_parts P where T.trans_id = P.trans_id");//
			for(HashMap<String,Object> row2 : results){ 
				Object p_name = row2.get("Part_name");//Part_name
				Object p_id = row2.get("Part_id");//Part_id
				Object p_quantity = row2.get("quantity");//P_quantity
				Object remaining = row2.get("remaining");//P_remaining
				String tran_p_name = (String) p_name;
				String tran_p_id = (String) p_id;
				String tran_p_quantity =(String) p_quantity;
				String tran_remaining = (String) remaining;
					int i = Integer.parseInt(tran_remaining.trim());
					if(i >0){// Check if all parts have been collected!
						ready = false;
					}
			
			// 
				results = db.fetch("SELECT from sparePart where part_id=part_id");//
				row = results.get(0);  
			
				Object availability  = row.get("coloumn2");//availability 
				String part_availability  =(String) availability;
		%>	
			
			
			<tr>
			
			<td><%= tran_p_name %>
			<td><%= tran_p_id %>
			<td><%= tran_p_quantity %>
			<td><%= tran_remaining %>
			<td><%= part_availability %>
			<td>	<form action="CollectPart.jsp" method="post">
					<input type="submit" value="Collect More!">
					<input type="hidden" name="p_id" value="<%=tran_p_id%>">
					<input type="hidden" name ="t_id" value="<%=t_id%>">
					</form>
			</tr>
		<%
		}
		%>
			</tbody>
			</table>
			<%if (ready){//If all parts have been collected then show the "finish" button.
			%>
			<form action="" method="post">
				<input type="submit" value="Finish Order!">
				<input type="hidden" name="tran_id" value="<%=t_id%>">
			
			</form>
			<%} %>
</body>
</html>