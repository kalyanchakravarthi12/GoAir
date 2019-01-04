package methodsandObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage {
 
	    private WebDriver driver ;
	
		
		By loginLink = By.linkText("Login/Register");
	    By emailTxtBx= By.id("email");
	    By pwdTxtBx= By.id("password");
	    By loginBtn= By.xpath("//button[@class='btn btn-primary']"); 
	    
	  public  loginPage (WebDriver driver){
	    	
	    	this.driver=driver;
	    }
	    public void launchApp() {
	    	 this.driver.get("https://chartink.com");
	    	
	    }
	    public void loign(String uname,String Pword) {
	    	this.driver.findElement(loginLink).click(); 
	      	this.driver.findElement(emailTxtBx).sendKeys(uname); 
	      	this.driver.findElement(pwdTxtBx).sendKeys(Pword); 
	      	this.driver.findElement(loginBtn).click();; 
	      	
	    
	    
	    }

		
		
		

	

	
        
		
		

	

}
