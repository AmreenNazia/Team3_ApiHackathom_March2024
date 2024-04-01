package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.api.models.PC_token;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UC_LoginLogoutStep extends BaseTest {

	public static String jsonFileName = "UserLogin.json";
	public static String jsonKey = "LoginUser";
	public static PC_token tk = new PC_token();
	public JsonReader reader = new JsonReader();
	RequestSpecification request;
	Response response;
	public int statusCode;
	
	@Given("Admin creates post request with valid emailid and password")
	public void admin_creates_post_request_with_valid_emailid_and_password() {
		 RestAssured.baseURI = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
		  JSONObject jsonobj = new JSONObject();
		  request = given().header("Authorization", "Bearer "+PC_token.getToken()).
		  spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey));
	}

	@When("Admin calls Post Http request with valid endpoint")
	public void admin_calls_post_http_request_with_valid_endpoint() {
		response = request
				.when()
				.post("/login").then().log().all().extract().response();
	}
	@Given("user creates post request with invalid endpoint.")
	public void user_creates_post_request_with_invalid_endpoint() {
		 RestAssured.baseURI = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
		  JSONObject jsonobj = new JSONObject();
		  request = given().header("Authorization", "Bearer "+PC_token.getToken()).
		  spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey));
	}

	@When("user hit invalid url.")
	public void user_hit_invalid_url() {
		response = request
				.when()
				.post("//login").then().log().all().extract().response();
	}
	
	@Then("user receives {int} bad request")
	public void user_receives_bad_request(Integer int1) {
		statusCode = response.getStatusCode();
	}
	
	@Given("Unauthorized user creates post request with valid emailid and password")
	public void Unauthorized_user_creates_post_request_with_valid_emailid_and_password() {
		 RestAssured.baseURI = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
		  JSONObject jsonobj = new JSONObject();
		  request = given().
		  spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,jsonKey));
	}

	@When("user calls Post Http request with valid endpoint")
	public void user_calls_post_http_request_with_valid_endpoint() {
		response = request
				.when()
				.post("/login").then().log().all().extract().response();
	}

	@Then("user receives {int} status.")
	public void user_receives_status(Integer int1) {
		statusCode = response.getStatusCode();
	}
	@Given("user creates GET request with valid emailid and password")
	public void user_creates_get_request_with_valid_emailid_and_password() {
		request =
				 given().spec(CommonSpec());
		}
	

	@When("user calls GET Http request with valid endpoint")
	public void user_calls_get_http_request_with_valid_endpoint() {
		response = request
				.header("Authorization", "Bearer "+tk.getToken())
				.when()
				.get("/logoutlms").then().log().all().extract().response();
	}

	@Given("Unauthorized user creates GET request with valid emailid and password")
	public void unauthorized_user_creates_get_request_with_valid_emailid_and_password() {
		request =
				 given();
	}

	@When("Unauthorized user calls GET Http request with valid endpoint")
	public void unauthorized_user_calls_get_http_request_with_valid_endpoint() {
		response = request.when()
		.get("/logoutlms").then().log().all().extract().response();
	}


}
