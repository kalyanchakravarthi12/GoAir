package framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriver extends EventFiringWebDriver {
	
	private static Config config ;
	private static org.openqa.selenium.WebDriver webDriver;
    public WebDriver (String browser) {
    	super (setDriver(browser));
    	
    }	
	
    public static org.openqa.selenium.WebDriver setDriver(String browser) {
    	try {
    		 config = new Config(); 
    	  //   System.out.println("Executing on browser " +browser); 
    	     System.out.println(config.getBrowser());
           
            
          //   System.setProperty("webdriver.chrome.driver",config.getChromeDriverLocation());
		  //   webDriver = new ChromeDriver();
          	} 
    	
    	catch (FileNotFoundException e)
        {
          e.printStackTrace();
        }
        catch (IOException e)
        {
          e.printStackTrace(); 
          
        } 
    	
    	if (browser.equalsIgnoreCase("")) {
    		  browser = config.getBrowser(); 
    		  System.out.println("Executing on browser " +browser); 
    		  System.setProperty("webdriver.chrome.driver",config.getChromeDriverLocation());
      		  webDriver = new ChromeDriver();
    		
    	}
    	
             //	DesiredCapabilities cap = null;
    /*	if( browser.equalsIgnoreCase("firefox")) { 
    		System.setProperty("webdriver.firefox.driver",config.getFirefoxDriverLocation());
    		webDriver = new FirefoxDriver();
    		System.out.println("Executing on Firefox");
    //		cap = DesiredCapabilities.firefox();
    // 		cap.setBrowserName("firefox");
    // 		System.out.println("Executing on Firefox"); */
    		
  // 	}  */
    	
    	if( browser.equalsIgnoreCase("chrome")) { 
    		System.out.println("Executing on Chrome");
    		System.setProperty("webdriver.chrome.driver",config.getChromeDriverLocation());
    		webDriver = new ChromeDriver();
    		System.out.println("Executing on Chrome");
    		
    	} 
    	
    	else 
    	{
    		System.out.println("no browser is found");
    		
    	}
    	webDriver.manage().window().maximize();
    //	webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    	return webDriver;
    	
    }
	
	
}
