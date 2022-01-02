package RestfullBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_Basics {
	
	@Test
	public void postMethod() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.log().all();
		reqSpec.baseUri("https://restful-booker.herokuapp.com/");
		reqSpec.basePath("booking");
		reqSpec.body("{\r\n"
				+ "    \"firstname\" : \"Rohit\",\r\n"
				+ "    \"lastname\" : \"Agarwal\",\r\n"
				+ "    \"totalprice\" : 999,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-01-01\",\r\n"
				+ "        \"checkout\" : \"2022-01-04\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		reqSpec.contentType(ContentType.JSON);
		
		Response response = reqSpec.post();
		
		ValidatableResponse vResponse = response.then();
		vResponse.log().all();
		vResponse.statusCode(200);
		vResponse.statusLine("HTTP/1.1 200 OK");
	}

}
