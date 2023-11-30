package docker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class pathandquery {
	@Test
	public void pathquery()
	{
		given()
		.pathParam("mypath", "api")
		.queryParam("fromDate", "2023-09-05")
		.queryParam("toDate", "2023-09-06")
		.queryParam("variety", "Desi")
		.queryParam("market", "Ghaziabad")
		.queryParam("state", "UP")
		
		
		.when()
		.get("http://192.168.0.24:8001/{mypath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
		
	
	}

}
