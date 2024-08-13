package practice.dataprovider;

import org.testng.annotations.DataProvider;

public class ByHavingMultipleDataUsingDP {

	@DataProvider
	public Object[][] getDataForProduct()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="mobile";
		objArr[0][1]="Apple";
		objArr[1][0]= "mobile";
		
		objArr[1][1]="Samsung";
		objArr[2][0]="mobile";
		objArr[2][1]= "Nokia";
		
		return objArr;
	}
	
	@DataProvider
	public Object[][] getDataForUser()
	{
Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="Deepak";
		objArr[0][1]="Hr";
		objArr[1][0]= "Sam";
		
		objArr[1][1]="Hd";
		objArr[2][0]="john";
		objArr[2][1]= "smith";
		
		return objArr;
	}
	
}
