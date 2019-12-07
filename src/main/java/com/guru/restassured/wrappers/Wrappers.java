package com.guru.restassured.wrappers;

import com.google.gson.Gson;

public class Wrappers {
	
	Gson gson;
	
	protected  Wrappers(){
		gson = new Gson();
	}
	
	protected Object parseJsonString(String jsonString){
		return gson.fromJson(jsonString, Object.class);
	}

}
