package api.endpoints;

//bse URI= https://petstore.swagger.io/v2/user
//All the end point uURL will be stored here

public class Routes {
	
	public static String baseUrl= "https://petstore.swagger.io/v2";
	//User Module
	public static String post_url= baseUrl+"/user";
	public static String get_url = baseUrl+"/user/{username}";
	public static String put_url = baseUrl+"/user/{username}";
	public static String delete_url = baseUrl+"/user/{username}";

	

}
