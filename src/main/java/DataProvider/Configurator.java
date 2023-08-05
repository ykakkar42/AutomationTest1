package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurator {

	public static String getproperty(String fileloc, String key)
	{
		Properties pro=new Properties();
		//use to manipulate properties files
		try
		{
			pro.load(new FileInputStream(new File(fileloc)));//loading the file from the location given by user
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FIle not found"+e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("File not accessible"+e.getMessage());
		}
		
		String property=pro.getProperty(key);//fidning the key given by the user in the loaded file and storing its value
		
		return property;
	}
	
}
