package org.example.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	Properties pro;
	File src = new File("./Configuration/config.properties");
	
	public Config() {
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

	public String getBaseUrl() {
		String url  = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String username  = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String pass  = pro.getProperty("password");
		return pass;
	}
	

}
