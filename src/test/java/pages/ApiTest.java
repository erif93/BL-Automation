package pages;

import java.io.File;
import java.util.List;

import org.json.simple.JSONObject;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	private RequestSpecification request;
	private JSONObject requestParams;
	private String jsonString = "";
	private JsonPath jsonPathEvaluator;
	private List<Object> jsonList;
	private Response response;
	private File schema;
	
	public ApiTest(RequestSpecification request, Response response) {
			this.request=request;
			this.response=response;
			
	}
	
	public RequestSpecification setRequest(String base) {
		
		RestAssured.baseURI = base;
		request= RestAssured.given();
		return request.header("Content-Type", "application/json");
	}
	
	public Response sendHttpPostRequest(String title, String body, String userId, String endPoint, RequestSpecification request) {
		
		requestParams = new JSONObject();
		requestParams.put("title",title);
		requestParams.put("body", body);
		requestParams.put("userId", userId);
		
		return request.body(requestParams.toJSONString()).post(endPoint);
	}
	
	public String getResponseString(Response response) {
		
		   jsonString = response.asString();
		  
		   return jsonString;
	}
	
	public Response sendHttpGetRequest(RequestSpecification request, String endPoint) {
		 	
		return request.get(endPoint);
	}
	
	public void verifyPostResponse(Response response, String statusCode) {	
		
		jsonPathEvaluator = response.jsonPath();
		
		if(response.statusCode()== Integer.parseInt(statusCode)) {
			   
		     System.out.println("data created with id "+jsonPathEvaluator.get("id"));
		 
		   
	     } else if(jsonPathEvaluator.get("id")!=null && response.statusCode()!= Integer.parseInt(statusCode)) {  
		    
		    System.out.println("data should not be created");
		    
	   } else {
		   
		   System.out.println("bad request");
	     }
     }
	
	
	public void verifyJsonSchema(Response response) {
		
		File schema = new File(System.getProperty("user.dir")+"//src/test/resources//schema//jsonschema.json");
		response.then().body(matchesJsonSchema(schema));
	}
 } 
