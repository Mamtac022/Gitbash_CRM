package fetchthedata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowDataBasedOnExpectedCondition {

	public static void main(String[] args) throws Throwable
	{
		String expectedTestId="tc_100";
		String data1="";
		String data2="";
		String data3="";
		boolean flag = false;
		
		
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\mamta\\\\OneDrive\\\\Desktop\\\\OrangeHrmTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Orgtestcase");
		int rowcount =sh.getLastRowNum();
		for(int i=0;i<=rowcount;i++)
		{
			String data="";
			try {
			 data=sh.getRow(i).getCell(0).toString();
			 if(data.equals(expectedTestId)) {
				 flag=true;
				 data1=sh.getRow(i).getCell(0).toString();
				 data2=sh.getRow(i).getCell(1).toString();
				 data3=sh.getRow(i).getCell(2).toString();
				 
				 
			 }
			}
			catch(Exception e)
			{
			
			}
		}
		if(flag==true) 
		{
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		else
		{
			System.out.println("expected Test case id is not available");
		}
		
		
		
	}

}
