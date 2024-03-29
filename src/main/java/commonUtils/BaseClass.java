package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver driver;
	//static declaration is only for takesScreenShot
	public static WebDriver sdriver ;
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wdutil = new WebDriverUtil();
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to the base class");
	}
	
	@BeforeClass
	public void BC() throws IOException {
		//@BeforeClass is used to launch application
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("Url");
		
//		WebDriver driver = new ChromeDriver();
		
		
		if(BROWSER.equals("Chrome")) {
			 driver = new ChromeDriver();
		}
		else if(BROWSER.equals("Edge")) {
			 driver = new EdgeDriver();
		}
		else {
			 driver = new FirefoxDriver();
		}
		
		wdutil.maximize(driver);
		//To apply wait for findelement
		wdutil.implicitwait(driver);
		//initialization is only for takesScreenShot
		sdriver = driver ;
		driver.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException {
		//@BeforeMethod used to login to the application
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//Login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AM() {
		//@AfterMethod is used to sign out from the application
		//Mouse overing on image
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdutil.mouseOver(driver, img);
		
		//click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void  AC() {
		//@AfterClass Used to close the browser
		driver.quit();
	}
	
	public void AS() {
		System.out.println("Disconnect to the database");
	}
}
