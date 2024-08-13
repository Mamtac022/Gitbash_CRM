package practice.testNg;

import org.testng.annotations.Test;

public class OrderTest {
	@Test
	public void createOrderTest() {
		System.out.println("Execute createorderTest===>123");
		String str=null;
		System.out.println(str.equals("123"));
		
	}
	@Test(dependsOnMethods="createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("Execute billingAnorderTest===>123");
	}
}
