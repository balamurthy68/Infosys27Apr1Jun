package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpathAxesExample {
	static WebDriver driver;
	final static String Company = "Hindustan Unilever";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Company name for which you want to find the BSE Price and %
		String exePath = "d://geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		
		WebElement txt_email,lnk_logout;
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// open the browser with the url
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		
		WebElement getCurrentPrice,getPercentage;  
	
		
		WebElement myTable;
		myTable = driver.findElement(By.xpath("//a[contains(text(),'"+ Company + "')]//ancestor::table"));
		
		//table[contains(@class,'data')]//descendant::a[contains(text(),'Lux')]
		
		System.out.println(myTable.getAttribute("class"));
		
		//a[contains(text(),'PVR')]//parent::td//following-sibling::td[3]
		
		String myxpath = "//a[contains(text(),'"+ Company + "')]/parent::td/following-sibling::td[3]";
		
		
		System.out.println(myxpath);
		
		
		
		getCurrentPrice = driver.findElement(By.xpath(myxpath));
		
		System.out.println("********BSE Group A Top Gainers for " + Company + "*********");
		
		System.out.println("Current Price- Rs." +getCurrentPrice.getText());
		String str = getCurrentPrice.getText();
		
		str= str.replaceAll("[^0-9.]","");
		
		
		System.out.println(str);
		
		System.out.println("current price is > 1000 for " + Company + ( Double.parseDouble(str) > 1000));
		
		
		//following-sibling
		
		myxpath="//a[contains(text(),'" + Company +  "')]/parent::td/following-sibling::td[3]/following-sibling::td";
		
		System.out.println(myxpath);
		getPercentage = driver.findElement(By.xpath(myxpath));
		System.out.println("% Change -" + getPercentage.getText());
		
		
		///bookstore/book[price>35]/title

		//locate upto the table
		
		//td [text() > 1000]
		
		
		
	}

}
