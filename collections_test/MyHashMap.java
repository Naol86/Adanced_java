package collections_test;

import java.util.*;

public class MyHashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> index = new HashMap<>();
		String[] numbers = {"one","two","three","four"};
		int i = 1;
		for(String number : numbers){
			index.put(number, i++);
		}
		System.out.println(index);

		// you can use this methods
		/**
		 * get() by passing a key you can get value
		 * remove()
		 * containsKey()
		 * containsValue()
		 * keySet() to get key as a set
		 * values() to get values as a array/list
		 */
	}
}
