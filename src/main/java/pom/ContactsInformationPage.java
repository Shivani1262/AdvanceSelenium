package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInformationPage {
	//Identify First Name text field
	@FindBy(name="firstname")
	private WebElement firstnameTf;
	
	//Identify Last Name text field
	@FindBy(name="lastname")
	private WebElement lastnameTf;
	
	//Identify organization name textfield and click on..(+)
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement orgnamePlusTf;
	
	//Identify search textfield for organization name
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement orgnameTF;
	//Identify search now button
	@FindBy(name="search")
	private WebElement searchnowbtn;
	
	//Identify group radio button
	@FindBy(xpath="(//input[@name='assigntype'])[3]")
	private WebElement groupbtn ;

	//Identify the drop down 
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
}

