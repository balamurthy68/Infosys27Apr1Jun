package basic;


	import java.io.FileInputStream;
	import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	//How to read excel files using Apache POI
	public class excelReader {
		
		static XSSFCell s_username;
		static XSSFCell s_password;
	    static WebDriver driver;	
		
		public static void main (String [] args) throws IOException, InterruptedException{
			String exePath = "d://chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			
			WebElement txt_email,lnk_logout;
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// open the browser with the url
			
			
			driver.get("https://the-internet.herokuapp.com/login");
						
			//I have placed an excel file 'Test.xlsx' in my D Driver 
				FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
								  
	            //Get how many rows are there in the sheet
				System.out.println(sheet.getLastRowNum());
				
				int rowcount = sheet.getLastRowNum();
				
				for (int i = 1; i < rowcount +1; i ++) {
					s_username = sheet.getRow(i).getCell(0);
					s_password = sheet.getRow(i).getCell(1);
					doLogin(s_username,s_password);
				}
				
				driver.close();
				
		
		}//end of main	 
		
		
		//user defined method
		static void doLogin(XSSFCell p_username,XSSFCell p_password) throws InterruptedException
		{
			
			System.out.println("username is:" + p_username + " password is : " + p_password);
					
			//open the browser 
			//load the url
			//identify userid and password boxes
			//sendkeys the parameters
			String p1 = p_username.toString();	
			String p2 = p_password.toString();
			
		    driver.findElement(By.name("username")).sendKeys(p1);
		    
		    driver.findElement(By.name("password")).sendKeys(p2);
		    
		    driver.findElement(By.cssSelector("#login > button")).click();
		    
		    
		    //See if successfully logged in
		    
		    try {
		    	driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
		    	
		    	System.out.println("Login Successful for username:" + p1 + " and Password:" + p2);
		    	driver.findElement(By.linkText("Logout")).click();
		    
		    }
		    catch(NoSuchElementException e)
		    {
		    	System.out.println("***Login unsuccessful for username:" + p1 + " and Password:" + p2);
		    }
		    
		    
		    Thread.sleep(2000);
			
			
			driver.navigate().to("https://the-internet.herokuapp.com/login");
			
		}
		
		
	}
	
	

