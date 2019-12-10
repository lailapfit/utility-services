package com.laila.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laila.model.Crayon;

public class JsonUtils {
	
	//Get json object from endpoint
	public JSONObject getJsonObjectFromUrl(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String response = readAll(in);
			JSONObject jsonObject = new JSONObject(response);
			return jsonObject;
		} finally {
			is.close();
		}
	}
	
	//Find which object is removed between two lists
	public List<Object> getRemovedObjectFromLists(List<Object> previousList, List<Object> currentList) {
		List<Object> removedObjectList = new ArrayList<Object>();
		Collection<Object> removedObjectCollection = CollectionUtils.removeAll(previousList, currentList);
		Iterator<Object> iterator = removedObjectCollection.iterator();
		while(iterator.hasNext()) {
			Object next = iterator.next();
			removedObjectList.add(next);
		}
		return removedObjectList;
	}
	
	// get a json object from endpoint of json arrau to a map
	public Map<Integer, Crayon> getObjectsFromUrl(String url) {
		ObjectMapper mapper = new ObjectMapper();
		List<Crayon> crayons = null;
		try {
			crayons = mapper.reader().forType(new TypeReference<List<Crayon>>() {
			}).readValue(new URL(url));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<Integer, Crayon> crayonMap = new HashMap<Integer, Crayon>();
		for(Crayon c: crayons) {
			crayonMap.put(c.getId(), c);
		}
		return crayonMap;
	}
	
	//get json object from list of maps
	public JSONObject listToJsonObject(List<Map<String, Object>> projectList, String objectName, String arrayName) {
		JSONObject project = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < projectList.size(); i++) {
			JSONObject projects = new JSONObject();
			JSONObject jsonObject = new JSONObject();
			for(Map.Entry<String, Object> entry: projectList.get(i).entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				jsonObject.put(key, value);
			}
			projects.put(objectName, jsonObject);
			jsonArray.put(projects);
		}
		project.put(arrayName, jsonArray);
		return project;
	}
	
	// json string to map
	public Map<String, Object> mapPreviousJson(String value) {
		Map<String, Object> previousJsonMap = new HashMap<String, Object>();
		JSONObject object = new JSONObject(value);
		Iterator<String> itr = object.keys();
		while(itr.hasNext()) {
			String key = itr.next();
			previousJsonMap.put(key, object.get(key));
		}		
		return previousJsonMap;
	}
	
	//read in from BufferedReader as a String
	private String readAll(BufferedReader br) throws IOException {
		String inputLine;
		StringBuilder sb = new StringBuilder();
		while((inputLine = br.readLine()) != null) {
			sb.append(inputLine);
		}
		return sb.toString();
	}

}
