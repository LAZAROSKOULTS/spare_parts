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
<%
String t_id=request.getParameter("t_id");//Transaction id
String p_id=request.getParameter("p_id");//Part id



				Dummy db = new Dummy("String");//SELECT * from Trans_part where trans_id=t_id && part_id=p_id
				HashMap<String,Object> row = db.results.get(0);  
				Object tran_p_name = row.get("coloumn0");//Part_name
				Object remaining = row.get("coloumn3");//P_remaining

				String p_name = (String) tran_p_name;
				String s_remain = (String) remaining;
				
				Dummy db3 = new Dummy("String");//SELECT  from sparePart where part_id=part_id
				HashMap<String,Object> row3 = db3.results.get(0);  
				Object availability  = row.get("coloumn2");//availability 
				String s_available  =(String) availability;
				%>
<h2> These are some info for the part:<%=tran_p_name %>.</h2>
<table border=1>
	<tr>
		<td>Part name
		<td>Part id
		<td>Remain
		<td>Available
	</tr>
	<tr>
		<td><%=p_name %>
		<td><%=p_id %>
		<td><%=s_remain %>
		<td><%=s_available %>
	</tr>

</table>
<br>
<h3>Collect amount!</h3>
<br>

	Amount of Part:
<form action="../CollectPart" method="post">
		<input type="text" name="lots">
		<input type="submit" value="SAVE!">
		<input type="hidden" value="<%=p_id%>" name="p_id">
		<input type="hidden" value="<%=t_id%>" name="t_id">
		<input type="hidden" value="<%=s_remain%>" name="s_remain"> <%// It's s_remain because it's a String but i want an int %>
		
</form>

</body>
</html>