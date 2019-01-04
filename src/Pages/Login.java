package Pages;

import org.testng.annotations.Test;
import methodsandObjects.loginPage;
import framework.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Login {
	
	private WebDriver driver ;
	private loginPage loginpage;
	
	
  @Test
  public void f() { 
	loginpage = new loginPage(this.driver);  
	loginpage.loign("XXX", "XXXX");
  }
  @Parameters({"browser"})
  @BeforeTest
  public void beforeTest(@Optional("") String browser) {
  
	 driver.get("https://chartink.com/");
  
   
  
  }

  @AfterTest
  public void afterTest() {
	  
	  this.driver.close();
  }

}
