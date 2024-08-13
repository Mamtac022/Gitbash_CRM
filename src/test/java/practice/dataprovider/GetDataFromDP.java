package practice.dataprovider;

import org.testng.annotations.Test;

public class GetDataFromDP {
	@Test(dataProviderClass=ByHavingMultipleDataUsingDP.class,dataProvider ="getDataFromProduct")
		public void getDataFromDP(String mobileName, String brandName) {
		System.out.println("mobileName:"+mobileName+"brandName:"+brandName);
		
		
	}

}
