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
String did= request.getParameter("id");
%>

Delete form!<br>
Are you sure you want to delete user with this id: <%= did %>

<form action="DeleteServlet" method="post">
	<input type="submit" value="OK!"/>
	<input type="hidden" name="id" value="<%= did %>"/>
</form>
</body>
</html>