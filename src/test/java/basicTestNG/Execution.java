package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution {

	@Test(groups="Shopping")
	public void myntraTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
	}
	
	@Test(groups="Food")
	public void zomatoTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
	}
	
	@Test(groups="Shopping")
	public void ajioTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
	
	@Test(groups="Food")
	public void swiggyTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
	}
}
