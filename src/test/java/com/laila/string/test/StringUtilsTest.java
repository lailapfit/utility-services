package com.laila.string.test;

import org.junit.Before;
import org.junit.Test;

import com.laila.string.StringUtils;

import junit.framework.Assert;

public class StringUtilsTest {
	
	private StringUtils util;

	@Before
	public void setUp() throws Exception {
		util = new StringUtils();
	}

	@Test
	public void generateCronExpressionTest() {
		String cronTest = "0 06 23 ? * *";
		String time = "06:23";
		String testResult = util.generateCronExpression(time);
		System.out.println("Result >>> " + testResult);
		
		Assert.assertEquals(cronTest, testResult);
	}

}
