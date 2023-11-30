package project;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class reading_json {
	@Test
	
	public void parsing_json_response()
	{
		/*given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://192.168.0.24:8001/api?fromDate=2021-01-01&toDate=2021-01-15&variety=Desi&market=Ghaziabad&state=UP")
		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset-utf-8");*/
		//.body(, null)
		
		
		Response res =    given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://192.168.0.24:8001/api?fromDate=2021-01-01&toDate=2021-01-15&variety=Desi&market=Ghaziabad&state=UP");
		
		JSONObject jo =new JSONObject(res.toString());
		for(int i=0;i<15;i++)
		{
			String json_value=jo.getJSONObject("prices").get("").toString();
			System.out.println(json_value);
		}
		
	}

}
