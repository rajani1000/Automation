# Publicis.Sapient - Java exercise

The Problem
Using Java, find all of the English words in a given String.  
For example, if you are given the word WORKING, you can easily find WORK and KING, 
but ROW, RING and KNOW are also in there.  You have access to a utility class called Dictionary, 
which has one method, isEnglishWord(String word). 
Dictionary.isEnglishWord(String word) connects to a (mocked) online dictionary and returns Boolean true 
if the String passed to it is an English word, return false otherwise.


Instructions
1.	Use Maven to create a project to answer this problem.
2.	You will need to create the Dictionary class.
3.	You will need to mock Dictionary.isEnglishWord(String word) for your solution and tests.
4.	The output of your primary method should be a collection of Strings without duplicates.
5.	Create tests that exercise your class and methods.
6.	Please complete the instructions to the best of your ability and understanding and come prepared to discuss the design decisions you chose.


Solution:

Main class - FindEnglishWords.java under Test package - com.mytest.testpackage
   -- Created a method to generate 3,4 and 5 character words from a given String
   -- This method also verifies the generated word is in dictionary file
   -- Saving all verified unique strings in a Set object 

Dictionary.java class - this class is under com.mytest.utils package
  --Connects to the dictionary text file and verifies the given string exists in the dictionary

Dictionary text file - contains 3, 4 and 5 characters English words 

 

 	
 	  	

	
	
			
			
		


 

