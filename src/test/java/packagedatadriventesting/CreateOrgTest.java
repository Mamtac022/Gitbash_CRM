package packagedatadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgTest 
{

	@Test
	public void createOrgtest(XmlTest test) throws Throwable 
	{
	/*	//read common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\vitegar.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
	*/	
		
		//read common data from cmd line 
		String URL =test.getParameter("url");
		String  BROWSER =test.getParameter("browser") ;
		String USERNAME =test.getParameter("username");
		String PASSWORD =test.getParameter("password") ;
			
	
		
		// Generate the random number
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		 
		// read testscript data from excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\OrangeHrmTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Orgtestcase");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString()+randomInt;
		
		WebDriver driver =null;
		
	    if(BROWSER.equals("chrome"))
	    {
	    	driver = new ChromeDriver();
    }
	    else if(BROWSER.equals("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    else if(BROWSER.equals("edge"))
	    {
	    	driver = new EdgeDriver();
	    }
	    else
	    {
	    	driver= new ChromeDriver();
	    }
	    //Step :Login to app
	    
	    driver.get(URL);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	    
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    // Step: Navigate to Organization module
	    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click(); 
	    
	    // Step: Click on "create Organizatin" Button
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    Thread.sleep(2000);
	    
	    // Step: Enter all the details and create new organization
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("orgName");
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	    Thread.sleep(2000);
	    
	    // Step: logout
	    
	   Actions act = new Actions(driver);
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   
	   Thread.sleep(2000);
	   act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"Sign Out\")]"))).click().perform();
	  
	   
	    driver.quit();
		
		
		
		

	}

}
