package basicAsserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrue {

	@Test
	public void myntra() {
		 WebDriver wb = new ChromeDriver();
		 wb.manage().window().maximize();
	     wb.get("https://www.myntra.com/");
	     
	     WebElement searchtf = wb.findElement(By.className("desktop-searchBar"));
	     
	     //Call assertTrue(boolean Condition)
	     Assert.assertTrue(searchtf.isSelected());
//	     Assert.assertTrue(searchtf.isDisplayed());
//	     Assert.assertTrue(searchtf.isEnabled());
	     System.out.println("Good Morning");
	     
	     //searchtf.isDisplayed()=> True Condition => Pass
	    //searchtf.isSelected()=> False Condition => Fail
	   //searchtf.isEnabled()=> False Condition => Pass
	  }
}