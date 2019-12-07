package apiproj;



import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

public class MyFirstApiTest {

	/**
	 * Body, Pathparam, QueryParams
		0 0 0
		0 0 1
		0 1 0
		1 0 0
		1 1 0
		1 0 1
		0 1 1
		1 1 1

	 */
	
	@Before
	public void setup(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public void testGetAPI(){
		//http://dummy.restapiexample.com/api/v1/employees
		
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		String responseString = RestAssured
			.given()
			.when().get("/employees")
			.prettyPrint();
		
		System.out.println("..................."+responseString);
		
		
	}
	
	@Test
	public void testGetAPIJsonPath(){
		//http://dummy.restapiexample.com/api/v1/employees
		
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		String responseString = RestAssured
			.given()
			.when().get("/employees")
			.jsonPath()
			.getString("[0].employee_name");
		/**
		 *  $ - complete response body 
		 *  $[0] = null - Reason - there is no object relevant for this json path
		 *  $.[0] - Illegal argument exception due to invalid JSON expression
		 */
		
				
				
		System.out.println("..................."+responseString);

	}
	
	@Test
	public void testCreateAPI(){
		//http://dummy.restapiexample.com/api/v1/create
		
		String reqBody = "{"+
				"    \"name\": \"testt\",\r\n" + 
				"    \"salary\": \"12300\",\r\n" + 
				"    \"age\": \"25\"\r\n" + 
				"}"
	;			
				//reqBody = "{\"name\":\"firstemp1\",\"salary\":\"12300\",\"age\":\"25\",\"id\":\"135434\"}";
		
		
	
		
		String responseString = 	RestAssured
			.given().body(reqBody).header("Content-Type", "application/json")
			.when().post("/create")
			.then()
			.statusCode(200)
			.assertThat()
			.body("name", Matchers.equalTo("testt"), "salary", Matchers.containsString("12300"))
			/*.body("salary", containsString("12300"))
			.body("$",containsString("age"))
			.body("age", notNullValue())*/
			.extract()
			.asString()
			;
			
		System.out.println("..................."+responseString);

	}
	
	@Test
	public void testCreateAPIWithRequestBodyAsMap(){
		//http://dummy.restapiexample.com/api/v1/create
		
		
		Map<String, Object> reqBody1 = new HashMap<String, Object>();
		reqBody1.put("name", "test11");
		reqBody1.put("salary", "12300");
		reqBody1.put("age", "25");
	
		
		String responseString = 	RestAssured
			.given().contentType("application/json").body(reqBody1)
			.when().post("/create")
			.then()
			.statusCode(200)
			/*.assertThat().body("name", equalTo("firstempl"))
			.body("salary", containsString("12300"))
			.body("$",containsString("age"))
			.body("age", notNullValue())*/
			.extract()
			.asString()
			;
			
		System.out.println("..................."+responseString);

	}
	
}
