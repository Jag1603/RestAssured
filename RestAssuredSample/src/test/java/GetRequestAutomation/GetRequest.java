package GetRequestAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetRequest

{
	@Test
	public  void getemployeedetails() 
	{
     Response empdetails =get("https://reqres.in/api/users?page=2");
     int Responsecode=  empdetails.getStatusCode();
     System.out.println(Responsecode);
     System.out.println(empdetails.prettyPrint());
     String Statusline=empdetails.getStatusLine();
     System.out.println(Statusline);
     empdetails.getHeaders();
     Assert.assertEquals(Responsecode,200);
     Assert.assertEquals(Statusline,"HTTP/1.1 200 OK");
     
     
	}
    @Test
	public void bddtest()
	{
		given().get("https://reqres.in/api/unknown").then().statusCode(200);
		
		
	}
    @Test
    public void jsonvalidation()
    {
    	given().
    	get("https://reqres.in/api/users?delay=3")
    	.then().
    	statusCode(200)
    	.body("data[3].first_name",equalTo("Eve"));
    	
    }
}
