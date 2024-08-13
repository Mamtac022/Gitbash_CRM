package practice.testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName, String lastName, long phoneNumber) {
		System.out.println("Firstname: "+firstName +", Lastname:"+ lastName+"PhoneNumber:"+phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Deepak";
		objArr[0][1]="hr";
		objArr[0][2]= 123456789l;
		
		objArr[1][0]="sam";
		objArr[1][1]="hd";
		objArr[1][2]= 123456787l;
		
		objArr[2][0]="john";
		objArr[2][1]="smith";
		objArr[2][2]= 123458789l;
		
		return objArr;
	}
	

}
