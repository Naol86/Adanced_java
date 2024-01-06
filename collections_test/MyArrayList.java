package collections_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MyArrayList {
	public static void main(String[] args) {
		// creating list 1
		ArrayList<Integer> list_1 = new ArrayList<Integer>();
		// adding elements in list 1
		list_1.add(1);
		list_1.add(2);
		list_1.add(3);

		// creating list two
		List<Integer> list_2 = new ArrayList<Integer>();
		// add elements in list two
		list_2.add(4);
		list_2.add(5);
		list_2.add(6);
		list_2.add(7);
		list_2.add(8);

		// add both list one and two and save it in new list called list_3
		List<Integer> list_3 = new ArrayList<Integer>();
		list_3.addAll(list_1);
		list_3.addAll(list_2);

		// add all list two elements in list one
		list_1.addAll(list_2);

		// print list 3 using for loop
		for(Integer i : list_3)
			System.out.println(i);
		
		// get the first element in the array
		System.out.println("get index 1 : " + list_1.get(1));

		// remove the last element in the array
		System.out.println("before : " + list_2);
		list_2.remove(list_2.size() - 1);
		System.out.println("after : " + list_2);

		// print list 2 using Iterator class
		System.out.print("this is list 2 : ");
		Iterator iter = list_2.iterator();
		while(iter.hasNext())
			System.out.printf("%d ",iter.next());


		/**
		 * 
		 */

	}
}
