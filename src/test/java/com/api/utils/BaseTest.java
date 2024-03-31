package com.api.utils;

import org.json.JSONObject;
import org.junit.Before;

import com.api.stepdefinition.PC_login;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest extends PropertiesFile {
	
	public Response response;
	public static RequestSpecification requestSpec;
	private static final String BaseURL = PropertiesFile.getProperty("baseURL");
	private static final String BaseURL1 = PropertiesFile.getProperty("invalidbasseURI");
	
	public JSONObject jsonObject = new JSONObject();
	public static PC_login token = new PC_login();
	 
	@Before
	public static  RequestSpecification CommonSpec() {
		 
		  
		 RequestSpecBuilder reqBuilder1 = new RequestSpecBuilder();
		 reqBuilder1.setBaseUri(BaseURL);
		 reqBuilder1.setContentType(PropertiesFile.getProperty("content.type"));
		 reqBuilder1.setAccept(PropertiesFile.getProperty("content.type"));
		 requestSpec = reqBuilder1.build();
		   return requestSpec;
	 }
	
	public static  RequestSpecification CommonSpec1() {
		 
		  
		 RequestSpecBuilder reqBuilder1 = new RequestSpecBuilder();
		 reqBuilder1.setBaseUri(BaseURL1);
//		 reqBuilder1.setContentType(PropertiesFile.getProperty("content.type"));
//		 reqBuilder1.setAccept(PropertiesFile.getProperty("content.type"));
		 requestSpec = reqBuilder1.build();
		   return requestSpec;
	 }
	 
	 }
	


