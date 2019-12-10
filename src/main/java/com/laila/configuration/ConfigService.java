package com.laila.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	
	public Properties prop;
	
	public void load() {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("./config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loaded the configuration file");
	}
	
	public String getproperty(String key) {
		if(prop == null) {
			load();
		}
		return prop.getProperty(key);
	}
	
	public String getPropertiesInString() {
		if(prop == null) {
			load();
		}
		return prop.toString();
	}
	
	public Properties getProperties() {
		return prop;
	}

}
