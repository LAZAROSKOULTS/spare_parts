package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Loginservlet() {
        super();
    }
    
	public void destroy() {
		System.out.println("Selvet is being destroyed!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Lazaros was here! i'm joking... Servlet is working!");
		
		String user;// Make a variable to keep the input from user text-input.
		user = request.getParameter("user");
		String pass;// Make a variable to keep the input from password text-input.
		pass= request.getParameter("pass");
		
		if (user!=null && pass!=null){
			System.out.println("Hello "+user +" "+ pass+"!");
		}
		
		response.sendRedirect("Welcome.jsp");
		
	}

}
