package fetchthedata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSingleeDataFromExcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\mamta\\OneDrive\\Desktop\\OrangeHrmTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Mobile");
		Row r = sh.getRow(0);
		String cellvalue = r.getCell(2).toString();
		System.out.println(cellvalue);
		
		

	}

}
