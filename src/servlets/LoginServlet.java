package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.Dummy;

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
		
		Dummy db = new Dummy("String");//SELECT username from Users where username=user
		HashMap<String,Object> row = db.results.get(0);  
			Object DBusername = row.get("coloumn1");//username
			String username = (String) DBusername;
			username = "laz";
			
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/login.html");//That's for the false case!
			PrintWriter out=response.getWriter();
			
			if (username.equals(user)){
				Dummy db2 = new Dummy("String");//SELECT password,usertype from Users where username=user
				HashMap<String,Object> row2 = db2.results.get(0);  
					Object DBpass = row2.get("coloumn1");//password
					Object DBtype = row2.get("coloumn2");//usertype
					String password = (String) DBpass;
					String usertype = (String) DBtype;
					password = "laz";
					usertype = "Supervisor";
				
					if(password.equals(pwd)){

						HttpSession session =request.getSession();
						session.setAttribute("user",username );//user is a Session's attribute with value the username.
						session.setAttribute("type", usertype);//type is a Session's attribute with value the usertype of user.
						session.setMaxInactiveInterval(30*60);//Session expires in 30 mins.
						Cookie userName=new Cookie("user",user);
						userName.setMaxAge(30*60);
						response.addCookie(userName);
						if(usertype.equals("Warehouse_keeper")){
							response.sendRedirect("Warehouse_keeper/Warehouse_keeper.jsp");
						}else if (usertype.equals("Employee")){
							response.sendRedirect("Employee.jsp");
						}else if (usertype.equals("Supervisor")){
						response.sendRedirect("Supervisor/Supervisor.jsp");
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
