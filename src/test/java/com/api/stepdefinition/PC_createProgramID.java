package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.utils.PropertiesFile;
import com.api.utils.ResponseHandler;
 
import com.api.models.PC_CreateProgramIDPojos;
import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 

public class PC_createProgramID extends BaseTest{
	
	
	static int statusCode;
	JSONObject credentials;
	Response response;
	public static String jsonFileName = "ProgramController.json";
	public static String jsonKey = "CreateProgramId";
	public static String Endpoint = PropertiesFile.getProperty("createprogram");
	public static PC_token tk = new PC_token();
	public JsonReader reader = new JsonReader();
	  RequestSpecification request;
	
	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws FileNotFoundException {
		  request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		 
		 
			response = request
					.header("Authorization", "Bearer "+PC_token.getToken())
					 .when()
					.post(Endpoint).then().log().all().extract().response();
			
			 
			
	// PC_CreateProgramIDPojos pojo = ResponseHandler.deserializedResponse(response,PC_CreateProgramIDPojos.class);
	 
	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
	    
		int statusCode= response.getStatusCode();
		 
		 Assert.assertEquals(201, statusCode);
	}



}
