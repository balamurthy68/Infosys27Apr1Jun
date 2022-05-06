

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RadioButtonExample {
    static WebDriver driver;
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		String exePath = "d://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Launch the URL
		driver.get("file:///D:/sample.html");
		
		List<WebElement> rdBtn_fav= driver.findElements(By.name("fav_language"));
		
		System.out.println(rdBtn_fav.size());
		
		for(int i=0;i<rdBtn_fav.size(); i++)
		{
			System.out.println(rdBtn_fav.get(i).getAttribute("Value"));
		}
		// Create a boolean variable which will hold the value (True/False)
		boolean bValue = false;
		//rdBtn_fav.get(0).click();
		
		// This statement will return True, in case of first Radio button is selected
		bValue = rdBtn_fav.get(0).isSelected();
		System.out.println(bValue);
		
		// This will check that if the bValue is True means if the first radio button is selected
		if(bValue == true){
			// This will select Second radio button, if the first radio button is selected by default
			rdBtn_fav.get(1).click();
		}else{
			// If the first radio button is not selected by default, the first will be selected
			
			rdBtn_fav.get(0).click();
		}
		
	
		}

}

