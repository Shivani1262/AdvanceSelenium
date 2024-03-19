package basicDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	//Step1 : Create object of FileInputStream class and in FileInputStream constructor enter the location of the file.
		FileInputStream fis = new FileInputStream("src\\test\\resources\\TestResource.xlsx");
		
	//Step2 : Call a WorkBookFactory class from Apache POI and call create(InputStream)
		Workbook wb = WorkbookFactory.create(fis);
		
	//Step3 : Call a getSheet(String Name) and Enter sheet name	
		Sheet sht = wb.getSheet("Sheet1");
		
	//Step4 : Call getRow(int num) and Enter the Row Number
		Row rw = sht.getRow(2);
		
	//Step5 : Call getCell(int cell)
		Cell cl = rw.getCell(1);
		
	//Step6 : Call getStringCellValue()
		String data = cl.getStringCellValue();
		
		System.out.println(data);

	}

}
