package Thread_test;

public class thread_one extends Thread{
	public void run(){
		for (int i =0; i<10;i++){
			int ans;
			ans = i * i;
			System.out.println(ans);
		}
	}
	
}
