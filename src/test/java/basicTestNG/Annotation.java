package basicTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

	
	@Test
	public void facebook() {
		System.out.println("Facebook");
	}
	
	@BeforeMethod
	public void  BM() {
		System.out.println("Before Method");
	}
	
	
	@AfterMethod
	public void  AM() {
		System.out.println("After Method");
	}
}
