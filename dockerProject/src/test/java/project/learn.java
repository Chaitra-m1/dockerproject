package project;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class learn {

	@Test
	
	public  void lea() {
		// TODO Auto-generated method stub
		given()
		
		.when()
			.get("http://192.168.0.2:4010/fetch_mandi_data?mandi=azadpur&state=nct-of-delhi&district=Delhi")
		.then()
		.statusCode(200)
		.log().all();
		
	
	}

}
