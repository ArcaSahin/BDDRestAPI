package StepDefinitions;

import files.Payload;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {

	Response response;
	RequestSpecification request;
	
	@Given("Add Place Payload")
	public void add_place_payload() {
		
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        RestAssured.given().queryParam("key", "qaclick123")		
		.header("Content-Type", "application/json")
		.body(Payload.AddPlace());
	 	    
	}

	@When("User calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		
		 response = RestAssured.when().post("maps/api/place/add/json");
		 response.then().log().all();
		
	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1)  {
     
		assertEquals(response.getStatusCode(), 200);
	
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {

		String res = response.asString();
		JsonPath js = new JsonPath(res);
		assertEquals(js.get(string), string2);

	}

}
