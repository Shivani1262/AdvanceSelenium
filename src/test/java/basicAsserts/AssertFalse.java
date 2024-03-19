package basicAsserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertFalse {
	@Test
	public void myntra() {
		 WebDriver wb = new ChromeDriver();
		 wb.manage().window().maximize();
	     wb.get("https://www.myntra.com/");
	     
	     WebElement searchtf = wb.findElement(By.className("desktop-searchBar"));
	     
	     //Call assertFalse(boolean Condition)
//	     Assert.assertFalse(searchtf.isEnabled());
	     Assert.assertFalse(searchtf.isSelected());
//	     Assert.assertFalse(searchtf.isDisplayed());
	     System.out.println("Good Morning");
	     
	     //searchtf.isEnabled()=> TrueCondition => Fail
	    //searchtf.isDisplayed()=> True Condition => Fail
	   //searchtf.isSelected()=> False Condition => Pass
	     
	}
}
