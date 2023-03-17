package org.howard.edu.lsp.midterm.problem51;

@SuppressWarnings("serial")
public class EmptyRangeException extends Exception{
	public EmptyRangeException(String note) {
		super(note);
	}
}