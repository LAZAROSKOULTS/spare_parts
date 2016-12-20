package adminTools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GodMode
 */
@WebServlet(description = "Initial page for sysadmin tools!", urlPatterns = { "/GodMode" })
public class GodMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Whoever has access to this code is god :p
    private String usr;
    private String pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GodMode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		usr = "godmode";
		pass = "lsd96lsd";
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
		//Basic Setup...
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Admin for SpareParts System";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
				"transitional//en\">\n";
		//Check if admin requests a tool through session 
		//If session has been already set, values are not null.
		String result = (String) request.getSession().getAttribute("Access");
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		if (result != null){//If values are not null...
			if(username.equals(usr) && password.equals(pass) && result.equals("GodMode")){
			//Check that everything is in order...Then Redirect to the Specified Tool...
				String catalog = request.getParameter("Catalog");
				if(catalog != null){
					//if user addition or removal is selected...UserCatalog
					//if access addition or removal of groups is selected...ServiceCatalog
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/"+catalog+".jsp");
					dispatcher.forward(request, response);
					return;
				}
			}
		}else{
			//Check if admin has just logged in...		
			username = request.getParameter("username");
			password = request.getParameter("password");
		}
		result = "";//Reset temp
		//If admin is connected for first time.
		if(username.equals(usr) && password.equals(pass)){
			//Create an administrator session!
			HttpSession session = request.getSession();
			session.setAttribute("username",usr);
			session.setAttribute("password", pass);
			//Set attribute access to imply that login has been done.
			session.setAttribute("Access", "GodMode");
			//Give options to administrator...
			result = "<p><h1><b>WELLCOME ADMIN, HERE ARE YOUR TOOLS:<b></h1><br>"+
					"<form action='GodMode' method='POST'>"+
						"<b>USER CATALOG</b><br>"+
						"<input type='submit' name='Catalog' value='UserCatalog'/><br>"+
						"<b>SERVICE AND USER GROUP CATALOG</b>"+
						"<input type='submit' name='Catalog' value='ServiceCatalog'/><br>"+
					"</form>";
		} else {//If visitor is not admin...
			//Get a warning @System log!
			System.out.println("WARNING! user:"+username+" pass:"+password+" tried to access admin tools!");
			System.out.println("@IP: "+ request.getRemoteAddr());
			result = "<h1 style ='color:red' ><b>YOU ARE NOT ADMIN, <a href='Welcome.jsp' target='_self'>GET OUT OF HERE!!!</a></b></h1>";
		}
	      
		//finally print	
		out.println(docType + "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n"+ result + "" +
	        "</body></html>");
		
		
	}

}
