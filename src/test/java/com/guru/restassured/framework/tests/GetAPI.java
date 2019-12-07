package com.guru.restassured.framework.tests;

import org.junit.Test;

import com.guru.restassured.commons.RestAssuredBaseClass;
import com.guru.restassured.pages.RestAssuredRequest;

public class GetAPI extends RestAssuredBaseClass{

	@Test
	public void getAPIRequest(){
		
		new RestAssuredRequest()
		.addBaseUri("http://dummy.restapiexample.com/api/v1")
		.initRequest()
		.goToReqMethod()
		.getRequest("/employees")
		.printResponse()
		.verifyStatusCode(200)
		.validateResponseBasedOnJsonPath("[0].employee_name", "Obed")
		.endOfRequest()
		;
	}
}
