import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorsExample {
   
	
	public static void main(String[] args) {
	
		WebDriver driver;
		// TODO Auto-generated method stub

		String exePath = "d://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	    driver = new ChromeDriver();
		driver.get("file:///D:/sample.html");
		
		WebElement carsLabel,secondTableSecondRow;
		String expectedCarsLabel = "Select cars";
				
		carsLabel = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td[1]"));
		
		String actualCarsLabel = carsLabel.getText();
				
		System.out.println(carsLabel.getText());
		
		if (actualCarsLabel.contains(expectedCarsLabel))
		{
			System.out.println("Label contains "+ expectedCarsLabel);
		}
		else
		{
			System.out.println("Label check failed does not contain "+ expectedCarsLabel);
			System.out.println("Expected label is:"+expectedCarsLabel + " Actual label:" + actualCarsLabel);
			
		}
		
		
		
		
		secondTableSecondRow = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[2]"));
		
		System.out.println(secondTableSecondRow.getText());
		
				
		
		//driver.close();
	}

}
