package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserExecution {
	public WebDriver driver;
	//Cross Browser Execution => executing the testscript more than one browser
	@Parameters("Browser")
	@Test
	public void myntraTest(String Browser) {
		if (Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		driver.get("https://www.myntra.com/");
	}
	
}
