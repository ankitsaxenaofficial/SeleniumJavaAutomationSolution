package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExccel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream inp = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdataexcel.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//int rows = sheet.getLastRowNum();
		//int col = sheet.getRow(1).getLastCellNum();
		
		//System.out.println("Total Rows: " + rows);
		//System.out.println("Total Cols: " + col);
		
		for(Row row : sheet) {
			for(Cell cell : row) {
				System.out.print(cell.toString() + " | ");
			}
			System.out.println();
		}
		
		/*
		 * for(int i=0; i<=rows;i++) {
		 * 
		 * XSSFRow currentRow= sheet.getRow(i);
		 * 
		 * for(int j=0;j<col;j++) { XSSFCell cell = currentRow.getCell(j);
		 * 
		 * System.out.print(cell.toString() + " | "); } System.out.println(); }
		 */
		
		wb.close();
		inp.close();
		
		
		FileOutputStream op = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\writeExcel.xlsx");
		XSSFWorkbook wb1 = new XSSFWorkbook();
		XSSFSheet sheet1 = wb1.createSheet("Data");
		
		XSSFRow row1 =  sheet1.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue("Selenium");
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2 =  sheet1.createRow(1);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue("AI");
		row2.createCell(2).setCellValue("Automation");
		
		XSSFRow row3 =  sheet1.createRow(2);
		row3.createCell(0).setCellValue("Jenkins");
		row3.createCell(1).setCellValue("CI/CD");
		row3.createCell(2).setCellValue("Pipeline");
		
		wb1.write(op);
		
		wb1.close();
		op.close();

	}

}
