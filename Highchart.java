package rahulshetty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highchart {

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
			
			
			// Energy Tree chart
			
			
			String verticleXpath = "//*[local-name()='svg']//*[name()='g'and@class='highcharts-series-group']";
		
		 List<WebElement> highchart	= driver.findElements(By.xpath(verticleXpath));
		
		System.out.println("size of highchartlist:"+highchart.size());

		// actual consumption
		
	String mainvalue = "//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]";
	
		
     String value	= driver.findElement(By.xpath(mainvalue)).getText();
	
	System.out.println("actual consumption value:"+value);
	
	// predictive consumption
	
	
	String totalvalue = "//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]";
	
    String Tvalue	= driver.findElement(By.xpath(totalvalue)).getText();
	
	System.out.println("Predictive consumption value:"+Tvalue);
	
	
	// main candle value

	String Mvalue = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]";
	
    String cvalue	= driver.findElement(By.xpath(Mvalue)).getText();
	
	System.out.println("main candle value:"+cvalue);
	
	
		
	
	}

}
