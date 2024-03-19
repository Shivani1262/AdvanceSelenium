package basicTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotaion1 {

		@Test
		public void facebook() {
			System.out.println("Facebook");
		}
		
		@BeforeSuite
		public void  BS() {
			System.out.println("Before Suite");
		}
		
		
		@AfterSuite
		public void  AS() {
			System.out.println("After Suite");
		}
		
		@Test
		public void amazon() {
			System.out.println("Amazon");
		}
		
		@BeforeMethod
		public void  BM() {
			System.out.println("Before Method");
		}
		
		
		@AfterMethod
		public void  AM() {
			System.out.println("After Method");
		}
 
		@AfterClass
		public void  AC() {
			System.out.println("After Class");
		}
		
		@BeforeClass
		public void  BC() {
			System.out.println("Before Class");
		}
		
		@BeforeTest
		public void  BT() {
			System.out.println("Before Test");
		}
		
		@AfterTest
		public void  AT() {
			System.out.println("After Test");
		}
}
