<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s_name=request.getParameter("name");
String s_id=request.getParameter("id");
String s_remain=request.getParameter("remain");
String s_available=request.getParameter("available");
%>
<h2> These are some info for the part:<%=s_name %>.</h2>
<table border=1>
	<tr>
		<td>Part name
		<td>Part id
		<td>Remain
		<td>Available
	</tr>
	<tr>
		<td><%=s_name %>
		<td><%=s_id %>
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
		<input type="hidden" value="<%=s_id%>" name="s_id">
		<input type="hidden" value="<%=s_remain%>" name="s_remain">
</form>

</body>
</html>