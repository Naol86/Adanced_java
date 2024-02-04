package collections_test;

import java.util.*;

public class test{
	public static void main(String[] args) {
		for(String s : args){

			System.out.println(s);
		}
		TreeMap<String, Integer> num = new TreeMap<>();
		num.put("three",3);
		num.put("one",1);
		num.put("two",2);
		System.out.println(num);
		
		for(String n : num.keySet()){
			System.out.println(n +" : "+ num.get(n));
		}
	}
}