package Thread_test;

public class Main {
	public static void main(String[] args) {
		// thread_one t1 = new thread_one();
		// t1.start();
		thread_runnable t2 = new thread_runnable();
		Thread t3 = new Thread(t2);
		t3.start();
		// thread_runnable t2 = new thread_runnable();
		Thread t4 = new Thread(t2);
		t4.start();
	}
}
