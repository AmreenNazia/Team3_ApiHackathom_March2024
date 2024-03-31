package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UC_GetUsers extends BaseTest{
	JSONObject credentials;
	Response response;	
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	
	@Given("Admin creates Get request")
	public void admin_creates_get_request() {
		 request = given().spec(CommonSpec());
	}

	@When("Admin sends https request with {string}")
	public void admin_sends_https_request_with(String endpoint) {
	   String Endpoint = PropertiesFile.getProperty(endpoint);
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				 .when()
				.get(Endpoint).then().log().all().extract().response();
	}

	@Then("Admin receives {int} ok")
	public void admin_receives_ok(Integer int1) {
		int statusCode= response.getStatusCode();		 
		 Assert.assertEquals(200, statusCode);
		 //response.then().assertThat()
         //.statusCode(statusCode);
         //.statusLine("HTTP/1.1 200 ")
         //.header("Content-Type","application/json")
         //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/UserGetSchema.json"));
	}
	
	@Then("Admin receives {int}")
	public void admin_receives_with_unauthorized(Integer int1) {
		int statusCode= response.getStatusCode();		 
		 Assert.assertEquals(404, statusCode);
	}
}
