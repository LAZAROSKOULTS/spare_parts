<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<%
		
		String user;// Make a variable to keep the input from user text-input.
		user = request.getParameter("user");
		String pass;// Make a variable to keep the input from password text-input.
		pass= request.getParameter("pass");
		
		if (user!=null && pass!=null){
			out.println("Hello "+user +" "+ pass+"!");
		}
	%>
	<form action="login.jsp" method="post">
		<p><label>Enter your credentials above:</label></p>
		<p><input type="text" name="user" /></p>
		<p><input type="text" name="pass" /></p>
		<p><input type="submit" value="OK!"/></p>
	</form>

	
</body>
</html>