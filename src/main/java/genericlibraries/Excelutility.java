package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains reusable methods to perform operationson excel workbook
 * @author Kaviya
 *
 */

public class Excelutility {
	private Workbook wb;
	/**
	 * This method is used to initialize excel workbook
	 * @param excelpath
	 */
	public void excelinitiallization(String excelpath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelpath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		
	}
public String fetchDataFromExcel(String sheetName,int rowNum,int cellNum) {
	return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
}
public List<String> fetchDataFromExcel(String sheetName){
	List<String> dataList = new ArrayList<>();
	Sheet sheet = wb.getSheet(sheetName);
	for(int i=0;i<4 ; i++) {
		String data = sheet.getRow(i).getCell(1).getStringCellValue();
		dataList.add(data);
		
	}
	return dataList;
}
public void closeexcel() {
	try {
		wb.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
}
