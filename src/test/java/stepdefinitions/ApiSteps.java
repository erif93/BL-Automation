package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.ApiTest;

public class ApiSteps {
	
	String baseURI="https://jsonplaceholder.typicode.com";
	ApiTest objApi;
	RequestSpecification request;
	Response response;
	String postEndPoint ="/posts";
	String jsonResponse="";
	
	@Given("^I set base url Api$")
	  public void setRequest() {
		  
			objApi = new ApiTest(request,response);
			request = objApi.setRequest("https://jsonplaceholder.cypress.io");
	}
	
	@When("^send post request with valid (.*), valid (.*) and valid(.*)$")
	public void sendPostRequest(String title,String body, String userId) {
		
		response = objApi.sendHttpPostRequest(title, body, userId, postEndPoint, request);
		jsonResponse = objApi.getResponseString(response);
		System.out.println(jsonResponse);
		
	}
	
	@When("^I send get request$")
	public void sendGetRequest() {
		
		response = objApi.sendHttpGetRequest(request,postEndPoint);
		jsonResponse = objApi.getResponseString(response);
		System.out.println(jsonResponse);
	}
	
	@Then("^I verify the (.*) from the respons$")
	public void verifyResponse(String statusCode) {
		
		objApi.verifyPostResponse(response, statusCode);
	}
	
	@Then("^I verify json schema$")
	public void verifyJsonSchema() {
		
		objApi.verifyJsonSchema(response);
	}

}
