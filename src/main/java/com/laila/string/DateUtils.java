package com.laila.string;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.laila.model.Season;

public class DateUtils {
	
	//get season with format string yyyy based on the Season intervals and date 
	public String getSeason(Season season, String date) throws ParseException {
		String seasonString = "";
		
		DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(date);
		Integer yearInput = dateTime.getYear();
		
		String fallBeginning = season.getFallBeginning() + "/" + yearInput;
		DateTime fallBeginningDateTime = formatter(fallBeginning);
		
		String fallEnd = season.getFallEnd() + "/" + yearInput;
		DateTime fallEndDateTime = formatter(fallEnd);

		boolean isFall = isSeason(fallBeginningDateTime, fallEndDateTime, dateTime);
		
		String summerBeginning = season.getSummerBeginning() + "/" + yearInput;
		DateTime summerBeginningDateTime = formatter(summerBeginning);
		
		String summerEnd = season.getSummerEnd() + "/" + yearInput;
		DateTime summerEndDateTime = formatter(summerEnd);

		boolean isSummer = isSeason(summerBeginningDateTime, summerEndDateTime, dateTime);
		
		String springBeginning = season.getSpringBeginning() + "/" + yearInput;
		DateTime springBeginningDateTime = formatter(springBeginning);
		
		String springEnd = season.getSpringEnd() + "/" + yearInput;
		DateTime springEndDateTime = formatter(springEnd);
		
		boolean isSpring = isSeason(springBeginningDateTime, springEndDateTime, dateTime);
		
		String winterBeginning = season.getWinterBeginning() + "/" + yearInput;
		DateTime winterBeginningDateTime = formatter(winterBeginning);

		Integer yearInputWinterPrevious = yearInput - 1;
		String winterBeginningWinterprevious = season.getWinterBeginning() + "/" + yearInputWinterPrevious;
		DateTime winterBeginningWinterpreviousDateTime = formatter(winterBeginningWinterprevious);

		boolean isWinterPreviousYr = isSeason(winterBeginningWinterpreviousDateTime, winterBeginningDateTime, dateTime);
		
		Integer yearInputWinter = yearInput + 1;
		String winterEnd = season.getWinterEnd() + "/" + yearInputWinter;
		DateTime winterEndDateTime = formatter(winterEnd);

		boolean isWinter = isSeason(winterBeginningDateTime, winterEndDateTime, dateTime);
		
		if(isFall) {
			seasonString = "Fall " +  yearInput;
		} else if(isSummer) {
			seasonString = "Summer " + yearInput;
		} else if(isSpring) {
			seasonString = "Spring " + yearInput;
		} else if(isWinter) {
			seasonString = "Winter " + yearInput + "-" + yearInputWinter;
		} else if(isWinterPreviousYr) {
			seasonString = "Winter " + yearInputWinterPrevious + "-" + yearInput;
		}
		return seasonString;
	}
	
	// date formatter
	private DateTime formatter(String date) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		DateTime dt = formatter.parseDateTime(date);
		return dt;

	}
	
	//is a date between interval of two dates (can be used with any date values, not just season)
	private boolean isSeason(DateTime date1, DateTime date2, DateTime date3) {
		Interval interval = new Interval(date1, date2);
		boolean isDateInterval = interval.contains(date3);
		return isDateInterval;
	}
	
}
