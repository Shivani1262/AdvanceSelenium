package basicAsserts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void myntra() {
		 WebDriver wb = new ChromeDriver();
		 wb.manage().window().maximize();
	     wb.get("https://www.myntra.com/");
	     String actualUrl = wb.getCurrentUrl();
	     String expectedUrl = "https://www.myntra.com/";
	     
	     //Create Object of SoftAssert
	     SoftAssert sa = new SoftAssert();
	     
	   //Call assertEquals(boolean actual,boolean expected)
	     sa.assertEquals(actualUrl, expectedUrl);
	     System.out.println("Good Morning");
	     
	     sa.assertAll();
	}

	private void assertEquals(String actualUrl, String expectedUrl) {
		// TODO Auto-generated method stub
		
	}

	private void assertAll() {
		// TODO Auto-generated method stub
		
	}

}
