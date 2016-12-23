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
		
		<%//κληση στην βαση για να παρουμε πληροφοριες για την συναλλαγη.
		String t_id = request.getParameter("tran");
		boolean ready = true ;
		Dummy db = new Dummy("String");//SELECT * from Transaction where trans_id=t_id
		HashMap<String,Object> row = db.results.get(0);  
			
			Object amount = row.get("coloumn2");//amount
			Object customer_id = row.get("coloumn3");//customer_id
			Object status = row.get("coloumn4");//status
			Object supervisor_id = row.get("coloumn5");//supervisor_id
			Object employee_id = row.get("coloumn6");//employee_id
			Object est_date = row.get("coloumn7");//est_date
			Object entry_date = row.get("coloumn8");//entry_date
			
			String tran_amount =(String) amount;
			String tran_customer_id = (String) customer_id;
			String tran_status = (String) status;
			String tran_supervisor_id = (String) supervisor_id;
			String tran_employee_id = (String) employee_id;
			String tran_entry_date = (String) entry_date;
			String tran_est_date = (String) est_date;
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

			<%//Κληση στην βαση για το ποια ανταλακτικα θελει ο πελατης, ποσα ηθελε εξ' αρχης, και ποσα θελει ακομα (ολη η λιστα παραγκελιας).
			Dummy db2 = new Dummy("String");//SELECT * from Join Transaction T on trans_parts P where T.id = P.t_id
			for(HashMap<String,Object> row2 : db.results){ 
				Object p_name = row2.get("coloumn0");//Part_name
				Object p_id = row2.get("coloumn1");//Part_id
				Object p_quantity = row2.get("coloumn2");//P_quantity
				Object remaining = row2.get("coloumn3");//P_remaining

				String tran_p_name = (String) p_name;
				String tran_p_id = (String) p_id;
				String tran_p_quantity =(String) p_quantity;
				String tran_remaining = (String) remaining;
				tran_remaining="0";
					int i = Integer.parseInt(tran_remaining.trim());
					if(i >0){// Check if all parts have been collected!
						ready = false;
					}
			
			// κληση στον πινακα parts για να βρουμε την τρεχουσα διαθεσιμοτητα καθε ανταλλακτικου.
				Dummy db3 = new Dummy("String");//SELECT  from sparePart where part_id=part_id
				HashMap<String,Object> row3 = db3.results.get(0);  
			
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
					<input type="hidden" name="name" value="<%=tran_p_name%>">
					<input type="hidden" name="id" value="<%=tran_p_id%>">
					<input type="hidden" name="remain" value="<%=tran_remaining%>">
					<input type="hidden" name="available" value="<%=part_availability%>">
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