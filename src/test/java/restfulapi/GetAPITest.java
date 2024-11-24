package restfulapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

// All the tests in this class are for Read Operation only i.e only Get requests.

public class GetAPITest {
	
	String BaseURL = "https://api.restful-api.dev/objects/";
	int userID = 7;

	
	@Test
	public void getListofall() {
		
		// Validating a API call of a Get method - Retrieving API for all the list of users present in the /objects endpoint
		
		try {
		
		
		RestAssured.given()
		.when().get(BaseURL)
		.then().statusCode(200);
		
		} catch (Exception e) {
			System.out.println("Exception occured during Retreiving list of users/ Get request"+e.getMessage());
		}
	}
	
	
	// below test - is to fetch an object by providing ID through Query Parameters - 
	//filtering the results using query parameter
	
	@Test
	public void getbyID() {
		
		try {
		
		String queryparams = "?id=3&id=5&id=10";
		
		
		RestAssured.given()
		.when().get(BaseURL+queryparams)
		.then().statusCode(200).log().all();
		}
		
		catch (Exception e) {

			System.out.println("Exception occured during Retreiving a user by IDS/ Get request"+e.getMessage());

		
		}
		
	}

	
	// Below Test fetches the object by giving a particular ID value 
	
	@Test
	public void getcreateduser() {
		try {
		
		Response response = RestAssured.given()
				
				.when().get(BaseURL +userID) 
				.then().statusCode(200).extract().response();
		
		String responseBody = response.prettyPrint(); 
		
		System.out.println(responseBody);
		} 
		
		catch (Exception e) {

			System.out.println("Exception occured during Retreiving  user/ Get request"+e.getMessage());

		
		}
		
	}
	
	
	// BELOW is a  NEGATIVE TEST
	// Validating a API call of a Get method - for an invalid id 
	// Expected status code is 404 - getting 404 as expected
	
	@Test
	public void getListofall_Negative() {
		
		
		
		try {
		
			String URL = "http://api.restful-api.dev/objects/102924";
		
		RestAssured.given()
		.when().get(URL)
		.then().statusCode(404);
		
		} catch (Exception e) {
			System.out.println("Exception occured during Retreiving list of users/ Get request"+e.getMessage());
		}
	}
	
}
