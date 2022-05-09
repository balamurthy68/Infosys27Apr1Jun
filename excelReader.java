package basic;


	import java.io.File;
import java.io.FileInputStream;
	import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	//How to read excel files using Apache POI
	public class excelReader {
		
		static XSSFCell s_username;
		static XSSFCell s_password;
	    static WebDriver driver;	
	    static String loginFailedFilename;
		public static void main (String [] args) throws Exception{
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
		static void doLogin(XSSFCell p_username,XSSFCell p_password) throws Exception
		{
			String dttime;
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
		    String flashMsg = driver.findElement(By.id("flash")).getText();
	    	
		    try {
		    	driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
		    	
		    	System.out.println("Login Successful for username:" + p1 + " and Password:" + p2);
		    	driver.findElement(By.linkText("Logout")).click();
		    
		    }
		    catch(NoSuchElementException e)
		    {
		    
		    	//Take screenshot on unsuccessful login 
		    
		    	System.out.println( flashMsg + p1 + " and Password:" + p2);
		    	
		    	
		    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yy_"
		          		+ "HH:mm:ss");  
		        
		    	LocalDateTime now = LocalDateTime.now();
		    	
		        dttime = dtf.format(now);
		        		        
		        System.out.println(dtf.format(now));  
		 
		    	loginFailedFilename = "d://infy//" + p1 + "_" + p2 + "_" + dttime+ ".png";
		    	takePicture(driver, loginFailedFilename);
		    
		    }
		    
		    
		    Thread.sleep(2000);
			
			
			driver.navigate().to("https://the-internet.herokuapp.com/login");
			
		}
		
		/**
	     * This function will take screenshot
	     * @param webdriver
	     * @param fileWithPath
	     * @throws Exception     *      */
	    public static void takePicture(WebDriver webdriver,String fileWithPath) throws Exception{
	    	
	        //Convert web driver object to TakeScreenshot - Similar to user pressing PrtScrn button
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	
	        //Call getScreenshotAs method to create image file - similar to the clipboard contents
	        
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        
	        //Move image file to new destination - Similar to saving the file as .png or .bmp  or .jpeg file format
	         File DestFile=new File(fileWithPath); 
	         
	      //Copy file at destination - Similar to saving the contents of clipboard to the filename  in the disk
	        FileUtils.copyFile(SrcFile, DestFile);
	    }

		
		
		
		
		
	}
	
	

