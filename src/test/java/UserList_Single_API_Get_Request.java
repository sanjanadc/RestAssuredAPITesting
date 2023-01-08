import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserList_Single_API_Get_Request {
	@Test
	void getweatherDeatils() 
	{
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification httpRequest =  RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/1");
		
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println("status Line is " + statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	
	}
}
