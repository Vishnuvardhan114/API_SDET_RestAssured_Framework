package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.core.appender.FileAppender;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	//public void onTestStart(ITestResult result) {
	//	// TODO Auto-generated method stub
	//	test=extentReports.createTest(result.getName());
	//}

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest test;
	String repTime;
	int stepCounter;
	
	public void logInit() {
		
		//FileAppender fa = new FileAppender();
		//fa.setName("FileLogger");
		//fa.setFile("mylog.log");
		
		
		
	}
	
	
	public void reportInit() {
		SimpleDateFormat  dFormat= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		repTime=dFormat.format(new Date());
		
		sparkReporter= new ExtentSparkReporter(System.getProperty("Results")+repTime);
		sparkReporter.config().setDocumentTitle("Rest Assured Automation Project");
		sparkReporter.config().setReportName("Pet Stote-Users API");
		//sparkReporter.config().setTheme(Theme.DARK);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Application", "Pet Store -USERS API");
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("User", "Vishnu");
		
	}
	public void reportCreateTest(String testname) {
		test=extentReports.createTest(testname);
		stepCounter=1;
		
		
	}
	
	public void testPass(String passFailComment) {
		test.log(Status.PASS, "Step-"+stepCounter+" :: "+passFailComment);
		stepCounter++;
		
	}
	
	public void testFail(String passFailComment) {
		String screenshotPath= System.getProperty("user.dir")+"//Testdata//Screenshot.png";
		String ancherTag= "<a href="+screenshotPath+" target='_blank'>Step-"+stepCounter+"</a>";
		
		test.log(Status.FAIL, ancherTag+" :: "+passFailComment);
		stepCounter++;
		
	}
	
	public void reportFlushTest() {
		extentReports.flush();
	}
	public void onStart(ITestContext context) {
		System.out.println("%%%%%%%%%%%%%%% Vishnu %%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%% Vishnu %%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%% Vishnu %%%%%%%%%%%%%%%%%%");
	}
	
	/*public void onStart(ITestContext context) {
		
		SimpleDateFormat  dFormat= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		repTime=dFormat.format(new Date());
		
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+repTime);
		sparkReporter.config().setDocumentTitle("Rest Assured Automation Project");
		sparkReporter.config().setReportName("Pet Stote-Users API");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Application", "Pet Store -USERS API");
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("User", "Vishnu");
		
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test.createNode(result.getName()).pass("Passeddddd");
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
		
		
		//test.pass("Test Passedddddddd");
		
	}
	public void onTestFailure(ITestResult result) {
		//test=extentReports.createTest(result.getName());
		test.createNode(result.getName()).fail("Failed");
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	public void onTestSkipped(ITestResult result) {
		//test=extentReports.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		//extentReports.flush();
	}*/
	
	
	

}
