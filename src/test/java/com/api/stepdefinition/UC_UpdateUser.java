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

	public class UC_UpdateUser extends BaseTest{
		
		JSONObject credentials;
		Response response;
		public static String jsonFileName = "UserController.json";		
		public JsonReader reader = new JsonReader();
		RequestSpecification request;
		
		@Given("Admin creates request with valid response body {string}")
		public void admin_creates_request_with_valid_response_body(String key) {
			 request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,key));
		}

		@When("Admin sends https put request with {string}")
		public void admin_sends_https_put_request_with(String endpoint) {
			String Endpoint = PropertiesFile.getProperty(endpoint);
			response = request
					.header("Authorization", "Bearer "+PC_token.getToken())
					 .when()
					.put(Endpoint).then().log().all().extract().response();
		}
		
		@Then("Admins receives {int} ok")
		public void admins_receives_ok(Integer int1) {
			int statusCode= response.getStatusCode();		 
			 Assert.assertEquals(200, statusCode);
			 response.then().assertThat()
             //.statusCode(statusCode)
             //.statusLine("HTTP/1.1 200 ")
             .header("Content-Type","application/json")
             .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/UserUpdateSchema.json"));
		}


	}




