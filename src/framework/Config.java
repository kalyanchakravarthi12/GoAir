package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private Properties configproperties ; 
	private String url ;
	private String browser ;
	private String ChromeExeDriverLocation;
	private String FirefoxExeDriverLocation;
	private String IEexeDriverLocation;
	private String driverExcelPath;
	
	public Config () throws FileNotFoundException, IOException {
		
		initialize ();
		
	}

	 public void initialize () throws FileNotFoundException, IOException { 
		 
		 this.configproperties = new Properties();
		 this.configproperties.load(new FileInputStream("Configuration\\config.properties"));
		 this.url = this.configproperties.getProperty("URL");
		 this.browser = this.configproperties.getProperty("browser");
		 this.ChromeExeDriverLocation=this.configproperties.getProperty("ChromeExeDriverLocation");
		 this.FirefoxExeDriverLocation=this.configproperties.getProperty("FirefoxExeDriverLocation");
		 this.driverExcelPath=this.configproperties.getProperty("driverExcelfilePath"); 
		 
		 
		 
	 }
	 
	 public String getURL() {
		 return this.url;
	 } 
	 public String getBrowser() {
		 return this.browser;
	 }
	 
	 public String getChromeDriverLocation () {
		 return this.ChromeExeDriverLocation;
	 } 
	 
	 public String getFirefoxDriverLocation () {
		 return this.FirefoxExeDriverLocation;
	 }
	 public String getdriverExcelPath () {
		 return this.driverExcelPath;
	 }


}
