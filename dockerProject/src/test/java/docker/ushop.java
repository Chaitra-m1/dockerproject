package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ushop {

	@Test
	public void shop() throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		URL url=new URL("http://localhost:4545/wd/hub");
		RemoteWebDriver driver1=new RemoteWebDriver(url, options);
		long start = System.currentTimeMillis();
		driver1.get("https://www.theushop.in/");
		System.out.println(driver1.getTitle());
		driver1.manage().window().maximize();
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start; 
		 
		
		
		System.out.println("Total Time for page1 to load - "+totalTime1); 
		
		
		long start2 = System.currentTimeMillis();
		driver1.findElement(By.xpath("//input[@id='wizzy-search-desktop-input']")).click();
		driver1.findElement(By.xpath("//input[@id='wizzy-search-desktop-input']")).sendKeys("dove");
		
		driver1.findElement(By.xpath("//input[@id='wizzy-search-desktop-input']")).sendKeys(Keys.ENTER);
		long finish2 = System.currentTimeMillis();
		long totalTime2 = finish2 - start2; 
		System.out.println("Total Time for page2 to load - "+totalTime2); 
		long start3 = System.currentTimeMillis();
		driver1.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		long finish5 = System.currentTimeMillis();
		long totalTime5 = finish5 - start3; 
		System.out.println("Total Time for page3 to load - "+totalTime5); 
		long start4 = System.currentTimeMillis();
		JavascriptExecutor j = (JavascriptExecutor) driver1;
       j.executeScript("window.scrollBy(0,400)");
      // driver.findElement(By.xpath("(//span[@class='add-to-cart'])[1]")).click();
       Thread.sleep(2000);
       System.out.println("$$$$$");
  new WebDriverWait(driver1, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='add-to-cart'])[1]"))).click();
  System.out.println("$$$$$"); 
  /*for(int i=2;i<3;i++)
       {
    	   driver.findElement(By.xpath("(//span[@class='add-to-cart'])["+i+"]")).click();
       }*/
  long finish6 = System.currentTimeMillis();
	long totalTime6 = finish6 - start4; 
	System.out.println("Total Time for page4 to load - "+totalTime6); 
	long start5 = System.currentTimeMillis();
  driver1.findElement(By.xpath("//a[@class='Header__Icon Icon-Wrapper Icon-Wrapper--clickable Cart-page ']")).click();
	Thread.sleep(4000);
  driver1.findElement(By.xpath("//span[@class='cart_drawer_checkout_msg']")).click();
  long finish7 = System.currentTimeMillis();
	long totalTime7 = finish7 - start5; 
	System.out.println("Total Time for page5 to load - "+totalTime7); 
	long finish = System.currentTimeMillis();
	long totalTime = finish - start; 
	System.out.println("Total response Time for all pages - "+totalTime);


	}

}
