package collections_test;

import java.util.*;

public class MyHashSet {
	public static void main(String[] args) {
		//  creating hash set
		HashSet<Integer> list_1 = new HashSet<>();

		// adding element in to the hash set
		list_1.add(10);
		list_1.add(4);
		list_1.add(5);
		list_1.add(3);
		// print hash set
		Iterator iter = list_1.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
		// as you can see it is not ordered because hash set don't keep order of insertion

		// you can remove element using remove method
		list_1.remove(4);
	}
}
