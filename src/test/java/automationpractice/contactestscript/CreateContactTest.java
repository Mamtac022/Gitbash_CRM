package automationpractice.contactestscript;

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

public class CreateContactTest {

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
		Sheet sh = book.getSheet("Contactcase");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString()+ randomInt;
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
	    
	    
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    // Step: Navigate to Contact module
	    driver.findElement(By.linkText("Contacts")).click(); 
	    
	    // Step: Click on "create Contact" Button
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    Thread.sleep(2000);
	    
	    // Step: Enter all the details and create new Contact
	    driver.findElement(By.name("lastname")).sendKeys("lastName");
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	    Thread.sleep(2000);
	    
	   
	    // Verify lastName  Expected Result
	    
	    String actLastName =driver.findElement(By.id("dtlview_Last Name")).getText();
	    if(actLastName.equals(lastName))
	    {
	    	System.out.println(lastName +"is available");
	    }
	    else
	    {
	    	System.out.println(lastName +"is not available"); 
	    }
	    
	    // Step: logout
	    
	  
	   
	    driver.quit();
		
		

	}

}
