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
	//A REALLY REALLY DUMB SERVLET FOR TESTINGS
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	super.init();
    	
    	
    }

    private void printResult(PrintWriter output){	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title;
		String docType;
		String result;
		PrintWriter out;
		title = "TEST DB";
    	docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
				"transitional//en\">\n";
    	result = "";
		response.setContentType("text/html");
		out = response.getWriter();
		result = "<p><h1><b>WRITE SOME SQL:<b></h1></br>"+
				"<form action='DBTestServlet' method='POST'>"+
					"<textarea rows='10' cols='100' name='sql'>"+
					"Enter SELECT query here..."+
					"</textarea>"+"<input type='submit' name='submit' value='Submit' />"+
				"</form>";
		String user = "";
		DataBase DB = (DataBase) getServletContext().getAttribute("DataBase");
		ArrayList<HashMap<String,Object>> ret = DB.fetch("SELECT max(id) as max FROM user");
		Integer max = (Integer) ret.get(0).get("max");
		System.out.println("max is :"+max);
		//max = max + 1;
		//int success = DB.execute("INSERT INTO user VALUES ('myUser','myUser','me@gmail.com',"+max+",'test')");
		ret = DB.fetch("SELECT * FROM user where usertype='test'");
		user = (String) ret.get(0).toString();
		result = result + "ADDITION:" + user;
		out.println(docType + "<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n"+ result + "" +
		        "</body></html>");
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title;
		String docType;
		String result;
		PrintWriter out;
		title = "TEST DB";
    	docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
				"transitional//en\">\n";
    	result = "";
		response.setContentType("text/html");
		out = response.getWriter();
		result = "<p>";
		DataBase DB = (DataBase) getServletContext().getAttribute("DataBase");
		ArrayList<HashMap<String,Object>> ret = DB.fetch("SELECT * FROM user");
		if(ret==null){
			System.out.println("Nothing returned from db:first call");
		} else {
			System.out.println(ret);
			for(HashMap<String,Object> m : ret){
				result = result + m.toString() + "</br>";
				System.out.println(m.toString());
			}
			
		}	
		String sql = "SELECT * FROM company ";
		ret = DB.fetch(sql);
		if(ret==null){
			System.out.println("Nothing returned from db:second call");
		}else{
			System.out.println(ret);
			for(HashMap<String,Object> m : ret){
				result = result + m.toString() + "</br>";
				System.out.println(m.toString());
			}
		}
		result = result + "</p>";
		out.println(docType + "<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n"+ result + "" +
		        "</body></html>");
	}

}
