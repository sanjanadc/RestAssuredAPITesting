package com.BookStore;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class GetBookStroreAPI {
	@Test
	void getweatherDeatils() 
	{
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		RequestSpecification httpRequest =  RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"");
		
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);
		
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
	
		String content = response.header("Content-Type");
		System.out.println("content - type "+ content);
		
		Headers allheaders = response.getHeaders();
		
		System.out.println("list of headers");
		for(Header header : allheaders)
		{
			
			System.out.println(header);
		}
		
		
	}
}