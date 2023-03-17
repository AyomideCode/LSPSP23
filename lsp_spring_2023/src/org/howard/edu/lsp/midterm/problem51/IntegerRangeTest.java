package org.howard.edu.lsp.midterm.problem51;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerRangeTest {
	
	private IntegerRange range1;

	@Test
	@DisplayName("Test case for overlaps(), purposefully throwing IntegerSetException")
	void testOverlaps_Exception() throws EmptyRangeException {
		Throwable exception = assertThrows(EmptyRageException.class, () -> range1.overlaps() );
		assertEquals("EmptyRangeException: The provided range is empty.", exception.getMessage() );
	}
}
