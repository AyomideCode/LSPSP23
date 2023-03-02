package org.howard.edu.lsp.assignment4;

/**
 * @author AyomideCode
 * Ayomide Okeshola @ 02936424
 * 
 * This class exists to contain the program's main method, and to test the IntegerSet class while calling methods from it.
 */
public class Driver {

	// intersect() might be broken.
	// difference() is broken.
	
	public static void main(String[] args) throws IntegerSetException {
		System.out.println("This program will go through and execute all the methods in IntegerSet.java. \n");
		
		System.out.println("Making a new set, Set 1.");
		IntegerSet set1 = new IntegerSet();
		
		System.out.println("Testing add(). Adding items to Set 1...");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set 1 is: \n" + set1.toString() + "\n");
		
		System.out.println("Testing clear().");
		set1.clear();
		System.out.println("Set 1, as a result of clearing: \n" + set1.toString());
		System.out.println("(Since Set 1 was cleared, toString() printed nothing as to represent the now empty set.) \n");
		
		System.out.println("Adding those same three items back to Set 1...");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set 1 is back to being: " + set1.toString() + "\n");
		
		System.out.println("Testing length(). Length of Set 1 is: \n" + set1.length() + "\n");
	
		System.out.println("Making another new set, Set 2. Adding items to it...");
		
		IntegerSet set2 = new IntegerSet();
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println("Value of Set 2 is: \n" + set2.toString() + "\n");

		System.out.println("Testing equals(). Does Set 1 have the same values as Set 2? True/false: \n" + set1.equals(set2) + "\n");

		System.out.println("Testing contains(). Does Set 1 contain the value '2'? True/false: \n" + set1.contains(2) + "\n");

		System.out.println("Testing largest(). Largest item in Set 1: \n" + set1.largest() + "\n");
		
		System.out.println("Testing smallest(). Smallest item in Set 1: \n" + set1.smallest() + "\n");

		System.out.println("Adding an extra integer 999 to Set 1, that will soon be removed...");
		set1.add(999);
		System.out.println("New value of Set 1 is: " + set1.toString() + "\n");

		System.out.println("Testing remove(). Removing 999 from Set 1...");
		set1.remove(999);
		System.out.println("Value of Set 1 now is: " + set1.toString() + "\n");

		System.out.println("Testing union().");
		System.out.println("Value of Set 1 is: " + set1.toString());
		System.out.println("Value of Set 2 is: " + set2.toString());
		set1.union(set2);																		// union of set 1 and set 2
		System.out.println("Result of union of Set 1 and Set 2: \n" + set1.toString() + "\n");
		
		System.out.println("Testing intersect(). Intersecting Set 1 & Set 2:");
		set1.intersect(set2);
		
		System.out.println("\nTesting difference(). Set 2 - Set 1:");
		set2.diff(set1);
		
		System.out.println("\nTesting isEmpty(). Is Set 1 empty? True/false: \n" + set1.isEmpty() + "\n");
		System.out.println("Using clear() on Set 1, to test isEmpty on it again...");
		set1.clear();
		System.out.println("Testing isEmpty() again. Is Set 1 empty? True/false: \n" + set1.isEmpty() + "\n");
		
		System.out.println("Testing IntegerSetException, by using smallest() on the emptied Set 1: \n");
		set1.smallest();
	}
	
}
