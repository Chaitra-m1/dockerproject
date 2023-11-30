package docker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesdemo {
	@Test
	public void cookie()
	{
		Response resp =given()
		
		.when()
		.get("https://www.google.com/");
		String str=resp.getCookie("AEC");
		System.out.println("cookies is"+str);
	}
	@Test
	public void cookies_value()
	{
		Response resp =given()
				
				.when()
				.get("https://www.google.com/");
		
			Map<String,String>cookies_value=resp.getCookies();
			for(String k:cookies_value.keySet())
			{
				String cookies_values=resp.getCookie(k);
				System.out.println(k+"   "+cookies_values);
			}
	}

}
