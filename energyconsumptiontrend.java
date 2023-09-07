package rahulshetty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class energyconsumptiontrend {

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
		
		Thread.sleep(3000);
		
		
		// energy consumption trend grapgh 
		
		//showing xand y coordinate value
		
		String ectgraph = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][4]";

	   Point graph = driver.findElement(By.xpath(ectgraph)).getLocation();
		
		System.out.println("ectgraph value:"+graph);
		
		// maximum value of ect graph and DB maximum value verify
		
	//String graph1	="(//*[local-name()='svg' and @class='highcharts-root'])[3]//*[name()='rect'][]";
		
	List<WebElement> graphlist = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[3]//*[name()='rect']"));	
	Actions act = new Actions(driver);
    	
		for (WebElement e : graphlist) {
			
			 act.doubleClick(e).moveToElement(e).build().perform();
			 
			System.out.println("moving point :"+e.getSize()); 
			 
			//Thread.sleep(3000);
			 	 
		
			String graph2= driver.findElement(By.xpath("//div[@class='col-md-12 trendcss']")).getText();
			
		System.out.println("value:"+graph2);
	}

}}
