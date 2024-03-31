package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UC_DeleteUser extends BaseTest{
	JSONObject credentials;
	Response response;	
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	
	
	@Given("Admin creates delete request")
	public void admin_creates_delete_request() {
		request = given().spec(CommonSpec());
	}
	
	@When("Admin sends delete request with {string}")
	public void admin_sends_delete_request_with(String endpoint) {
		String Endpoint = PropertiesFile.getProperty(endpoint);
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				 .when()
				.delete(Endpoint).then().log().all().extract().response();
	}

}
