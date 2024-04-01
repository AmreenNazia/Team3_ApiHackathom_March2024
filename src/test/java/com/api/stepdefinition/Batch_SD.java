package com.api.stepdefinition;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;

import org.json.JSONObject;

import com.api.models.Batch_Payload;
import com.api.models.PC_CreateIDPojo;
import com.api.models.PC_token;
import com.api.utils.API_Path;
import com.api.utils.BaseTest;
import com.api.utils.JsonReader;
import com.api.utils.PropertiesFile;
import com.api.utils.ResponseHandler;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Batch_SD extends BaseTest {

	RequestSpecification request;
	Response response;
	public static String jsonFileName = "BatchDataLMS.json";
	public static String jsonKey;
	public static  int batchID;
	public static String batchName;
	public static int programID;
    public  Batch_Payload batch1=new Batch_Payload();
    public PC_CreateIDPojo pojo = new PC_CreateIDPojo();
     
    JSONObject data;
    JSONObject data1;
    

	// @CreateNewBatch

	@Given("User creates request for the LMS API endpoint {string}.")
	public void user_creates_request_for_the_lms_api_endpoint(String jsonKey) throws FileNotFoundException {
		data = new JSONObject();
		data.put("programId",pojo.getProgramId());
		data.put("programName",PC_PositiveStepDefinitions.Programname );
		data.put("batchDescription","SDET Batch");
		data.put("batchName","API_testers-364");
		data.put("batchNoOfClasses", 20);
		data.put("batchStatus","Active");
		
//		.body(JsonReader.getRequestBody(jsonFileName, jsonKey)) 
		request = given().spec(CommonSpec()).body(data.toString())
				                            .header("Authorization", "Bearer " + PC_token.getToken());
		 
		
	}

	@When("User sends HTTPS post request for batch and request body with mandatory and additional fields.")
	public void user_sends_https_post_request_for_batch_and_request_body_with_mandatory_and_additional_fields() {

		response = request.when()
				          .post(API_Path.apiPath.createBatch)
				          .then().log().all().extract().response();
		  batchID = response.path("batchId");
		  programID = response.path("programId");
	   Batch_Payload batch1=ResponseHandler.deserializedResponse(response, Batch_Payload.class);
	 

	}

	@Then("User receives {int} created status for batch.")
	public void user_receives_created_status_for_batch(Integer statusCode) {

		// Validating Status Code,Status Line,Header,Json Schema 
		response.then().assertThat()
		               .statusCode(statusCode)
		               .statusLine("HTTP/1.1 201 ")
		               .header("Content-Type","application/json")
		               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/postBatch.json"));
		
		// Validating Data
//		assertEquals("Batch Description not equal", batch1.getBatchDescription(),getJsonPath(response,"batchDescription"));
//		assertEquals("BatchName not equal", batch1.getBatchName(), getJsonPath(response,"batchName"));
//		assertEquals("BatchNoOfClasses not equal", batch1.getBatchNoOfClasses(),getJsonPath(response,"batchNoOfClasses"));
//		assertEquals("Batch Status not equal", batch1.getBatchStatus(), getJsonPath(response,"batchStatus"));
//		assertEquals("Program Id not equal", batch1.getProgramId(), getJsonPath(response,"programId"));
//		
	}
	
	//Create Batch Existing batch name

	@Given("Admin creates POST Request  with existing value in request body {string}")
	public void admin_creates_post_request_with_existing_value_in_request_body(String jsonKey)
			throws FileNotFoundException {

		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
				.header("Authorization", "Bearer " + PC_token.getToken());
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer statusCode) {
		
		// Validating Status Code,Status Line,Header
				response.then().assertThat()
				               .statusCode(statusCode)
				               .statusLine("HTTP/1.1 400 ")
				               .header("Content-Type","application/json");

	}
	
	// @CreateBatchMissingMandatory
	
	@Given("Admin creates POST Request  with invalid data in request body {string}")
	public void admin_creates_post_request_with_invalid_data_in_request_body(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
				.header("Authorization", "Bearer " + PC_token.getToken());
	}
	
	//@CreateBatchInvalidEndpoint
	
	@Given("Admin creates POST Request {string}")
	public void admin_creates_post_request(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
				.header("Authorization", "Bearer " + PC_token.getToken());
	    
	}
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response = request.when()
		          .post(API_Path.apiPath.invalidcreateBatch)
		          .then().log().all().extract().response();	   
	}
	@Then("Admin receives {int} not found  Status")
	public void admin_receives_not_found_status(Integer statusCode) {
		// Validating Status Code,Status Line,Header
		response.then().assertThat()
		               .statusCode(statusCode)
		               .statusLine("HTTP/1.1 404 ")
		               .header("Content-Type","application/json");
	   
	}
	
	// @CreateBatchMandatoryField
		@Given("Admin creates POST Request with missing additional fields Create New Batch Missing Field.")
		public void admin_creates_post_request_with_missing_additional_fields() throws FileNotFoundException {
//			.body(JsonReader.getRequestBody(jsonFileName, jsonKey))
			data = new JSONObject();
			data.put("programId",pojo.getProgramId());
			data.put("batchName","API_testers-415");
			data.put("batchNoOfClasses", 20);
			data.put("batchStatus","Active");
			request = given().spec(CommonSpec()).body(data.toString())
					                            .header("Authorization", "Bearer " + PC_token.getToken());
		}

		@When("Admin sends HTTPS Request with endpoint.")
		public void admin_sends_https_request_with_endpoint() {
			response = request.when().post(API_Path.apiPath.createBatch)
					                 .then().log().all().extract().response();
			  batchID = response.path("batchId");
			 
		}

		@Then("Admin receives {int} Created Status with response body.")
		public void admin_receives_created_status_with_response_body(Integer statusCode) {
			// Validating Status Code,Status Line , Header
			response.then().assertThat().statusCode(statusCode)
			                            .statusLine("HTTP/1.1 201 ")
			                            .header("Content-Type","application/json")
			                            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/postBatchMandatory.json"));;
	    }
	    
	
	// @CreateBatchInvalidData
	@Given("Admin creates POST Request with invalid data in request body {string}")
	public void admin_creates_post_request_with_invalid_data_in_request_body1(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
				.header("Authorization", "Bearer " + PC_token.getToken());
	    
	}
		
   //@CreateBatchInactiveProgramId
	@Given("Admin creates POST Request with inactive program id {string}")
	public void admin_creates_post_request_with_inactive_program_id(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
				.header("Authorization", "Bearer " + PC_token.getToken());
	}
	
	// @CreateBatchNoAuth
	
	@Given("Admin creates POST Request  with valid data in request body {string}")
	public void admin_creates_post_request_with_valid_data_in_request_body(String jsonKey) {
		try {
			request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	@Then("Admin receives {int} Unauthorized")
	public void admin_receives_unauthorized(Integer statusCode) {
		// Validating Status Code,Status Line,Header,Json Schema 
				response.then().assertThat()
				               .statusCode(statusCode)
				               .statusLine("HTTP/1.1 401 ")
				               .header("Content-Type","application/json");	   
	}
	
	// @GetAllBatches

	@Given("Admin creates GET Request.")
	public void admin_creates_get_request() throws FileNotFoundException {
		request = given().spec(CommonSpec())
				.header("Authorization", "Bearer " + PC_token.getToken());
	   
	}
	  
		@When("Admin sends {string} with endpoint.")
		public void admin_sends_with_endpoint(String get) {
			
			response = request.when()
			          .get(API_Path.apiPath.getAllBatches);
			           
			}
		   			    	
		@Then("Admin receives {int} OK Status with response body.")
		public void admin_receives_ok_status_with_response_body(Integer statusCode) {
			// Validating Status Code,Status Line,Header,Json Schema 
			response.then().assertThat()
			               .statusCode(statusCode)
			               .statusLine("HTTP/1.1 200 ")
			               .header("Content-Type","application/json");
			            	    
		}
		
		// @GetInvalidEndpoint
		@Then("Admin receives {int} status with error message Not Found .")
		public void admin_receives_status_with_error_message_not_found(Integer statusCode) {
			response.then().assertThat()
            .statusCode(statusCode)
            .statusLine("HTTP/1.1 404 ")
            .header("Content-Type","application/json");
		   
		}
		
		//  @GetAllBatchesSearchString
		@Given("Admin creates GET Request with search string.")
		public void admin_creates_get_request_with_search_string() throws FileNotFoundException {
			request = given().spec(CommonSpec())
                    .header("Authorization", "Bearer " + PC_token.getToken())
                    .queryParam("searchString", "batch");
		    
		}
		@Then("Admin receives {int} Ok status with response body.")
		public void admin_receives_ok_status_with_response_body1(Integer statusCode) {
			response.then().assertThat()
            .statusCode(statusCode)
            .statusLine("HTTP/1.1 200 ")
            .header("Content-Type","application/json");
		   
		}
		
		// @GetNoAuth

		@Given("Admin creates GET Request with no auth")
		public void admin_creates_get_request_with_no_auth() throws FileNotFoundException {
			request = given().spec(CommonSpec());
                    
		}

		@Then("Admin receives {int} status with error message Unauthorized.")
		public void admin_receives_status_with_error_message_unauthorized(Integer statusCode) {
			// Validating Status Code,Status Line,Header,Json Schema 
			response.then().assertThat()
			               .statusCode(statusCode)
			               .statusLine("HTTP/1.1 401 ")
			               .header("Content-Type","application/json");
            }
		
		//@GetBatchNoAuth
		@When("Admin sends {string} Request with endpoint")
		public void admin_sends_request_with_endpoint(String string) {
			response = request.when()
			          .get(API_Path.apiPath.getBatchByBatchID+batchID)
			          .then().log().all().extract().response();
			
		
		}


//@GetBatchByBatchId
	@Given("Admin creates GET Request with valid Batch ID.")
	public void admin_creates_get_request_with_valid_batch_id() throws FileNotFoundException {

		request = given().spec(CommonSpec()).header("Authorization", "Bearer " + PC_token.getToken());

	}

	@When("Admin sends HTTPS get Request with endpoint.")
	public void admin_sends_https_get_request_with_endpoint() {
		  System.out.println(batch1.getBatchId());
          //batchID=   batch1.getBatchId();
		response = request.when().log().all().get(API_Path.apiPath.getBatchByBatchID+batchID)
				.then().log()
				.all().extract().response();

	}

	@Then("Admin receives {int} OK Status with response body for batch.")
	public void admin_receives_ok_status_with_response_body_for_batch(Integer statusCode) {

		// Validating Status Code,Status Line,Header,Json Schema 
				response.then().assertThat()
				               .statusCode(statusCode)
				               .statusLine("HTTP/1.1 200 ")
				               .header("Content-Type","application/json")
				               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getBatch.json"));
	}
	@Then("Admin receives {int} OK Status with the response body for batch.")
	public void admin_receives_ok_status_with_the_response_body_for_batch(Integer statusCode) {
		response.then().assertThat()
        .statusCode(statusCode)
        .statusLine("HTTP/1.1 200 ")
        .header("Content-Type","application/json")
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getBatchName.json"));
	}



	
	// @GetBatchInvalidBatchId

	@Given("Admin creates GET Request with invalid Batch ID")
	public void admin_creates_get_request_with_invalid_batch_id() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());
	}
	
	@When("Admin sends HTTPS Request with endpoint {string}")
	public void admin_sends_https_request_with_endpoint(String string) {
		response = request.when()
		          .get(API_Path.apiPath.getBatchByBatchID+85220)
		          .then().log().all().extract().response();   
	}
	
	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer statusCode) {
		// Validating Status Code,Status Line,Header,Json Schema 
		response.then().assertThat()
		               .statusCode(statusCode)
		               .statusLine("HTTP/1.1 404 ")
		               .header("Content-Type","application/json");	   
	}

	// @GetBatchInvalidEndpoint
	@When("Admin sends HTTPS Request with {string}")
	public void admin_sends_https_request_with(String endpoint) {
		response = request.when()
		          .get(API_Path.apiPath.invalidEndpoint+endpoint)
		          .then().log().all().extract().response();		
	}
	
	//@GetBatchNameNoAuth
	@When("Admin sends HTTPS Request with batchName endpoint")
	public void admin_sends_https_request_with_batch_name_endpoint() {
		
		  batchName=   batch1.getBatchName();
		response = request.when()
		          .get(API_Path.apiPath.getBatchByBatchName+batchName)
		          .then().log().all().extract().response();
	    
	}
	
	// @GetBatchbyBatchName
	@Given("Admin creates GET Request with valid Batch Name.")
	public void admin_creates_get_request_with_valid_batch_name() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());

	}
	@When("Admin sends HTTPS Request with endpoint batchName.")
	public void admin_sends_https_request_with_endpoint_batch_name() {
		batchName=batch1.getBatchName();
		response = request.when()
		          .get(API_Path.apiPath.getBatchByBatchName+batchName)
		          .then().log().all().extract().response();
	    
	}
	
	// @GetBatchByInvalidBatchname
	@Given("Admin creates GET Request with invalid Batch Name")
	public void admin_creates_get_request_with_invalid_batch_name() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());
	}
	@When("Admin sends HTTPS Request with endpoint invalid BatchName")
	public void admin_sends_https_request_with_endpoint_invalid_batch_name() {
		response = request.when()
		          .get(API_Path.apiPath.getBatchByBatchName+API_Path.apiPath.invalidBatchName)
		          .then().log().all().extract().response();

	}
	
    // @GetBatchInvalidEndpoint
	@When("Admin sends HTTPS Request with invalid endpoint batchName")
	public void admin_sends_https_request_with_invalid_endpoint_batch_name() {
		
		response = request.when()
		          .get(API_Path.apiPath.invalidEndpoint+batchName)
		          .then().log().all().extract().response();	    		
}
    // @GetBatchByValidPgmId and   @GetBatchByPgmIdNoAuth
	@Given("Admin creates GET Request with the program id.")
	public void admin_creates_get_request_with_program_id() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());
	    
	}
	@When("Admin sends HTTPS Request with the endpoint for programId.")
	public void admin_sends_https_request_with_endpoint_for_program_id() {
		programID=batch1.getProgramId();
		response = request.when()
		          .get(API_Path.apiPath.getBatchByProgramID+programID)
		          .then().log().all().extract().response();
	
	}
	
	// @GetBatchByInvalidPgmId
	@When("Admin sends HTTPS Request with invalid programId endpoint")
	public void admin_sends_https_request_with_invalid_program_id_endpoint() {
	
		response = request.when()
		          .get(API_Path.apiPath.getBatchByProgramID+768657688)
		          .then().log().all().extract().response();
	  
	}	
	@When("Admin sends HTTPS Request with invalid endpoint for get batch")
	public void admin_sends_https_request_with_invalid_endpoint_for_get_batch() {
		response = request.when()
		          .get(API_Path.apiPath.invalidEndpoint+programID)
		          .then().log().all().extract().response();	   
	}
	
	// @UpdateBatchNoAuth
	
	@Given("Admin creates PUT Request with valid BatchId and {string}")
	public void admin_creates_put_request_with_valid_batch_id_and(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey));
               
	}
	
	@When("Admin sends HTTPS Request  with update endpoint.")
	public void admin_sends_https_request_with_update_endpoint() {
		
		 batchID=   batch1.getBatchId();
		 response = request.when()
				           .put(API_Path.apiPath.updateBatch+8466)
		 				   .then().log().all().extract().response();

		 		   batch1=ResponseHandler.deserializedResponse(response, Batch_Payload.class);	 
	}
	
    // @UpdateBatchValid
	@Given("Admin creates PUT Request with auth, valid BatchId and Update Valid Data.")
	public void admin_creates_put_request_with_auth_valid_batch_id_and_Update_Valid_Data() throws FileNotFoundException {
		System.out.println(programID);
		data1 = new JSONObject();
		data1.put("batchDescription","SDET BatchUpdates");
		data1.put("batchName","API_testers-515");
		data1.put("batchNoOfClasses", 20);
		data1.put("batchStatus","Active");
		data1.put("programId",programID);
		
//		.body(JsonReader.getRequestBody(jsonFileName, jsonKey))
		request = given().spec(CommonSpec()).body(data1.toString())
                .header("Authorization", "Bearer " + PC_token.getToken());
	}
	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer statusCode) {
		// Validating Status Code,Status Line,Header,Json Schema 
		response.then().assertThat()
		               .statusCode(statusCode)
		               .statusLine("HTTP/1.1 200 ")
		               .header("Content-Type","application/json")
		               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/putBatch.json"));
		batchID = response.path("batchId");
		  programID = response.path("programId");
	}
	
	//@UpdateBatchInvalid
	@When("Admin sends HTTPS Request  with endpoint invalid batch")
	public void admin_sends_https_request_with_endpoint_invalid_batch() {
		response = request.when()
		           .put(API_Path.apiPath.updateBatch+846678888)
				   .then().log().all().extract().response();	    
	}
	
	//@UpdateMissingMandatory
	@Given("Admin creates PUT Request with auth,BatchId and {string}")
	public void admin_creates_put_request_with_auth_batch_id_and(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
                .header("Authorization", "Bearer " + PC_token.getToken());
	}
	
	//@UpdateInvalidData
	@Given("Admin creates PUT Request with {string}")
	public void admin_creates_put_request_with(String jsonKey) throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, jsonKey))
                .header("Authorization", "Bearer " + PC_token.getToken());
	    
	}
	//UpdateInvalidEndpoint
	@When("Admin sends HTTPS put Request  with invalid endpoint")
	public void admin_sends_https_put_request_with_invalid_endpoint() {
		response = request.when()
		           .put(API_Path.apiPath.invalidEndpoint+8466)
				   .then().log().all().extract().response();	
	   
	}
	// @UpdateBatchwithDeletedProgramId
	
	@Given("Admin creates PUT Request with Valid batch Id and Deleted programID.")
	public void admin_creates_put_request_with_valid_batch_id_and_deleted_program_id() throws FileNotFoundException {
		request = given().spec(CommonSpec()).body(JsonReader.getRequestBody(jsonFileName, "Update with deleted programId"))
                .header("Authorization", "Bearer " + PC_token.getToken());

	}

	@When("Admin sends HTTPS Request  with update endpoint and deleted programID.")
	public void admin_sends_https_request_with_update_endpoint_and_deleted_program_id() {
		response = request.when()
		          .post(API_Path.apiPath.updateBatch+8452)
		          .then().log().all().extract().response();
	  
	}
	
     // @DeleteBatchwithValidBatchId
	@Given("Admin creates DELETE Request with valid BatchId.")
	public void admin_creates_delete_request_with_valid_batch_id() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());
	}

	@When("Admin sends HTTPS Request  with endpoint for batch.")
	public void admin_sends_https_request_with_endpoint_for_batch() {
		response = request.when()
		          .delete(API_Path.apiPath.deleteBatchByBatchId+batchID)
		          .then().log().all().extract().response();
	}

	@Then("Admin receives {int} Ok status with message.")
	public void admin_receives_ok_status_with_message(Integer statusCode) {

		// Validating Status Code,Status Line,Header,Json Schema 
				response.then().assertThat()
				               .statusCode(statusCode)
				               .statusLine("HTTP/1.1 200 ")
				               .header("Content-Type","application/json");
	}
	
	//@DeleteBatchwithInvalidEndpoint
	@When("Admin sends HTTPS Request  with invalid delete batch endpoint")
	public void admin_sends_https_request_with_invalid_delete_batch_endpoint() {
		response = request.when()
		          .delete(API_Path.apiPath.invalidEndpoint)
		          .then().log().all().extract().response();
	}
	
	//@DeleteBatchwithInvalidBatchId
	@Given("Admin creates DELETE Request with invalid BatchId")
	public void admin_creates_delete_request_with_invalid_batch_id() throws FileNotFoundException {
		request = given().spec(CommonSpec())
                .header("Authorization", "Bearer " + PC_token.getToken());
	}
	@When("Admin sends HTTPS Request  with endpoint invalid batchID")
	public void admin_sends_https_request_with_endpoint_invalid_batch_id() {
		response = request.when()
		          .delete(API_Path.apiPath.deleteBatchByBatchId+988888)
		          .then().log().all().extract().response();
	}
	
	//@DeleteBatchWithNoAuth
	@Given("Admin creates DELETE Request with valid BatchId no auth")
	public void admin_creates_delete_request_with_valid_batch_id_no_auth() throws FileNotFoundException {
		request = given().spec(CommonSpec());
         
	}
	
	//GetBatchAfterDelete
	@Then("Admin receives {int} OK Status with  batchStatus field {string} in the response body.")
	public void admin_receives_ok_status_with_batch_status_field_in_the_response_body(Integer statusCode, String string) {

		// Validating Status Code,Status Line,Header,Json Schema 
				response.then().assertThat()
				               .statusCode(statusCode)
				               .statusLine("HTTP/1.1 200 ")
				               .header("Content-Type","application/json");
	}
	
	// @UpdatewithDeletedBatchId
	@When("Admin sends HTTPS Request  with endpoint and deleted batchID")
	public void admin_sends_https_request_with_endpoint_and_deleted_batch_id() {
		response = request.when()
		          .delete(API_Path.apiPath.deleteBatchByBatchId+8466)
		          .then().log().all().extract().response();

	}
	
	// @UpdatewithDeletedBatchId
	@Then("Admin receives {int} Ok status with message for update")
	public void admin_receives_ok_status_with_message_for_update(Integer statusCode) {
		response.then().assertThat()
        .statusCode(statusCode)
        .statusLine("HTTP/1.1 200 ")
        .header("Content-Type","application/json");
	}








	







	
}
