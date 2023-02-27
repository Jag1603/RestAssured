package PatchRequestAutomation;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequest 
{
	
	
	@Test
	public void patchtest()
	{
			
		JSONObject json= new JSONObject();
		json.put("name","jagadeesh kumar");
		json.put("job","Tutor");
		 given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(json.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();
			
		
	}
	

}
