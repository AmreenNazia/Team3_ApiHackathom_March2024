//package com.api.stepdefinition;
//
//import static io.restassured.RestAssured.given;
//
//import java.io.FileNotFoundException;
//
//import org.json.JSONObject;
//
//import com.api.models.PC_token;
//import com.api.utils.BaseTest;
//import com.api.utils.JsonReader;
//import com.api.utils.PropertiesFile;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class UC_DeleteUser extends BaseTest{
//	JSONObject credentials;
//	Response response;	
//	public JsonReader reader = new JsonReader();
//	RequestSpecification request;
//	public UC_PostRequestStep post = new UC_PostRequestStep();
//	
//	@Given("Admin creates delete request")
//	public void admin_creates_delete_request() throws FileNotFoundException {
//		request = given().spec(CommonSpec());
//	}
//	
//	@When("Admin sends delete request with deleteuser")
//	public void admin_sends_delete_request_with_deleteuser() {
//		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
//				.delete(PropertiesFile.getProperty("deleteuser") + "/{userId}", post.userID).then().log()
//				.all().extract().response();
//	}
//
//	@When("Admin sends delete request with deleteassignedprogrambatchbyuserId")
//	public void admin_sends_delete_request_with_deleteassignedprogrambatchbyuser_id() {
//		response = request.header("Authorization", "Bearer " + PC_token.getToken()).when()
//				.delete(PropertiesFile.getProperty("deleteassignedprogrambatchbyuserId") + "/{userId}", post.userID).then().log()
//				.all().extract().response();
//	}
//
//}
