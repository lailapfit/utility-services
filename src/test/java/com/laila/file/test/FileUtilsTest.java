package com.laila.file.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.laila.file.FileUtils;

import junit.framework.Assert;

public class FileUtilsTest {
	
	FileUtils util;
	
	@Before
	public void setUp() throws Exception {
		util = new FileUtils();
	}
	
	@Test
	public void getRenameFileName() {
		String fileNameTest = "files/Test-Rename.txt";	
		String fileNameTest2 = "files/Test-Rename-2.txt";
		util.renameFileName(fileNameTest);
		File testFile = new File(fileNameTest2);
		
		Assert.assertEquals(true, testFile.exists());
	}
	
	@Test
	public void getDataFromFileTest() {
		String fileNameTest = "files/Test-Rename-2.txt";
		List<String[]> strings = util.getDataFromFile(fileNameTest);
		
		Assert.assertEquals(4, strings.size());
	}
	
	@Test
	public void getLastLinesTest() throws IOException {
		String fileNameTest = "files/Test-Rename-2.txt";
		String result = util.getLastLines(2, fileNameTest);
		String testResult = "Example for my txt file in 4\nExample for my txt file in 3\n";
		Assert.assertEquals(testResult, result);
	}
	
	@Test
	public void getSeparateByRegexTest() {
		String test = "t,e,s,t";
		List<String> testList = new ArrayList<String>();
		testList.add("t");
		testList.add("e");
		testList.add("s");
		testList.add("t");
		
		List<String> result = util.separateByRegex(test, ",");
		Assert.assertEquals(testList, result);
	}

}
