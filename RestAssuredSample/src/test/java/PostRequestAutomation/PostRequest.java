package PostRequestAutomation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import org.json.simple.JSONObject;

public class PostRequest 
{
@Test
	public void posttest()
	{
		
	JSONObject json= new JSONObject();
	json.put("name","jagadeesh");
	json.put("job","QA");
	 given()
	.header("Content-Type","application/json")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(json.toJSONString())
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log()
	.all();
	
	
	}

	
	

}
