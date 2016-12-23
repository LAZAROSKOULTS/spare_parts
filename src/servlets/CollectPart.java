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
		String p_id = request.getParameter("p_id").trim();// The part's id. Trim is just for test
		String s_lots = request.getParameter("lots");// The amount of parts that Warehouse_keeper have collected.
		String s_remain= request.getParameter("s_remain");// the amount of part that Warehouse have to collect.
		String t_id=request.getParameter("t_id").trim();//The tran's id trim is just for test
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/Warehouse_keeper/CollectPart.jsp?t_id="+t_id+"&p_id="+p_id);//That's for the false case!
		PrintWriter out =response.getWriter();
		try
	    {
	      int lots = Integer.parseInt(s_lots.trim());
	      int remain = Integer.parseInt(s_remain.trim());
	      System.out.println("Remain= "+remain+". Lots= "+lots+".");
	      if(lots <=0 ){// if Ware
	    	  out.println("<font color=red>Your number of amount is negative.</font>");
	      }else{
	    	  System.out.println(remain -= lots);
	    	  if(remain < 0){
	    		  out.println("<font color=red>Cosumer wants less parts.</font>");
	    	  }
	    	  //thelw mia klhsh(UPDATE) ston pinaka part_trans opou part_id=p_id && trans_id=t_id
	    	  // tha kanei to remaining = n_amount
	    	  
	    	  //thelw mia klhsh(UPDATE) ston pinaka spare_parts opou part_id=p_id 
	    	  //tha kanei availiability -= lots (isws na prepei prvta na kaneis klhsh gia na matheis poso
	    	  //einai to availiability kai meta na kaneis thn afairesh.
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