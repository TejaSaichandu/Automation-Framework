package vtigerGenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtilities {
	/**
	 * This method is used to read the Data from Excel
	 * @param row
	 * @param col
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet, int row, int col) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantUtilities.excelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet data = book.getSheet(sheet); 
		DataFormatter df = new DataFormatter();
		String values = df.formatCellValue(data.getRow(row).getCell(col));
		book.close();
		return values;
	}
	/**
	 * This method is used to get the row count
	 * @param Sheet 
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantUtilities.excelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet data = book.getSheet(sheet);
		int count = data.getLastRowNum();
		book.close();
		return count;
	}
	/**
	 * This method is to write something into the excel
	 * @param sheet
	 * @param row
	 * @param col
	 * @param data
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int col, String data) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantUtilities.excelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Row value = book.getSheet(sheet).getRow(row);
		value.createCell(col).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\vtiger.xlsx");
		book.write(fos);
		System.out.println(data+" ---->data added");
		book.close();
	}
	
	public Object[][] readMultipleDataFromExcel(String sheet) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantUtilities.excelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int lastRow = sh.getLastRowNum();
		int lastCol = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCol];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCol;j++)
			{
				data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
