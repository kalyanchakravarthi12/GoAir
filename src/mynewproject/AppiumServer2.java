package mynewproject;

import java.io.IOException;
import java.net.ServerSocket;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer2 {
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		service.stop();
		}
	}


