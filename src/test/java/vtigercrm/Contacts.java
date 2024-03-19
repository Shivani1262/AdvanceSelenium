package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtils;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplementation.class)
public class Contacts {
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wdutil = new WebDriverUtil();
	ExcelUtil exutil = new ExcelUtil();
//	JavaUtils jutil = new JavaUtils();
	@Test
	public void ContactTest() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		wdutil.maximize(driver);
		
		//To apply wait for findelement
		wdutil.implicitwait(driver);
		
		//To read the data from propertyfile
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");		
		
		//To read data from Excel file
		String FirstName = exutil.getDataFromExcel("Contacts", 0, 1);
		String LastName = exutil.getDataFromExcel("Contacts", 1, 1);
		String OrgName = exutil.getDataFromExcel("Contacts", 2, 1);
		String Assign = exutil.getDataFromExcel("Contacts", 3, 1);
				
		//To launch the application
		driver.get(URL);
		
		//Login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on create contact(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		
				
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//To fail the test Script
//		 WebElement notifyCheckBox = driver.findElement(By.name("notify_owner"));
//		 Assert.assertTrue(false);
		
		 //To fail the test Script
		 String actualUrl = driver.getCurrentUrl();
	     String expectedUrl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing" ;
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     Thread.sleep(3000);
	     //In AssignTo Click on group
	     driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	     Thread.sleep(3000);
	     //Select dropdown
	     WebElement dropdown = driver.findElement(By.cssSelector("select[name='assigned_group_id']"));
		 wdutil.handleDropDown(dropdown, Assign);
		 //Click on select (+) in organization tf
		 driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 
		 Thread.sleep(3000);
		 //Transfer the control from parent window to child window
		 wdutil.switchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	     
		 Thread.sleep(3000);
		 //To Enter Organization name in searchtf
		 driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		 
		 //To click on search now button
		 driver.findElement(By.name("search")).click();
		 
		 //To click on organization name
		 driver.findElement(By.xpath("//a[text()='Intel4']")).click();
	
		//Transfer the control from parent window to child window
		 wdutil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		 
		 //Click on save
		 driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			
		 //to take screenshot of contact
		 Thread.sleep(3000);
		 wdutil.screenShot(driver, "Contacts");
		 
		 //Mouse hovering on administration
		 WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 wdutil.mouseOver(driver, image);
		 
		 //click on signout
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
