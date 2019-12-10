package com.laila.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

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
	
	@SuppressWarnings("resource")
	public void sortStringsInFile(String unsorted, String sorted) throws FileNotFoundException {
		File unsortedIncomingFile = new File(unsorted);
		File sortedFileOutput = new File(sorted);
		
		PrintWriter printWriter = new PrintWriter(sortedFileOutput.getAbsoluteFile());
		Scanner incoming = new Scanner(unsortedIncomingFile);
		String[] unsortedStrings = null;
		
		while(incoming.hasNextLine()) {
			unsortedStrings = incoming.nextLine().split(" ");
		}
		
		Arrays.sort(unsortedStrings, (a, b) -> Integer.compare(a.length(), b.length()));
		
		for(String u: unsortedStrings) {
			printWriter.write(u + "\n");
		}
		
		printWriter.flush();
	}
	

}
