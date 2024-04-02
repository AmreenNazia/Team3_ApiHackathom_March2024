package com.api.stepdefinition;

	import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
	import org.junit.Assert;

	import com.api.models.PC_token;
import com.api.models.UpdateUserPayload;
import com.api.models.UserStatus;
import com.api.models.userUpdateRole;
import com.api.utils.BaseTest;
	import com.api.utils.JsonReader;
	import com.api.utils.PropertiesFile;
import com.beust.jcommander.internal.Lists;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

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
//		public userUpdateRole role = new userUpdateRole();
//		public UserStatus status = new UserStatus();
		public UpdateUserPayload load = new UpdateUserPayload();
		@Given("Users creates request with valid response body {string}")
		public void admin_creates_request_with_valid_response_body(String key) throws FileNotFoundException {
			 request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName,key));
		}
		@Given("Users creates request with valid response body UserRoleProgramBatch.")
		public void users_creates_request_with_valid_response_body_user_role_program_batch() throws FileNotFoundException, JsonProcessingException {
//			
//			List<Map<String, Object>> finalPlayload = new LinkedList<Map<String,Object>>();
			
			Map<String, Object> userDetails = new LinkedHashMap<String, Object>();
			 
			userDetails.put("programId", Batch_SD.programID);
			userDetails.put("roleId", "R03");
			userDetails.put("userId", post.userID);
			Map<String, Object> details = new HashMap<String, Object>();

			
			details.put("userRoleProgramBatchStatus", "Active");
			details.put("batchId", Batch_SD.batchID);
			List<Map<String,Object>> object = new ArrayList<Map<String, Object>>();
			object.add(details);
			
			
			userDetails.put("userRoleProgramBatches", object);
			 
 				 
			request = given().log().all().spec(CommonSpec()).body(userDetails);
			 
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
					.put(("/users/roleProgramBatchStatus/")+UC_PostRequestStep.userID).then().log()
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




