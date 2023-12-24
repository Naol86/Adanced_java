package collections_test;

import java.util.*;

public class MyVector {
	public static void main(String[] args) {
		// creating vector
		Vector<String> list_1 = new Vector<>();
		// adding element using legacy method
		list_1.addElement("maths");
		list_1.addElement("physics");
		list_1.add("English");
		// iterating through list using for loop
		for (int i = 0; i < list_1.size(); i++){
			System.out.println(list_1.elementAt(i));
		}

		// we can remove by using legacy method
		list_1.removeElementAt(0);
		System.out.println("after element is removed");
		// iterating through list using iterator
		Iterator iter = list_1.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
