package mynewproject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import framework.*;
import methodsandObjects.loginPage;
public class intradayVOLUME { 
	
	private WebDriver driver ;
	private loginPage login;
	private Config con;
//	private String
	@Parameters("browser")	
    
	@BeforeTest 
  
  public void setup(@Optional("") String browser) {
	  System.out.println("browser is "+browser);
	  driver = new WebDriver(browser);
	  login = new loginPage(driver);
	//  driver.get(con.getURL());
	  System.out.println("Opening URL");
	  
  }
  @Test
  public void f() {
	  login.launchApp();
	  login.loign("ckalyan72@gmail.com", "Hasvitha@12");
	  driver.close();
  System.out.println("Testcase is executed");
  }
}
