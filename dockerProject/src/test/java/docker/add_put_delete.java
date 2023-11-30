package docker;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class add_put_delete {
	@Test
	public void put()
	{
		RequestSpecification request=RestAssured.given();
		request.header("Content-type","application/json");
		JSONObject json=new JSONObject();
		json.put(1, 76.48578475);
		request.body(json.toJSONString());
		Response resp=request.post("http://192.168.0.24:8001/api?fromDate=2023-09-05&toDate=2023-09-06&variety=Desi&market=Ghaziabad&state=UP");
		int code=resp.statusCode();
		System.out.println("code is"+code);
	}

}
