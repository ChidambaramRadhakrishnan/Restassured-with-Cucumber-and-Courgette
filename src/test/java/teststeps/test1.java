package teststeps;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class test1 {

	ValidatableResponse response;
	RequestSpecification respec;

	@Given("I verify the response status")
	public void i_verify_the_response_status() {
		response = RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		System.out.println("Response Code Will be 200");
	}

	@When("I Verify the the Post Response")
	public void i_verify_the_the_post_response() {

		response.assertThat().statusCode(200);
		response = RestAssured.given().when().get("https://reqres.in/api/users").then();
		response.assertThat().statusCode(200);
		JsonObject json=new JsonObject();
		json.add("email", "chidambaram@mail.com");
		json.add("first_name", "chidam");
		json.add("last_name", "baram");
//	   HashMap<String, String> data=new HashMap<>();
//	   data.put("name", "chidambaram");
//	   data.put("job",	"superman");
		response = RestAssured.given().body(json.toString()).when().post("https://reqres.in/api/users").then()
				.statusCode(201);
		System.out.println("Response Code should be 201");

	}

	@Then("I Verify the the Get methods")
	public void i_verify_the_the_get_methods() {
		RestAssured.baseURI = "https://reqres.in/api/unknown";
		response = RestAssured.given().when().get().then().body("data[1].'name'", equalTo("fuchsia rose")); // fuchsia
																											// rose
		response.assertThat().statusCode(200);
		System.out.println(" I Verify the Response Code is 200");
	}

	@Then("I Verify the delete Response Code")
	public void i_verify_the_delete_response_code() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		response = RestAssured.given().delete().then().statusCode(204);
		System.out.println("I verify the Resonse Code is 204");
	}

	@Then("I Verify the Authentication using Basic Auth")
	public void i_verify_the_authentication_using_basic_auth() {
		RestAssured.baseURI="https://reqres.in/api/login";
		response=RestAssured.given().auth().preemptive().basic("eve.holt@reqres.in", "cityslicka").when().get().then().statusCode(200);
		System.out.println("I Verified Basic Auth and Response Code is 200");
	}
	
	@When("I Verify the Set Reuse Variables")
	public void i_verify_the_set_reuse_variables() {
	   respec = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/users?page=2").build();
	   RestAssured.given().spec(respec).get().then().statusCode(200);
	   System.out.println("I Verify"+respec+"is working");
	}

}
