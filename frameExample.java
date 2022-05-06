package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class frameExample{
   public static void main(String[] args) {
      System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
      WebDriver driver = new FirefoxDriver();
      driver.get("https://the-internet.herokuapp.com/frames");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // identify element and click
      driver.findElement(By.partialLinkText("Nested")).click();
      
      List <WebElement> frames=driver.findElements(By.tagName("frame"));
      
      System.out.println("Frames in this page "+ frames.size());
      
      for(WebElement l : frames)
      {
    	  System.out.println("Frame "+ l.getAttribute("name"));
            
      }     
      // switching to frame with frame name
      
        
      driver.switchTo().frame(driver.findElement(By.name("frame-top")));      
      System.out.println("frame top found");
      driver.switchTo().frame(driver.findElement(By.name("frame-middle")));      
      System.out.println("frame middle found");
       
      WebElement m = driver.findElement(By.cssSelector("body"));
      
      System.out.println("Middle text: " +m.getText());
      
      //Switch back to the state when you loaded the page
      
      
      driver.switchTo().parentFrame();
      
      System.out.println("switched to parent frame top again");
      
      
      driver.switchTo().frame(driver.findElement(By.name("frame-right")));
      m = driver.findElement(By.cssSelector("body"));
      
      System.out.println("Right text: " +m.getText());
      
      
      driver.switchTo().defaultContent();
      System.out.println("switched to default state");
      
      driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
      m = driver.findElement(By.cssSelector("body"));
      
      System.out.println("Bottom Frame text: " +m.getText());
      
      driver.close();
   }
}