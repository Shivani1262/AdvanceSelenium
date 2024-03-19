package basicPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM1 {
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/");
		Thread.sleep(3000);
		
		//click on Login
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		
		//Enter admin in emailtf
		WebElement emailtf = driver.findElement(By.id("email"));
		emailtf.sendKeys("admin");
		
		Thread.sleep(3000);
		//refresh
		driver.navigate().refresh();
		
		//Enter user in emailtf
		emailtf.sendKeys("user");
	}

}
