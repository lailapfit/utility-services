package com.laila.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {
	
	@Autowired
	private ConfigService config;
	
	public Properties getProperties() {
		return config.getProperties();
	}
	
	public String getDateFormat() {
		return config.getproperty("date.format");
	}
	
	public String getScheduleTime() {
		return config.getproperty("schedule.time");
	}
	
	public String getScheduleExecution() {
		return config.getproperty("schedule.execution");
	}
}
