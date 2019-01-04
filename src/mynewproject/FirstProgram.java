package mynewproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstProgram {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Geckodriver\\geckodriver.exe");
	FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.goair.in/");
		
		
		// Myflight.selectByIndex(2);
				driver.getTitle();
				System.out.println("My title is:" + driver.getTitle());
				driver.getCurrentUrl();
				System.out.println("My current URL is:" + driver.getCurrentUrl());

				// Header
				String Header = driver.findElement(By.xpath("html/body/header/div[1]/div/span[1]")).getText();
				if (Header.equals("  GoAir Customer Care: 092 - 2322 - 2111 / 022 - 6273 – 2111 | ")) {
					System.out.println("Test pass for Header");
				} else {
					System.out.println("Test fail for Header");
				}

				String PartnerloginTxt = driver.findElement(By.xpath("html/body/header/div[1]/div/span[3]/a/strong[1]"))
						.getText();
				if (PartnerloginTxt.equals("Partner Login")) {
					System.out.println("Test pass for PartnerloginTxt");
				} else {
					System.out.println("Test fail for PartnerloginTxt");
				}

				// Banner Text

				String BannerRightTxt = driver
						.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[1]/div/div/div/div/div[2]/div/p[1]/span/a"))
						.getText();
				if (BannerRightTxt.equals("Get up to 10%*off with the new GoAir App")) {
					System.out.println("Test pass for BannerRightTxt");
				} else {
					System.out.println("Test fail BannerRightTxt");
				}

				String BannerLeftTxt = driver
						.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[1]/div/div/div/div/div[2]/div/p[2]/span/a"))
						.getText();
				if (BannerLeftTxt.equals("#LowFareWednesday")) {
					System.out.println("Test pass BannerLeftTxt ");
				} else {
					System.out.println("Test fail BannerLeftTxt");
				}
				
				//Know more Buttons
				String Knowmoreright = driver
						.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[1]/div/div/div/div/div[2]/div/p[1]/a/button"))
						.getText();
				if (Knowmoreright.equals("Know More")) {
					System.out.println("Test pass Knowmoreright ");
				} else {
					System.out.println("Test fail Knowmoreright");
				}
				
				
				String Knowmoreleft = driver
						.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[1]/div/div/div/div/div[2]/div/p[2]/a/button"))
						.getText();
				if (Knowmoreleft.equals("Know More")) {
					System.out.println("Test pass Knowmoreleft ");
				} else {
					System.out.println("Test fail Knowmoreleft");
				}
				

				// Scroller Text

				String ScrollerText = driver.findElement(By.xpath(".//*[@id='test']/span")).getText();
				System.out.println(ScrollerText);
				if (ScrollerText.equals("Attention! Attention! Effective Oct 29, 2017, GoAir will operate all its flights from Terminal 2 at the Indira Gandhi International Airport, New Delhi.  ")) 
				{
					System.out.println("Test pass ScrollerText ");
				} else {
					System.out.println("Test fail ScrollerText");
				}
			

				// Footer
				String Footer = driver.findElement(By.xpath("html/body/footer/div/div[2]/div/div[2]/p")).getText();
				if (Footer.equals("GoAir: India's Low Cost Domestic Airline. © 2017. GoAir All Rights Reserved")) {
					System.out.println("Test pass for Footer");
				} else {
					System.out.println("Test fail for Footer");
				}

			//	driver.close();
			}



}



