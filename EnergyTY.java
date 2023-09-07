package rahulshetty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnergyTY {

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
		
		
		
		// Energy tree yesterday 
		
	//	driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[2]/a")).click();
		
		//Thread.sleep(5000);
		
    //throughout graph size shows with x,y axis 
		
     String verticleXpath = "//*[local-name()='svg']//*[name()='g'and@class='highcharts-series-group']";
	
	List<WebElement> highchart	= driver.findElements(By.xpath(verticleXpath));
	
	System.out.println("size of highchartlist:"+highchart.size());
	
	// red candle size shows only 

	//	String redcandle  = "//*[local-name()='svg']//*[name()='g'and@class='highcharts-grid highcharts-yaxis-grid']";
		
		String redcandle  = "//*[local-name()='svg']//*[name()='g'and@class='highcharts-label highcharts-tooltip highcharts-color-undefined']";
		
		List<WebElement> candle	= driver.findElements(By.xpath(redcandle));
		
		System.out.println("colour candle list:"+candle.size());
		
	//	total candle value 
		
		String totalcandle="#highcharts-pcuh7ly-602 > svg > g.highcharts-data-labels.highcharts-series-0.highcharts-bar-series.highcharts-tracker > g:nth-child(2) > text > tspan";
		
		String Tvalue=driver.findElement(By.cssSelector(totalcandle)).getText();
		
		System.out.println("total candle  value:"+Tvalue);
		
	
		
	}
		
		
		
	}


