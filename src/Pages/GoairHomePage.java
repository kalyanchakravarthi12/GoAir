package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoairHomePage {

	public static void main(String[] args) throws InterruptedException { 
		
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Geckodriver\\geckodriver.exe");

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.goair.in/");

		//Navigate to login Page
		driver.findElement(By.linkText("Login/Register")).click(); 
		driver.findElement(By.id("email")).sendKeys("ckalyan72@gmail.com");; 
		driver.findElement(By.id("password")).sendKeys("Hasvitha@12"); 
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); 
		driver.findElement(By.linkText("")).click();

		Thread.sleep(3000);

		// List<WebElement> dropdown =
		// driver.findElements(By.xpath("//ul[@id='ui-id-5']/li[a]//td"));
		List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@id='ui-id-5']/li[@class='ui-menu-item']"));
		int total_node = dropdown.size();
		System.out.println("size is " + total_node);
        
		for (int i = 0; i < total_node; i++) {
			String List1 = dropdown.get(i).getText();
			System.out.println("title is " + List1);
		}
		for (int i = 0; i < total_node; i++) {
			String List = dropdown.get(i).getText();
			System.out.println("title is " + List);
			if (List.contains("Delhi (DEL)")) {
				System.out.println("In loop");
				dropdown.get(i).click();
			}

			// driver.quit();
		}

	}

}
