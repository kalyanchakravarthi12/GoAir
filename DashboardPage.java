package methodsandObjects; 


import java.io.File.test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook

added new line 1 23

//added new line 1 2 3


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	
		
	
		By watchlistLink=By.linkText("Watchlists2");
	    By Volume_scanner =By.linkText("Volume_Scanner");
	    By WEEKLY_20=By.linkText("WEEKLY_20");
	    By textBx=By.xpath("//*[@id='home']/form/div/input[1]");
	    By searchBtn=By.xpath("//*[@id='home']/form/div/input[2]");
				
	
	    
	    
	    File file =    new File("C:\\Users\\dell\\Desktop\\Volume_List.xlsx");
		String sheetName = "Update";
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
	    guru99Workbook = new XSSFWorkbook(inputStream); 
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
// added new file
	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    
	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	  //      for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(0).getStringCellValue());
	            driver.findElement(By.xpath("//*[@id='home']/form/div/input[1]")).clear(); 
	    	    driver.findElement(By.xpath("//*[@id='home']/form/div/input[1]")).sendKeys(row.getCell(0).getStringCellValue()); 
	    	    driver.findElement(By.xpath("//*[@id='home']/form/div/input[2]")).click(); 
	    	    WebDriverWait mywait = new WebDriverWait(driver,10);
	    	    WebElement Element1 =  mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchbox']/option")));
	    		List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchbox']/option"));
	
	    		int total_node = dropdown.size();
	    		if (total_node>1) 
	    			 driver.findElement(By.xpath("//*[@id='searchbox']/option[1]")).click();
	    		else 
	    			 driver.findElement(By.xpath("//*[@id='searchbox']/option")).click();
	    		
	    	    driver.findElement(By.xpath("//*[@id='home']/form/table/tbody/tr[1]/td/input")).click(); 
	    	    Alert alert = driver.switchTo().alert();
	    	    alert.accept();  
	    	    WebDriverWait wait = new WebDriverWait(driver,10);
	    	    WebElement Element =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='home']/form/div/input[2]")));
	    	    
	    
	    }
	    
       guru99Workbook.close();
       driver.quit();
   }
}
