package com.BookStore;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class GetBookByIsbn {
	
	@Test
	public void returnBook()
	{
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/Book?ISBN=9781449325862");
		
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String title = jsonPathEvaluator.get("title");
		String author = jsonPathEvaluator.get("author");
		System.out.println("Title of book "+title);
		System.out.println("Author of book " + author );
		
	
	}

}
