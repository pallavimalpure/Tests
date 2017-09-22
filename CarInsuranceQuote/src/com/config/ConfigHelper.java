package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper 
{
	private String Url;
	private String isentiaUrl;
	private String browserDriver;
	private String browserExe;
	private String operatingSystem;
	
	private ConfigHelper()
	{
		readProperties();
	}

	static ConfigHelper conHelper = new ConfigHelper();
	
	
	public static ConfigHelper getConHelper() 
	{
		return conHelper;
	}

	public String getBrowserDriver() 
	{
		return browserDriver;
	}

	public String getBrowserExe() 
	{
		return browserExe;
	}

	public String getIsentiaUrl() 
	{
		return isentiaUrl;
	}
	
	public String getUrl() 
	{
		return Url;
	}
	
	public String getOperatingSystem() 
	{
		return operatingSystem;
	}

	private void readProperties()
	{
		InputStream fis;
		Properties prop = null;
		try 
		{
			fis = new FileInputStream("config.properties");
			prop = new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Url = prop.getProperty("Url");
		isentiaUrl = prop.getProperty("isentiaUrl");
		browserDriver = prop.getProperty("browserDriver");
		browserExe = prop.getProperty("browserExe");
		operatingSystem = prop.getProperty("operatingSystem");
	}
}
