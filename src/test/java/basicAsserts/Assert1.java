package basicAsserts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assert1 {

	@Test
	public static void assertTrue(boolean displayed) {
		 WebDriver wb = new ChromeDriver();
		 wb.manage().window().maximize();
	     wb.get("https://www.myntra.com/");
	   
	    String url = wb.getCurrentUrl();
	    if(url.equals("https://www.myntra.com/")) {
	    	System.out.println("Url is Matching");
	    }
	    else {
	    	System.out.println("Url is not Matching");
	    }
	    System.out.println(url);
	    
	}
}
