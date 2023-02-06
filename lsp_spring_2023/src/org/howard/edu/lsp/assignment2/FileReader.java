package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * @author AyomideCode
 * Ayomide Okeshola @ 02936424
 * 
 * .java file initially provided by instructor (bpwoolfolk), then edited for Assignment #2.
 * The program is designed to read a text file off of main path, and count the number of times each 'word' contained, appears.
 * 
 * Unique rules to 'words':
 * It is assumed the file only contains words, spaces, digits and newlines. 
 * Spaces, punctuation, and other non-letter characters i.e. digits are not counted as words. 
 * Contractions are counted as two words, and separated. 
 * No case-sensitivity. "Design" and "design" should count the same. 
 * Consider words with three or less letters to be trivial and uncounted. 
 */

public class FileReader {
	/**
	 * 
	 * @param resource qualifies the location of the file
	 * @throws FileNotFoundException
	 * @return output, a string that lists the names and their individual count, using words.txt
	 */
	
	public String readToString(String resource) throws FileNotFoundException {
		URL url = getClass().getClassLoader().getResource(resource); 
		
		// creates an ArrayList for the words and one for the count of those words	
		ArrayList<String> words = new ArrayList<String>(); 
        ArrayList<Integer> count = new ArrayList<Integer>();
		
		if (url != null) {
			File file = new File(url.getPath());
			
			Scanner sc = null;
			try {
				sc = new Scanner(file, "UTF-8"); // specifying the file encoding will keep words like 'Haägen Dasz' from messing up
				sc.useDelimiter("\\W+"); // this tells the Scanner that I want the 'thing between tokens' to be 'any amount of non-letters', using regex
								
				while (sc.hasNext()) { 
		            String nextWord = sc.next(); // gets the next word
		            
		            if (nextWord.length() <= 3) { // forces to not count words 3 or less in length
		            	continue;
		            }
		            
		            nextWord = nextWord.toLowerCase(); // forces case-insensitivity
		            
		            if(words.contains(nextWord)) { //this determines if the word is in the ArrayList
		                int index = words.indexOf(nextWord);
		                count.set(index, count.get(index) + 1);
		            }
		            else {
		                words.add(nextWord);
		                count.add(1);
		            }
				}
				
			} finally {
				sc.close(); // closes the scanner	
			}
			
			String output = "";
			for(int i = 0; i < words.size(); i++){ // generates the output
	            output += (words.get(i) + "\t" + count.get(i) + "\n");
	        }
			return output;	

		}
		throw new FileNotFoundException();
	}
}
