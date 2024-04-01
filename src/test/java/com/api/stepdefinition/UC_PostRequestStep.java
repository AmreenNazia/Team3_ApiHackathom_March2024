package com.api.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UC_PostRequestStep extends BaseTest{
     
	
	public static String jsonFileName = "PostData.json";
	public static String jsonKey = "PostUser";
	public static String jsonKey1 = "PostUserInvalid";
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	Response response;
	public int statusCode;
	public static String userID ;
	
	@Given("Authorized Admin creates POST request with valid request body.")
	public void authorized_admin_creates_post_request_with_valid_request_body() throws FileNotFoundException {
		
		  JSONObject jsonobj = new JSONObject();
		  request = given().header("Authorization", "Bearer "+PC_token.getToken()).
		  spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey));
	}

	@When("Authorized admin send valid post api request")
	public void authorized_admin_send_valid_post_api_request() {
		response = request
				.when()
				.post("/users/roleStatus");
		userID = response.path("userId");
		System.out.println(userID);
		 
	}

	@Then("Authorized admin receive {int} status with response body")
	public void authorized_admin_receive_status_with_response_body(Integer int1) {
		  statusCode = response.getStatusCode();
	
		  response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + PropertiesFile.getProperty("Jsonschemapath")));
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is: " + responseBody);
	}
	

	@Given("Authorized admin user create post request with invalid request body")
	public void authorized_admin_user_create_post_request_with_invalid_request_body() throws FileNotFoundException {
		
		  JSONObject jsonobj = new JSONObject();
		  request = given().
		  spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey1));
				
	}
	
	@When("Authorized admin user send valid post api request")
	public void authorized_admin_user_send_valid_post_api_request() {
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				.when()
				.post("/users/roleStatus").then().log().all().extract().response();
	}

	@Then("Authorized admin user receive {int} status with message")
	public void authorized_admin_user_receive_status_with_message(Integer int1) {
		  statusCode = response.getStatusCode();
		  assertEquals(statusCode, 400);
		  
	}

	@Given("Unauthorized admin user create post request with valid request body")
	public void unauthorized_admin_user_create_post_request_with_valid_request_body() {
		          request = given();
	}

	@When("Unauthorized admin user send valid post api request")
	public void unauthorized_admin_user_send_valid_post_api_request() {
		response = request
				  .when()
				  .post("/users/roleStatus").then().log().all().extract().response();
	}

	@Then("Unauthorized admin user receive {int} status with message")
	public void unauthorized_admin_user_receive_status_with_message(Integer int1) {
		  statusCode = response.getStatusCode();
		  assertEquals(statusCode, 401);
	}

}