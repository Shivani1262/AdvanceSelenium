package basicDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		
		//Step1 : Create object of FileInputStream class and in FileInputStream constructor enter the location of the file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\DDT.properties");
		
		//Step2 : Create the object of Properties class 
		Properties p = new Properties();
		
		//Step3 : call load(InputStream) to fetch the location of external file
		p.load(fis);
		
		//Step4 : call getProperty(String Key) to fetch or read the keys 
		String url = p.getProperty("Url");
		String email = p.getProperty("Email");
		String pass = p.getProperty("Password");
		
		wb.get(url);
		
		wb.findElement(By.xpath("//a[text()='LOGIN']")).click();
		Thread.sleep(3000);
		wb.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(3000);
		wb.findElement(By.id("password")).sendKeys(pass);
	}

}
