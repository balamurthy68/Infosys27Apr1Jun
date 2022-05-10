package junitExamples;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testng.annotations.Ignore;

import FileIO.CreateFileExample;
import junit.framework.Assert;
import static org.testng.AssertJUnit.*;

public class TestCreateFileExample {

	//@Ignore
	@Test
	public void testCreateFile() {

	CreateFileExample cf = new CreateFileExample();
	
    boolean fileCreated = CreateFileExample.createFile("d://infy/JUsecondfile.TXT");
	
   Assert.assertEquals(true, fileCreated);
	
	}

}
