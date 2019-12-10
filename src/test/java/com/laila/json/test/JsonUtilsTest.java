package com.laila.json.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.laila.json.JsonUtils;
import com.laila.model.Crayon;

import junit.framework.Assert;

public class JsonUtilsTest {
	
	private JsonUtils util;

	@Before
	public void setUp() throws Exception {
		util = new JsonUtils();
	}

	@Test
	public void getJsonObjectFromUrlTest() throws MalformedURLException, IOException {
		String url = "http://my-json-server.typicode.com/lailapfit/ellisprojects2/db";
		JSONObject jsonObject = util.getJsonObjectFromUrl(url);
		String name = "Projects";
		Assert.assertEquals(true, jsonObject.has(name));
		Assert.assertEquals(1, jsonObject.length());
		Assert.assertEquals(name, jsonObject.names().getString(0));
	}
	
	@Test
	public void getRemovedObjectFromListsTest() {
		List<Object> one = new ArrayList<Object>();
		one.add("1");
		one.add("2");
		one.add("3");
		one.add("4");
		one.add("5");
		List<Object> two = new ArrayList<Object>();
		two.add("1");
		two.add("2");
		two.add("3");
		two.add("4");
		List<Object> removed = new ArrayList<Object>();
		removed.add("5");
		
		List<Object> five = util.getRemovedObjectFromLists(one, two);
		Assert.assertEquals(removed.get(0), five.get(0));
	}
	
	@Test
	public void getObjectsFromUrlTest() {
		String urlTest = "https://raw.githubusercontent.com/lailapfit/example/master/db.json";
		Map<Integer, Crayon> cmap = util.getObjectsFromUrl(urlTest);
		Integer test = 342020;
		
		Assert.assertEquals("Fisher", cmap.get(13).getBrand());
		Assert.assertEquals("Pink", cmap.get(14).getColor());
		Assert.assertEquals(test, cmap.get(17).getLength());
	}

}
