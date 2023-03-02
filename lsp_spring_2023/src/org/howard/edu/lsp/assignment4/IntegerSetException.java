/**
 * 
 */
package org.howard.edu.lsp.assignment4;

/**
 * @author AyomideCode
 * Ayomide Okeshola @ 02936424
 * 
 * This class exists to throw a user-defined exception for largest() and smallest(), methods found in IntegerSet.java and called in Driver.java
 */
public class IntegerSetException extends Exception{
	/**
	 * Class solely dedicated to throwing custom exception type: IntegerSetException
	 */
	
	public IntegerSetException(String note) {
		super(note);
	} 
}
