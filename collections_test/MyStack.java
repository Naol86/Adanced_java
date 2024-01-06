package collections_test;

import java.util.HashMap;
import java.util.Stack;

public class MyStack {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		HashMap<Character, Integer> roman = new HashMap<>();
		roman.put('M',1000);
		roman.put('D',500);
		roman.put('C',100);
		roman.put('L',50);
		roman.put('X',10);
		roman.put('V',5);
		roman.put('I',1);
		System.out.println(roman);
		System.out.println(roman.get(s.charAt(0)));
		stack.push(roman.get(s.charAt(0)));
		sum += roman.get(s.charAt(0));

		for(int i = 1; i < s.length(); i ++){
			if (stack.peek() < roman.get(s.charAt(i))){
				int temp = stack.pop();
				sum -= temp;
				temp = roman.get(s.charAt(i)) - temp;
				stack.push(temp);
				sum += temp;
			}
			else{
				stack.push(roman.get(s.charAt(i)));
				sum += roman.get(s.charAt(i));
			}
		}
		System.out.println(stack);
		System.out.println(sum);

	}
}
