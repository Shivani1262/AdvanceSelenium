package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtils;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class OrganizationsTestNG extends BaseClass{
	public WebDriver driver;
	//Object creation
		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wdutil = new WebDriverUtil();
		ExcelUtil exutil = new ExcelUtil();
		JavaUtils jutil = new JavaUtils();
		
		@Test
		public void organizationTest() throws IOException, InterruptedException {
			WebDriver driver = new ChromeDriver();
			wdutil.maximize(driver);
			//To apply wait for findelement
			wdutil.implicitwait(driver);
			//To read the data from propertyfile
			String URL = putil.getDataFromPropertyFile("Url");
			String USERNAME = putil.getDataFromPropertyFile("Username");
			String PASSWORD = putil.getDataFromPropertyFile("Password");
			
			//To read data from Excel file
			String ORGNAME = exutil.getDataFromExcel("Organizations", 0, 1);
			String GROUP = exutil.getDataFromExcel("Organizations", 1, 1);
			
			//To launch the application
			driver.get(URL);
			
			//Login the application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();	
			
			//click on organization
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
			//click on create organizations(+)
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
			
			//In Assigned To click on group
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
			
			//In the dropdown select Support Group
			WebElement dropdown = driver.findElement(By.name("assigned_user_id"));
			wdutil.handleDropDown(dropdown, GROUP);
			
			//Click on Save Button
			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			
			Thread.sleep(2000);
			//Mouse overing on image
			WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			wdutil.mouseOver(driver, img);
			
			//click on sign out
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
}
