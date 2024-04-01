package com.api.utils;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.json.JSONObject;
import org.junit.Before;

import com.api.stepdefinition.PC_login;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest extends PropertiesFile {
	
	public static RequestSpecification requestSpec;
	private static final String BaseURL = PropertiesFile.getProperty("baseURL");
	public JSONObject jsonObject = new JSONObject();
	public static PC_login token = new PC_login();
	private static final String BaseURL1 = PropertiesFile.getProperty("invalidbasseURI");
	
	@Before
	public static  RequestSpecification CommonSpec() throws FileNotFoundException {
		 
		  PrintStream log= new PrintStream(new FileOutputStream("LMS_RestAssuredLogs.txt"));
		 RequestSpecBuilder reqBuilder1 = new RequestSpecBuilder();
		 reqBuilder1.setBaseUri(BaseURL);
		 reqBuilder1.setContentType(PropertiesFile.getProperty("content.type"));
		 reqBuilder1.setAccept(ContentType.JSON);
//		 reqBuilder1.addFilter(RequestLoggingFilter.logRequestTo(log))
//		            .addFilter(ResponseLoggingFilter.logResponseTo(log));
		 requestSpec = reqBuilder1.build();
		   return requestSpec;
	 }
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
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
	


