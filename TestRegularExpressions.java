package junitExamples;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.Ignore;

import basic.RegularExpressions;

import static org.testng.AssertJUnit.*;


public class TestRegularExpressions {


	@Test
	public void testPatternMatch() {
		
		RegularExpressions re=new RegularExpressions();
		
		//String exampleString = "Bala";
		// String should end with y
		//Pattern p = Pattern.compile(".*[a]$");
        
		//time display
		Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
		String exampleString = "12:05:38";
		
		
		//Pattern p = Pattern.compile("^(1|2)[0-9]{8}");
		
		//Pattern p = Pattern.compile("^(1|2)\\d{7}$");
		boolean match = re.patternMatch(exampleString, p);
		Assert.assertEquals(true, match);
	
	}

}
