package org.howard.edu.lsp.finals.problem;
import java.util.*;

/*
 * Below is sample that uses your implementation:
Hint: You need some of the below in your JUnit test cases.
			…
SongsDatabase db = new SongsDatabase();
db.add(“Rap”, “Savage”);
db.add(“Rap”, “Gin and Juice”);
db.add(“Jazz”, “Always There”);
Set<String> songs = db.getSongs(“Rap”); // contains Savage and
                                        // Gin and Juice
System.out.println( db.getGenreOfSong(“Savage”) );// prints “Rap”
System.out.println( db.getGenreOfSong(“Always There”) );// prints 
“Jazz”

Be sure to include a JUnit test case for each method in SongsDatabase. (15 pts.)

****************************************************************
Instructions:
Your implementation should be uploaded to your GitHub repository (the same you have been using all semester).  The package is howard.edu.lsp.final.problem (contains implementation and JUnit test cases).   At the least, your implementation should have:
1.	SongsDatabase.java (implementation)
2.	SongsDatabaseTest.java (JUnit test cases)
 */

public class SongsDatabase {
	/* Key is the genre, HashSet contains associated songs */
    	private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

	
	 		/* Add a song title to a genre */
    	public void addSong(String genre, String songTitle) {
    		HashSet<String> songs = map.getOrDefault(genre, new HashSet<String>());
    		songs.add(songTitle);
    		map.put(genre, songs);
					//Code it!!
				}
    	/* Return the Set that contains all songs for a genre */
 		public HashSet<String> getSongs(String genre) {
 			HashSet<String> result = map.get(genre);
 			System.out.println(result);
 			return result;	
        			// Code it!!
    		}
 		/* Return genre, i.e., jazz, given a song title */
    	public String getGenreOfSong(String songTitle) {
    		
    		String result = "";
    		
    		for(String genre : map.keySet()) {
    			if (map.get(genre).contains(songTitle)) {
    				result = genre;
    				break;
    			}
    		}
    		
    		return result;
    	}
}