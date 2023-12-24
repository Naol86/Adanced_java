package collections_test;

import java.util.*;

public class test{
	public static void main(String[] args) {
		Vector<Integer> numbers = new Vector<Integer>();
		for (int i = 11; i  > 0; i--)
			numbers.add(i*i);
		Collections.sort(numbers);
		for (Integer number : numbers)
			System.out.println(number);
	}
}