package org.howard.edu.lsp.midterm.problem51;

// In addition to a working program, you must provide appropriate JUnit test cases for each method in IntegerRange.

public class IntegerRange implements Range {
	private int lower;
	private int upper;

	// Hint: implement getters for lower and upper

	IntegerRange(int lower, int upper) { 	// Constructor
    		this.lower = lower;
    		this.upper = upper;
    		}
	
	public boolean contains(int value) {
		return true;
	// implement
	}
	public boolean overlaps(Range other) throws EmptyRangeException {
		if(other == null) {
			throw new EmptyRangeException("EmptyRangeException: The provided range is empty.");
		}
		else {
			return true;
		}
	// implement
	}

	public int size()  {
		return upper - lower;
	// implement
	}
}