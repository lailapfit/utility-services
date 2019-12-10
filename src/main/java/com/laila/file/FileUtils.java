package com.laila.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class FileUtils {
	
	// removing the last modified file so the files do not exceed the maxLogFile  
	public void removeFileLastModified(String fileName, int maxLogFile) {
		File folder = new File(fileName);
		File[] files = folder.listFiles();
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
		if(files.length >= maxLogFile + 1) {
			//System.out.println("FILE delete >>>> " + files[0]);
			files[0].delete();
		}
	}
	
	// rename file name
	public void renameFileName(String fileName) {
		Date date = new Date();
	//	Integer one = 2;
		File current = new File(fileName);
		if(current.exists()) {
			//System.out.println("1");
			fileName = fileName.substring(0, fileName.lastIndexOf(".")) + "-" + date + fileName.substring(fileName.lastIndexOf("."));
			//System.out.println("File name >>> " + fileName);
			File replace = new File(fileName);
			current.renameTo(replace);
		}		
	}
	
	// utility method to obtain data from txt files.
	public List<String[]> getDataFromFile(String filename) {
		List<String[]> stringList = new ArrayList<String[]>();
		File incoming = new File(filename);
		Scanner in = null;
		try {
			in = new Scanner(incoming);
			while(in.hasNextLine()) {
				String inputLine = in.nextLine();
				System.out.println(inputLine);
				String[] input = inputLine.split(" ");
				stringList.add(input);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringList;
	}
	
	//read from file to string
	public String readFileAsString(String filePath) throws IOException {
		return org.apache.commons.io.FileUtils.readFileToString(new File(filePath),"UTF-8");
	}
	
	// read from file to List of strings
	public List<String> readLines(String file) throws IOException {
		return org.apache.commons.io.FileUtils.readLines(new File(file), "UTF-8");
	}
	
	// get last lines according to parameter limit from file
	public String getLastLines(int limit, String filePath) throws IOException {
		List<String> stringList = readLines(filePath);
		StringBuilder sb = new StringBuilder();
		int lastIndex = stringList.size() - limit;
		
		for(int i = stringList.size() -1; i >= lastIndex; i--) {
			sb.append(stringList.get(i));
			sb.append(System.getProperty("line.separator"));
		}
		String result = sb.toString();
		return result;
	}
	
	//split strings by regex into list of strings
	public List<String> separateByRegex(String input, String regex) {
		List<String> results = Arrays.asList(input.split(regex));
		return results;
	}
} 
