package DeleteRequestAutomation;

import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class DeleteRequest
{
	
	@Test
	public void deletetest()
	{
		
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log()
		.all();
		
	}

}
