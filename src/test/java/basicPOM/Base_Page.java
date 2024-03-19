package basicPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtils;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
import pom.ContactsInformationPage;
import pom.ContactsPage;
import pom.HomePage;
import pom.LoginPage;

public class Base_Page {
	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException, IOException {
	//Object Creation
	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wdutil = new WebDriverUtil();
	JavaUtils jutil = new JavaUtils();
	
	//To read the data from propertyfile
	String browser = putil.getDataFromPropertyFile("Browser");
	String url = putil.getDataFromPropertyFile("Url");
	String username = putil.getDataFromPropertyFile("Username");
	String password = putil.getDataFromPropertyFile("Password");
	
	//To read data from Excel file
	String FirstName = eutil.getDataFromExcel("Contacts", 0, 1);
	String LastName = eutil.getDataFromExcel("Contacts", 1, 1);
	String OrgName = eutil.getDataFromExcel("Contacts", 2, 1);
	String Assign = eutil.getDataFromExcel("Contacts", 3, 1);
	
			//Launch the browser
			if (browser.equals("Chrome")) {
				driver = new ChromeDriver();
			}else if (browser.equals("EdgeDriver")) {
				driver = new EdgeDriver();
			}else {
				driver =  new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			//Launch the application
			driver.get(url);
			
			//Create object of LoginPage
			LoginPage lp = new LoginPage(driver);
			
			//To initialize WebElements.
			PageFactory.initElements(driver, lp);
			
			Thread.sleep(3000);
			//Login to the application
			lp.getUsernametf().sendKeys(username);
			lp.getPasswordtf().sendKeys(password);
			lp.getLoginbtn().click();
			
			Thread.sleep(3000);
			//Create object of HomePage
			HomePage hp = new HomePage(driver);
			//To initialize WebElements.
			PageFactory.initElements(driver, hp);
			hp.getContacts().click();
			
			//Create Object of Contacts
			ContactsPage ct = new ContactsPage();
			PageFactory.initElements(driver, ct);
			//click on contacts...(+)
			ct.getCreatecontact().click();
			//Create object of ContactsInformationPage
			ContactsInformationPage cip = new ContactsInformationPage();
			PageFactory.initElements(driver, cip);
			
	}

}
