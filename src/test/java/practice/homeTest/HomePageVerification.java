package practice.homeTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerification {
	@Test
	public void homePageTest(Method mtd) {
		
		
		System.out.println(mtd.getName()+" Test Start");
		
		String expectedPage="Home page";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		String actTitle =driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		//Hard Assert
		Assert.assertEquals(actTitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName()+" Test End");
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		
		System.out.println(mtd.getName()+" Test Start");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//Hard Assert
		Assert.assertTrue(status);
		driver.close();
			System.out.println(mtd.getName()+" Test End");
	}
}
