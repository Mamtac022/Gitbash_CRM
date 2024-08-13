package practice.testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest
{
	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		
		//spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();	
	}
	@Test
	public void createContactTest() 
	{
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://localhost:8888");
		 
		ExtentTest test =report.createTest("createContactTest");
		
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
	}
}
