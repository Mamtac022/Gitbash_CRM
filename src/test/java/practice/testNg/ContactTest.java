package practice.testNg;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createContactTest() {
		System.out.println("execute createcontact with==>HDFC");
	}
	@Test(dependsOnMethods="createContactTest")
	public void modifyContactTest() {
		
		System.out.println("execute modifycontacttest===>HDFC==>ICICI");
	}
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest() {
		
		System.out.println("execute delete contact ICICI");
	}
}
