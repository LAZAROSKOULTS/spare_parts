package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataBase;

/**
 * Servlet implementation class CollectPart
 */
@WebServlet("/CollectPart")
public class CollectPart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase DB = (DataBase) getServletContext().getAttribute("DataBase");
		String p_id = request.getParameter("s_id");// The part's id.
		String s_lots = request.getParameter("lots");// The amount of parts that Warehouse_keeper has collected.
		String s_remain= request.getParameter("s_remain");// the amount of part that has to be collected.
		String t_id=request.getParameter("t_id");//The tran's id
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/Warehouse_keeper/CollectPart.jsp?t_id="+t_id+"&p_id="+p_id);//That's for the false case!
		PrintWriter out =response.getWriter();
		try
	    {
	      int lots = Integer.parseInt(s_lots.trim());
	      int remain = Integer.parseInt(s_remain.trim());
	      System.out.println("Remain= "+remain+". Lots= "+lots+".");
	      if(lots <=0 ){//
	    	  out.println("<font color=red>Your amount is negative!</font>");
	      }else{
	    	  System.out.println(remain -= lots);
	    	  if(remain < 0){
	    		  out.println("<font color=red>Cosumer wants less parts.</font>");
	    	  }
	    	  //Database queries...
	    	  remain=remain-lots;//How many more have to be collected.
	    	  DB.execute("UPDATE part_trans SET remaining="+remain +" WHERE part_id="+p_id+" AND trans_id="+t_id);
	    	  //Update availability of product...
	    	  DB.execute("UPDATE spare_part  SET availability=(SELECT availability FROM spare_part WHERE part_id="+p_id+")-"+lots +" WHERE part_id="+p_id);
	      }

	      response.sendRedirect("/Warehouse_keeper/CollectPart.jsp?t_id="+t_id+"&p_id="+p_id);
	     }
	    
	    catch (NumberFormatException nfe)
	    {
	    	System.out.println("NumberFormatException: " + nfe.getMessage());
	      	out.println("<font color=red>Your number of amount is wrong.</font>");
	    }

		rd.include(request,response);
	}

}