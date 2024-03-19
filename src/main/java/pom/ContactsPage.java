package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage {
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontact;

	public WebElement getCreatecontact() {
		return createcontact;
	}
}
