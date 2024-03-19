package basicTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {

	@Test(priority=0,invocationCount=2)
	public void facebook() {
//		System.out.println("facebook");
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.facebook.com/");
	}
	
	@Test(priority=1)
	public void amazon() {
//		System.out.println("Amazon");
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://amazon.in/");
	}
	
	@Test(priority=2)
	public void myntra() {
//		System.out.println("Myntra");
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.myntra.com/");
	}
	
	
}
