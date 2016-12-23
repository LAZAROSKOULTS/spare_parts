<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashMap,java.util.ArrayList,util.DataBase" %>
<%! DataBase db = (DataBase) getServletContext().getAttribute("DataBase"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String t_id=request.getParameter("t_id");//Transaction id
String p_id=request.getParameter("p_id");//Part id
ArrayList<HashMap<String,Object>> results = db.fetch("SELECT * from part_trans where trans_id="+t_id+" AND "+"part_id="+p_id);//SELECT * from Trans_part where trans_id=t_id && part_id=p_id
ArrayList<HashMap<String,Object>> results2 = db.fetch("SELECT * from spare_part where part_id="+p_id);
HashMap<String,Object> row = results.get(0);  
HashMap<String,Object> row2 = results2.get(0); 
Object tran_p_name = row2.get("name");//Part_name
Object remaining = row.get("remaining");//P_remaining
String p_name = (String) tran_p_name;
int s_remain = (int) remaining;			  
Object availability  = row2.get("availability");//availability 
int available  =(int) availability;
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
		<td><%=available %>
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
		<input type="hidden" value="<%=s_remain%>" name="s_remain">
		
</form>
</body>
</html>