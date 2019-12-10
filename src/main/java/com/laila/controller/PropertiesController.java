package com.laila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.laila.configuration.ConfigService;
import com.laila.configuration.PropertiesService;

@RestController
public class PropertiesController {
	
	@Autowired
	private ConfigService config;
	
	@Autowired
	private PropertiesService prop;
	
	@RequestMapping(value={"/properties"}, method=RequestMethod.GET) 
	public String getProperties() {
		String result;
		try {
			result = config.getPropertiesInString();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Nothing found";
	}
	
	@RequestMapping(value={"/properties/{key:.+"}, method=RequestMethod.GET)
	public String getProperties(@PathVariable String key) {
		String result;
		try {
			result = config.getproperty(key);
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Nothing found";
	}
	
	@ResponseBody
	@RequestMapping(value={"log"}, method=RequestMethod.GET)
	public String retrieveLogStatus(@RequestParam(defaultValue = "") String delimiter) {
		return prop.getDateFormat();
	}
}
