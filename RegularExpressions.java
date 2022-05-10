package basic;

import java.util.regex.*;

public class RegularExpressions {
	public static void main(String[] args) {

		/*
		 * Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}"); Matcher m =
		 * p.matcher(timeString);
		 */
		// String exampleString = "aaaaaabpotterpatterabcd";
		// Pattern p = Pattern.compile(".*patter.*");

	//	String exampleString = "Harry";
		
	//	Pattern p = Pattern.compile("/^[A-Z]/");

		
		String exampleString = "Harry";
		// String should end with y
		Pattern p = Pattern.compile(".*[y]$");
        //email address
		  //String exampleString = "aAcd2222@gma999il.com";
	      //Pattern p = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");

		
		
		//String exampleString="03:23:00";
		 //Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
		//// *[@id="ct"]
		// hh:mm:ss
		// Aug 22, 2019

		// String exampleString = "04:30:45";

		//String exampleString = "May 04, 2021";

		//Pattern p = Pattern.compile("[A-Z,a-z]{3} [0-9]{2}, [0-9]{4}");
		// Pattern p = Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[-
		// /.](0[1-9]|[12][0-9]|3[01])$");
		// String exampleString = "2021-02-22";

		boolean ans = false;
		try {
			ans = patternMatch(exampleString, p);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(ans);
	}

	// Patternmatcher
	public static boolean patternMatch(String exampleString, Pattern p) {

		
		System.out.println("Example string is " + exampleString + " to match against pattern:"+ p.toString());
		
		Matcher m = p.matcher(exampleString);

		boolean b = m.matches();

		return b;

	}
}
