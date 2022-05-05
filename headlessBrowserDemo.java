import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class headlessBrowserDemo {
	public static void main(String[] args) {
        // Declaring and initialising the HtmlUnitWebDriver
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        
        // open demo site webpage
        unitDriver.get("https://the-internet.herokuapp.com/login");
		
	//Print the title of the page
        System.out.println("Title of the page is -> " + unitDriver.getTitle());
        
    }
}