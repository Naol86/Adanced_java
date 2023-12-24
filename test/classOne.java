package test;

public class classOne{
	public static void main(String[] args) throws InterruptedException {

		counter num = new counter();

		Thread t = new Thread(new Runnable(){
			public void run(){
				for(int i= 0;i<1000;i++){
					num.increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i= 0;i<1000;i++){
					num.increment();
				}
			}
		});
		t.start();
		t2.start();
		t.join();
		t2.join();
		System.out.println(num.count);

	}
}

class counter{
	int count;
	public synchronized void increment(){
		count++;
	}
}