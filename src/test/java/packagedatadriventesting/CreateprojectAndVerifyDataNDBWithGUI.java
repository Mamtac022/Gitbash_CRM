package packagedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class CreateprojectAndVerifyDataNDBWithGUI 
{

	public static void main(String[] args) throws Throwable 
	
	{
		//create project in GUI using Selenium code
		String projectName="Tekpyramid_022";
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://106.51.90.215:8084");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(projectName);
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Geeta");
	    Select sel = new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
	    sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Verify the project in Backened JDDB
					boolean flag=false;
					Connection conn =null;
					
					Driver driveRef = new Driver();
					DriverManager.registerDriver(driveRef);
					
					Thread.sleep(2000);
					 conn =DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%" ,"root");
					 Thread.sleep(2000);
				 
					Statement stat = conn.createStatement();

					ResultSet resultset = stat.executeQuery("select * from project");
					while(resultset.next()) {
						String actProjectName = resultset.getString(1);
						if(projectName.equals(actProjectName)) {
							flag=true;
							System.out.println(projectName + "is available in DB ==pass");
						}
					}
						if(flag==false)
						{
							System.out.println(projectName +"is not available in DB==fail");
							
							  
						}
						
					
					
						conn.close();
						
					}
					
					


		
		
		

	}


