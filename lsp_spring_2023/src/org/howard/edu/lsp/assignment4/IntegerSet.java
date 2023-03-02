package org.howard.edu.lsp.assignment4;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author AyomideCode
 *
 * This class is made up of multiple functions, taking user-defined sets and manipulating them in Driver.java
 * Implemented set operations: clear(), length(), equals(), contains(), largest(), smallest(), add(), remove(), union(), intersect(), diff(), isEmpty(), toString()
 */

public class IntegerSet {
	/**
	 * @param resource qualifies the location of the file
	 * @throws IntegerSetException
	 * @return Driver.java uses the methods in this class to return strings, booleans & int for length(); otherwise, void
	 */
	
    //Makes the default, mutable set, and a getter for it	
	private ArrayList<Integer> set = new ArrayList<Integer>();
	public ArrayList<Integer> getSet() {
		return this.set;
	}

	// Clears the internal representation of the set
	public void clear(){
		set.clear();
		//System.out.println(set);
	}

	// Returns the length of the set
	public int length() {
		//System.out.println(set.size());
		return set.size();			
	}

	/*
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	*/
	public boolean equals(IntegerSet setB){
		boolean equals;
		ArrayList<Integer> tempArrayList = setB.getSet();							// creates getter for the set.
		if(set.containsAll(tempArrayList) && tempArrayList.containsAll(set)) {
			equals = true;
		}	
		else {
			equals = false;
		}
		//System.out.println(equals);
		return equals;
	}

	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value){
		boolean contains;
		if (set.contains(value)) {
			contains = true;
		}
		else {
			contains =  false;
		}
		//System.out.println(contains);
		return contains;
	}    

	// Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	public int largest() throws IntegerSetException{
		int largest = 0;
		if(set.isEmpty()) {
			throw new IntegerSetException("IntegerSetException: The provided list is empty; there is no largest integer.");
		}
		else {
			ArrayList<Integer> sortedList = new ArrayList<Integer>(set);
			Collections.sort(sortedList);
			//System.out.println(sortedList.get(sortedList.size() -1));
			largest = sortedList.get(sortedList.size() -1);
			return largest;
		}
	}

	// Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	public int smallest() throws IntegerSetException{
		int smallest = 0;
		if(set.isEmpty()) {
			throw new IntegerSetException("IntegerSetException: The provided list is empty; there is no smallest integer.");
		}
		else {
			ArrayList<Integer> sortedList = new ArrayList<Integer>(set);
			Collections.sort(sortedList);
			//System.out.println(sortedList.get(0));
			smallest = sortedList.get(0);
			return smallest;
		}
	}
	
	// Adds an item to the set or does nothing if already there
 	public void add(int item){
 		if(set.contains(item) == false) {
 			set.add(item);			 			
 		}
 		//System.out.println(set);
 	} 

	// Removes an item from the set or does nothing if not there
	public void remove(int item){
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();	// creates getter for the set
		for (int i=0; i < set.size(); i++) {
			if(set.get(i) != item){
				tempArrayList.add(set.get(i));
				//System.out.println(tempArrayList);
			}
		}
		set = tempArrayList;
	}

	// Set union
	public void union (IntegerSet setB) {
		ArrayList<Integer> tempArrayList = setB.getSet();			// creates getter for the set
	    for (int i=0; i< tempArrayList.size(); i++) {				// iterates through all elements of passed in ArrayList<Integer)
	       if (!set.contains(tempArrayList.get(i)))  {				// checks if item is not already in set
	           add(tempArrayList.get(i));							// if so, adds it
	       }
	    }	  
	}	
	
	// Set intersection
	public void intersect(IntegerSet setB){
		ArrayList<Integer> tempArrayList = setB.getSet();			// creates getter for the set
		ArrayList<Integer> fillerList = new ArrayList<Integer>();	// creates getter for the common set elements
	    for (int i=0; i< tempArrayList.size(); i++) {				// iterates through all elements of passed in ArrayList<Integer)
	       if (set.contains(tempArrayList.get(i)))  {				// checks if item is already in set
	           fillerList.add(tempArrayList.get(i));				// adds the item, if not there
	       }
	    }
        System.out.println(fillerList);

	} 

	// Set difference, i.e., s1 - s2
	public void diff(IntegerSet setB) {
		ArrayList<Integer> tempArrayList = set;						// creates getter for the set
		ArrayList<Integer> fillerList = new ArrayList<Integer>();	// creates getter for elements only in set A
	    for (int i=0; i< tempArrayList.size(); i++) {				// iterates through all elements of passed in ArrayList<Integer)
	       if (!setB.contains(tempArrayList.get(i)))  {				// checks if item is already in set
	           fillerList.add(tempArrayList.get(i));				// adds the item, if not there
	       }
	    }
	    System.out.println(fillerList);
	}

	// Returns true if the set is empty, false otherwise
	public boolean isEmpty() {
		boolean empty;
		empty = (set.size() == 0);
		//System.out.println(empty);
		return empty;				 
	}
	
	// Returns a String representation of the set
	public String toString(){
		String set_string ="";
		for (int i = 0; i < set.size(); i++) {
			set_string = set_string.concat(String.valueOf(set.get(i)) + ", ");
		}
		//System.out.println(set_string);
		return set_string;
	}
	
}