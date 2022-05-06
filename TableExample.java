package selenium;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExample {
	
	public static void main(String[] args)
	
	{
		WebDriver driver;
		
		System.out.println("Hello welcome to Webdriver Table example java");
	
		String exePath = "d://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("file:///D:/sample.html");
	
		WebElement secondTable;
		int rowcount,columncount;
		
		//second static table
	    secondTable=driver.findElement(By.xpath("/html/body/table[2]"));
	    
	    //HOW MANY COLUMNS ARE THERE
	    List <WebElement> cols = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr[1]/th"));
	    
	    System.out.println("Columns in the second table:" + cols.size());
	    
	    //HOW MANY ROWS ARE THERE
	    List <WebElement> rows = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr"));
	    
	    System.out.println("Rows in the second table:" + rows.size());
	    
	    WebElement firstColumn=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/th[1]"));
	    
	    String ExpectedTextInFirstColumn = "First name";
	    String ActualTextInFirstColumn = firstColumn.getText();
	    
	    
	    if (ActualTextInFirstColumn.equalsIgnoreCase(ExpectedTextInFirstColumn))
	    {
	    	System.out.println("Yes.First Name is found in first column");
	    }
	
	}
}
