package basicDDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\TestResource.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.createRow(3);
		Cell c1 = rw.createCell(0);
		c1.setCellValue("Pune");
		FileOutputStream op = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\TestResource.xlsx");
		wb.write(op);
	}

}
