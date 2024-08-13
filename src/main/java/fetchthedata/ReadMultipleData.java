package fetchthedata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\OrangeHrmTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Mobile");
		int rowNum =sh.getLastRowNum();
		for(int i=1;i<=rowNum;i++)
		{
			Row r = sh.getRow(i);
			String cellvalue= r.getCell(0).toString();
			String cellvalue2 = r.getCell(1).toString();
			System.out.println(cellvalue+" "+cellvalue2);
			
		}
		book.close();
		
	}

}
