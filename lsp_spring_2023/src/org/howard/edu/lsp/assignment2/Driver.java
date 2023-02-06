package org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;

/**
 * .java file provided by instructor. 
 * This file is used for testing for now, until the instructor introduces us to the JUnit testing framework.
 * @author bpwoolfolk
 */

public class Driver {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		try {
			System.out.println(fr.readToString("main/java/resources/words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}
}
