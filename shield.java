package rahulshetty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shield {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\seleniumframework\\driver\\chromedriver.exe");
	     
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://shield.tor-iot.com/");
		
		driver.manage().window().maximize();
		
	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(2000);
		  
		  // login shield  
			
			driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[2]/input")).sendKeys("lenzuser");
			
			driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[3]/input")).sendKeys("Lenz@999");
		 
			
			driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
			
			
			
		
		//

	 
	}

}
