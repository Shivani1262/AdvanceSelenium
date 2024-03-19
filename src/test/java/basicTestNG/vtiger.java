package basicTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class vtiger {
	
	@Test
	public void vTigerCRM() throws InterruptedException, IOException {
		WebDriver wb=new ChromeDriver();
		
		wb.manage().window().maximize();
		wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wb.get("https://demo.vtiger.com/vtigercrm/");
		Thread.sleep(3000);
		wb.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		wb.findElement(By.cssSelector("span[class='app-icon fa fa-bars']")).click();
		Thread.sleep(3000);
		WebElement market = wb.findElement(By.xpath("//span[text()=' MARKETING']"));
		
		Actions a = new Actions(wb);
		a.moveToElement(market);
		a.perform();
		
		wb.findElement(By.cssSelector("a[href='index.php?module=Contacts&view=List&app=MARKETING']")).click();
		wb.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		wb.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Ingle");
		JavascriptExecutor js = (JavascriptExecutor) wb ;
		Thread.sleep(3000);
		
		js.executeScript("window.scroll (0,document.body.scrollHeight)");
		
		wb.findElement(By.cssSelector("div[class='fileUploadBtn btn btn-primary']")).click();
	}
}
