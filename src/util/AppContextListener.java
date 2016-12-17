package util;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AppContextListener implements ServletContextListener {
	DButility connectionUtil;
	
	//Constructor
    public AppContextListener() {
    }

    //Happens when application is initialized
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext ctx = arg0.getServletContext();//Get context.
    	//Get values from context,and initialize the utility for DB connection.
    	connectionUtil = new DButility(ctx.getInitParameter("dbURL"),ctx.getInitParameter("dbUser"),ctx.getInitParameter("dbPassword"));
    	Connection conn = connectionUtil.getConnection();
    	if(conn!=null){
    		ctx.setAttribute("DBConnection", conn);
    		System.out.println("DB Connection initialized successfully.");
    	}else{
    		System.out.println("Couldn't initialize DB connection properly. Context not set!\nFix and restart!!!");
    	}
    	
    }
	
    
    //Happens when application is ended
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	connectionUtil.close();//Close the connection...
    }

}
