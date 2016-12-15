package adminTools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GodMode
 */
@WebServlet(description = "Initial page for sysadmin tools!", urlPatterns = { "/GodMode" })
public class GodMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Whosoever has access to this code is god :p
    private static final String usr = "godmode";
    private static final String pass = "lsd96lsd";
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Admin for SpareParts System";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
				"transitional//en\">\n";
		String result;
		if(request.getParameter("username") == usr && request.getParameter("password") == pass){
			//Create a session with an admin attribute!
			//TODO TODO TODO!!!!!!!!!
			//Give options to admin...
			result = "<p><h1><b>WELLCOME ADMIN, HERE ARE YOUR TOOLS:<b></h1><br>"+
					"<a href='UserCatalog' target='_self'><b>USER CATALOG</b></a>"+
					"<a href='ServiceCatalog' target='_self'><b>SERVICE AND USER GROUP CATALOG</b></a>";
		} else {
			result = "<h1 style ='color:red' ><b>YOU ARE NOT ADMIN, GET OUT OF HERE!!!<b></h1>";
		}
	      
		//finally print	
		out.println(docType + "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + result + "" +
	        "</body></html>");
	}

}
