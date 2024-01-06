package Thread_test;

public class hana {
	public static void main(String[] args) {
		count temp = new count();
		one _one = new one(temp,"han");
		one _two = new one(temp,"naol");
		one _three = new one(temp,"ma");
		Thread t1 = new Thread(_one);
		Thread t2 = new Thread(_two);
		Thread t3 = new Thread(_three);

		t1.setName("t1");
		t2.setName("t2");
		t1.setPriority(9);
		t2.setPriority(8);
		t3.setPriority(1);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		// try {
		// 	t2.join();
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
	}
}
