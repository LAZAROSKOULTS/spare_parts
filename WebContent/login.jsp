<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>

	<form action="LoginSuccess.jsp" method="post">
		<p><label>Enter your credentials above:</label></p>
		NAME:
		<p><input type="text" name="user" /></p>
		PASSWORD:
		<p><input type="password" name="pass" /></p>
		<p><input type="submit" value="OK!"/></p>
	</form>
<%
		String user;// Make a variable to keep the input from user text-input.
		user = request.getParameter("user");
		String pass;// Make a variable to keep the input from password text-input.
		pass= request.getParameter("pass");
		
		if (user!=null && pass!=null){
			System.out.println("Hello "+user +" "+ pass+"!");
		}

%>
</body>
</html>