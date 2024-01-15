package Thread_test;

public class thread_runnable implements Runnable{
	public void run(){
		for (int i= 0; i<10;i++){
			int ans = i + i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(ans);
		}
	}
}
