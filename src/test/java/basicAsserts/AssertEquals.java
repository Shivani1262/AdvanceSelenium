package basicAsserts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEquals {
	
		@Test
		public void myntra() {
			 WebDriver wb = new ChromeDriver();
			 wb.manage().window().maximize();
		     wb.get("https://www.myntra.com/");
		   
		     String actualTitle = wb.getTitle();
		     String expectedTitle = ""; 
		   
		     Assert.assertEquals(actualTitle, expectedTitle);
		    System.out.println(actualTitle);
		   
		   
		   
//		    String actualurl = wb.getCurrentUrl();
//		    String expectedUrl = "https://www.myntra.com/Pune" ;
		    
		    //Call assertEquals(boolean actual,boolean expected)
//		    Assert.assertEquals(actualurl, expectedUrl);
//		    System.out.println(actualurl);
		    
		    
	}

}
