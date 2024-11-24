package restfulapi;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


// There are 10 Tests in this class - ALl of them are Edge cases -

public class NegativeTests {
	
	// Negative test with year and price passing as a string instead of numbers - Invalid data type for date and price
	// result - passing and creating resource with the mentioned string
	@Test
	public void createinvaliduser() {
		

		try {
		
		//String BaseURL = "https://api.restful-api.dev/objects";
		
		String Requestbody = "{\r\n"
				+ "   \"name\": \"Karnataka laptops\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": \"twenty nine teen\",\r\n"
				+ "      \"price\": \"twenty five rupees\",\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}";
		

	 Response response = RestAssured.given()
		.header("Content-type","application/json")
		.body(Requestbody) 
		.when().post(PostTests.BaseURL) 
		.then().statusCode(200).body("name", equalTo("Karnataka laptops"))
		.extract().response();
		
		// Extract and assert additional response details
	 
	 
		 String userId = response.jsonPath().getString("id");
		
		//System.out.println(userId);
		System.out.println(response.prettyPrint());
		
		}
		
		catch (Exception e) {

		System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
		
		}
		
	}
	
	
	
	
	
	// The below negative test where in request body the name field is missing
	
	// Results - Creating Resource with name as Null. 
	@Test
	public void createinvaliduserWithoutName() {
		

		try {
		
		
		String Requestbody = "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"year\": 2019,\r\n"
				+ "    \"price\": 1849.99,\r\n"
				+ "    \"CPU model\": \"Intel Core i9\",\r\n"
				+ "    \"Hard disk size\": \"1 TB\"\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		

	 Response response = RestAssured.given()
		.header("Content-type","application/json")
		.body(Requestbody) 
		.when().post(PostTests.BaseURL) 
		.then().statusCode(200).body("name", equalTo(null))
		.extract().response();
		
		// Extract and assert additional response details
	 
	 
		 String userId = response.jsonPath().getString("id");
		
		System.out.println(response.prettyPrint());
		
		}
		
		catch (Exception e) {

		System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
		
		}
		
	}
	
	// Below test if for Negative testing for negative price value
	
	// Result is - It is accepting the price as a negative value - which should not have been the case.
	
	// Expected behavior - A proper Error message had to be displayed with a appropriate status code in 4xx series
	
	@Test
	public void createinvaliduser_NegativePrice() {
		

		try {
		
		//String BaseURL = "https://api.restful-api.dev/objects";
		
		String Requestbody = "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"year\": 2019,\r\n"
				+ "    \"price\": -0.13,\r\n"
				+ "    \"CPU model\": \"Intel Core i9\",\r\n"
				+ "    \"Hard disk size\": \"1 TB\"\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		

	 Response response = RestAssured.given()
		.header("Content-type","application/json")
		.body(Requestbody) 
		.when().post(PostTests.BaseURL) 
		.then().statusCode(200)
		.extract().response();
		
		// Extract and assert additional response details
	 
	 
		 String userId = response.jsonPath().getString("id");
		
		//System.out.println(userId);
		System.out.println(response.prettyPrint());
		
		}
		
		catch (Exception e) {

		System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
		
		}
		
	}
	
	// Below test if for 0 price value
	
		// Result is - It is accepting the price as a 0  value - which should not have been the case.
		
		// Expected behavior - A proper Error message had to be displayed with a appropriate status code in 4xx series

	
	@Test
	public void createinvaliduser_ZeroPriceValue() {
		

		try {
		
		//String BaseURL = "https://api.restful-api.dev/objects";
		
			String Requestbody = "{\r\n"
					+ "   \"name\": \"Karnataka laptops\",\r\n"
					+ "   \"data\": {\r\n"
					+ "      \"year\": \"twenty nine teen\",\r\n"
					+ "      \"price\": 0,\r\n"
					+ "      \"CPU model\": \"Intel Core i9\",\r\n"
					+ "      \"Hard disk size\": \"1 TB\"\r\n"
					+ "   }\r\n"
					+ "}";
		

	 Response response = RestAssured.given()
		.header("Content-type","application/json")
		.body(Requestbody) 
		.when().post(PostTests.BaseURL) 
		.then().statusCode(200)
		.extract().response();
		
		// Extract and assert additional response details
	 
	 
		 String userId = response.jsonPath().getString("id");
		
		//System.out.println(userId);
		System.out.println(response.prettyPrint());
		
		}
		
		catch (Exception e) {

		System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
		
		}
		
	}
	
	// Below test if for High price value
	
			// Result is - It is accepting the price as a 99999999.00  value - which should not have been the case.
			
			// Expected behavior - A proper Error message had to be displayed with a appropriate status code in 4xx series

		
		@Test
		public void createinvaliduser5() {
			

			try {
			
			//String BaseURL = "https://api.restful-api.dev/objects";
			
				String Requestbody = "{\r\n"
						+ "  \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "  \"data\": {\r\n"
						+ "    \"year\": 2019,\r\n"
						+ "    \"price\": 99999999.00,\r\n"
						+ "    \"CPU model\": \"Intel Core i9\",\r\n"
						+ "    \"Hard disk size\": \"1 TB\"\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ "";
			

		 Response response = RestAssured.given()
			.header("Content-type","application/json")
			.body(Requestbody) 
			.when().post(PostTests.BaseURL) 
			.then().statusCode(200)
			.extract().response();
			
			// Extract and assert additional response details
		 
		 
			 String userId = response.jsonPath().getString("id");
			
			//System.out.println(userId);
			System.out.println(response.prettyPrint());
			
			}
			
			catch (Exception e) {

			System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
			
			}
			
		}

		
		// Negative test - where name field has special characters

		@Test
		public void createinvaliduserwithSpecialChar() {
			

			try {
			
			//String BaseURL = "https://api.restful-api.dev/objects";
			
				String Requestbody = "{\r\n"
						+ "  \"name\": \"Apple MacBook)*(#$)#(\",\r\n"
						+ "  \"data\": {\r\n"
						+ "    \"year\": 2019,\r\n"
						+ "    \"price\": 99999999.00,\r\n"
						+ "    \"CPU model\": \"Intel Core i9\",\r\n"
						+ "    \"Hard disk size\": \"1 TB\"\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ "";
			

		 Response response = RestAssured.given()
			.header("Content-type","application/json")
			.body(Requestbody) 
			.when().post(PostTests.BaseURL) 
			.then().statusCode(200)
			.extract().response();
			
			// Extract and assert additional response details
		 
		 
			 String userId = response.jsonPath().getString("id");
			
			//System.out.println(userId);
			System.out.println(response.prettyPrint());
			
			}
			
			catch (Exception e) {

			System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
			
			}
			
		}
		
		// Below negative test - adding empty data field 

		@Test
		public void createinvaliduserwithEmptyDatafield() {
			

			try {
			
			//String BaseURL = "https://api.restful-api.dev/objects";
			
				String Requestbody = "{\r\n"
						+ "  \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "  \"data\": {}\r\n"
						+ "}\r\n"
						+ "";
			

		 Response response = RestAssured.given()
			.header("Content-type","application/json")
			.body(Requestbody) 
			.when().post(PostTests.BaseURL) 
			.then().statusCode(200)
			.extract().response();
			
			// Extract and assert additional response details
		 
		 
			 String userId = response.jsonPath().getString("id");
			
			//System.out.println(userId);
			System.out.println(response.prettyPrint());
			
			}
			
			catch (Exception e) {

			System.out.println("Exception occured during Adding a user/ Post test"+e.getMessage());
			
			}
			
		}
		
		
		// Below negative test is for Negative  price value 

		// It is accepting the negative values, where it is expected to not accept negative values for a product
		@Test
		public void updateUser_NegativePriceValue() {
			
			try {
			
			String user = "ff808181932badb60193583d19f376bf";
			
			String requestBody = "{\r\n"
					+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
					+ "   \"data\": {\r\n"
					+ "      \"year\": 2019,\r\n"
					+ "      \"price\": -1023,\r\n"
					+ "      \"CPU model\": \"Intel Core i9\",\r\n"
					+ "      \"Hard disk size\": \"1 TB\",\r\n"
					+ "      \"color\": \"silver\"\r\n"
					+ "   }\r\n"
					+ "}";
			
			 Response response = RestAssured.given()
					.header("Content-Type", "application/json")
					.body(requestBody).when()
					.put(PostTests.BaseURL+"/"+user)
					.then().statusCode(200).extract().response(); 
			  
			  // Print the response 
			  String responseBody = response.prettyPrint();
			  System.out.println(responseBody);
			}
			catch (Exception e) {
				System.out.println("Exception occured during Updating a user/ Put request"+e.getMessage());
			}
			
		}

		
		
		// Below is Negative test to check for High price values
				@Test
				public void updateUser_highPriceValue() {
					
					try {
					
					String user = "ff808181932badb60193583d19f376bf";
					
					String requestBody = "{\r\n"
							+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
							+ "   \"data\": {\r\n"
							+ "      \"year\": 2019,\r\n"
							+ "      \"price\": 9999999,\r\n"
							+ "      \"CPU model\": \"Intel Core i9\",\r\n"
							+ "      \"Hard disk size\": \"1 TB\",\r\n"
							+ "      \"color\": \"silver\"\r\n"
							+ "   }\r\n"
							+ "}";
					
					 Response response = RestAssured.given()
							.header("Content-Type", "application/json")
							.body(requestBody).when()
							.put(PostTests.BaseURL+"/"+user)
							.then().statusCode(200).extract().response(); 
					  
					  // Print the response 
					  String responseBody = response.prettyPrint();
					  System.out.println(responseBody);
					}
					catch (Exception e) {
						System.out.println("Exception occured during Updating a user/ Put request"+e.getMessage());
					}
					
				}	
				
				// Negative test of not adding name in the request 
				// Name should be a Mandatory field and should not be NULL 
				
				
				@Test
				public void updateUser_NotAddingName() {
					
					try {
					
					String user = "ff808181932badb60193583d19f376bf";
					
					String requestBody = "{\r\n"
							+ "   \"data\": {\r\n"
							+ "      \"year\": 2019,\r\n"
							+ "      \"price\": 9999999,\r\n"
							+ "      \"CPU model\": \"Intel Core i9\",\r\n"
							+ "      \"Hard disk size\": \"1 TB\",\r\n"
							+ "      \"color\": \"silver\"\r\n"
							+ "   }\r\n"
							+ "}";
					
					 Response response = RestAssured.given()
							.header("Content-Type", "application/json")
							.body(requestBody).when()
							.put(PostTests.BaseURL+"/"+user)
							.then().statusCode(200).extract().response(); 
					  
					  // Print the response 
					  String responseBody = response.prettyPrint();
					  System.out.println(responseBody);
					}
					catch (Exception e) {
						System.out.println("Exception occured during Updating a user/ Put request"+e.getMessage());
					}
					
				}	
				
				
}
