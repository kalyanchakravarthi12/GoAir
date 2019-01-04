package Pages; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class saveImage {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chartink.com/");
		driver.findElement(By.linkText("Login/Register")).click(); 
		driver.findElement(By.id("email")).sendKeys("ckalyan72@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Hasvitha@12"); 
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); 
		driver.findElement(By.linkText("Watchlists")).click(); 
		driver.findElement(By.linkText("WEEKLY_20")).click(); 
		WebElement table =driver.findElement(By.xpath("//*[@id='watchlist-stocks-table']//tbody")); 
		List<WebElement> rows = table.findElements(By.tagName("tr")); 
		System.out.println("size is "+rows.size()); 
		for (int i=0 ;i< rows.size();i++) {
			List<WebElement> Columns = rows.get(i).findElements(By.tagName("td")); 
			WebElement link = Columns.get(1).findElement(By.tagName("a"));
			System.out.println(link.getText()); 
		//	link.sendKeys(Keys.CONTROL+"t");
			link.click();
		//	Actions oAction = new Actions(driver);
	    //		oAction.moveToElement(link);
		//	oAction.contextClick(link).build().perform();  /* this will perform right click */
		//	oAction.sendKeys(Keys.ARROW_DOWN).build().perform();
	//		oAction.sendKeys(Keys.ENTER).build().perform();
			driver.switchTo().frame("ChartImage");
			 driver.findElement(By.id("saverbutton")).click();
			 driver.switchTo().defaultContent();
			 driver.navigate().back();
		//	WebElement elementOpen = driver.findElement(By.linkText("Open link in new tab")); /*This will select menu after right click */
	    //		elementOpen.click();

		}









		driver.quit();
	}
}
