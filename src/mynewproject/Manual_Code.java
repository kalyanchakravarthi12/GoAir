package mynewproject;

import java.io.IOException;
import java.net.ServerSocket;

public class Manual_Code {
	public void startServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			String s="cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"";
			runtime.exec(s);
			Thread.sleep(10000);
			System.out.println("Server is running");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
			System.out.println("Service is stopped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	public static void main(String[] args) {
		
		Manual_Code appiumServer = new Manual_Code ();
		appiumServer.startServer();
		int port = 4723;
		if(appiumServer.checkIfServerIsRunnning(port)) {
			System.out.println("Service is Running");
		}
		appiumServer.stopServer();
	}
}
