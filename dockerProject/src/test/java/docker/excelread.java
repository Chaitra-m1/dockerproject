package docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class excelread {
	@Test
	public void data()
	{
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://192.168.0.99:8001/api?fromDate=2022-09-06&toDate=2022-09-10&variety=Desi&market=Ghaziabad&state=UP");
		driver.manage().window().maximize();
		String data_from_table=driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")).getText();
		System.out.println(data_from_table);*/
		Response resp=get("http://192.168.0.24:8001/api?fromDate=2023-09-05&toDate=2023-09-10&variety=Desi&market=Ghaziabad&state=UP");
		int code=resp.getStatusCode();
		System.out.println("status code="+code);
		Assert.assertEquals(code, 200);
	}
	@Test
	public void testbody()
	{
		Response resp=get("http://192.168.0.24:8001/api?fromDate=2023-09-05&toDate=2023-09-10&variety=Desi&market=Ghaziabad&state=UP");
		String data=resp.asString();
		System.out.println("status code="+data);
		System.out.println("response time"+resp.getTime());
	}

}
