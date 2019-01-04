package framework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class DBUtils { 
	
	private Config con;
	private String testCaseId;
	private String testCaseDes;
	private String testCaseWorkbook;
	private String testCaseID;
	
	
	public DBUtils () {
		this.testCaseId=null;
	    this.testCaseDes=null;
		this.testCaseWorkbook=null;
		this.testCaseID=null;
		
		
	}
	
	public DBUtils(String testCaseId) throws Exception {
		
		File file = new File (con.getdriverExcelPath()); 
		FileInputStream fin = new FileInputStream (file);
		Workbook wbk = new HSSFWorkbook(fin);
		
	}
	 
	
	
	
	
	

}
