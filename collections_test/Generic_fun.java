package collections_test;

public class Generic_fun {
	public static void main(String[] args) {
		PrintArray<Integer> print_int = new PrintArray<>();
		PrintArray<String> print_str = new PrintArray<>();
		Integer[] age = {12,32,90,87};
		String[] name = {"naol", "kasinet", "code_force", "leet_code"};
		print_int.print(age);
		print_str.print(name);
		print_int.test(name);
	}
}
