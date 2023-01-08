import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserList_Get_Conetenttypes {
	@Test
	void getHeaderDeatils() 
	{
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification httpRequest =  RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/users");
		
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);
		
		String content_type = response.header("Content-Type");
		System.out.println(content_type);
		Assert.assertEquals(content_type, "application/json; charset=utf-8");
		
		String content_encoding = response.header("Content-Encoding");
		System.out.println(content_encoding);
		Assert.assertEquals(content_encoding, "gzip");
		
	}


}
