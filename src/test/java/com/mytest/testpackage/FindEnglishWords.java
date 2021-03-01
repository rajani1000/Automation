package com.mytest.testpackage;
import java.util.HashSet;
import java.util.Set;

import com.mytest.utils.Dictionary;

/**
 * Problem - Using Java, find all of the English words in a given String.  
 * For example, if you are given the word WORKING, 
 * you can easily find WORK and KING, but ROW, RING and KNOW are also in there. 
 * You have access to a utility class called Dictionary, which has one method, isEnglishWord(String word). 
 * Dictionary.isEnglishWord(String word) connects to a (mocked) online dictionary and returns Boolean true 
 * if the String passed to it is an English word, return false otherwise.
 * 
 * @author Rajani
 *
 */
public class FindEnglishWords { 
	static String engWord = "WORKING";
	static char[] alphabet = engWord.toCharArray();
	static Set<String> words = new HashSet<String>();;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		for(int length = 3; length <= 5; length++) {
			sb.setLength(length);
			generate(sb, 0);
		}
		if(!words.isEmpty()) {
			System.out.println(words.toString());
		} else {
			System.out.println("There are no matching words in the dictionary file");
		}		
	}

	private static void generate(StringBuilder sb, int n) throws Exception {
		
		if(n == sb.length()) {
			if(Dictionary.isEnglishWord(sb.toString())) {
				words.add(sb.toString());				
			}
			return;
		}
		for(char letter : alphabet) {
			sb.setCharAt(n, letter);
			generate(sb, n+1);
		}	
		
	}

}
