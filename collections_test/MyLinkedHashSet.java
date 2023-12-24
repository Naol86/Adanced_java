package collections_test;

import java.util.*;

public class MyLinkedHashSet {
	public static void main(String[] args) {
		// creating linked hash set
		LinkedHashSet<String> names = new LinkedHashSet<>();
		names.add("naol");
		names.add("kasinet");
		names.add("habibti");

		// print linked hash set
		Iterator iter = names.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		// it kept the order of insertion
	}
}
