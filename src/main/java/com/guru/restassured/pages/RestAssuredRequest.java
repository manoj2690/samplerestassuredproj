package com.guru.restassured.pages;
import com.guru.restassured.wrappers.Wrappers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredRequest  extends Wrappers {

	RequestSpecification reqSpec;
	
	public RestAssuredRequest(){
		
	}
	
	//Request initialize
	public RestAssuredRequest initRequest(){
		
		reqSpec = RestAssured.given();
		return this;
	}
	
	//Add Baseuri
	public RestAssuredRequest addBaseUri(String baseUri){
		
		RestAssured.baseURI = baseUri;
		return this;
	}
	
	//Add Request Header
	public RestAssuredRequest addReqHeader(String key, String val){
		
		reqSpec = reqSpec.with().header(key, val);
		
		return this;
	}
	
	//Add Request body
	
	//Add path params
	

	//Go To request Method
	public RestAssuredRequestMethod goToReqMethod(){
		return new RestAssuredRequestMethod(reqSpec);
	}
	
}
