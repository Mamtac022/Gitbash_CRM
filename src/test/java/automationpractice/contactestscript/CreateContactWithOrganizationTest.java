package automationpractice.contactestscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrganizationTest {

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
		Sheet sh = book.getSheet("Contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString()+randomInt;
		String contactLastName = row.getCell(3).getStringCellValue();
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
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	    Thread.sleep(2000);
	    
	    //Verify Header message Expected Result
	    String headermsg=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headermsg.contains(orgName)) {
	    	System.out.println(orgName+ "is created");
	    }
	    else
	    {
	    	System.out.println(orgName + "is not created");
	    }
	    
	    //Step: Navigate to contact module
	    
        driver.findElement(By.linkText("Contacts")).click(); 
	    
	    // Step: Click on "create Contact" Button
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    Thread.sleep(2000);
	    
	    // Step: Enter all the details and create new Contact
	    driver.findElement(By.name("lastname")).sendKeys(contactLastName);
	    
	    driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	    
	    //Switch to child window
	    
	    Set<String> set =driver.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    
	    while(it.hasNext())
	    {
	    	String window = it.next();
	    	String child = driver.switchTo().window(window).getTitle();
	    	
	    	
	    	if(child.contains("Accounts&action"))
	    	{
	    		break;
	    	}
	    }
	    driver.findElement(By.name("search_text")).sendKeys(orgName);
	    driver.findElement(By.xpath("//input[@type='button']")).click();
	    driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	    
	    //switch to parent window
	    
	    Set<String> set1 =driver.getWindowHandles();
	    Iterator<String> it1 = set1.iterator();
	    
	    while(it1.hasNext())
	    {
	    	String windowID = it1.next();
	    	String par =driver.switchTo().window(windowID).getTitle();
	    	
	    	if(par.contains("Contacts&action"))
	    	{
	    		break;
	    	}
	    }
	    Thread.sleep(2000);
	   WebElement leadsource = driver.findElement(By.xpath("//select[@name='leadsource']"));
	   
	   Select sel = new Select(leadsource);
	   sel.selectByVisibleText("Employee");
	    
	    System.out.println("-- switch to parent window --");
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    
	    // Verify Header orgname Expected Result
	    
	    String actOrganame =driver.findElement(By.xpath("//span[text()='fb2455']")).getText();
	    if(actOrganame.equals(contactLastName))
	    {
	    	System.out.println(contactLastName +"is available");
	    }
	    else
	    {
	    	System.out.println(contactLastName +"is not available"); 
	    }
	    
	    // Step: logout
	    
	  //Verify Header message Expected Result
	     headermsg=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headermsg.contains(orgName)) {
	    	System.out.println(orgName+ "is created");
	    }
	    else
	    {
	    	System.out.println(orgName + "is not created");
	    }
	    // Verify Header orgname Expected Result
	    
	    actOrganame =driver.findElement(By.id("mouseArea_Organization Name")).getText();
	    if(actOrganame.equals(orgName))
	    {
	    	System.out.println(orgName +"is available");
	    }
	    else
	    {
	    	System.out.println(orgName +"is not available"); 
	    }
	    driver.quit();
		
		
		
		

	}

}
