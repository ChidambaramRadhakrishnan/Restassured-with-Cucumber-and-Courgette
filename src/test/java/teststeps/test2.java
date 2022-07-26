package teststeps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class test2 {
	
	static ValidatableResponse response;

	@Given("I send get request to server")
	public void i_send_get_request_to_server() {
	    //RestAssured.baseURI="www.thecocktaildb.com/api/json/v1/1/search.php?f=a";
	    response = RestAssured.given().when().get("www.thecocktaildb.com/api/json/v1/1/search.php?f=a").then();
	    int statusCode = response.extract().response().getStatusCode();
	    System.out.println("Status code is : "+statusCode);
	}

	

	@Given("I validate the response code as {int}")
	public void i_validate_the_response_code_as(Integer int1) {
	    response.assertThat().statusCode(int1);
	}

	

	@Then("I validate the reponse time")
	public void i_validate_the_reponse_time() {
	    long time = response.extract().time();
	    long time2 = response.extract().response().getTime();
	    System.out.println(time + " "+ time2);
	}
}
