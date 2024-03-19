package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class OrganizationsInformationPage {
	public WebDriver driver ;
	
	//create object of WebDriverUtil
	WebDriverUtil wutil = new WebDriverUtil();
	
	//Identify Organizations name
	@FindBy(name="accountname")
	private WebElement OrganizationsnameTf ;

	//Identify group radio button
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn ;
	
	//Identify the drop down 
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	//Identify the save button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn ;

	public WebElement getOrganizationsnameTf() {
		return OrganizationsnameTf;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public OrganizationsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create a method 
	public HomePage organizationsInformation(String Orgnamedata, String groupdata) {
		//Enter Organizations Name
		OrganizationsnameTf.sendKeys(Orgnamedata);
		//click on group radio button
		groupbtn.click();
		//select support group in the dropdown
		wutil.handleDropDown(dropdown, groupdata);
		//Click on save button
		savebtn.click();
		return new HomePage(driver);
	}
}
