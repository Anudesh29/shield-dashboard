package rahulshetty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ECT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\seleniumframework\\driver\\chromedriver.exe");
	     
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://shield.tor-iot.com/");
		
		driver.manage().window().maximize();
		
	
		  // login shield  
		
		driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[2]/input")).sendKeys("lenzuser");
		
		driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[3]/input")).sendKeys("Lenz@999");
	 
		
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
		
	    //actual consumption value

        

	    String mainvalue = "//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]";

	    

	        

	     String value    = driver.findElement(By.xpath(mainvalue)).getText();

	    

	    System.out.println("actual consumption value:"+value);

	    

	    //  main candle value

	    

	    

	    String mainlvalue = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]";

	    

	    String Tvalue    = driver.findElement(By.xpath(mainvalue)).getText();

	    

	    System.out.println("main candle value:"+Tvalue);

	    

	    Thread.sleep(3000);
		
		
	}

}
