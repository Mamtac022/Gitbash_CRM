package automationpractice.organizationtestscript;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest 
{

	public static void main(String[] args) throws IOException, Throwable
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
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString()+randomInt;
		String industry = row.getCell(3).toString();
		String type = row.getCell(4).toString(); 
		 
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
	    // Step: Navigate to Organization module
	    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click(); 
	    
	    // Step: Click on "create Organizatin" Button
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    Thread.sleep(2000);
	    
	    // Step: Enter all the details and create new organization
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgName);
	    WebElement wbsele =driver.findElement(By.xpath("//select[@name='industry']"));
	    Select sel = new Select(wbsele);
	    sel.selectByVisibleText(industry);
	    
	    WebElement wbsele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
	    Select sel2 = new Select(wbsele2);
	    sel2.selectByVisibleText(type);
	    
	    
	    
	    
	    
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	    Thread.sleep(2000);
	    
	    
	    //Verify Industry and type information
	    String actIndustries=	driver.findElement(By.id("dtlview_Industry")).getText();
	    if(actIndustries.contains(industry)) {
	    	System.out.println(industry + "is verified");
	    }
	    else
	    {
	    	System.out.println(industry + "is not verified");
	    }
	    
	    String actType =driver.findElement(By.id("dtlview_Type")).getText();
	    if(actType.equals(type))
	    {
	    	System.out.println(type +"is verified");
	    }
	    else
	    {
	    	System.out.println(type +"is not verified"); 
	    }
	    
	   
	    
	    // Step: logout
	    
	   
	   
	    driver.quit();
		
		

	}

}
