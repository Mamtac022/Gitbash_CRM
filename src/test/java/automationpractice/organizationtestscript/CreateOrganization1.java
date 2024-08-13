package automationpractice.organizationtestscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateOrganization1 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream Fis = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\vitegar.properties");
		Properties pobj = new Properties();
		pobj.load(Fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
	
		// Generate the random number
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		 
		// read testscript data from excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\OrangeHrmTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Orgtestcase");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString()+randomInt;
		book.close();
		
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
	    
	    
	    
	    // Step: Navigate to Organization module
	    
	    
	    // Step: Click on "create Organizatin" Button
	   
	    
	    // Step: Enter all the details and create new organization
	   
	    
	    //Verify Header message Expected Result
	    String headermsg=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headermsg.contains(orgName)) {
	    	System.out.println(orgName+ "is created");
	    }
	    else
	    {
	    	System.out.println(orgName + "is not created");
	    }
	    // Verify Header orgname Expected Result
	    
	    String actOrganame =driver.findElement(By.xpath("//span[text()='fb2455']")).getText();
	    if(actOrganame.equals(orgName))
	    {
	    	System.out.println(orgName +"is available");
	    }
	    else
	    {
	    	System.out.println(orgName +"is not available"); 
	    }
	    
	    // Step: logout
	    
	   Actions act = new Actions(driver);
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   
	   Thread.sleep(2000);
	   act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"Sign Out\")]"))).click().perform();
	  
	   
	    driver.quit();
		
		
		

	}

}
