package Pages;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IntradayStocks {  
	
	//System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver(); 

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		HashSet<String> myarray = new HashSet<String>();
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe"); 
		 FileWriter writer =    new FileWriter("D:\\PIVOT\\Volume\\today.txt");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		//login
		
		driver.get("https://chartink.com/"); 
		driver.findElement(By.linkText("Login/Register")).click(); 
		driver.findElement(By.id("email")).sendKeys("ckalyan72@gmail.com"); 
		driver.findElement(By.id("password")).sendKeys("Hasvitha@12"); 
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();  
		
		// volume Break out scan 
		List<WebElement>rows=driver.findElements(By.xpath(".//*[@id='home']/table/tbody/tr/td[1]/a"));
	for (int i=0;i<rows.size();i++){
			String scan=rows.get(i).getText();
	if (scan.equalsIgnoreCase("Volume_BreakOut")){
			rows.get(i).click(); 
			break;
		     }
		 } 
		
		// fetching stocks  
		for (int k=7;k<75;k++){ 
			
			WebDriverWait wait = new WebDriverWait(driver,30); 
			WebElement ele=driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-8']/a"));
			wait.until(ExpectedConditions.elementToBeClickable(ele));		
		    driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-8']/a")).click();
		    WebElement dropdown =driver.findElement(By.xpath("//select[@id='filter-select-intraday_offset-8']"));
		
		    Select item=new Select(dropdown);
		    item.selectByVisibleText("n candles ago");
		    Alert alert =driver.switchTo().alert(); 
		    System.out.println(String.valueOf(k));
		   alert.sendKeys(String.valueOf(k));
		    alert.accept();  
		    
		// Drop down -2 
		WebDriverWait wait2 = new WebDriverWait(driver,30); 
		WebElement ele1=driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-20']/a"));
		wait2.until(ExpectedConditions.elementToBeClickable(ele1));	
		driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-20']/a")).click(); 
		WebElement dropdown1 =driver.findElement(By.xpath("//select[@id='filter-select-intraday_offset-20']"));
		
		    Select item1=new Select(dropdown1);
		    item1.selectByVisibleText("n candles ago");
		    Alert alert1 =driver.switchTo().alert(); 
		System.out.println(String.valueOf(k));
		alert1.sendKeys(String.valueOf(k));
		alert1.accept();  
		
		//Drop down-3  
		WebDriverWait wait3 = new WebDriverWait(driver,30); 
		WebElement ele3=driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-24']/a"));
		wait3.until(ExpectedConditions.elementToBeClickable(ele3));	
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='filter-span-intraday_offset-24']/a")));	
		
		WebElement element = driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-24']/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	//	driver.findElement(By.xpath("//*[@id='filter-span-intraday_offset-24']/a")).click();
		WebElement dropdown2 =driver.findElement(By.xpath("//select[@id='filter-select-intraday_offset-24']"));
		
		    Select item2=new Select(dropdown2);
		    item2.selectByVisibleText("n candles ago");
		    Alert alert2 =driver.switchTo().alert(); 
		System.out.println(String.valueOf(k));
		alert2.sendKeys(String.valueOf(k));
		alert2.accept();
		
		
		driver.findElement(By.id("run_scan")).click();   
         Thread.sleep(1000);
		
		// read table 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebDriverWait wait1 = new WebDriverWait(driver,30); 
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DataTables_Table_0']/tbody")));
				List<WebElement>data=driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]/a"));
			//	System.out.println(	data.size());
				if (data.size()>0) {
				for (int s=0;s<data.size();s++){ 
					 
			            writer.write("\r\n");   // write new line
			            writer.write(k + data.get(s).getText());
				        myarray.add(data.get(s).getText());
				   } 
				 }
		
		}  
		
		// adding stocks to watch list 
		writer.close();
	driver.findElement(By.linkText("Watchlists")).click(); 
	driver.findElement(By.linkText("Volume15")).click(); 
        Iterator<String>itr=myarray.iterator();  
		while(itr.hasNext()){  
			driver.findElement(By.xpath("//*[@id='home']/form/div/input[1]")).clear(); 
		driver.findElement(By.xpath("//*[@id='home']/form/div/input[1]")).sendKeys(itr.next()); 
		driver.findElement(By.xpath("//*[@id='home']/form/div/input[2]")).click(); 
		WebDriverWait mywait = new WebDriverWait(driver,10);
		WebElement Element1=  mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchbox']/option")));
			List<WebElement>dropdown = driver.findElements(By.xpath("//*[@id='searchbox']/option"));
			int total_node = dropdown.size();
			if (total_node>1) 
				driver.findElement(By.xpath("//*[@id='searchbox']/option[1]")).click();
			else
				driver.findElement(By.xpath("//*[@id='searchbox']/option")).click();
			
		driver.findElement(By.xpath("//*[@id='home']/form/table/tbody/tr[1]/td/input")).click(); 
		    Alert alert = driver.switchTo().alert();
		alert.accept();  
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement Element=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='home']/form/div/input[2]")));
		  }  
		
		System.out.println("Completed Successfully");
		driver.quit();
	} 
	
	public static void alertcall(int num) { 
		
		
		
	}

	}

//}
