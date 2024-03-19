package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel_Execution {
	
	@Test
	public void myntraTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void zomatoTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
	}
	
	@Test
	public void ajioTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
	
	@Test
	public void swiggyTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
	}
}
