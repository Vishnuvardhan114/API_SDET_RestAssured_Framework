package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




//UserEndPoints.Java
//Create to have CRUD operations-Create,Retrive,Update,Delete operations
public class UserEndPoints {
	
	
	
	public static Response createUser(User payLoad) {
		
		Response response=	given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payLoad)
							
							.when()
								.post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response readUser(String username) {
		
		Response response=	given()
								.pathParam("username", username)
								
							
							.when()
								.get(Routes.get_url);
		
		return response;
		
	}
	public static Response updateUser(User payLoad,String username) {
		
		Response response=	given()
								.pathParam("username", username)
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payLoad)
								
							
							.when()
								.put(Routes.put_url);
		
		return response;
		
	}
	public static Response deleteUser(String username) {
		
		Response response=	given()
								.pathParam("username", username)
								
							
							.when()
								.delete(Routes.delete_url);
		
		return response;
		
	}
	
	

}
