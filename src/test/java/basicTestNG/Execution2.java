package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution2 {

	@Test
	public void skillraryTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://skillrary.com/");
	}
	
	@Test
	public void vTigerTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
	}
}
