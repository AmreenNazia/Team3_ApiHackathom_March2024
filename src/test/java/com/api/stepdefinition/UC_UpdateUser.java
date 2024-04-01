package com.api.stepdefinition;

	import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

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
		
		 JSONObject data;;
		Response response;
		public static String jsonFileName = "UserController.json";		
		public JsonReader reader = new JsonReader();
		RequestSpecification request;
		public UC_PostRequestStep post = new UC_PostRequestStep();
		public static int UserID;
		public static int ProgramID;
		public static int BatchID;
		
		@Given("Users creates request with valid response body {string}")
		public void admin_creates_request_with_valid_response_body(String key) throws FileNotFoundException {
			 request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,key));
		}
		@Given("Users creates request with valid response body UserRoleProgramBatch.")
		public void users_creates_request_with_valid_response_body_user_role_program_batch() throws FileNotFoundException {
			
			data = new JSONObject();
			data.put("programId", Batch_SD.programID);
			data.put("roleId", "R03");
	 
			data.put("userRoleProgramBatches[0].batchId", Batch_SD.batchID);
			data.put("userRoleProgramBatches[0].userRoleProgramBatchStatus","Active");
			System.out.println(data.toString());
	System.out.println(data.toString());		
			
			
			request = given().spec(CommonSpec()).body(data.toString());
			 
		}




		@When("Users sends https put request with {string}")
		public void admin_sends_https_put_request_with(String endpoint) {
			String Endpoint = PropertiesFile.getProperty(endpoint);
			response = request
					.header("Authorization", "Bearer "+PC_token.getToken())
					 .when()
					.put(Endpoint).then().log().all().extract().response();
		}
		
		@Then("users receives the {int} ok.")
		public void admins_receives_ok(Integer int1) {
			int statusCode = response.getStatusCode();

			assertEquals(int1,statusCode);
//			 response.then().assertThat()
//             //.statusCode(statusCode)
//             //.statusLine("HTTP/1.1 200 ")
//             .header("Content-Type","application/json")
//             .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/UserUpdateSchema.json"));
		}
		@When("Users sends https put request with assignupdateuserroleprogrambatch")
		public void admin_sends_https_put_request_with_assignupdateuserroleprogrambatch() {
			response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
					.put(PropertiesFile.getProperty("assignupdateuserroleprogrambatch")+UC_PostRequestStep.userID).then().log()
					.all().extract().response();
		}
		@When("Users sends https put request with updateuser")
		public void admin_sends_https_put_request_with_updateuser() {
			response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
					.put(PropertiesFile.getProperty("updateuser")+UC_PostRequestStep.userID).then().log()
					.all().extract().response();
		}
		@When("Users sends https put request with updateuserrolestatus")
		public void admin_sends_https_put_request_with_updateuserrolestatus() {
			response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
					.put(PropertiesFile.getProperty("updateuserrolestatus")+UC_PostRequestStep.userID).then().log()
					.all().extract().response();
		}
		@When("Users sends https put request with updateuserroleId")
		public void admin_sends_https_put_request_with_updateuserrole_id() {
			response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
					.put(PropertiesFile.getProperty("updateuserroleId")+UC_PostRequestStep.userID).then().log()
					.all().extract().response(); 
		}
		@When("Users sends https put request with updateuserloginstatus")
		public void admin_sends_https_put_request_with_updateuserloginstatus() {
			response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
					.put(PropertiesFile.getProperty("updateuserloginstatus")+UC_PostRequestStep.userID).then().log()
					.all().extract().response();  
		}





	}




