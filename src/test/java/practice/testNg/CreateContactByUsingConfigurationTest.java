package practice.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactByUsingConfigurationTest {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("execution configBS");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("execute configBC");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("execute configBM");
	}
	
	@Test
	public void createContact() {
		System.out.println("execute createContact");
	}
	@Test
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate");
	}
	
	@AfterMethod
	
		public void configAM() {
			System.out.println("execute configAM");
		}
	@AfterClass
	public void configAC() {
		System.out.println("execute configAC");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("execution configAS");
	}
	

}
