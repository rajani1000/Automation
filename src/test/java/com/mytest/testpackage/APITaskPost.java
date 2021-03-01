package com.mytest.testpackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.junit.Test;

/**
 * @author Rajani	
 *Task II
 *Post call - Verifying status code 200 , 201 and not null
 *This test can be run as junit test
 */
public class APITaskPost {
	
	@Test
	public void postCall() throws Exception {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	//	String requestBody = "{\"title\":\"foo\", \"body\":\"bar\", \"userId\":\"89\"}";

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json;charset=UTF-8");
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "foo"); 
		requestParams.put("body", "bar");		 
		requestParams.put("userId", "1");
		
		request.body(requestParams.toString());

		Response response = request.post("/posts");	

		int statusCode = response.statusCode();
		String sCode = Integer.toString(statusCode);
		System.out.println("Status code: " + sCode);
		
		if(!(sCode.equals("200")) && sCode.equals("201") && sCode != null ) {
			System.out.println("Status code verification passed");
		} else {
			throw new Exception("Response status code not returned as expected, Verification failed");
		}

	}
}
