package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	public static String GetExcelCellData(int rowIndex, int colIndex) throws IOException {
		
		FileInputStream inp = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdataexcel.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		XSSFRow row = sheet.getRow(rowIndex);       
        XSSFCell cell = row.getCell(colIndex);

        String cellData = "";
        
        cellData = cell.getStringCellValue();
		wb.close();
		inp.close();
		
		return cellData;
	}
}
		

	
