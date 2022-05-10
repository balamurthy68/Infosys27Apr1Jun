package junitExamples;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.annotations.Ignore;

import basic.Calculator;
import junit.framework.Assert;
import static org.testng.AssertJUnit.*;

public class TestCalculator {

	@Test
	public void testAdd() {

		Calculator c = new Calculator("Scientific");
		
		int actualval = c.add(10, 20);
		
		int expectedval = 30;
		
		Assert.assertEquals(expectedval, actualval);
		
		
	}
	
	@Ignore
	//@SuppressWarnings("deprecation")
	//@Test
	public void testAddintfloat() {

		Calculator c = new Calculator("Scientific");
		
		float actualval = c.add(10,10.2f);
		
		float expectedval = 20.2f;
		
		Assert.assertEquals(expectedval, actualval);
		
		
	}
	

}
