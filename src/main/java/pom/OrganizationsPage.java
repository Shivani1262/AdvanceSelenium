package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	public WebDriver driver ;
	
	//Click on Create Organization...(+)
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganization;

	public WebElement getCreateorganization() {
		return createorganization;
	}
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create a method 
	public OrganizationsInformationPage Organizations() {
		//click on create organization ..(+)
		createorganization.click();
		return new OrganizationsInformationPage(driver);
	}
}
