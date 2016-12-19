package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataBase;

/**
 * Servlet implementation class DBTestServlet
 */
@WebServlet(description = "DELETE IT BEFORE SENDING...", urlPatterns = { "/DBTestServlet" })
public class DBTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String title;
	String docType;
	String result;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	title = "TEST DB";
    	docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
				"transitional//en\">\n";
    	result = "";
    	
    }

    private void printResult(PrintWriter output){
		output.println(docType + "<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n"+ result + "" +
		        "</body></html>");	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out = response.getWriter();
		result = "<p><h1><b>WRITE SOME SQL:<b></h1></br>"+
				"<form action='DBTestServlet' method='POST'>"+
					"<textarea rows='10' cols='100' name='sql'>"+
					"Enter SELECT query here..."+
					"</textarea>"+"<input type='submit' name='submit' value='Submit' />"+
				"</form>";
		printResult(out);
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out = response.getWriter();
		result = "<p>";
		DataBase DB = (DataBase) getServletContext().getAttribute("DataBase");
		ArrayList<HashMap<String,Object>> ret = DB.fetch("SELECT * FROM user");
		System.out.println(ret.toString());
		result = result + ret.toString() + "</br>";
		String sql = request.getAttribute("sql").toString();
		ret = DB.fetch(sql);
		result = result + "</p>";
		printResult(out);
	}

}
