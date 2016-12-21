package adminTools;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDispatch
 */
@WebServlet("/AdminDispatch")
public class AdminDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDispatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Check session
		//CHECK FOR NULL POINTER (TRY_CATCH IF ERROR...)
		String usr = "godmode";
		String pass = "lsd96lsd";
		String access = (String) request.getSession().getAttribute("Access");
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		//Check if proper access has been obtained.
		if(!(access.equals("GodMode") && username.equals(usr) && password.equals(pass))){
			//If not admin, redirect to admin login...
			response.sendRedirect("admin.html");
			return;
		}
		String action = request.getParameter("Action");//Through our forms' Action attribute the User/Admin is redirected properly.
		//In case admin chooses to return to tools selection...
		if(action.equals("Return")){
			response.sendRedirect("GodMode");
			return;
		}
		//Otherwise the action shows where admin will go next!!!
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/"+action+".jsp");
		dispatcher.forward(request, response);
	}

}
