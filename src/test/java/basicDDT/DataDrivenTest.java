package basicDDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		
		wb.get("https://demoapp.skillrary.com/");
		Thread.sleep(3000);
		
		wb.findElement(By.xpath("//a[text()='LOGIN']")).click();
		Thread.sleep(3000);
		wb.findElement(By.id("email")).sendKeys("user");
		Thread.sleep(3000);
		wb.findElement(By.id("password")).sendKeys("user");
	}

}
