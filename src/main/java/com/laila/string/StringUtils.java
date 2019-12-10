package com.laila.string;

public class StringUtils {
	
	//generate cron expression with String hh:mm
	public String generateCronExpression(String time) {
		 String hour = "";
		 String minute = "";
		 if(!time.isEmpty()) {
			 hour = time.substring(0, 2);
			 minute = time.substring(3, 5);
		 }		 
		 return String.format("%1$s %2$s %3$s %4$s %5$s %6$s", "0", hour, minute, "?", "*", "*");

	 }

}
