package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;


public class IntegerSetTest {
	
	private IntegerSet set1;
	private IntegerSet set2;
	
	@BeforeEach
	void setUp() {
		set1 = new IntegerSet();
		set2 = new IntegerSet();
	}
	
	@Test
	@DisplayName("Test case for add()")
	void testAdd() {
		set1.add(0);		
		assertEquals(true, set1.contains(0));
	}
	
	@Test
	@DisplayName("Test case for smallest(), purposefully throwing IntegerSetException")
	void testSmallest_IntegerSetException() throws IntegerSetException {
		set1.clear();
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.smallest() );
		assertEquals("IntegerSetException: The provided list is empty; there is no smallest integer.", exception.getMessage() );
	}
	

}
