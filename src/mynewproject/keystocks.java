package mynewproject;

import java.io.File;

public class keystocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		//D:\data 
		File file = new File("D://data");
		File[] files = file.listFiles();
		for (File fname:files) {
		System.out.println(	fname.getName());
		}
		

	}

}
