package fetchthedata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelData {

	public static void main(String[] args)throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\Selenium\\Book1.xlsx");
		 
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		/*Row r = sh.getRow(1);
		Cell c = r.getCell(0);
		String msg = c.getStringCellValue();
		
		System.out.println(msg);
		
	
		DataFormatter format = new DataFormatter();
		String msg = format.formatCellValue(sh.getRow(2).getCell(1));
		System.out.println(msg);
		*/
	}

}
