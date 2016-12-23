package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import util.DataBase;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		//Find if the username exists...
		DataBase db = (DataBase) getServletContext().getAttribute("DataBase");
		ArrayList<HashMap<String,Object>> results = db.fetch("SELECT username FROM user WHERE username = '"+user+"'");
		HashMap<String,Object> row = results.get(0);  
		String username = (String) row.get("username");
			
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/login.html");//For any false case!
		PrintWriter out=response.getWriter();
			
		if (username.equals(user)){
			//find the corresponding password and role for the user...
			results = db.fetch("SELECT password,usertype FROM user WHERE username = '"+user+"'");
			row = results.get(0);
			String password = (String) row.get("password");
			String usertype = (String) row.get("usertype");			
			if(password.equals(pwd)){
				//Control user access with session...
				HttpSession session =request.getSession();
				session.setAttribute("user",username );//user is a Session's attribute with value the username.
				session.setAttribute("type", usertype);//type is a Session's attribute with value the role of user.
				session.setMaxInactiveInterval(30*60);//Session expires in 30 mins.
				Cookie userName=new Cookie("user",user);
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				//Beginning of user dispatch(TO BE EDITED LATER...)
				if(usertype.equals("Warehouse_keeper")){
					response.sendRedirect("Warehouse_keeper/Warehouse_keeper.jsp");
				}else if (usertype.equals("Employee")){
					response.sendRedirect("Employee.jsp");
				}else if (usertype.equals("Supervisor")){
					response.sendRedirect("Supervisor/Supervisor.jsp");
				}else if (usertype.equals("Customer")){
					response.sendRedirect("Customer/Customer.jsp");
				}		
			}else{
				out.println("<font color=red>Password is wrong.</font>");
				rd.include(request,response);
					}
					
			}else{	
				out.println("<font color=red>User name or password is wrong.</font>");
				rd.include(request,response);
			}
	}

}
