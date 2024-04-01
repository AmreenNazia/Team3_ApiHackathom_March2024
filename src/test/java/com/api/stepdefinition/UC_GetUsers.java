package com.api.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.models.Batch_Payload;
import com.api.models.PC_CreateIDPojo;
import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UC_GetUsers extends BaseTest{
	JSONObject credentials;
	Response response;	
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	public PC_CreateIDPojo pojo = new PC_CreateIDPojo();
	public UC_PostRequestStep post = new UC_PostRequestStep();
	public Batch_Payload load = new Batch_Payload();
	
	@Given("Users creates Get user request")
	public void user_creates_get_user_request() throws FileNotFoundException {
		 request = given().spec(CommonSpec());
	}

	@When("Users sends https request with {string}")
	public void user_sends_https_request_with(String endpoint) {
	   String Endpoint = PropertiesFile.getProperty(endpoint);
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				 .when()
				.get(Endpoint);
	}

	@Then("Users receives {int} ok.")
	public void user_receives_ok(Integer int1) {
		 	 
		int statusCode = response.getStatusCode();

		assertEquals(int1,statusCode);
		 //response.then().assertThat()
         //.statusCode(statusCode);
         //.statusLine("HTTP/1.1 200 ")
         //.header("Content-Type","application/json")
         //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/UserGetSchema.json"));
	}
	
	@Then("Users receives {int}")
	public void admin_receives_with_unauthorized(Integer int1) {
		int statusCode= response.getStatusCode();		 
		 Assert.assertEquals(404, statusCode);
	}
	@When("Users sends https request with getadminbyprogrambatchId")
	public void user_sends_https_request_with_getadminbyprogrambatch_id() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getadminbyprogrambatchId")+Batch_SD.batchID)
				.then().log().all().extract().response();
	}
	@When("Users sends https request with getadminbyprogramId")
	public void user_sends_https_request_with_getadminbyprogram_id() {
		
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getadminbyprogrambatchId")+pojo.getProgramId())
				.then().log().all().extract().response();
	     
	}
	@When("Users sends https request with getuserbyuserId")
	public void user_sends_https_request_with_getuserbyuser_id() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getadminbyprogrambatchId")+post.userID )
				.then().log().all().extract().response();
	     
	}
	@When("Users sends https request with getassignedprogrambatchbyuserId")
	public void admin_sends_https_request_with_getassignedprogrambatchbyuser_id() {
		
		 
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getassignedprogrambatchbyuserId")+post.userID )
				.then().log().all().extract().response();
	     
	}

	

	





}
