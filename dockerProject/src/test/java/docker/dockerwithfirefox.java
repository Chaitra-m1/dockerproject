package docker;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class dockerwithfirefox {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		URL url=new URL("http://localhost:4545/wd/hub");
		RemoteWebDriver driver1=new RemoteWebDriver(url, options);
		 List<Long> start_value=new ArrayList<Long>();
		    List<Long> total_value=new ArrayList<Long>();
		    List<String> page_number=new ArrayList<String>();
		long start = System.currentTimeMillis();
		start_value.add(start);
		String page="page1";
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
	driver1.quit();
	Connection connection=null;
	Statement statement=null;
	connection db_connect=new connection();
	connection=db_connect.get_connection();
	try
	{
		String query="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start+",'page1',"+totalTime1+")";
		String query1="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start2+",'page2',"+totalTime2+")";
		String query2="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start3+",'page3',"+totalTime5+")";
		String query3="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start4+",'page4',"+totalTime6+")";
		String query4="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start5+",'page5',"+totalTime7+")";
		String query5="insert into TotalMeasuredResponsesTime(MeasuredTime,StepName,MeasuredResponseTime)values("+start+",'AllPage',"+totalTime+")";
		statement=connection.createStatement();
		statement.execute(query);
		statement.execute(query1);
		statement.execute(query2);
		statement.execute(query3);
		statement.execute(query4);
		statement.execute(query5);
		System.out.println("successfull");
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		

	}

}
