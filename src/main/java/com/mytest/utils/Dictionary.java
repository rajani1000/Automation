package com.mytest.utils;

import java.io.File;
import java.util.Scanner;

public class Dictionary {
	public static boolean isEnglishWord(String word) throws Exception {
		boolean isWord = false;
		
		File file = new File("src/dictionary");
		Scanner sc  = new Scanner(file);
		
		while(sc.hasNextLine()) {
			if(word.equalsIgnoreCase(sc.nextLine())) {
				isWord = true;				
			}
		}
		return isWord;		
	}

}
