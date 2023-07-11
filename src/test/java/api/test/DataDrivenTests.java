package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	
	
	@Test(dataProvider = "GetAllDataProvider",priority = 1,dataProviderClass = DataProviders.class)
	//public void testPostUser(String userID,String userName,String fName,String lName,String eMail,String passWord,String pHone) {
	public void testPostUser(String... excelData) {
		User userPayLoad= new User();
		 
		 
		 userPayLoad.setId(Integer.parseInt(excelData[0]));
		 userPayLoad.setUsername(excelData[1]);
		 userPayLoad.setFirstName(excelData[2]);
		 userPayLoad.setLastName(excelData[3]);
		 userPayLoad.setEmail(excelData[4]);
		 
		 userPayLoad.setPassword(excelData[5]);
		 userPayLoad.setPhone(excelData[6]);
		 
		 Response res=UserEndPoints.createUser(userPayLoad);
		 	
		 res.then().log().all();
		 Assert.assertEquals(res.statusCode(), 200);
			
		
	}
	@Test(dataProvider = "UserNamesDataProvider",priority = 2,dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {
		
		Response res=UserEndPoints.deleteUser( userName);
		
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}

}
