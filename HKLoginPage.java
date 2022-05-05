import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class HKLoginPage {
static WebDriver driver;
WebElement un, pw, loginbtn, logoutbtn;
 String usernamevalue = "tom";
 String passwordvalue = "SuperSecretPassword!";

@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//String exePath = "d://chromedriver.exe";
	      String exePath = "d://geckodriver.exe";
		//System.setProperty("webdriver.chrome.driver", exePath);
		//Firefox browser
		System.setProperty("webdriver.gecko.driver", exePath);
	    //driver = new ChromeDriver();
		
		driver = new FirefoxDriver();
		//implicit wait - common to all the elements
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://the-internet.herokuapp.com/login");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method****************");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method****************");
	}

	//Method that checks if password field hides characters
	@Test
	public void checkPasswordHidden() {
		boolean pwHidden;
		pw = driver.findElement(By.id("password"));
		//Test step to check if password text box is of type password
		
		if (pw.getAttribute("type").equals("password"))
		{
			System.out.println("Yes. Password is hidden textbox entry");
			pwHidden = true;
		
		}
		else
		{
			pwHidden = false;
		}
		
		Assert.assertEquals(true,pwHidden);
	}
	
	@Test
	public void loginSuccess() {
	
		boolean loginsuccess;
		un = driver.findElement(By.xpath("//*[contains(@id,'username')]"));
		
		un.sendKeys(usernamevalue);
		
		pw = driver.findElement(By.id("password"));
		pw.sendKeys(passwordvalue);
		
		
		//loginbtn = driver.findElement(By.cssSelector("#login > button"));
		loginbtn = driver.findElement(By.xpath("//button[@type='submit' or @class='radius']"));
		////button[@type='submit' or @class='radius'] 
		
		loginbtn.click();
		
		//validation of successful login
		
		try {
		
			logoutbtn =driver.findElement(By.linkText("Logout"));
			logoutbtn.click();
			System.out.println("Successful login");
			loginsuccess = true;
		}
		catch(NoSuchElementException e)
		{
			loginsuccess=false;
			System.out.println("Login failed.");
		}
		Assert.assertEquals(true, loginsuccess);
	
	}
	
	

}
