package restfulapi;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostTests {
	
	 // Common variables for all the tests in this class
	public static String userId;
	public static String BaseURL = "https://api.restful-api.dev/objects";

	
	
	// Below test is to create a new object - Post Request 
	
	@Test(priority = 1)
	public void addobject() {
		
		try {
		
		
		String Requestbody = "{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}";
		

	 Response response = RestAssured.given()
		.header("Content-type","application/json")
		.body(Requestbody) 
		.when().post(BaseURL) 
		.then().statusCode(200).body("name", equalTo("Apple MacBook Pro 16"))
		.extract().response();
		
		// Extract and assert additional response details
	 
	 
		 userId = response.jsonPath().getString("id");
		
		System.out.println(response.prettyPrint());
		
		}
		
		catch (Exception e) {

		System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
		
		}
	}
	
	// The below test is a get method to fetch the Created/Updated Resource that uses the ID value that 
	// was used for creation/ Updation
	
	// here the priority is assigned as 4 because in this context i am executing this after a patch request

	@Test(priority = 4)
	public void getcreateduser() {
		
		try {
		
		Response response = RestAssured.given()
				
				.when().get(BaseURL+"/"+userId) 
				.then().statusCode(200).extract().response();
		
		String responseBody = response.prettyPrint(); 
		
		System.out.println(responseBody);
		} 
		
		catch (Exception e) {
			
			System.out.println("Exception occured during Retreiving  a user/ Get request"+e.getMessage());
		}
		
	}
	
	// Below test is a Update request - Put Method 
	
	@Test(priority = 2)
	public void updateobjecttest() {
		
		try {
		
		
		String requestBody = "{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 2049.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\",\r\n"
				+ "      \"color\": \"silver\"\r\n"
				+ "   }\r\n"
				+ "}";
		
		 Response response = RestAssured.given()
				.header("Content-Type", "application/json")
				.body(requestBody).when()
				.put(BaseURL+"/"+userId)
				.then().statusCode(200).extract().response(); 
		  
		  // Print the response 
		  String responseBody = response.prettyPrint();
		  System.out.println(responseBody);
		}
		catch (Exception e) {
			System.out.println("Exception occured during Updating a user/ Put request"+e.getMessage());
		}
		
	}
	
	// Below test is a Update request - Patch  Method 

	
	@Test(priority = 3)
	public void patchuser() {
		try {
		
		String patchbody = "{\r\n"
				+ "   \"name\": \"Kiran laptops\"\r\n"
				+ "}";
		
		Response response = RestAssured.given() 
				.header("Content-Type", "application/json")
				.body(patchbody) .when() 
				.patch(BaseURL +"/"+ userId) .then() .statusCode(200)
				.extract().response();
		
		System.out.println(response.asPrettyString());
		} 
		
		catch (Exception e) {

			System.out.println("Exception occured during Patch a user/ Patch Request"+e.getMessage());

		
		}
	}
	
	// Below test is a Delete request - To Delete a user 

	
	@Test(priority = 5)
	public void deleteuser() {
		
		
		try {
		
		Response response = RestAssured.given()
				.header("Content-Type", "application/json")
				.when().delete(BaseURL +"/"+ userId)
				.then().statusCode(200) 
				 .extract().response();
		
		}
		
		catch (Exception e) {
			System.out.println("Exception occured during Deleting a user/Delete Request"+e.getMessage());
		}
		
	}
	

}
