<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello!</h1>
<p>There is all the transactions!</p>

	<jsp:useBean id="db" class="my.FakeDB"/> 
	<jsp:useBean id="tran" class="my.Transaction"/>
	<% 
		
		for(int i=0; i<db.getTransactions().size(); i++){  
			tran = db.getTransactions().get(i);
	%>
		<p> <%= tran %> 
		
		<form action="Storekeeper/TransactionDetails.jsp" method="post">
		<input type="submit" value="Details!">
		</form>
		</p>
	
	<%
		}
	%>
</body>
</html>