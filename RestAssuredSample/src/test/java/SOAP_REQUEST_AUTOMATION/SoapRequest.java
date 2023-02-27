package SOAP_REQUEST_AUTOMATION;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SoapRequest 
{
	@Test
	public void soaptest() throws IOException
	{
		
		File xmlfile= new File("./SoapRequest/Add.xml");
		FileInputStream fis= new FileInputStream(xmlfile);
		String body=IOUtils.toString(fis,"UTF-8");
		
		given()
		 .contentType("text/xml")
		 .accept(ContentType.XML)
		.body(body)
		 .when()
		  .post("http://www.dneonline.com/calculator.asmx")
		  .then()
		  .statusCode(200)
		  .log()
		  .all()
		  .and()
		  .body("//*:AddResult.text()",equalTo("12"));
		
	}
	
	

}
