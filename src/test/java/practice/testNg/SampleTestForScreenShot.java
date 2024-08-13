package practice.testNg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class SampleTestForScreenShot {

	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		//Step-1 create am object of EventFiring WebDriver
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//Step-2 user getScreenshotAs method to get file type of screenshot
	File srcFile=	edriver.getScreenshotAs(OutputType.FILE); 
	
	//Step-3 Store screen on local driver
	FileUtils.copyFile(srcFile, new File(".//Screenshot/test.png"));
		
		
		
	
	}
}
