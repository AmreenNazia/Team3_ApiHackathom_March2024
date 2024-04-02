package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
 
 
public class PC_login extends BaseTest{
	
	JSONObject credentials;
	Response response;
	public static String authToken;
	public static String Endpoint = PropertiesFile.getProperty("endpoint");
	public JsonReader reader = new JsonReader();
	public PC_token tok = new PC_token();
	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() throws JsonProcessingException, FileNotFoundException {
		credentials = new JSONObject();
		credentials.put("userLoginEmailId",PropertiesFile.getProperty("username"));
		credentials.put("password",PropertiesFile.getProperty("password") );
//		 
//		Map<String, Object> userDetails = new LinkedHashMap<String, Object>();
//		 
//		userDetails.put("programId", Batch_SD.programID);
//		userDetails.put("roleId", "R03");
//		userDetails.put("userId", UC_PostRequestStep.userID);
//		Map<String, Object> details = new HashMap<String, Object>();
//
//		
//		details.put("userRoleProgramBatchStatus", "Active");
//		details.put("batchId", Batch_SD.batchID);
//		List<Map<String,Object>> object = new ArrayList<Map<String, Object>>();
//		object.add(details);
//		
//		
//		userDetails.put("userRoleProgramBatches", object);
//		 RestAssured.given().log().all().body(userDetails).get().prettyPrint();
//				 
//		 
		
		 
	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() throws FileNotFoundException {
		response =  given()
				 .spec(CommonSpec())
				 .body(credentials.toString())
				.when()
				.post(Endpoint);
		
		  authToken= response.path("token");
		  tok.setToken(authToken);
		  
	     
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer integer) {
		
		int statusCode = response.getStatusCode();
		String userID = response.path("userId");
		 
		int statuscode = integer;
		 Assert.assertEquals("Statuscode is not Equal", statuscode, statusCode);
		 Assert.assertNotNull("User Id is null", userID);
	 	 
	 	 
	     
	}
	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws FileNotFoundException {
		response =  given()
				 .spec(CommonSpec())
				 .body(credentials.toString())
				.when()
				.post("/log");
	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals("Statuscode is not Equal", statusCode, 401);
	}

	@Given("Admin creates request with invalid credentials")
	public void admin_creates_request_with_invalid_credentials() {
		credentials = new JSONObject();
		credentials.put("userLoginEmailId", "numpy@gmail.com");
		credentials.put("password",123 );
	}

	@Then("Admin receives {int} Bad request")
	public void admin_receives_bad_request(Integer int1) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals("Statuscode is not Equal", statusCode, 400);
	}

	


}
