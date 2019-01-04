package Pages;

import java.io.File;
import java.io.FileInputStream;
 //import java.io.FileNotFoundException;
import framework.*;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	private static Config con;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		//Volume_List.xlsx 
	//	 System.out.print("URL IS " + con.getURL());
		File file =    new File("C:\\Users\\dell\\Desktop\\Volume_List.xlsx");
		String sheetName = "Update";
		FileInputStream inputStream = new FileInputStream(file);
		  Config con = new  Config();
		 
		  System.out.print("URL IS " + con.getURL());
	    Workbook guru99Workbook = null;
	    guru99Workbook = new XSSFWorkbook(inputStream); 
	    
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	    
	}
 guru99Workbook.close();
	}}
