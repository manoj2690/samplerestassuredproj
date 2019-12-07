package com.guru.restassured.pages;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.guru.restassured.wrappers.Wrappers;

import io.restassured.response.Response;

public class RestAssuredResponse extends Wrappers {

	Response response;
	String responseString;
	Map<String, Object> responseMap;
	List<Object> responseList;

	public RestAssuredResponse(Response response) {

		this.response = response;

	}

	// response print
	public RestAssuredResponse printResponse() {

		responseString = response.getBody().asString();
		System.out.println("================= Response: ================\n" + responseString);
		return this;
	}

	// verify status code
	public RestAssuredResponse verifyStatusCode(int expStatusCode) {

		int actStatusCode = response.statusCode();
		System.out.println("Status Code: " + actStatusCode);
		Assert.assertEquals(expStatusCode, actStatusCode);
		return this;
	}

	// get response as string
	public RestAssuredResponse convertResponseToString() {
		System.out.println("================= Response: ================\n" + responseString);
		return this;
	}

	// parse response string as map
	@SuppressWarnings("unchecked")
	public RestAssuredResponse parseResponseStringToMap() {

		responseMap = (Map<String, Object>) parseJsonString(responseString);
		return this;
	}

	// parse response string as list
	@SuppressWarnings("unchecked")
	public RestAssuredResponse parseResponseStringToList() {

		responseList = (List<Object>) parseJsonString(responseString);
		return this;
	}

	// validate response field map using key and value
	public RestAssuredResponse validateResponseMapField(String key, Object expVal) {
		Object actVal = responseMap.get(key);
		Assert.assertEquals(expVal, actVal);
		return this;
	}

	// validate response based on jsonPath
	public RestAssuredResponse validateResponseBasedOnJsonPath(String jsonPath, Object expVal) {

		Object actVal = response.jsonPath().get(jsonPath);
		Assert.assertEquals(expVal, actVal);
		return this;
	}
	
	public RestAssuredRequest endOfRequest(){
		return new RestAssuredRequest();
	}

}
