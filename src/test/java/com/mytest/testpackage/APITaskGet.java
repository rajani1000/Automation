package com.mytest.testpackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Test;

/**
 * @author Rajani
 * This is Get call task, verifying status code 200 and not null
 *
 */
public class APITaskGet {	

	@Test
	public void getCall() throws Exception {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json;charset=UTF-8");

		Response response = httpRequest.request(Method.GET, "/posts/1");		

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		int statusCode = response.getStatusCode();
		String sCode = Integer.toString(statusCode);
		System.out.println("Status code: " + sCode);
		
		if(sCode.equals("200") && sCode != null ) {
			System.out.println("Status code returned as expected - verification passed");
		} else {
			throw new Exception("Response status code is not returned as expected, Verification failed");
		}

	}
}
