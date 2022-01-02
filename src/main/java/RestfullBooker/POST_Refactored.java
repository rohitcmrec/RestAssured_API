package RestfullBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_Refactored {
	
	@Test
	public void postMethod() {
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{id}")
				.pathParam("id", 21)
			.when()
				.get()
			.then()
				.log().all()
				.statusCode(200)
				.contentType(ContentType.JSON);
	}

}
