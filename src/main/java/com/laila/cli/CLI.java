package com.laila.cli;

import java.io.FileNotFoundException;

import com.laila.string.StringUtils;

public class CLI {

	public static void main(String[] args) throws FileNotFoundException {
		StringUtils util = new StringUtils();
		util.sortStringsInFile("unsorted.txt", "sorted.txt");
	}

}
