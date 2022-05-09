package selenium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class printDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yy_"
         		+ "HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();  
         
         System.out.println(dtf.format(now));  
 
         LocalDateTime tomorrow = LocalDateTime.of(22, 05, 10, 10, 10);
         System.out.println(dtf.format(tomorrow));  
         
         

	}

}
