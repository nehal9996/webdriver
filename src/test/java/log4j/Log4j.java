package log4j;



import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

		
	
	
	/* Get the class name to be printed on */  
	   static Logger log = Logger.getLogger(Log4j.class.getName());  
	     
	   public static void main(String[] args)throws IOException{  
		   try {
		   PropertyConfigurator.configure("./Log4jproperties/Log4j.properties");
	      log.debug("Hello this is a debug message");  
	      log.info("Hello this is an info message");  
	      log.error("this is error message");
	   
		   System.out.println("done ");  
		   }
		   catch (Exception e) {
			e.printStackTrace();
			System.out.println("---failed");
			   
		   }
		   
		   }
}
