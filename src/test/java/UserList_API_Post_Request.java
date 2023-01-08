import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserList_API_Post_Request {
	
	@Test
	void postUserListDeatils() 
	{
		RestAssured.baseURI = "https://reqres.in/api";
		//request object
		RequestSpecification httpRequest =  RestAssured.given();
		
		//Request payload 
		
		JSONObject  requestParam = new JSONObject();
		requestParam.put("email","eve.holt@reqres.in");
		requestParam.put("password","cityslicka");
		
		httpRequest.header("Content-Type", "application/json");
		
		//payload data attached to request body
		httpRequest.body(requestParam.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/register");
		
		
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String code = response.jsonPath().get("token");
		System.out.println("success code is " + code);
	}

}
