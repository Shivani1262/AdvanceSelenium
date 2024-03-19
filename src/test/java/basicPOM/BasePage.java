package basicPOM;

import java.io.IOException;
import java.util.Properties;

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
import pom.OrganizationsInformationPage;
import pom.OrganizationsPage;

public class BasePage {
	
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
		
		//To read the data from Excel file
		String orgName = eutil.getDataFromExcel("Organizations", 0, 1);
		String group = eutil.getDataFromExcel("Organizations", 1, 1);			
		
		
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
		//Login to the application
		LoginPage lp = new LoginPage(driver);
		lp.Login(username, password);

		//Create object of HomePage
		HomePage hp = new HomePage(driver);
		hp.Home();
		
		//Create object of organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.Organizations();
		
    	//Create object of OrganizationsInformationPage
		OrganizationsInformationPage oip = new OrganizationsInformationPage(driver);
		oip.organizationsInformation(orgName+jutil.getRandomNumber(),group);
			
		Thread.sleep(3000);
		hp.Home(driver);				
		
	}

}
