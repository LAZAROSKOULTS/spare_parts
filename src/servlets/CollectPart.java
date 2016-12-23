package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollectPart
 */
@WebServlet("/CollectPart")
public class CollectPart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_id = request.getParameter("s_id");
		String s_lots = request.getParameter("lots");
		String s_remain= request.getParameter("s_remain");
		String tran="9";
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/Warehouse_keeper/TransactionDetails.jsp?tran="+tran);//That's for the false case!
		PrintWriter out =response.getWriter();
		try
	    {
	      int lots = Integer.parseInt(s_lots.trim());
	      int remain = Integer.parseInt(s_remain.trim());
	      System.out.println("Remain= "+remain+". Lots= "+lots+".");
	      if(lots <=0 ){
	    	  out.println("<font color=red>Your number of amount is negative.</font>");
	      }else{
	    	  System.out.println(remain -= lots);
	    	  if(remain < 0){
	    		  out.println("<font color=red>Cosumer wants less parts.</font>");
	    	  }
	    	  //thelw mia klhsh(UPDATE) ston pinaka part_trans opou part_id=p_id && trans_id=t_id
	    	  // tha kanei to remaining = n_amount
	      }

	      //response.sendRedirect("Supervisor/TransactionDetails.jsp?tran="+p_id );
	     }
	    
	    catch (NumberFormatException nfe)
	    {
	    	System.out.println("NumberFormatException: " + nfe.getMessage());
	      	out.println("<font color=red>Your number of amount is wrong.</font>");
	    }

		rd.include(request,response);
	}

}