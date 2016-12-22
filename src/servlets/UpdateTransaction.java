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
 * Servlet implementation class UpdateTransaction
 */
@WebServlet("/UpdateTransaction")
public class UpdateTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String s_disc=request.getParameter("disc");
			String id= request.getParameter("tran_id");
			String s_amount = request.getParameter("amount");
			System.out.println("s_disc="+ s_disc);
			
			System.out.println(" ID= " +id);
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/Supervisor/TransactionDetails.jsp");//That's for the false case!
			PrintWriter out =response.getWriter();
			
			 try
			    {
			      
			      
			      float disc = Float.parseFloat(s_disc)/100;
			      float amount = Float.parseFloat(s_amount.trim());
			      System.out.println("Discount is  " + disc +".");
			      
			      if(disc < 0.05){
			    	  
			    	  out.println("<font color=red>Your number discount is smaller than 5.</font>");

			      }else{
			    	  
			    	  float n_amount= (1-disc)*amount ;
			    	//kane (UPDATE) ston pinaka TRANSACTION me TRAN_ID=ID
				      //kai sto ÁMOUNT bale to n_amount kai kane to status=checked!
			    	  System.out.println("New amount is "+n_amount+" and discount is "+ disc);
			      response.sendRedirect("Supervisor/TransactionDetails.jsp?tran="+id );
			      }
			    }
			    catch (NumberFormatException nfe)
			    {
			    	System.out.println("NumberFormatException: " + nfe.getMessage());
			      	out.println("<font color=red>Your number discount is wrong.</font>");
			    }

			 rd.include(request,response);
			
			
			

	}

}
