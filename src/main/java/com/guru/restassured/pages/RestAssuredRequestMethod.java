package com.guru.restassured.pages;

import com.guru.restassured.wrappers.Wrappers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredRequestMethod extends Wrappers {

	RequestSpecification reqSpec;
	Response response;

	public RestAssuredRequestMethod(RequestSpecification reqSpec) {

		this.reqSpec = reqSpec;
	}

	// get request

	public RestAssuredResponse getRequest(String requestUri) {

		response = reqSpec.when().get(requestUri);
		return new RestAssuredResponse(response);
	}

}
