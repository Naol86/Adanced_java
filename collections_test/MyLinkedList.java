package collections_test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	public static void main(String[] args) {
		// creating linked list which contain string first name
		LinkedList<String> firstNames = new LinkedList<String>();
		// adding names in our linked list
		firstNames.add("Naol");
		firstNames.add("Hana");

		// create new linked list which contain string last name
		List<String> lastNames = new LinkedList<String>();
		// adding last names in out linked list
		lastNames.add("Kasinet");
		lastNames.add("Mesfin");

		// create full name linked list that store full name by adding first name and last name
		LinkedList<String> fullNames = new LinkedList<String>();
		for (int i = 0; i < firstNames.size(); i++)
			fullNames.add(firstNames.get(i) + " " + lastNames.get(i));
		System.out.println(fullNames);
		Collections.sort(fullNames);
		System.out.println(fullNames);

		// iterate through full name
		for(String name : fullNames)
			System.out.println(name);

		/**
		 * we can also implement
		 * getFirst() : to get first element in the list
		 * getLast() : to get last element in the list
		 * removeFirst() : to remove first element in the list
		 * removeLast() : to remove last element in the list
		*/
	}
}
