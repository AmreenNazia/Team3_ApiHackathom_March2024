package com.api.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;

import com.api.models.PC_CreateIDPojo;
import com.api.models.PC_UpdatePojo;
import com.api.models.PC_token;
import com.api.utils.API_Path;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;
import com.api.utils.ResponseHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PC_PostiveStepDefinitions extends BaseTest {
	static int statusCode;
	JSONObject credentials;
	Response response;
	 

 
	RequestSpecification request;
	public static int ProgramID;
	public static String ProgramName;
	public PC_CreateIDPojo pojo = new PC_CreateIDPojo();
	public PC_UpdatePojo pojo1 = new PC_UpdatePojo();
	 
	public static String Programname;

	 
	 
//** Create Program ID **//

	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {

		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.post(PropertiesFile.getProperty("createprogram")).then().log().all().extract().response();

			 
		PC_CreateIDPojo pojo = ResponseHandler.deserializedResponse(response, PC_CreateIDPojo.class);

	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {

		int statusCode = response.getStatusCode();

		assertEquals(201, statusCode, "StatusCode is Null");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + PropertiesFile.getProperty("JSonSchemaPath")));
	}

//*Get ALl Programs*//

	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {

		request = given().spec(CommonSpec());
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {

		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getallprograms")).then().log().all().extract().response();

	}

	@Then("Admins receives {int} OK Status with response body")
	public void admins_receives_ok_status_with_response_body(Integer statuscode) {

		int StatusCode = response.getStatusCode();
		assertEquals(statuscode, StatusCode);

	}

//** Get Program ID**//

	@Given("Admin create GET Request for  LMS API")
	public void admin_create_get_request_for_lms_api() {
		request = given().spec(CommonSpec());
	}

	@When("Admin send HTTPS Request with the endpoint")
	public void admin_send_https_request_with_the_endpoint() {

		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getallprograms_with_users") + "/{programId}", pojo.getProgramId())
				.then().log().all().extract().response();

	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		int StatusCode=response.getStatusCode();
		assertEquals(int1, StatusCode, "StatusCodeisNull");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + PropertiesFile.getProperty("JSonSchemaPath")));

	}

//** Get all Program with Users **//

	@Given("Admin create the GET Request for  LMS API")
	public void admin_create_the_get_request_for_lms_api() {
		request = given().spec(CommonSpec());
	}

	@When("Admin sends the HTTPS Request with endpoint")
	public void admin_sends_the_https_request_with_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getallprogramswithUsers")).then().log().all().extract().response();
	}

	@Then("Admin receive {int} OK Status with the response body")
	public void admin_receive_ok_status_with_the_response_body(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);

	}

//** Update Program Name **//

	 
	@Given("Admin creates PUT Request for the LMS API endpoint with the valid request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_the_valid_request_body_with_mandatory_additional_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey1));
	}

	@When("Admin sends HTTPS Request with the valid endpoint")
	public void admin_sends_https_request_with_the_valid_endpoint() {

		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramName") + "/{programName}", pojo.getProgramName()).then()
				.log().all().extract().response();
		PC_UpdatePojo pojos = ResponseHandler.deserializedResponse(response, PC_UpdatePojo.class);
	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		int statusCode = response.getStatusCode();
//		assertEquals(response.path("programName"),pojo1.getProgramName() , "programName is not same");
		assertEquals(200, statusCode, "StatusCode is Null");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + PropertiesFile.getProperty("JSonSchemaPath")));
	}

	// ** Update Program ID **//

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey2));
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() {

		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramID") + "/{programId}", pojo.getProgramId()).then().log()
				.all().extract().response();
		Programname = response.path("programName");
	}

	@Then("Admin receives {int} OK Status with updated value in response body")
	public void admin_receives_ok_status_with_updated_id_in_response_body(Integer int1) {

		int statusCode = response.getStatusCode();

		assertEquals(int1, statusCode, "StatusCode is Null");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + PropertiesFile.getProperty("JSonSchemaPath")));

	}

	// ** Delete Program Name **//

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		request = given().spec(CommonSpec());
	}

	@When("Admin has sends  HTTPS Request with endpoint")
	public void admin_has_sends_https_request_with_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("DeleteProgramName") + "/{programName}", Programname).then().log()
				.all().extract().response();
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		int Statuscode = response.getStatusCode();
		assertEquals(int1, Statuscode, "Statuscode is Null");
	}

	// ** Delete ProgramID**//
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() {
		request = given().spec(CommonSpec());
	}

	@When("Admin send HTTPS Request with endpoint.")
	public void admin_send_https_request_with_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("DeleteProgramId") + "/{programId}", pojo.getProgramId()).then()
				.log().all().extract().response();
	}

	@Then("Admin receive {int} Ok status with message")
	public void admin_receive_ok_status_with_message(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode, "StatusCode is Null");

	}
	 
//** Create Program without Authorization **//
	@When("Admin send HTTPS Request and  request Body with endpoint")
	public void admin_send_https_request_and_request_body_with_endpoint() {
		
		response = request
				 .when()
				.post(PropertiesFile.getProperty("createprogram")).then().log().all().extract().response();
	     
	}

	@Then("Admin receives {int} Unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}

//** Create Program with invalid Endpoint **//
	
	@When("Admin sends HTTPS Request and the request Body with endpoint")
	public void admin_sends_https_request_and_the_request_body_with_endpoint() {
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				 .when()
				.post("/save").then().log().all().extract().response();
	}

	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode); 
		
	}
	
//**Create a program with already existing program name**//
	@Given("Admin creates POST Request for LMS with request body")
	public void admin_sends_https_request_and_request_Body_with_endpoint() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName,API_Path.jsonKey3)); 
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_method_not_allowed(Integer int1) {
	     
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}
	
//** Create Program with invalid Method **//
	@When("Admin sends HTTPS Request and request Body with endpoint.")
	public void invalidMethod() {
		response = request
				.header("Authorization", "Bearer "+PC_token.getToken())
				 .when()
				.put("/saveprogram").then().log().all().extract().response();
	}

	@Then("Admin receives {int} Method Not Allowed")
	public void methodnotAllowed(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}
	
//** Create Program with invalid request body **//
	@Given("Admin creates POST Request for the LMS with invalid request body")
	public void admin_creates_post_request_for_the_lms_with_invalid_request_body() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName,API_Path.jsonKey4)); 
	}

	@Then("Admin receives {int} Bad Request Status")
	public void admin_receives_bad_request_status(Integer int1) {
	     
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	} 

//** Create Program with missing values in Request Body **//
	@Given("Admin creates POST Request for the LMS with missing values in request body")
	public void admin_creates_post_request_for_the_lms_with_missing_values_in_request_body() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName,API_Path.jsonKey6));
	}
	@Then("Admin receives {int} ok")
	public void admin_receives_ok(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}

//** Get all Programs with invalid Endpoint **//
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get("allProgram").then().log().all().extract().response();
	}

	@Then("Admin receives {int} not found  Status with error message")
	public void admin_receives_not_found_status_with_error_message(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}
//** Get all programs with invalid Method **//	
	@When("Admin sends HTTPS Request with invalid method")
	public void admin_sends_https_request_with_invalid_method() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put("allPrograms").then().log().all().extract().response();
	}

	@Then("Admin receives {int} Method will Not Allowed")
	public void admin_receives_method_will_not_allowed(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}
//** Get all Programs without Authorization **//
	@When("Admin sends HTTPS Request without Authorization")
	public void admin_sends_https_request_without_authorization() {
		response = request.when()
				.get("allPrograms").then().log().all().extract().response();
	}

	@Then("Admin receives {int} Status with response body as Unauthorized")
	public void admin_receives_status_with_response_body_as_unauthorized(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode);
	}
//** Get Program with Invalid Program ID **//	
	@When("Admin sends HTTPS Request with invalid programID")
	public void admin_sends_https_request_with_invalid_program_id() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getallprograms_with_users") + "/{programId}",  "100000000")
				.then().log().all().extract().response();
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success(Integer int1) {
		int StatusCode = response.getStatusCode();
		assertEquals(int1, StatusCode); 
		
	}
//**Get Program ID with invalid base URI**//
	@Given("Admin creates GET Request for the LMS API with invalid BaseURI")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_base_uri() {
		request = given().spec(CommonSpec1());
	}


//** Get Program ID without Authorization **//
	@When("Admin sends HTTPS Request to retrieve without Authorization")
	public void admin_sends_https_request_to_retrieve_without_authorization() {
		response = request.when()
				.get(PropertiesFile.getProperty("getallprograms_with_users") + "/{programId}",  pojo.getProgramId())
				.then().log().all().extract().response();
	}
	
//** Get ProgramID with invalid Endpoint **//

	@When("Admin sends HTTPS Request with invalid Endpoint for program")
	public void admin_sends_https_request_with_invalid_endpoint_for_program() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("getallprograms_with_users") + "{programId}",  pojo.getProgramId())
				.then().log().all().extract().response();
	}
//** Get all Programs with Admins with invalid Endpoint **//
	
	@When("Admin sends the HTTPS Request with the invalid endpoint")
	public void admin_sends_the_https_request_with_the_invalid_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get("allProgramsWithUser").then().log().all().extract().response();
	}
//** Get all Programs with Admins with invalid Method **//
	@When("Admin sends the HTTPS Request with the invalid Method")
	public void admin_sends_the_https_request_with_the_invalid_method() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.post("/allProgramsWithUsers").then().log().all().extract().response();
	}
//**Get all Programs with Admins without Authorization **//
	@When("Admin sends the HTTPS Request without Authorization")
	public void admin_sends_the_https_request_without_authorization() {
		response = request.when()
				.get("/allProgramsWithUsers").then().log().all().extract().response();
	}
	
//** Update Prgoram with invalid ProgramName and Request Body **//
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory and additional  fields")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_and_additional_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "InvalidRequestBody"));  
	}

	@When("Admin send HTTPS Request with invalid endpoint")
	public void admin_send_https_request_with_invalid_endpoint() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put("/program" + "/{programName}", pojo.getProgramName()).then()
				.log().all().extract().response();
	}
//** Update Program Missing mandatory fields **//
	@Given("Admin creates PUT Request for the LMS API  with missing mandatory fields")
	public void admin_creates_put_request_for_the_lms_api_with_missing_mandatory_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "MissingProgramNameandStatus"));
	}
//** Update invalid values in Request Body **//
	@Given("Admin creates PUT Request for the LMS API endpoint  and  invalid program Name")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_invalid_program_name() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "InvalidRequestBody"));
	}

	@When("Admin sends HTTPS Request  and  request Body with mandatory fields.")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramName") + "/{programName}", pojo.getProgramName()).then()
				.log().all().extract().response();
	}
//** Update Program with invalid ProgramDescription **//
	@Given("Admin creates PUT Request for the LMS API endpoint  and  invalid program Description")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_invalid_program_description() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "InvalidProgramDescription"));
	}
	
//** Update Program with program Status **//
	@Given("Admin creates PUT Request for the LMS API endpoint  and  Valid program Name and status")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and_status() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "ProgramStatus"));
	}

//** Update Program without Authorization **//
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with the mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_the_mandatory_additional_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey1)); 
	}

@When("Admin sends HTTPS Request with valid endpoint and without authorization")
	public void admin_sends_https_request_with_valid_endpoint_and_without_authorization() {
		response = request.when()
				.put(PropertiesFile.getProperty("updateProgramName") + "/{programName}", pojo.getProgramName()).then()
				.log().all().extract().response();

	}

//** Update with invalid Program iD**//
	
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey2));
	}

	@When("Admin sends HTTPS Request with valid endpoint and invalid programid")
	public void admin_sends_https_request_with_valid_endpoint_and_invalid_programid() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramID") + "/{programId}", 99999999).then().log()
				.all().extract().response();
	}
	
//** Update Program Id with Invalid Request Body **//

	@Given("Admin creates PUT Request for the LMS API  with invalid request body")
	public void admin_creates_put_request_for_the_lms_api_with_invalid_request_body() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, "InvalidRequestBody"));
	}
	@When("Admin sends HTTPS Request with invalid requestbody")
	public void admin_sends_https_request_with_invalid_requestbody() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramID") + "/{programId}", pojo.getProgramId()).then().log()
				.all().extract().response();
	     
	}

//**Update Program Id without request Body **//

	@Given("Admin creates PUT Request for the LMS API  without request body")
	public void admin_creates_put_request_for_the_lms_api_without_request_body() {
		request = given().spec(CommonSpec());
	}

//** Update Program ID invalid BaseURi**//

	@Given("Admin creates PUT Request for the LMS API endpoint with invalid baseuri")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_invalid_baseuri() {
		request = given().spec(CommonSpec1());
	}
		
	@When("Admin sends HTTPS the Request with valid endpoint")
	public void admin_sends_https_the_request_with_valid_endpoint() {
		
		response = request.body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey2)).header("Authorization", "Bearer " + PC_token.getToken()).when()
				.put(PropertiesFile.getProperty("updateProgramID") + "/{programId}", pojo.getProgramId());
		System.out.println(pojo.getProgramId());
 
	}

	@Then("Admin receives {int} Not Found the Status with message and boolean success details")
	public void admin_receives_not_found_the_status_with_message_and_boolean_success_details(Integer int1) {
		int statusCode = response.getStatusCode();

		assertEquals(int1, statusCode, "StatusCode is Null");
	}


	
//** Update with Invalid Method **//

	@When("Admin sends HTTPS Request for PUt with invalid method")
	public void admin_sends_https_request_for_p_ut_with_invalid_method() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.get(PropertiesFile.getProperty("updateProgramID") + "/{programId}", pojo.getProgramId()).then().log()
				.all().extract().response();
		Programname = response.path("programName");
	}


//** Update Program ID without Authorization **//
	@Given("Admin creates PUT Request for the LMS API endpoint with request Body")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body() {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(API_Path.jsonFileName, API_Path.jsonKey2)); 
	}

	@When("Admin sends HTTPS Request without the authorization")
	public void admin_sends_https_request_without_the_authorization() {
		response = request.when()
				.put(PropertiesFile.getProperty("updateProgramID") + "/{programId}", pojo.getProgramId()).then().log()
				.all().extract().response();
		Programname = response.path("programName");
	}

//** Delete With Invalid Program Name **//
	@When("Admin has sends  HTTPS Request with endpoint and  invalid  programName")
	public void admin_has_sends_https_request_with_endpoint_and_invalid_program_name() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("DeleteProgramName") + "/{programName}",  "vjkfnbjknbvjkfsnbnk").then().log()
				.all().extract().response();
	}


//** Delete without Authorization **//
	@When("Admin has sends  HTTPS Request with endpoint and  without Authorization")
	public void admin_has_sends_https_request_with_endpoint_and_without_authorization() {
		response = request.when()
				.delete(PropertiesFile.getProperty("DeleteProgramName") + "/{programName}",  "vjkfnbjknbvjkfsnbnk").then().log()
				.all().extract().response();
	}
//** Delete with Invalid Program ID **//
	@Given("Admin creates DELETE Request for the LMS API endpoint")
	public void admin_creates_delete_request_for_the_lms_api_endpoint() {
		request = given().spec(CommonSpec());
	}

	@When("Admin send HTTPS Request with endpoint  and  invalid program ID.")
	public void admin_send_https_request_with_endpoint_and_invalid_program_id() {
		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
				.delete(PropertiesFile.getProperty("DeleteProgramId") + "/{programId}", "8789789798798").then()
				.log().all().extract().response();
	}
//** Delete without Authorization **//
	@Given("Admin create DELETE Request for the LMS API endpoint")
	public void admin_create_delete_request_for_the_lms_api_endpoint() {
		request = given().spec(CommonSpec());
	}

	@When("Admin send HTTPS Request with endpoint withOut Authorization")
	public void admin_send_https_request_with_endpoint_with_out_authorization() {
		response = request.when()
				.delete(PropertiesFile.getProperty("DeleteProgramId") + "/{programId}", "8789789798798").then()
				.log().all().extract().response();
	}




	
	
	







	
	

	
	

}
