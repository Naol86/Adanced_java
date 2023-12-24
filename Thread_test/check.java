package Thread_test;


public class check {

	public static void main(String[] args) {
		
		Count_number num1 = new Count_number();
		Thread thread_one = new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i < 1000; i++)
					num1.count();
			}
		});
	
		Thread thread_two =  new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i < 1000; i++)
					num1.count();
			}
		});
	
		thread_one.start();
		thread_two.start();
		thread_one.setPriority(10);

		try {
			thread_one.join();
			thread_two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num1.num);
	}
}


class Count_number {
	int num = 0;
	public void count(){
		
			num++;
		
	}
}
