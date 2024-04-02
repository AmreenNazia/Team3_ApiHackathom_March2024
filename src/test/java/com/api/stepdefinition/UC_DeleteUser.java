package com.api.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.json.JSONObject;
 

import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertEquals;

public class UC_DeleteUser extends BaseTest{
	JSONObject credentials;
	Response response;	
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	public UC_PostRequestStep post = new UC_PostRequestStep();
	
	@Given("Users creates delete request")
	public void admin_creates_delete_request() throws FileNotFoundException {
		request = given().spec(CommonSpec());
	}
	
	@When("Users sends delete request with deleteuser")
	public void admin_sends_delete_request_with_deleteuser() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("deleteuser") +UC_PostRequestStep.userID).then().log()
				.all().extract().response();
	}

	@When("Users sends delete request with deleteassignedprogrambatchbyuserId")
	public void admin_sends_delete_request_with_deleteassignedprogrambatchbyuser_id() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("deleteassignedprogrambatchbyuserId") +UC_PostRequestStep.userID ).then().log()
				.all().extract().response();
	}
	@Then("Userss receives {int} ok.")
	public void userss_receives_ok(Integer int1) {
	     int statusode = response.getStatusCode();
	      assertEquals(int1, statusode);
	}


}
