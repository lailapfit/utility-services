package com.laila.string.test;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import com.laila.model.Season;
import com.laila.string.DateUtils;

import junit.framework.Assert;

public class DateUtilsTest {
	
	private DateUtils util;

	@Before
	public void setUp() throws Exception {
		util = new DateUtils();
	}

	@Test
	public void getSeasonTest() {
		Season season = new Season();
		season.setFallBeginning("09/21");
		season.setFallEnd("12/21");
		season.setSpringBeginning("03/21");
		season.setSpringEnd("06/21");
		season.setSummerBeginning("06/21");
		season.setSummerEnd("09/21");
		season.setWinterBeginning("12/21");
		season.setWinterEnd("03/21");
		
		String date = "2020-04-20";
		String seasonTestString = "Spring 2020";
		
		try {
			Assert.assertEquals(seasonTestString, util.getSeason(season, date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
