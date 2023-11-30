package docker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class requests {
	int id;
	@Test
	public void getuser()
	{
		
		HashMap hm=new HashMap();
		hm.put("Max Price (Rs./Quintal)","834.6455971708953,841.236177167944");
		hm.put("Min Price (Rs./Quintal)","834.6455971708953,841.236177167944");
		hm.put("Modal Price (Rs./Quintal)","834.6455971708953,841.236177167944");
		id=given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.post("http://192.168.0.24:8001/api?fromDate=2023-09-05&toDate=2023-09-06&variety=Desi&market=Ghaziabad&state=UP")
		.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(200)
		//.log().all();
		
	}

}
