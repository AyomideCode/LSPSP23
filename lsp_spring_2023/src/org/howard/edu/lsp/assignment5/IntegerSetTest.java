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
	private IntegerSet test;
	
	@BeforeEach
	void setUp() {
		set1 = new IntegerSet();
		set2 = new IntegerSet();
		test = new IntegerSet();
	}
	
	@Test
	@DisplayName("Test case for add()")
	void testAdd() {
		set1.add(0);		
		assertEquals(true, set1.contains(0));
	}
	
	@Test
	@DisplayName("Test case for clear()")
	void testClear() {
		set1.add(0);		
		set1.clear();
		assertEquals(true, set1.length() == 0);
	}
	
	@Test
	@DisplayName("Test case for length()")
	void testLength() {
		set1.add(0);
		set1.add(1);
		set1.add(2);
		assertEquals(3, set1.length());
	}
	
	@Test
	@DisplayName("Test case for equals()")
	void testEquals() {
		set1.add(0);
		set2.add(0);
		assertEquals(true, set1.equals(set2));	// True if set1 == set1
		set2.add(1);							// Adding a value to Set 2, in order to test if equals() will now pick up on that
		assertEquals(false, set1.equals(set2));	// False if set1 != set2
	}
	
	@Test
	@DisplayName("Test case for contains()")
	void testContains() {
		set1.add(1);
		set1.add(3);
		set1.add(5);
		assertEquals(true, set1.contains(5));	// True if Set 1 has the integer 5 in it
		set1.remove(5);							// Removing 5 in order to test contains() again with the same parameter
		assertEquals(false, set1.contains(5));

	}
	
	@Test
	@DisplayName("Test case for largest()")
	void testLargest() throws IntegerSetException {
		set1.add(2);
		set1.add(4);
		set1.add(6);
		assertEquals(true, set1.largest() == 6);
	}
	
	@Test
	@DisplayName("Test case for largest(), purposefully throwing IntegerSetException")
	void testLargest_IntegerSetException() throws IntegerSetException {
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.largest() );
		assertEquals("IntegerSetException: The provided list is empty; there is no largest integer.", exception.getMessage() );
	}
	
	@Test
	@DisplayName("Test case for smallest()")
	void testSmallest() throws IntegerSetException {
		set1.add(2);
		set1.add(4);
		set1.add(6);
		assertEquals(true, set1.smallest() == 2);
	}
	
	@Test
	@DisplayName("Test case for smallest(), purposefully throwing IntegerSetException")
	void testSmallest_IntegerSetException() throws IntegerSetException {
		set1.clear();
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.smallest() );
		assertEquals("IntegerSetException: The provided list is empty; there is no smallest integer.", exception.getMessage() );
	}
	
	@Test
	@DisplayName("Test case for toString()")
	void testtoString() {
		set1.add(3);
		set1.add(6);
		set1.add(9);								// [3, 6, 9]
		
		String expected = "[3, 6, 9]";
		assertEquals(set1.toString(), expected);
	}
	
	@Test
	@DisplayName("Test case for remove()")
	void testRemove() {
		set1.add(0);
		set1.add(1);
		set1.add(2);
		set1.add(333);								// [0, 1, 2, 333]
		
		assertEquals(4, set1.length());				// Making sure there are four integers, implying add() worked
		set1.remove(333);							// Using remove() to remove 999 from the set
		assertEquals(3, set1.length());				// Making sure there is one less integer in the set, implying length() worked
		assertEquals(false, set1.contains(333));	// Making sure now that 999 is removed, it is not part of the set anymore
	}
	
	@Test
	@DisplayName("Test case for union()")
	void testUnion() {
		set1.add(1);
		set1.add(2);
		
		set2.add(3);
		set2.add(4);
		
		set1.union(set2);
		assertEquals(true, set1.contains(3));	// Making sure now that union() has worked on Set 1 with Set 2, 
		assertEquals(true, set1.contains(4));	// that integers '3' and '4' are now in Set 1
	}
	
	@Test
	@DisplayName("Test case for intersect()")
	void testIntersect() {
		set1.add(2);
		set1.add(5);
		set1.add(6);							// set1 = [2, 5, 6]
		
		set2.add(6);
		set2.add(5);							// set2 = [5, 6]
		
        test.add(5);
		test.add(6);							// test = [5, 6]
		
		set1.intersect(set2);
		assertEquals(true, set1 == test);
	}
	
	@Test
	@DisplayName("Test case for difference()")
	void testDifference() {
		set1.add(2);
		set1.add(5);
		set1.add(6);							// set1 = [2, 5, 6]
		
		set2.add(2);
		set2.add(5);							// set1 = [2, 5]

		test.add(6);							// test = [6]
		
		set1.diff(set2);						// set1 - set2 = [5]
		assertEquals(true, set1 == test);
	}
	
	@Test
	@DisplayName("Test case for isEmpty()")
	void testisEmpty() {
		set1.add(1);
		assertEquals(false, set1.isEmpty());
		set1.clear();
		assertEquals(true, set1.isEmpty());

	}

}
