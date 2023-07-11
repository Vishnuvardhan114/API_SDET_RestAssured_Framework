package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;



public class UserTests {
	
	static {
		SimpleDateFormat dateFormat= new SimpleDateFormat("ddMMyyyy_hhmmss");
		System.setProperty("Results", System.getProperty("user.dir")+"//Results//UserTests//");
		System.setProperty("Curr_Time", dateFormat.format(new Date()));
		
	}
	
	Faker faker;
	User userPayLoad;
	
	//*****
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest test;
	String repTime;
	ExtentReportManager exr= new ExtentReportManager();
	
	
	public Logger logger;
	
	//*****
	
	@BeforeTest
	public void testInit() {
		System.out.println("^^^^^^ Test Start");
		exr.reportInit();
		
	}

	
	
	@BeforeClass
	public void setUp() {
		 userPayLoad= new User();
		 faker= new Faker();
		 
		 userPayLoad.setId(faker.idNumber().hashCode());
		 userPayLoad.setUsername(faker.name().username());
		 userPayLoad.setFirstName(faker.name().firstName());
		 userPayLoad.setLastName(faker.name().lastName());
		 userPayLoad.setEmail(faker.internet().emailAddress());
		 
		 userPayLoad.setPassword(faker.internet().password());
		 userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		 
		 //Loggers
		 
		 logger= LogManager.getLogger(this.getClass());
		 
		 
		 
		
		
	}
	@Test(priority=1)
	public void test_PostUser() {
		logger.info("******* Creating user*****");
		exr.reportCreateTest("test_PostUser");
		System.out.println("******Post Request*****");
		
		Response res=UserEndPoints.createUser(userPayLoad);
		
		res.then().log().all();
		//SoftAssert sf= new SoftAssert();
		//sf.assertEquals(res.statusCode(), 200);
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
			
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==201) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		logger.info("******** CReating user completed **********");
		
	}
	
	@Test(priority=2)
	public void test_GetUserByName() {
		logger.info("******** Reading user  **********");
		System.out.println(Thread.getAllStackTraces());
		exr.reportCreateTest("test_GetUserByName");
		System.out.println("*****Get Request*******");
	
		Response res=UserEndPoints.readUser(this.userPayLoad.getUsername());
		
		res.then().log().all();
		
		//assertEquals(res.statusCode(), 200,"Status Code Match Validation one ***");
		//assertEquals(res.statusCode(), 200,"Status Code Match Validation Two ***");
		//assertEquals(res.statusCode(), 200,"Status code matched");
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
			
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==201) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		logger.info("******** Reading user completed **********");
		
	}
	

	@Test(priority=3)
	public void test_ModifyUserByName() {
		logger.info("******** Updating user  **********");
		exr.reportCreateTest("test_DeleteUserByName");
		System.out.println("******* Put Request*******");
		userPayLoad.setEmail("Vishnu.Vardhan@wipro.com");
		
		Response res=UserEndPoints.updateUser(userPayLoad, this.userPayLoad.getUsername());
		
		res.then().log().all();
		//Assert.assertEquals(res.statusCode(), 200);
		//assertEquals(res.statusCode(), 200,"Status code matched");
		
		 res=UserEndPoints.readUser(this.userPayLoad.getUsername());
		
		res.then().log().all();
		//Assert.assertEquals(res.statusCode(), 200);
		//Assert.assertEquals(res.jsonPath().getString("email"), "Vishnu.Vardhan@wipro.com");
		//assertEquals(res.statusCode(), 200,"Status code matched");
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
			
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==201) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		logger.info("******** UPdating user completed **********");
		
	}
	
	@Test(priority=4)
	public void test_DeleteUserByName() {
		logger.info("******** Delete user  **********");
		exr.reportCreateTest("test_DeleteUserByName");
		System.out.println("******* Delete Request*******");
		
		
		Response res=UserEndPoints.deleteUser( this.userPayLoad.getUsername());
		
		res.then().log().all();
		//Assert.assertEquals(res.statusCode(), 200);
		//assertEquals(res.statusCode(), 200,"Status code matched");
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
			
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		if (res.statusCode()==200) {
			exr.testPass("Test Passed");
		} else {
			exr.testFail("Test Failes");
		}
		
		
		logger.info("******** Delete user completed **********");
		
	}
	@AfterTest
	public void onTestEnd() {
		exr.reportFlushTest();
		System.out.println("^^^^^^^ ON Test end");
	}
	

}
