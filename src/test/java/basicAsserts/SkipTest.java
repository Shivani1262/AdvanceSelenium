package basicAsserts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SkipTest {

	@Test
	public void facebook() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test(dependsOnMethods = "facebook")
	public void myntra() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.myntra.com/Pune" ;
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void zomato() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://zomato.com/");
	}
	
	@Test
	public void ajio() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
}
