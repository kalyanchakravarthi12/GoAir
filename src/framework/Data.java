package framework;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider 
	public static Object[][] dp(Method testMethod) { 
		
		Object[][] data=null;
		
		System.out.println("Test :" + testMethod.getDeclaringClass().getSimpleName());
		
		
		
		return data;
		
	}

}
