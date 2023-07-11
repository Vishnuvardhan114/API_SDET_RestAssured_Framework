package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




//UserEndPoints.Java
//Create to have CRUD operations-Create,Retrive,Update,Delete operations
public class UserEndPoints2 {
	
	public static ResourceBundle getURL(){
		ResourceBundle routs= ResourceBundle.getBundle("routs");//Load the properties file
		return routs;
		
	}
	
	
	
	public static Response createUser(User payLoad) {
		String post_url=getURL().getString("post_url");
		
		Response response=	given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payLoad)
							
							.when()
								.post(post_url);
		
		return response;
		
	}
	
	public static Response readUser(String username) {
		
		String get_url=getURL().getString("get_url");
		Response response=	given()
								.pathParam("username", username)
								
							
							.when()
								.get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(User payLoad,String username) {
		String put_url= getURL().getString("get_url");
		
		Response response=	given()
								.pathParam("username", username)
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payLoad)
								
							
							.when()
								.put(put_url);
		
		return response;
		
	}
	public static Response deleteUser(String username) {
		String delete_url= getURL().getString("delete_url");
		
		Response response=	given()
								.pathParam("username", username)
								
							
							.when()
								.delete(delete_url);
		
		return response;
		
	}
	
	/*export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home
			export PATH=$JAVA_HOME/bin:$PATH

			export MAVEN_HOME=/Library/apache-maven-3.9.2
			export PATH=$MAVEN_HOME/bin:$PATH*/
	
	

}
